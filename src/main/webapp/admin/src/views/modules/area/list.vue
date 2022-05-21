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
        <el-form-item label="区域名称">
          <el-input
            v-model="searchForm.areaName"
            placeholder="区域名称"
            clearable
          ></el-input>
        </el-form-item>
        <el-form-item label="区域类型">
          <el-select
            v-model="searchForm.areaType"
            placeholder="请选择"
            clearable
          >
            <el-option label="防控区" :value="1"></el-option>
            <el-option label="封控区" :value="2"></el-option>
          </el-select>
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
          :data="areaList"
          border
          v-loading="dataListLoading"
          @selection-change="selectionChangeHandle"
          style="width: 100%"
        >
        <el-table-column type="expand">
          <template slot-scope="{row}">
            <FloorExpand v-if="isShowExpand"  ref="floorExpand" @reload="reloadExpand" :areaInfo="row" :userInfo="userInfo"/>
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
            prop="areaName"
            header-align="center"
            align="center"
            label="区域名称"
          >
          </el-table-column>
          <el-table-column
            prop="areaType"
            header-align="center"
            align="center"
            label="区域类型"
          >
            <template slot-scope="{ row }">
              <div >
                {{ row.areaType == 1 ? "防控区" : "封控区" }}
              </div>
            </template>
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
    </div>

    <!-- 区域添加 -->
    <el-dialog
      :title="areaTitle"
      :visible.sync="areaDialogVisible"
      width="50%"
      :before-close="areaHandleClose"
    >
      <el-form
        :model="areaForm"
        :rules="areaRules"
        ref="areaRuleForm"
        label-width="100px"
      >
       <el-form-item label="区域名称" prop="areaName">
          <el-input
            v-model="areaForm.areaName"
            placeholder="区域名称"
            clearable
          ></el-input>
        </el-form-item>
        <el-form-item label="区域类型" prop="areaType">
          <el-select
            v-model="areaForm.areaType"
            placeholder="请选择"
            clearable
          >
            <el-option label="防控区" :value="1"></el-option>
            <el-option label="封控区" :value="2"></el-option>
          </el-select>
        </el-form-item>
        
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="areaHandleClose">取 消</el-button>
        <el-button type="primary" @click="confirmAreaFormHandle"
          >确 定</el-button
        >
      </span>
    </el-dialog>
  </div>
</template>
<script>
import axios from "axios";
import FloorExpand from './floor-expand.vue'
export default {
  components: {
    FloorExpand,
  },
  data() {
    return {
      searchForm: {
        areaName: "",
        areaType: "",
      },
      showFlag: true,
      areaList: [],
      dataListSelections: [],
      dataListLoading: false,
      pageSize: 10,
      pageIndex: 1,
      totalPage: 0,
      userInfo: {},
      //
      areaTitle: "添加区域",
      areaDialogVisible: false,
      areaForm: {
        areaName: '',
        areaType: 1,
      },
      areaRules: {
        areaName: [
           { required: true, message: '请输入区域名称', trigger: 'blur' },
        ]
      },
      isShowExpand: true
    };
  },
  created() {},
  mounted() {
    this.getUserInfo()
    this.getDataList();
  },
  filters: {},
  methods: {
    reloadExpand() {
      // this.$refs.floorExpand.reload()
      this.isShowExpand = false
      this.$nextTick(()=>{
        this.isShowExpand = true
      })
    },
    async getUserInfo() {
      let userId = localStorage.getItem('userid')
      if(!userId) return this.$router.push('/login')
      const { data: res } = await this.$http({
        url: '/users/info/'+ userId,
        method: 'get'
      })
      if(res.code == 401) {
        this.$message.error('登录过期')
        return this.$router.push('/login')
      }
      if(res.code != 0) return this.$message.error('服务器开了个下差')
      this.userInfo = res.data
    },
    async getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        ...this.searchForm,
      };
      const { data: res } = await this.$http({
        url: "/area/page",
        method: "get",
        params,
      });
      if (res.code != 0) return this.$message.error("服务器开了个小差");
      this.totalPage = res.data.total;
      this.areaList = res.data.list;
      this.dataListLoading = false;

    },
    // 
    addOrUpdateHandle(row) {
      this.areaTitle = '修改区域'
      this.areaForm = row
      this.areaDialogVisible = true
    },
    async deleteHandle(id) {
      let ids = id ? [id] : this.dataListSelections
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then( () => {
        this.$http({
          url: '/area/remove',
          method: 'post',
          data: ids
        }).then( res => {
          if(res.data.code != 0) return this.$message.error('删除失败')
          this.$message.success('删除成功')
          this.getDataList()
        })
      })
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
    // area dialog
    areaHandleClose() {
      this.$refs['areaRuleForm'].resetFields();
      this.areaForm = {
        areaName: '',
        areaType: 1,
      }
      this.areaDialogVisible = false;
    },
    clickAddAreaBtn() {
      this.areaTitle = '添加区域'
      this.areaDialogVisible = true
    },
    confirmAreaFormHandle() {
      let that = this
      let data = {
        ...this.areaForm,
      }
      if(that.areaTitle == '添加区域')data.createBy = this.userInfo.username
      else if(that.areaTitle == '修改区域')data.updateBy = this.userInfo.username
      this.$refs['areaRuleForm'].validate((valid) => {
          if (valid) {
            that.$http({
              url: that.areaTitle == '添加区域'? '/area/save':'/area/update',
              method: 'post',
              data
            }).then(({ data: res }) =>{
              if(res.code != 0) return that.$message.error(that.areaTitle == '添加区域'?'添加失败':'修改失败')
              that.$message.success(that.areaTitle == '添加区域'?'添加成功':'修改成功')
              that.getDataList()
              that.areaHandleClose()
            })
          } else {
            return that.$message.error('其中包含必填项');
          }
        });
    }
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