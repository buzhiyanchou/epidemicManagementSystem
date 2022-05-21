<template>
  <div class="supplies-bought-container">
    <div class="supplies-heaer-wrap">
      <div
        class="supplies-heaer-item"
        v-for="item of supplies"
        :key="item.name"
        :class="item.active ? 'supplies-heaer-item-active' : ''"
        @click="changeSuppliesItemHandle(item)"
      >
        {{ item.name }}
      </div>
    </div>

    <div class="material-tags-wrap">
      <div
        class="material-tags-item"
        v-for="item of goodsTypeList"
        :key="item.id"
        :class="item.active ? 'material-tags-active' : ''"
        @click="changeMaterialTagsHandle(item)"
      >
        {{ item.typeName }}
      </div>
    </div>

    <!-- 物资包 -->
    <uni-transition
      :show="supplies[0].active"
      mode-class="slide-right"
      :duration="500"
    >
      <div class="material-package-wrap">
        <div class="material-item-wrap">
          <div class="material-item" v-for="item of goods" :key="item.id">
            <div class="img-wrap">
              <image :src="baseUrl + item.img" mode="" />
              <div class="price-wrap">{{ item.price }}元</div>
            </div>
            <div class="material-item-describe">{{ item.describe }}</div>
            <checkbox
              @click="materialCheckHanlde(item)"
              :checked="item.isSelect"
            />
          </div>
          <div class="non-data-wrap" v-if="goods.length == 0">暂无商品</div>
        </div>

        <uni-goods-nav
          :fill="true"
          :options="options"
          :buttonGroup="buttonGroup"
          @click="onClick"
          @buttonClick="buttonClick"
        />
      </div>
    </uni-transition>
    <!-- 预约物资 -->
    <uni-transition
      mode-class="slide-left"
      :duration="500"
      :show="supplies[1].active"
    >
      <div class="subscribe-wrap material-package-wrap">
        <div class="material-item-wrap">
          <div
            class="material-item"
            v-for="item of subscribeGoods"
            :key="item.id"
          >
            <div class="img-wrap">
              <image :src="baseUrl + item.img" mode="" />
              <div class="price-wrap">{{ item.price }}元</div>
            </div>
            <div class="material-item-describe">{{ item.describe }}</div>
            <checkbox
              @click="subscribeCheckHanlde(item)"
              :checked="item.isSelect"
            />
          </div>
          <div class="non-data-wrap" v-if="subscribeGoods.length == 0">
            暂无商品
          </div>
        </div>

        <uni-goods-nav
          :fill="true"
          :options="subscribeOptions"
          :buttonGroup="subscribeButtonGroup"
          @click="subscribeOnClick"
          @buttonClick="subscribeButtonClick"
        />
      </div>
    </uni-transition>

    <!-- 客服按钮 -->
    <button open-type="contact" ref="contact" id="contact"></button>
  </div>
</template>
<script>
import Tabs from "@/components/wiszx-tabs/tabs.vue";
import TabPane from "@/components/wiszx-tabs/tabPane.vue";

