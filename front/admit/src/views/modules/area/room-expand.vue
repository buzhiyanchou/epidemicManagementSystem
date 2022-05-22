<template>
  <div class="room-expand-container" v-if="isShow">
    <el-form
      :inline="true"
      :model="searchForm"
      class="form-content"
      @keyup.enter.native="getDataList()"
    >
      <el-form-item label="房间名称/号">
        <el-input
          v-model="searchForm.roomNum"
          placeholder="房间名称/号"
          clearable
        ></el-input>
      </el-form-item>

      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button type="primary" @click="clickAddABtn">新增</el-button>
        <el-button
          type="danger"
          @click="deleteHandle()"
          :disabled="dataListSelections.length <= 0"
          >批量删除</el-button
        >
      </el-form-item>
    </el-form>
    <div class="table-content">
        <el-table
          :data="dataList"
          border
          v-loading="dataListLoading"
          @selection-change="selectionChangeHandle"
          style="width: 100%"
        >
        <el-table-column type="expand">
          <template slot-scope="{row}">
              {{row}}
            <!-- <FloorExpand :areaInfo="row" :userInfo="userInfo"/> -->
          </template>
        </el-table-column>
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
            prop="roomNum"
            header-align="center"
            align="center"
            label="房间名称/号"
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
          style="padding-top: 20px;"
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
       <!-- 区域添加 -->
    <el-dialog
      :title="dialogTitle"
      :visible.sync="dialogVisible"
      width="50%"
      :before-close="handleClose"
      :modal="false"
    >
      <el-form
        :model="form"
        :rules="rulesFrom"
        ref="ruleForm"
        label-width="100px"
      >
       <el-form-item label="房间名称/号" prop="roomNum">
          <el-input
            v-model="form.roomNum"
            placeholder="房间名称/号"
            clearable
          ></el-input>
        </el-form-item>        
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="handleClose">取 消</el-button>
        <el-button type="primary" @click="confirmFormHandle"
          >确 定</el-button
        >
      </span>
    </el-dialog>
  </div>
</template>
<script>
export default {
  props: {
    floorInfo: null,
    userInfo: null,
  },
  data() {
    return {
        isShow: true,
      searchForm: {
        roomNum: "",
      },
        pageIndex: 1,
        pageSize: 10,
      totalPage: 0,
      dataListLoading: true,
      dataListSelections: [],
      dataList: [],
      dialogTitle: '添加楼栋',
      form: {
          roomNum: ''
      },
      rulesFrom: {
          roomNum: [
              { required: true, message: '请输入楼栋名称/号', trigger: 'blur' },
          ]
      },
      dialogVisible: false
    };
  },
  mounted() {
    this.getDataList();
  },
  methods: {
    reload() {
        this.$emit('reload')
    },
    async getDataList() {
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        ...this.searchForm,
        floorId: this.floorInfo.id,
      };
      const { data: res } = await this.$http({
        url: "/room/page",
        method: "get",
        params,
      });
      if(res.code != 0) return this.$message.error('服务器开了个小差')
      this.totalPage = res.data.total;
      this.dataList = res.data.list;
      this.dataListLoading = false;
    },
    clickAddABtn() {
        this.dialogTitle = '添加'
        this.dialogVisible = true
    },
    addOrUpdateHandle(row) {
      this.dialogTitle = '修改'
      this.form = row
      this.dialogVisible = true
    },
     async deleteHandle(id) {
         let that = this
      let ids = id ? [id] : this.dataListSelections
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then( () => {
          that.$http({
              url: '/room/remove',
              method: 'post',
              data: ids
          }).then(({ data: res }) => {
              if(res.code != 0) return that.$message.error('删除失败')
              that.$message.success('删除成功')
              that.getDataList()
              that.reload()
          })
      })
    },
    handleClose() {
      this.$refs['ruleForm'].resetFields();
      this.form = {
       roomNum: ''
      }
      this.dialogVisible = false;
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
      this.dataListSelections = val.map(item => item.id);
    },

    confirmFormHandle() {
      let that = this
      let data = {
        ...this.form,
        floorId: this.floorInfo.id,
      }
      if(that.dialogTitle == '添加')data.createBy = this.userInfo.username
      else if(that.dialogTitle == '修改')data.updateBy = this.userInfo.username
      this.$refs['ruleForm'].validate((valid) => {
          if (valid) {
            that.$http({
              url: that.dialogTitle == '添加'? '/room/save':'/room/update',
              method: 'post',
              data
            }).then(({ data: res }) =>{
              if(res.code != 0) return that.$message.error(that.dialogTitle == '添加'?'添加失败':'修改失败')
              that.$message.success(that.dialogTitle == '添加'?'添加成功':'修改成功')
              that.getDataList()
              that.handleClose()
              that.reload()
            })
          } else {
            return that.$message.error('其中包含必填项');
          }
        });
    }
  },
};
</script>