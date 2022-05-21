<template>
  <div class="order-list-container">
    <div class="order-list--header">
      <div class="order-num-wrap">
        订单总数（<span>{{ orderList.length }}</span
        >）
      </div>
      <div class="remove-orders" @click="removeAllHandle">全部删除</div>
    </div>

    <div class="order-list-wrap">
      <div class="cart-item" v-for="item of orderList" :key="item.id">
        <div class="img-wrap">
          <image :src="baseUrl + item.img" mode="" />
        </div>
        <div class="goods-info-wrap">
          <div class="describe-wrap">
            {{ item.describe }}
          </div>
          <div class="num-wrap">
            <p>订单号:</p>
            <span> {{ item.orderNum }}</span>
          </div>
          <div class="price-operation-wrap">
            <div class="price-wrap"><span>￥</span>{{ item.totalPrice }}</div>
            <div class="order-time-wrap">
              <i class="iconfont icon-riqi"></i>
              <span>{{ item.createTime }}</span>
            </div>
            <p @click="removeOrderHandle(item.orderId)">删除</p>
          </div>
        </div>
      </div>
        <div v-if="orderList.length == 0" class="non-goods">
          暂无数据
        </div>
    </div>
  </div>
</template>
<script>
// import uniSwipeAction from '@/components/uni-swipe-action/uni-swipe-action/uni-swipe-action.vue'
// import uniSwipeActionItem from '@/components/uni-swipe-action/uni-swipe-action-item/uni-swipe-action-item.vue'

export default {
  data() {
    return {
      userId: null,
      userInfo: null,
      orderList: [],
    };
  },
  computed: {
    baseUrl() {
      return this.$base.url;
    },
  },
  mounted() {
    let tempUserId = uni.getStorageSync("userid");
    if (!tempUserId) uni.navigateTo({ url: "/pages/login/login" });
    this.userId = tempUserId;

    this.getOrderList();
  },
  methods: {
    async getUserInfo() {
      const res = await this.$http.request({
        url: "yonghu/info/" + this.userId,
        method: "get",
      });
      this.userInfo = res.data;
    },
    async getOrderList() {
      const res = await this.$http.request({
        url: "order/by/" + this.userId,
        method: "get",
      });
      this.orderList = res.data;
    },
    removeAllHandle() {
      let ids = [];
      this.orderList.forEach((item) => {
        ids.push(item.orderId);
      });
      this.$http.request({
        url: "order/remove",
        method: "post",
        data: ids,
      });
      uni.showToast({
        title: "删除成功",
        icon: "none",
        duration: 2000,
      });
      this.getOrderList();
    },
    removeOrderHandle(id) {
      this.$http.request({
        url: "order/remove",
        method: "post",
        data: [id],
      });
      uni.showToast({
        title: "删除成功",
        icon: "none",
        duration: 2000,
      });
      this.getOrderList();
    },
  },
};
</script>
<style lang="scss">
.order-list--header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 20rpx;
  border-bottom: 1px solid #eee;
  background: #fff;
  .order-num-wrap {
    span {
      color: #616161;
      font-size: 12px;
    }
  }
  .remove-orders {
    color: red;
    font-size: 28rpx;
  }
}
.num-wrap {
  display: flex;
  align-items: center;
  font-size: 12px;
  width: 95%;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  color: #b2bec3;
}
.non-goods {
  color: #b2bec3;
  font-size: 40rpx;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
.order-list-wrap {
  // min-height: calc(100vh - 200rpx);
  padding-bottom: 100rpx;
  .cart-item {
    display: flex;
    align-items: center;
    background: #fff;
    border-radius: 10rpx;
    border-bottom: 1px solid #dfe6e9;
    height: 170rpx;
    overflow: hidden;
    padding: 10rpx;
    .img-wrap {
      position: relative;
      image {
        height: 150rpx;
        width: 200rpx;
      }
    }
    .goods-info-wrap {
      height: 100%;
      display: flex;
      flex-direction: column;
      justify-content: space-around;
      padding: 0 20rpx;
      width: calc(100vw - 240rpx);
      .describe-wrap {
        width: 100%;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
      }
      .price-operation-wrap {
        width: 100%;
        display: flex;
        align-items: center;
        justify-content: space-between;
        .price-wrap {
          color: red;
        }
        .order-time-wrap {
          color: #ccc;
          font-size: 12px;
          display: flex;
          align-items: center;
          span {
            padding-left: 10rpx;
          }
        }
        p {
          color: red;
        }
      }
    }
  }
}
</style>