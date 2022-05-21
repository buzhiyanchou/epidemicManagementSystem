<template>
  <div class="cart-list-container">
    <div class="cart--header">
      <div class="user-info-addr-wrap">
        <div class="user-info">
          <p>{{ userInfo.xingming }}</p>
          <span>{{ userInfo.shouji }}</span>
        </div>
        <div class="user-addr">{{ userInfo.zhuzhi }}</div>
      </div>
      <uni-icons
        @click="goto('/pages/user-info/user-info')"
        type="right"
        size="30"
      ></uni-icons>
    </div>

    <div class="cart-list-wrap">
      <div class="cart-item" v-for="item of cartList" :key="item.id">
        <div class="img-wrap">
          <image :src="baseUrl + item.img" mode="" />
          <checkbox :checked="item.isSelect" @click="changeCheckbox(item)" />
        </div>
        <div class="goods-info-wrap">
          <div class="describe-wrap">
            {{ item.describe }}
          </div>
          <div class="price-operation-wrap">
            <div class="price-wrap"><span>￥</span>{{ item.price }}</div>
            <div class="operation-btn-wrap">
              <div @click="goodsNumChangeHandle(-1, item)">-</div>
              <span>{{ item.goodsNum }}</span>
              <div @click="goodsNumChangeHandle(1, item)">+</div>
            </div>
          </div>
        </div>
      </div>
      <div class="total-prices-wrap">
        <p>
          总价: <span>{{ totalPrice }} 元</span>
        </p>
      </div>
    </div>

    <uni-goods-nav
      :fill="true"
      :options="[]"
      :buttonGroup="group"
      @click="onClick"
      @buttonClick="buttonClick"
    />
  </div>
</template>

<script>
export default {
  components: {},
  data() {
    return {
      group: [
        {
          text: "删除",
          backgroundColor: "#ff7675",
          color: "#fff",
        },
        {
          text: "结算",
          backgroundColor: "#00b894",
          color: "#fff",
        },
      ],
      userId: null,
      cartList: [],
      userInfo: {},
      totalPrice: 0,
      selectGoodsIds: [],
    };
  },
  computed: {
    baseUrl() {
      return this.$base.url;
    },
  },
  watch: {},
  created() {
    let tempUserId = uni.getStorageSync("userid");
    if (!tempUserId) uni.navigateTo({ url: "/pages/login/login" });
    this.userId = tempUserId;
    //
  },
  mounted() {
    this.getUserInfo();
    this.getCartsList();
  },
  updated() {
    let totalPrice = 0;
    this.cartList.forEach((item) => {
      totalPrice += item.goodsNum * parseFloat(item.price);
    });
    this.totalPrice = totalPrice;
  },
  methods: {
    // 得到购物车数据
    async getCartsList() {
      const res = await this.$http.request({
        url: "cart/list/cart/" + this.userId,
        method: "get",
      });
      let tmepData = res.data;
      if (tmepData.length > 0) {
        tmepData.forEach((item) => {
          item.goodsNum = parseInt(item.goodsNum);
          item.isSelect = false;
        });
      }
      this.cartList = [...this.cartList, ...tmepData];
    },
    getUserInfo() {
      this.$http.request({
        url: "yonghu/info/" + this.userId,
        method: "get",
      }).then(res=>{
        this.userInfo = res.data;
        this.$http.request({
          url: 'addr/str/'+this.userId,
          method: 'get',
        }).then(addr=>{
          this.userInfo.zhuzhi = addr.data?addr.data:this.userInfo.zhuzhi
        })

      })

    },
    onClick(e) {
      console.log(e);
    },

    removeCartItem() {

      let ids = []
      this.selectGoodsIds.forEach(id=>{
        this.cartList.forEach(item=>{
          if(id == item.id) ids.push(item.cartId)
        })
      })

      this.$http.request({
        url: "cart/remove",
        method: "post",
        data: ids,
      });
    },
    buttonClick(e) {
      if (e.index == 0) {
        // 点击删除
        if (this.selectGoodsIds.length > 0) {
          this.removeCartItem()
          this.getCartsList()
        } else {
          uni.showToast({
            title: "您还没选购物品",
            icon: "none",
            duration: 2000,
          });
        }
      } else if (e.index == 1) {
        if(this.selectGoodsIds.length > 0){
          // 点击结算
          this.selectGoodsIds.forEach(id=>{
            this.cartList.forEach(item=>{
              if(id == item.id){
                let data = {
                  yonghuId: this.userId,
                  goodsId: item.id,
                  goodsNum: item.goodsNum,
                  totalPrice: this.totalPrice
                }
                this.$http.request({
                  url: 'order/save',
                  method: 'post',
                  data
                }).then(res => {
                })
              }
            })
          })
          this.removeCartItem()
          uni.navigateTo({
            url: '/pages/order-list/order-list'
          })

        }else {
           uni.showToast({
            title: "您还没选购物品",
            icon: "none",
            duration: 2000,
          });
        }
      }
    },
    //
    goto(url) {
      uni.navigateTo({
        url,
      });
    },
    goodsNumChangeHandle(order, obj) {
      obj.goodsNum = obj.goodsNum + order > 0 ? obj.goodsNum + order : 1;
      this.cartList.forEach((item) => {
        if (obj.id == item.id) item.goodsNum = obj.goodsNum;
      });
    },
    changeCheckbox(obj) {
      obj.isSelect = !obj.isSelect;
      if (obj.isSelect) {
        this.selectGoodsIds.push(obj.id);
      } else {
        let index = this.selectGoodsIds.findIndex((item) => item.id == obj.id);
        this.selectGoodsIds.splice(index, 1);
      }
    },
  },
};
</script>
<style lang="scss">
.uni-goods-nav {
  position: fixed;
  left: 0;
  right: 0;
  bottom: 0;
}

.cart--header {
  padding: 20rpx;
  background: #fff;
  margin: 20rpx;
  border-radius: 10rpx;
  display: flex;
  align-items: center;
  justify-content: space-between;
  .user-info-addr-wrap {
  }
  .user-info {
    display: flex;
    align-items: center;
    p {
    }
    span {
      color: #989898;
      font-size: 24rpx;
      padding-left: 20rpx;
    }
  }
  .user-addr {
    padding-top: 10rpx;
  }
  .uni-icons {
    font-size: 26rpx !important;
    color: #989898 !important;
  }
}
.total-prices-wrap {
  background: #fff;
  padding: 20rpx;
  font-weight: bold;
  span {
    color: red;
  }
}
.cart-list-wrap {
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
      checkbox {
        position: absolute;
        top: 0rpx;
        left: 0rpx;
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
        .operation-btn-wrap {
          display: flex;
          align-items: center;
          div {
            height: 50rpx;
            width: 50rpx;
            font-size: 30rpx;
            border: 1px solid #ccc;
            padding: 10rpx;
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            border-radius: 5rpx;
          }
          span {
            border: 1px solid #ccc;
            padding: 10rpx;
            margin: 0 10rpx;
          }
        }
      }
    }
  }
}
</style>