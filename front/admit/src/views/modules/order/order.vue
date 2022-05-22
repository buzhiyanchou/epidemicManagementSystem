<template>
  <div class="main-content">
    <!-- 列表页 -->
    <div v-if="showFlag">
      <el-form
        :inline="true"
        :model="searchForm"
        class="form-content"
        @keyup.enter.native="getDataList()"
      >

        <el-form-item label="订单状态">
          <el-select v-model="searchForm.goodsStatus" placeholder="请选择">
            <el-option label="发货中" value="0" clearable></el-option>
            <el-option label="已收货" value="1" clearable></el-option>
            <el-option label="退货中" value="2" clearable></el-option>
            <el-option label="已退货" value="3" clearable></el-option>
          </el-select>
        </el-form-item>

        <el-form-item>
          <el-button @click="getDataList()">查询</el-button>
        </el-form-item>
        <el-row>
          <!-- <el-button type="primary" @click="clickAddAreaBtn">新增</el-button> -->
          <el-button
            type="danger"
            @click="deleteHandle()"
            :disabled="dataListSelections.length <= 0"
            >批量删除</el-button
          >
        </el-row>
      </el-form>
      <div class="table-content">
        <el-table
          :data="dataList"
          border
          v-loading="dataListLoading"
          @selection-change="selectionChangeHandle"
          style="width: 100%"
        >
          <el-table-column
            type="selection"
            header-align="center"
            align="center"
            width="50"
          >
          </el-table-column>
          <el-table-column
            type="index"
            header-align="center"
            align="center"
            label="序号"
            width="50"
          >
          </el-table-column>
          <el-table-column
            prop="orderNum"
            header-align="center"
            align="center"
            label="订单号"
            width="150"
            :show-overflow-tooltip="true"
          >
          </el-table-column>
          <el-table-column
            header-align="center"
            align="center"
            label="商品名称"
            width="150"
            prop="goodsName"
            :show-overflow-tooltip="true"
          >
          </el-table-column>

          <el-table-column
            prop="img"
            header-align="center"
            align="center"
            label="物资图片"
          >
            <template slot-scope="{ row }">
              <el-image v-if="row.img" :src="$base.url + row.img" style="height: 100px; width: 100px;"></el-image>
              <span v-else>无图片</span>
            </template>
          </el-table-column>
          <el-table-column
            header-align="center"
            align="center"
            label="状态"
            width="100"
          >
              <template slot-scope="{row}">
                  <div class="order-status-tag" v-if="row.goodsStatus == 0">发货中</div>
                  <div class="order-status-tag" v-else-if="row.goodsStatus == 1">已收货</div>
                  <div class="order-status-tag" v-else-if="row.goodsStatus == 2">退货中</div>
                  <div class="order-status-tag" v-else-if="row.goodsStatus == 3">已退货</div>
              </template>
          </el-table-column>
          <el-table-column
            prop="goodsNum"
            header-align="center"
            align="center"
            label="商品数量"
            width="100"
          >
          </el-table-column>
          <el-table-column
            prop="totalPrice"
            header-align="center"
            align="center"
            label="总价格"
            width="100"
          >
          </el-table-column>

          <el-table-column
            prop="goodsAddr"
            header-align="center"
            align="center"
            label="收货地址"
            width="150"
            :show-overflow-tooltip="true"
          >
          </el-table-column>

          <el-table-column
            prop="createTime"
            header-align="center"
            align="center"
            label="创建时间"
            width="150"
            :show-overflow-tooltip="true"
          >
          </el-table-column>

          <!-- fixed="right" -->
          <el-table-column
            header-align="center"
            align="center"
            width="150"
            label="操作"
          >
            <template slot-scope="scope">
              <el-button
                type="text"
                size="small"
                @click="addOrUpdateHandle(scope.row)"
                >修改</el-button
              >
              <el-button
                type="text"
                size="small"
                @click="deleteHandle(scope.row.id)"
                >删除</el-button
              >
            </template>
          </el-table-column>
        </el-table>
        <el-pagination
          style="padding-top: 20px"
          v-show="totalPage"
          @size-change="sizeChangeHandle"
          @current-change="currentChangeHandle"
          :current-page="pageIndex"
          :page-sizes="[10, 20, 50, 100]"
          :page-size="pageSize"
          :total="totalPage"
          layout="total, sizes, prev, pager, next, jumper"
        >
        </el-pagination>
      </div>
    </div>

    <!-- 区域添加 -->
    <el-dialog
      :title="dialogitle"
      :visible.sync="dialogVisible"
      width="50%"
      :before-close="handleClose"
    >
      <el-form
        :model="dialogForm"
        :rules="dialogFormRules"
        ref="ruleForm"
        label-width="100px"
      >
        <el-form-item label="订单状态">
          <el-select v-model="dialogForm.goodsStatus" placeholder="请选择">
            <el-option label="发货中" value="0" ></el-option>
            <el-option label="已收货" value="1" ></el-option>
            <el-option label="退货中" value="2" ></el-option>
            <el-option label="已退货" value="3" ></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="地址" prop="goodsAddr">
          <el-input
            v-model="dialogForm.goodsAddr"
            placeholder="商品名称"
            clearable
          ></el-input>
        </el-form-item>

    
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="handleClose">取 消</el-button>
        <el-button type="primary" @click="confirmAreaFormHandle"
          >确 定</el-button
        >
      </span>
    </el-dialog>
  </div>
