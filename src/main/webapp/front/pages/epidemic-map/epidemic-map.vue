<template>
  <div class="epidemic-map-container">
    <web-view src="https://news.sina.cn/zt_d/yiqing0121/?sendweibouid=2028810631&sendweibouid=6433985375"></web-view>
  </div>
</template>
<script>
export default {
  components: {
  },
  data() {
    return {
      //地图数据
      chartsDataMap: {
        series: [],
      },
      // 覆盖的是 option
      config: {
        extra: {
          map: {
            mercator: true,
          },
        },
      },
    };
  },
  onLaunch() {},
  onLoad() {},
  onShow() {},
  created() {

  },
  mounted() {
    // this.initEcharts()
  },
  beforeDestroy() {},
  methods: {
  
  },
};
</script>
<style lang="scss">
.epidemic-map {
  width: 100%;
  height: 600rpx;
}
.charts-box {
  width: 100%;
  height: 360px;
}
</style>