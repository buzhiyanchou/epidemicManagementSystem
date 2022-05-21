<template>
  <div class="community-supplies-container">
    <div class="community-supplies-tip tip-wrap">
      <image src="@/static/community-supplies/cheer.png" mode="" />
      <p class="">社区防疫物资免费领取</p>
      <image src="@/static/community-supplies/cheer.png" mode="" />
    </div>
    <div class="community-supplies-item-wrap">
      <div
        class="community-supplies-item"
        v-for="item of dataList"
        :key="item.id"
      >
        <p>
          {{ item.name }}（剩余: <span>{{ item.inventory }}</span
          >）
        </p>
        <div>
          <image :src="baseUrl + item.img" mode="" />
        </div>
        <div class="supplies-item-describe">{{ item.description }}</div>
      </div>
      <button class="community-supplies-btn" @click="applySuppliesHandle">
        申报领取
      </button>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      dataList: [],
      userId: null,
    };
  },
  mounted() {
    let tempUserId = uni.getStorageSync("userid");
    if (!tempUserId) uni.navigateTo({ url: "/pages/login/login" });
    this.userId = tempUserId;
    this.getDataList();
  },
  computed: {
    baseUrl() {
      return this.$base.url;
    },
  },
  methods: {
    // 得到防疫物资列表
    async getDataList() {
      const res = await this.$http.request({
        url: "supplies/list",
        method: "get",
        data: {},
      });
      this.dataList = res.data;
    },
    // 点击申领
    async applySuppliesHandle() {
      const isApply = await this.$http.request({
        url: "supplies_yonghu/list",
        method: "get",
        data: {
          yonghuId: this.userId,
        },
      });
      if (isApply.data.length > 0) {
        return uni.showToast({
          title: "您已申领",
          icon: "none",
          duration: 2000,
        });
      }
      this.dataList.forEach((item) => {
        let data = {
          suppliesId: item.id,
          yonghuId: this.userId,
        };
        this.$http
          .request({
            url: "supplies_yonghu/save",
            method: "post",
            data,
          })
          .then((res) => {
            if (res.code != 0) {
              return uni.showToast({
                title: "申领失败",
                icon: "none",
                duration: 2000,
              });
            }
            uni.showToast({
                title: "申领成功",
                icon: "none",
                duration: 2000,
              });
          });
      });
    },
  },
};
</script>
<style lang="scss">
.community-supplies-container {
  .tip-wrap {
    display: flex;
    align-items: center;
    justify-content: center;
    image {
      height: 64rpx;
      width: 64rpx;
    }
    p {
      font-size: 36rpx;
      font-weight: bold;
      display: flex;
      align-items: center;
      justify-content: center;
    }
  }
  .community-supplies-item {
    border-bottom: 1px solid #dfe6e9;
    padding-bottom: 20rpx;
    div {
      text-align: center;
      image {
        width: 560rpx;
        height: 400rpx;
        border-radius: 10rpx;
      }
    }
    p {
      padding: 20rpx;
      font-size: 28rpx;
      color: #636e72;
    }
    .supplies-item-describe {
      padding: 10rpx 20rpx;
      text-align: left;
      font-size: 28rpx;
      color: #636e72;
    }
  }
  .community-supplies-item-wrap {
    padding-bottom: 140rpx;
  }
  .community-supplies-btn {
    background: #82a39d;
    margin: 20rpx;
    color: #fff;
    position: fixed;
    z-index: 100;
    bottom: 0;
    left: 0;
    right: 0;
  }
}
</style>