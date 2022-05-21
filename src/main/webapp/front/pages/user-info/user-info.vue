<template>
<view class="content">
	<view class="box" :style='{"padding":"0","boxShadow":"0 0 0px rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"#fff","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'>
		<view :style='{"padding":"0 40rpx","boxShadow":"0 0 16rpx rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 0.25)","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"88rpx"}' v-if="tableName=='yonghu'" class="cu-form-group">
			<view class="title" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"160rpx","lineHeight":"88rpx","fontSize":"28rpx","borderStyle":"solid"}'>用户名</view>
			<input disabled="true"  style="padding: 0 30upx" :style='{"padding":"0 20rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(161, 161, 161, 1)","backgroundColor":"rgba(0,0,0,0)","color":"rgba(161, 161, 161, 1)","borderRadius":"16rpx","borderWidth":"2rpx","width":"100%","lineHeight":"88rpx","fontSize":"28rpx","borderStyle":"solid","height":"60rpx"}' v-model="ruleForm.yonghuming" placeholder="用户名"></input>
		</view>
		<view :style='{"padding":"0 40rpx","boxShadow":"0 0 16rpx rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 0.25)","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"88rpx"}' v-if="tableName=='yonghu'" class="cu-form-group">
			<view class="title" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"160rpx","lineHeight":"88rpx","fontSize":"28rpx","borderStyle":"solid"}'>密码</view>
			<input  type="password" style="padding: 0 30upx" :style='{"padding":"0 20rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(161, 161, 161, 1)","backgroundColor":"rgba(0,0,0,0)","color":"rgba(161, 161, 161, 1)","borderRadius":"16rpx","borderWidth":"2rpx","width":"100%","lineHeight":"88rpx","fontSize":"28rpx","borderStyle":"solid","height":"60rpx"}' v-model="ruleForm.mima" placeholder="密码"></input>
		</view>
		<view :style='{"padding":"0 40rpx","boxShadow":"0 0 16rpx rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 0.25)","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"88rpx"}' v-if="tableName=='yonghu'" class="cu-form-group">
			<view class="title" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"160rpx","lineHeight":"88rpx","fontSize":"28rpx","borderStyle":"solid"}'>姓名</view>
			<input   style="padding: 0 30upx" :style='{"padding":"0 20rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(161, 161, 161, 1)","backgroundColor":"rgba(0,0,0,0)","color":"rgba(161, 161, 161, 1)","borderRadius":"16rpx","borderWidth":"2rpx","width":"100%","lineHeight":"88rpx","fontSize":"28rpx","borderStyle":"solid","height":"60rpx"}' v-model="ruleForm.xingming" placeholder="姓名"></input>
		</view>
			<view v-if="tableName=='yonghu'" :style='{"padding":"0 40rpx","boxShadow":"0 0 16rpx rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 0.25)","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"88rpx"}' class="cu-form-group select">
                                <view :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"160rpx","lineHeight":"88rpx","fontSize":"28rpx","borderStyle":"solid"}' class="title">性别</view>
                                <picker  @change="yonghuxingbieChange" :value="yonghuxingbieIndex" :range="yonghuxingbieOptions">
                                        <view style="padding: 0 30upx" :style='{"padding":"0 20rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","margin":"0","borderColor":"rgba(161, 161, 161, 1)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"16rpx","borderWidth":"2rpx","width":"calc(100% - 160rpx)","fontSize":"28rpx","borderStyle":"solid","height":"60rpx"}' class="uni-input picker-select-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
                                </picker>
                        </view>
		<view :style='{"padding":"0 40rpx","boxShadow":"0 0 16rpx rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 0.25)","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"88rpx"}' v-if="tableName=='yonghu'" @tap="yonghutouxiangTap" class="cu-form-group">
			<view class="title" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"160rpx","lineHeight":"88rpx","fontSize":"28rpx","borderStyle":"solid"}'>头像</view>
			<view style="flex: 1;">
				<image :style='{"padding":"0","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 auto","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"100%","borderWidth":"0","width":"60rpx","borderStyle":"solid","height":"60rpx"}' v-if="ruleForm.touxiang" style="margin: 0;" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
				<image :style='{"padding":"0","boxShadow":"0 0 0px rgba(0,0,0,.3)","margin":"0 auto","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","borderRadius":"100%","borderWidth":"0","width":"60rpx","borderStyle":"solid","height":"60rpx"}' v-else class="avator" style="margin: 0;" src="../../static/center/face.jpeg" mode=""></image>
			</view>
		</view>
		<view :style='{"padding":"0 40rpx","boxShadow":"0 0 16rpx rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 0.25)","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"88rpx"}' v-if="tableName=='yonghu'" class="cu-form-group">
			<view class="title" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"160rpx","lineHeight":"88rpx","fontSize":"28rpx","borderStyle":"solid"}'>手机</view>
			<input   style="padding: 0 30upx" :style='{"padding":"0 20rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(161, 161, 161, 1)","backgroundColor":"rgba(0,0,0,0)","color":"rgba(161, 161, 161, 1)","borderRadius":"16rpx","borderWidth":"2rpx","width":"100%","lineHeight":"88rpx","fontSize":"28rpx","borderStyle":"solid","height":"60rpx"}' v-model="ruleForm.shouji" placeholder="手机"></input>
		</view>
		<view :style='{"padding":"0 40rpx","boxShadow":"0 0 16rpx rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 0.25)","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"88rpx"}' v-if="tableName=='yonghu'" class="cu-form-group">
			<view class="title" :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"160rpx","lineHeight":"88rpx","fontSize":"28rpx","borderStyle":"solid"}'>住址</view>
			<input   style="padding: 0 30upx" :style='{"padding":"0 20rpx","boxShadow":"0 0 12rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(161, 161, 161, 1)","backgroundColor":"rgba(0,0,0,0)","color":"rgba(161, 161, 161, 1)","borderRadius":"16rpx","borderWidth":"2rpx","width":"100%","lineHeight":"88rpx","fontSize":"28rpx","borderStyle":"solid","height":"60rpx"}' v-model="ruleForm.zhuzhi" placeholder="住址"></input>
		</view>

		<!-- 区域 -->
		<view :style='{"padding":"0 40rpx","boxShadow":"0 0 16rpx rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 0.25)","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"88rpx"}' class="cu-form-group select">
				<view :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"160rpx","lineHeight":"88rpx","fontSize":"28rpx","borderStyle":"solid"}' class="title">区域</view>
				<picker  
					@change="selecAreaChange" 
					:value="selectAreaIndex" 
					:range="areaList"
					range-key="areaName"
				>
						<view style="padding: 0 30upx" :style='{"padding":"0 20rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","margin":"0","borderColor":"rgba(161, 161, 161, 1)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"16rpx","borderWidth":"2rpx","width":"calc(100% - 160rpx)","fontSize":"28rpx","borderStyle":"solid","height":"60rpx"}' class="uni-input picker-select-input">{{addrForm.areaId?areaList[selectAreaIndex].areaName:"请选择区域"}}</view>
				</picker>
		</view>
		<!-- 楼栋 -->
		<view :style='{"padding":"0 40rpx","boxShadow":"0 0 16rpx rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 0.25)","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"88rpx"}' class="cu-form-group select">
				<view :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"160rpx","lineHeight":"88rpx","fontSize":"28rpx","borderStyle":"solid"}' class="title">楼栋</view>
				<picker  
					@change="selecFloorChange" 
					:value="selectFloorIndex" 
					:range="floorLst"
					range-key="floorNum"
				>
						<view style="padding: 0 30upx" :style='{"padding":"0 20rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","margin":"0","borderColor":"rgba(161, 161, 161, 1)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"16rpx","borderWidth":"2rpx","width":"calc(100% - 160rpx)","fontSize":"28rpx","borderStyle":"solid","height":"60rpx"}' class="uni-input picker-select-input">{{addrForm.floorId?floorLst[selectFloorIndex].floorNum:"请选择区域"}}</view>
				</picker>
		</view>
		<!-- 属蛇 -->
		<view :style='{"padding":"0 40rpx","boxShadow":"0 0 16rpx rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"#ccc","backgroundColor":"rgba(255, 255, 255, 0.25)","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"88rpx"}' class="cu-form-group select">
				<view :style='{"padding":"0","boxShadow":"0 0 16rpx rgba(0,0,0,0)","margin":"0","borderColor":"rgba(0,0,0,0)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"0","borderWidth":"0","width":"160rpx","lineHeight":"88rpx","fontSize":"28rpx","borderStyle":"solid"}' class="title">房间号</view>
				<picker  
					@change="selecRoomChange" 
					:value="selectRoomIndex" 
					:range="roomList"
					range-key="roomNum"
				>
						<view style="padding: 0 30upx" :style='{"padding":"0 20rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","margin":"0","borderColor":"rgba(161, 161, 161, 1)","backgroundColor":"rgba(255, 255, 255, 0)","color":"rgba(161, 161, 161, 1)","textAlign":"left","borderRadius":"16rpx","borderWidth":"2rpx","width":"calc(100% - 160rpx)","fontSize":"28rpx","borderStyle":"solid","height":"60rpx"}' class="uni-input picker-select-input">{{addrForm.roomId?roomList[selectRoomIndex].roomNum:"请选择区域"}}</view>
				</picker>
		</view>
		<view class="btn">
			<button @tap="update()" class="cu-btn lg" :style='{"padding":"0 30rpx","boxShadow":"0 0 16rpx rgba(0,0,0,0) inset","margin":"0","backgroundColor":"rgba(130, 163, 157, 1)","borderColor":"rgba(130, 163, 157, 1)","borderRadius":"80rpx","color":"#fff","borderWidth":"1","width":"320rpx","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'>保存</button>
			<button @tap="logout()" class="cu-btn lg" :style='{"padding":"0 30rpx","boxShadow":"0 0 16rpx rgba(0,0,0,0) inset","margin":"0 0 0 30rpx","backgroundColor":"rgba(187, 187, 187, 1)","borderColor":"rgba(187, 187, 187, 1)","borderRadius":"80rpx","color":"#fff","borderWidth":"2rpx","width":"auto","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'>退出登录</button>
		</view>
	</view>
