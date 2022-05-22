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
            <el-form-item label="分类名称">
              <el-input
                v-model="searchForm.typeName"
                placeholder="分类名称"
                clearable
              ></el-input>
            </el-form-item>

            <el-form-item>
              <el-button @click="getDataList()">查询</el-button>
            </el-form-item>
            <el-row>
              <el-button type="primary" @click="clickAddAreaBtn"
                >新增</el-button
              >
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
                prop="typeName"
                header-align="center"
                align="center"
                label="分类名称"
              >
              </el-table-column>


              <el-table-column
                prop="createTime"
                header-align="center"
                align="center"
                label="创建时间"
              >
              </el-table-column>
              <el-table-column
                prop="updateTime"
                header-align="center"
                align="center"
                label="修改时间"
              >
              </el-table-column>
              <el-table-column
                prop="createBy"
                header-align="center"
                align="center"
                label="创建人"
              >
              </el-table-column>
              <el-table-column
                prop="updateBy"
                header-align="center"
                align="center"
                label="修改人"
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
        <el-form-item label="分类名称" prop="typeName">
          <el-input
            v-model="dialogForm.typeName"
            placeholder="分类名称"
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
        typeName: "",
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
        typeName: "",
      },
      dialogFormRules: {
        typeName: [{ required: true, message: "请输入分类名称", trigger: "blur" }],
      },
    };
  },
  created() {},
  mounted() {
    this.getUserInfo();
    this.getDataList();
  },
  filters: {},
  methods: {
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
    async getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        ...this.searchForm,
      };
      const { data: res } = await this.$http({
        url: "/goods/type/page",
        method: "get",
        params,
      });
      if (res.code != 0) return this.$message.error("服务器开了个小差");
      this.totalPage = res.data.total;
      this.dataList = res.data.list;
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
          url: "/goods/type/remove",
          method: "post",
          data: ids,
        }).then((res) => {
          if (res.data.code != 0) return this.$message.error("删除失败");
          this.$message.success("删除成功");
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
      this.dialogForm = {
        typeName: "",
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
              url:
                that.dialogitle == "添加"
                  ? "/goods/type/save"
                  : "/goods/type/update",
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
</style>