import uniGoodsNav from "@/components/uni-goods-nav/uni-goods-nav.vue";
export default {
  components: {
    Tabs,
    TabPane,
    uniGoodsNav,
  },
  data() {
    return {
      supplies: [
        {
          id: 1,
          name: "物资包",
          active: true,
        },
        {
          id: 2,
          name: "预约物资",
          active: false,
        },
      ],
      materiaCurrent: 0,
      options: [
        {
          icon: "headphones",
          text: "客服",
        },
        {
          icon: "cart",
          text: "购物车",
          info: 0,
        },
      ],
      buttonGroup: [
        {
          text: "加入购物车",
          backgroundColor: "#ff0000",
          color: "#fff",
        },
        {
          text: "立即购买",
          backgroundColor: "#ffa200",
          color: "#fff",
        },
      ],
      // 预约
      subscribeOptions: [
        {
          icon: "headphones",
          text: "客服",
        },
        {
          icon: "calendar-filled",
          text: "预约",
          info: 0,
        },
      ],
      subscribeButtonGroup: [
        {
          text: "立即预约",
          backgroundColor: "#55efc4",
          color: "#fff",
        },
      ],
      userId: null,
      //
      goods: [],
      goodsTypeList: [],
      goodsTypeId: null,
      selectGoods: [],
      // 预约
      subscribeGoods: [],
      selectSubscribeGoods: [],

      goodsCartList: [],
    };
  },
  mounted() {
    let tempUserId = uni.getStorageSync("userid");
    if (!tempUserId) uni.navigateTo({ url: "/pages/login/login" });
    this.userId = tempUserId;
    this.getGoodsType();
    this.getGoodsCart();
  },
  computed: {
    baseUrl() {
      return this.$base.url;
    },
  },
  methods: {
    // 得到购物车数据
    async getGoodsCart() {
      const res = await this.$http.request({
        url: "cart/list",
        method: "get",
        data: {
          yonghuId: this.userId,
        },
      });
      this.goodsCartList = res.data;
      this.options[1].info = this.goodsCartList.length;
    },
    // 得到商品分类
    async getGoodsType() {
      const res = await this.$http.request({
        url: "/goods/type/list",
        method: "get",
        data: {},
      });
      this.goodsTypeList = res.data;
      this.goodsTypeList.forEach((item) => {
        item.active = false;
      });
      this.goodsTypeList[0].active = true;
      this.goodsTypeId = this.goodsTypeList[0].id;
      this.getGoodsByType();
      this.getSubscribeGoods();
    },
    // 得到分类下的商品
    async getGoodsByType() {
      const res = await this.$http.request({
        url: "goods/list/has/" + this.goodsTypeId,
        method: "get",
      });
      this.goods = res.data;
      this.goods.forEach((item) => {
        item.isSelect = false;
        this.goodsCartList.forEach((cart) => {
          if (item.id == cart.goodsId) item.isSelect = true;
        });
      });
    },
    async getSubscribeGoods() {
      const res = await this.$http.request({
        url: "goods/list",
        method: "get",
        data: {
          goodsTypeId: this.goodsTypeId,
          inventory: 0,
        },
      });
      this.subscribeGoods = res.data;
      this.subscribeGoods.forEach((item) => {
        item.isSelect = false;
      });
    },
    changeSuppliesItemHandle(obj) {
      this.supplies.forEach((item) => {
        item.active = false;
      });
      obj.active = true;
    },
    changeMaterialTagsHandle(obj) {
      this.goodsTypeList.forEach((item) => {
        item.active = false;
      });
      obj.active = true;
      this.goodsTypeId = obj.id;
      this.getGoodsByType();
    },
    onClick(e) {
      // 客户
      if (e.index == 0) {
      } else if (e.index == 1) {
        // 购物车
        this.gotoCart();
      }
    },
    joinCart() {
      this.selectGoods.forEach((item) => {
        let data = {
          yonghuId: this.userId,
          goodsNum: 1,
          goodsId: item.id,
        };
        this.$http.request({
          url: "cart/save",
          method: "post",
          data,
        });
      });
    },
    buttonClick(e) {
      if (e.index == 0) {
        // 加入购物车
        this.options[1].info = this.selectGoods.length;
        this.joinCart();
      } else if (e.index == 1) {
        // 立即购买
        if (this.selectGoods.length > 0) {
          // this.joinCart();
          // this.gotoCart();
          this.selectGoods.forEach(item=>{
            let data = {
                  yonghuId: this.userId,
                  goodsId: item.id,
                  goodsNum: 1,
                  totalPrice: item.price
                }
                this.$http.request({
                  url: 'order/save',
                  method: 'post',
                  data
                }).then(res => {
                })
          })
          uni.navigateTo({
            url: '/pages/order-list/order-list'
          })
        } else {
          if (this.goodsCartList.length > 0) this.gotoCart();
          else {
            uni.showToast({
              title: "您还没选购物品",
              icon: "none",
              duration: 2000,
            });
          }
        }
      }
    },
    subscribeOnClick(e) {
      if (e.index == 1) {
        // 预约
        uni.navigateTo({
          url: "/pages/appointment-goods/appointment-goods",
        });
      }
    },
    subscribeButtonClick(e) {
      this.subscribeOptions[1].info = this.selectSubscribeGoods.length;
      this.selectSubscribeGoods.forEach((item) => {
        let data = {
          yonghuId: this.userId,
          goodsId: item.id,
        };
        this.$http
          .request({
            url: "/appointment/save",
            method: "post",
            data,
          })
          .then((res) => {
            console.log(res);
          });
      });
    },
    // 跳转到购物车
    gotoCart() {
      if (this.selectGoods.length > 0) {
        uni.setStorageSync("carts", this.selectGoods);
      }
      uni.navigateTo({
        url: "/pages/cart-list/cart-list",
      });
    },
    // checkbox 点击事件触发
    materialCheckHanlde(obj) {
      this.getGoodsCart();
      obj.isSelect = !obj.isSelect;
      if (obj.isSelect) this.selectGoods.push(obj);
      else {
        let index = this.selectGoods.findIndex((item) => item.id == obj.id);
        this.selectGoods.splice(index, 1);
        this.options[1].info = this.selectGoods.length;
        if (this.goodsCartList.length > 0) {
          let cart_index = this.goodsCartList.findIndex(
            (item) => item.goodsId == obj.id
          );
          let ids = this.goodsCartList[cart_index].id;
          this.$http
            .request({
              url: "cart/remove",
              method: "post",
              data: [ids],
            })
            .then((res) => {
              this.getGoodsCart();
            });
        }
      }
    },
    subscribeCheckHanlde(obj) {
      obj.isSelect = !obj.isSelect;
      if (obj.isSelect) this.selectSubscribeGoods.push(obj);
      // else {
      //   let index = this.selectSubscribeGoods.findIndex(item => item.id == obj.id)
      //   this.selectSubscribeGoods.splice(index, 1)
      //   this.subscribeOptions[1]. info = this.selectSubscribeGoods.length
      // }
    },
  },
};
</script>
<style lang="scss">
.supplies-bought-container {
  background: #fff;
}
.uni-goods-nav {
  position: fixed;
  left: 0;
  right: 0;
  bottom: 0;
}