</view>
</template>

<script>
export default {
  components: {},
  data() {
    return {
      ruleForm: {},
      tableName: "",
      yonghuxingbieOptions: [],
      yonghuxingbieIndex: 0,
      choiceContent: "请选择", //选择的内容
      choiceIndex: 0, //选择位置
      //
      addrForm: {
        yonghuId: null,
        areaId: null,
        floorId: null,
        roomId: null,
      },
      selectAreaIndex: null,
      areaList: [],
      selectFloorIndex: null,
      floorLst: [],
      selectRoomIndex: null,
      roomList: [],
    };
  },
  computed: {
    baseUrl() {
      return this.$base.url;
    },
  },
  created() {
    let tempUserId = uni.getStorageSync("userid");
    if (!tempUserId) uni.navigateTo({ url: "/pages/login/login" });
    this.addrForm.yonghuId = tempUserId;
  },
  mounted() {
    this.getAreaList();
    this.getYonghuAddr();
  },
  async onLoad() {
    let table = uni.getStorageSync("nowTable");
    let res = await this.$api.session(table);
    this.ruleForm = res.data;
    this.tableName = table;
    // 自定义下拉框值
    if (this.tableName == "yonghu") {
      this.yonghuxingbieOptions = "男,女".split(",");
      this.yonghuxingbieOptions.forEach((item, index) => {
        if (item == this.ruleForm.xingbie) {
          this.yonghuxingbieIndex = index;
        }
      });
    }
    this.styleChange();
  },
  methods: {
    async getYonghuAddr() {
      const res = await this.$http.request({
        url: "addr/list",
        method: "get",
        data: {
          yonghuId: this.addrForm.yonghuId,
        },
      });
      this.addrForm = res.data[0];
      if (this.addrForm.id) {
        this.selectAreaIndex = this.areaList.findIndex(
          (item) => this.addrForm.areaId == item.id
        );
        this.$http
          .request({
            url: "floor/list",
            method: "get",
            data: {
              areaId: this.addrForm.areaId,
            },
          })
          .then((res) => {
            this.floorLst = res.data;
            this.selectFloorIndex = this.floorLst.findIndex(
              (item) => this.addrForm.floorId == item.id
            );
          });
		  this.$http.request({
        url: "room/list",
        method: "get",
        data: {
          floorId: this.addrForm.floorId,
        },
      }).then(res =>{
		  this.roomList = res.data
        this.selectRoomIndex = this.roomList.findIndex(item=>this.addrForm.roomId == item.id)
	  })
        this.floorLst.forEach((item) => {
          console.log(item);
        });
      }
    },
    async getAreaList() {
      const res = await this.$http.request({
        url: "area/list",
        method: "get",
        data: {},
      });
      this.areaList = res.data;
    },
    async getFloorList() {
      const res = await this.$http.request({
        url: "floor/list",
        method: "get",
        data: {
          areaId: this.addrForm.areaId,
        },
      });
      this.floorLst = res.data;
    },
    async getRoomList() {
      const res = await this.$http.request({
        url: "room/list",
        method: "get",
        data: {
          floorId: this.addrForm.floorId,
        },
      });
      this.roomList = res.data;
    },
    // 下拉变化
    yonghuxingbieChange(e) {
      this.yonghuxingbieIndex = e.target.value;
      this.ruleForm.xingbie =
        this.yonghuxingbieOptions[this.yonghuxingbieIndex];
    },
    styleChange() {
      this.$nextTick(() => {
        // document.querySelectorAll('.cu-form-group .uni-input-input').forEach(el=>{
        //   el.style.backgroundColor = this.userInfoForm.list.input.backgroundColor
        // })
      });
    },
    // 获取uuid
    getUUID() {
      return new Date().getTime();
    },
    logout() {
      uni.setStorageSync("token", "");
      this.$utils.jump("../login/login");
    },
    // 注册
    async update() {
      if (!this.ruleForm.yonghuming && `yonghu` == this.tableName) {
        this.$utils.msg(`用户名不能为空`);
        return;
      }
      if (!this.ruleForm.mima && `yonghu` == this.tableName) {
        this.$utils.msg(`密码不能为空`);
        return;
      }
      if (!this.ruleForm.xingming && `yonghu` == this.tableName) {
        this.$utils.msg(`姓名不能为空`);
        return;
      }
      if (
        `yonghu` == this.tableName &&
        this.ruleForm.shouji &&
        !this.$validate.isMobile(this.ruleForm.shouji)
      ) {
        this.$utils.msg(`手机应输入手机格式`);
        return;
      }
      let table = uni.getStorageSync("nowTable");
      await this.$api.update(table, this.ruleForm);

      if (this.addrForm.id) {
        // 修改

        this.$http.request({
          url: "addr/update",
          method: "post",
          data: this.addrForm,
        });
      } else {
        // 添加
        this.$http.request({
          url: "addr/save",
          method: "post",
          data: this.addrForm,
        });
      }
      this.$utils.msgBack("修改成功");
    },

    yonghutouxiangTap() {
      let _this = this;
      this.$api.upload(function (res) {
        _this.ruleForm.touxiang = "upload/" + res.file;
        _this.$forceUpdate();
      });
    },
    // 区域选择
    selecAreaChange(e) {
      if (this.selectAreaIndex != e.target.value) {
        this.selectAreaIndex = e.target.value;
        this.addrForm.areaId = this.areaList[e.target.value].id;
        this.getFloorList();
        this.selectFloorIndex = null;
        this.addrForm.floorId = null;
        this.selectRoomIndex = null;
        this.addrForm.roomId = null;
      }
    },
    selecFloorChange(e) {
      if (this.selectFloorIndex != e.target.value) {
        this.selectFloorIndex = e.target.value;
        this.addrForm.floorId = this.floorLst[e.target.value].id;
        this.getRoomList();
        this.selectRoomIndex = null;
        this.addrForm.roomId = null;
      }
    },
    selecRoomChange(e) {
      this.selectRoomIndex = e.target.value;
      this.addrForm.roomId = this.roomList[e.target.value].id;
    },
  },
};
</script>

<style lang="scss" scoped>
page {
  background-color: #fff;
}

.content:after {
  position: fixed;
  top: 0;
  right: 0;
  left: 0;
  bottom: 0;
  content: "";
  background-image: url(http://codegen.caihongy.cn/20220210/4d3700fc122f4f31b2fffd227fbcd328.png);
  background-attachment: fixed;
  background-size: cover;
  background-position: center;
}

.avator {
  width: 110upx;
  height: 110upx;
  border-radius: 50%;
  margin-left: 30upx;
}

.cu-form-group.active {
  justify-content: space-between;
}

.cu-btn {
  width: 100%;
}
.cu-form-group .title {
  height: auto;
}

.right-input {
  flex: 1;
  text-align: left;
  line-height: 60rpx;
}
.btn {
  display: flex;
  align-items: center;
  justify-content: center;
  flex-wrap: wrap;
}
.box {
  width: auto;
  padding: 0 10upx;
  box-sizing: border-box;
  margin-bottom: 20upx;
}

.picker-select-input {
  line-height: 60rpx;
}
</style>