</template>
<script>
import axios from "axios";

export default {
  components: {},
  data() {
    return {
      addEditForm: {
        btnSaveFontColor: "#fff",
        selectFontSize: "14px",
        btnCancelBorderColor: "rgba(12, 107, 92, 1)",
        inputBorderRadius: "4px",
        inputFontSize: "14px",
        textareaBgColor: "#fff",
        btnSaveFontSize: "14px",
        textareaBorderRadius: "4px",
        uploadBgColor: "#fff",
        textareaBorderStyle: "solid",
        btnCancelWidth: "88px",
        textareaHeight: "120px",
        dateBgColor: "#fff",
        btnSaveBorderRadius: "4px",
        uploadLableFontSize: "14px",
        textareaBorderWidth: "1px",
        inputLableColor: "#606266",
        addEditBoxColor: "rgba(255, 255, 255, 1)",
        dateIconFontSize: "14px",
        btnSaveBgColor: "rgba(12, 107, 92, 1)",
        uploadIconFontColor: "#8c939d",
        textareaBorderColor: "#DCDFE6",
        btnCancelBgColor: "rgba(255, 255, 255, 1)",
        selectLableColor: "#606266",
        btnSaveBorderStyle: "dashed ",
        dateBorderWidth: "1px",
        dateLableFontSize: "14px",
        dateBorderRadius: "4px",
        btnCancelBorderStyle: "dashed ",
        selectLableFontSize: "14px",
        selectBorderStyle: "solid",
        selectIconFontColor: "#C0C4CC",
        btnCancelHeight: "44px",
        inputHeight: "40px",
        btnCancelFontColor: "#606266",
        dateBorderColor: "#DCDFE6",
        dateIconFontColor: "#C0C4CC",
        uploadBorderStyle: "solid",
        dateBorderStyle: "solid",
        dateLableColor: "#606266",
        dateFontSize: "14px",
        inputBorderWidth: "1px",
        uploadIconFontSize: "28px",
        selectHeight: "40px",
        inputFontColor: "#606266",
        uploadHeight: "148px",
        textareaLableColor: "#606266",
        textareaLableFontSize: "14px",
        btnCancelFontSize: "14px",
        inputBorderStyle: "solid",
        btnCancelBorderRadius: "4px",
        inputBgColor: "#fff",
        inputLableFontSize: "14px",
        uploadLableColor: "#606266",
        uploadBorderRadius: "4px",
        btnSaveHeight: "44px",
        selectBgColor: "#fff",
        btnSaveWidth: "88px",
        selectIconFontSize: "14px",
        dateHeight: "40px",
        selectBorderColor: "#DCDFE6",
        inputBorderColor: "#DCDFE6",
        uploadBorderColor: "#DCDFE6",
        textareaFontColor: "#606266",
        selectBorderWidth: "1px",
        dateFontColor: "#606266",
        btnCancelBorderWidth: "2px",
        uploadBorderWidth: "1px",
        textareaFontSize: "14px",
        selectBorderRadius: "4px",
        selectFontColor: "#606266",
        btnSaveBorderColor: "rgba(255, 255, 255, 1)",
        btnSaveBorderWidth: "2px",
      },

      searchForm: {
        goodsStatus: "",
      },
      showFlag: true,
      dataList: [],
      dataListSelections: [],
      dataListLoading: false,
      pageSize: 10,
      pageIndex: 1,
      totalPage: 0,
      userInfo: {},
      //
      dialogitle: "添加",
      dialogVisible: false,
      dialogForm: {
          goodsStatus: '',
        goodsAddr: ''
      },
      dialogFormRules: {
        goodsAddr: [
          { required: true, message: "收货地址不能为空", trigger: "blur" },
        ],
      },
      goodsType: [],
    };
  },
  created() {},
  mounted() {
    this.getUserInfo();
    this.getDataList();
    this.getGoodsType();
  },
  filters: {},
  methods: {
    reload() {
        this.showFlag = false
        this.$nextTick(()=>{this.showFlag=true})
    },
    async getUserInfo() {
      let userId = localStorage.getItem("userid");
      if (!userId) return this.$router.push("/login");
      const { data: res } = await this.$http({
        url: "/users/info/" + userId,
        method: "get",
      });
      if (res.code == 401) {
        this.$message.error("登录过期");
        return this.$router.push("/login");
      }
      if (res.code != 0) return this.$message.error("服务器开了个下差");
      this.userInfo = res.data;
    },
    async getGoodsType() {
      const { data: res } = await this.$http({
        url: "/order/list",
        method: "get",
        data: {},
      });
      if (res.code != 0) return console.log("得到商品分类失败");
      this.goodsType = res.data;
    },
    async getDataList() {
        let that = this
      this.dataListLoading = true;
      this.dataList = []
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        ...this.searchForm,
      };
      const { data: res } = await this.$http({
        url: "/order/page",
        method: "get",
        params,
      });
      if (res.code != 0) return this.$message.error("服务器开了个小差");
      this.totalPage = res.data.total;
      res.data.list.forEach(item=>{
          that.$http({
              url: '/goods/list',
              method: 'get',
              data: {
                  id: item.goodsId
              }
          }).then(({data: res})=>{
              item.goodsName = res.data[0].goodsName
              item.img = res.data[0].img
              this.dataList.push(item)
          })
      })
      this.dataListLoading = false;
    },
    //
    addOrUpdateHandle(row) {

      this.dialogitle = "修改";
      this.dialogForm = row;
      this.dialogVisible = true;
    },
    async deleteHandle(id) {
      let ids = id ? [id] : this.dataListSelections;
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        this.$http({
          url: "/order/remove",
          method: "post",
          data: ids,
        }).then((res) => {
          if (res.data.code != 0) return this.$message.error("删除失败");
          this.$message.success("删除成功");
          this.handleClose()
          this.getDataList();
        });
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandle(val) {
      this.dataListSelections = val.map((item) => item.id);
    },
    // area dialog
    handleClose() {
      this.$refs["ruleForm"].resetFields();
    //   this.$refs.imgUpload.clearFiles()
      this.dialogForm = {
          goodsStatus:'',
        goodsAddr: ''
      };
      this.dialogVisible = false;
    },
    clickAddAreaBtn() {
      this.dialogitle = "添加";
      this.dialogVisible = true;
    },
    imgUploadChange(fileUrls) {
      this.dialogForm.img = fileUrls;
      this.addEditUploadStyleChange();
    },
    addEditUploadStyleChange() {
      this.$nextTick(() => {
        document
          .querySelectorAll(
            ".addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item"
          )
          .forEach((el) => {
            el.style.width = this.addEditForm.uploadHeight;
            el.style.height = this.addEditForm.uploadHeight;
            el.style.borderWidth = this.addEditForm.uploadBorderWidth;
            el.style.borderStyle = this.addEditForm.uploadBorderStyle;
            el.style.borderColor = this.addEditForm.uploadBorderColor;
            el.style.borderRadius = this.addEditForm.uploadBorderRadius;
            el.style.backgroundColor = this.addEditForm.uploadBgColor;
          });
      });
    },
    confirmAreaFormHandle() {
      if (this.dialogForm.img != null) {
        this.dialogForm.img = this.dialogForm.img.replace(
          new RegExp(this.$base.url, "g"),
          ""
        );
      }

      let that = this;
      let data = {
        ...this.dialogForm,
      };
      if (that.dialogitle == "添加") data.createBy = this.userInfo.username;
      else if (that.dialogitle == "修改")
        data.updateBy = this.userInfo.username;
      this.$refs["ruleForm"].validate((valid) => {
        if (valid) {
          that
            .$http({
              url: that.dialogitle == "添加" ? "/order/save" : "/order/update",
              method: "post",
              data,
            })
            .then(({ data: res }) => {
              if (res.code != 0)
                return that.$message.error(
                  that.dialogitle == "添加区域" ? "添加失败" : "修改失败"
                );
              that.$message.success(
                that.dialogitle == "添加区域" ? "添加成功" : "修改成功"
              );
              that.getDataList();
              that.handleClose();
            });
        } else {
          return that.$message.error("其中包含必填项");
        }
      });
    },
  },
};
</script>

<style lang="scss">
.form-content {
  background: transparent;
}
.table-content {
  padding-top: 20px;
  background: transparent;
}
.order-status-tag{
    background: #78e08f;
    color: #fff;
}
</style>