.supplies-bought-container {
  width: 100%;
  height: 100%;
}
.supplies-heaer-wrap {
  display: flex;
  align-items: center;
  border-bottom: 1px solid #dfe6e9;
  height: 100rpx;
  .supplies-heaer-item {
    color: #b2bec3;
    padding: 20rpx;
    transition: all 0.3s ease;
  }
  .supplies-heaer-item-active {
    color: #ff7675;
  }
}
.material-tags-wrap {
  overflow-x: auto;
  white-space: nowrap;
  height: 80rpx;
  display: flex;
  align-items: center;
  .material-tags-item {
    display: inline;
    padding: 10rpx;
    color: #b2bec3;
    margin: 0 10rpx;
    transition: all 0.3s ease;
  }
  .material-tags-active {
    color: #000;
    border-bottom: 5upx solid #82a39d;
  }
}
.material-package-wrap {
  .material-item-wrap {
    width: 100%;
    height: calc(100vh - 100rpx - 80rpx - 100rpx);
    overflow-y: auto;
    display: flex;
    flex-wrap: wrap;
    .material-item {
      position: relative;
      border: 1px solid #dfe6e9;
      box-sizing: border-box;
      background: #fff;
      padding: 10rpx;
      height: 500rpx;
      width: 50%;
      overflow: hidden;
      .img-wrap {
        height: 400rpx;
        width: 100%;
        position: relative;
        image {
          border-radius: 10rpx;
          height: 400rpx;
          width: 100%;
        }
        .price-wrap {
          position: absolute;
          color: #fff;
          padding: 0 10rpx;
          bottom: 0;
          left: 0;
          right: 0;
          background: rgba($color: #000000, $alpha: 0.5);
        }
      }
      .material-item-describe {
        width: 100%;
        height: 80rpx;
        // overflow: hidden;
        // white-space: wrap;
        // text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-box-orient: vertical;
        -webkit-line-clamp: 2;
        overflow: hidden;

        padding: 0 0 10rpx 0;
        font-size: 30rpx;
      }
      checkbox {
        position: absolute;
        z-index: 100;
        top: 20rpx;
        right: 10rpx;
      }
    }
  }
  .non-data-wrap {
    color: #b2bec3;
    font-size: 40rpx;
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
  }
}
.uni-goods-nav {
  position: fixed;
  left: 0;
  right: 0;
  bottom: 0;
}
#contact {
  width: 48rpx;
  height: 100rpx;
  background: rgba($color: #000000, $alpha: 0);
  position: fixed;
  left: 20rpx;
  bottom: 0;
  z-index: 100;
  &::after {
    border: none;
  }
}
</style>