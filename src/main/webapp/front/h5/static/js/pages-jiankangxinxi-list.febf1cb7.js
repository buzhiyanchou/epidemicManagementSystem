(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-jiankangxinxi-list"],{"16be":function(n,t,e){"use strict";var i=e("4ea4");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0,e("55dd"),e("96cf");var a=i(e("3b8d")),r={data:function(){return{btnColor:["#409eff","#67c23a","#909399","#e6a23c","#f56c6c","#356c6c","#351c6c","#f093a9","#a7c23a","#104eff","#10441f","#a21233","#503319"],queryList:[{queryName:"上报标题"},{queryName:"风险地区"},{queryName:"上报日期"}],sactiveItem:{padding:"0 28rpx",boxShadow:"0 0 12rpx rgba(0,0,0,.3)",margin:"0 12rpx",borderColor:"rgba(0,0,0,1)",backgroundColor:"rgba(130, 163, 157, 1)",color:"#fff",borderRadius:"8rpx",borderWidth:"0",width:"auto",lineHeight:"70rpx",fontSize:"28rpx",borderStyle:"solid"},sitem:{padding:"0 20rpx",boxShadow:"0 0 12rpx rgba(0,0,0,.3)",margin:"0 12rpx",borderColor:"rgba(0,0,0,1)",backgroundColor:"rgba(161, 161, 161, 1)",color:"rgba(255, 255, 255, 1)",borderRadius:"8rpx",borderWidth:"0",width:"auto",lineHeight:"70rpx",fontSize:"28rpx",borderStyle:"solid"},queryIndex:0,list:[],userid:"",mescroll:null,downOption:{auto:!1},upOption:{noMoreSize:5,textNoMore:"~ 没有更多了 ~"},hasNext:!0,searchForm:{},CustomBar:"0"}},computed:{baseUrl:function(){return this.$base.url}},onShow:function(){var n=(0,a.default)(regeneratorRuntime.mark((function n(){return regeneratorRuntime.wrap((function(n){while(1)switch(n.prev=n.next){case 0:1==uni.getStorageSync("useridTag")?(this.userid=uni.getStorageSync("useridTag"),uni.removeStorageSync("useridTag")):this.userid="",this.btnColor=this.btnColor.sort((function(){return.5-Math.random()})),this.hasNext=!0,this.mescroll&&this.mescroll.resetUpScroll();case 4:case"end":return n.stop()}}),n,this)})));function t(){return n.apply(this,arguments)}return t}(),onLoad:function(n){1==uni.getStorageSync("useridTag")?(this.userid=uni.getStorageSync("useridTag"),uni.removeStorageSync("useridTag")):this.userid="",this.hasNext=!0,this.mescroll&&this.mescroll.resetUpScroll()},methods:{queryChange:function(n){this.queryIndex=n.detail.value,this.searchForm.shangbaobiaoti="",this.searchForm.fengxiandiqu="",this.searchForm.shangbaoriqi=""},mescrollInit:function(n){this.mescroll=n},downCallback:function(n){this.hasNext=!0,n.resetUpScroll()},upCallback:function(){var n=(0,a.default)(regeneratorRuntime.mark((function n(t){var e,i;return regeneratorRuntime.wrap((function(n){while(1)switch(n.prev=n.next){case 0:if(e={page:t.num,limit:t.size},this.searchForm.shangbaobiaoti&&(e["shangbaobiaoti"]="%"+this.searchForm.shangbaobiaoti+"%"),this.searchForm.fengxiandiqu&&(e["fengxiandiqu"]="%"+this.searchForm.fengxiandiqu+"%"),this.searchForm.shangbaoriqi&&(e["shangbaoriqi"]="%"+this.searchForm.shangbaoriqi+"%"),i={},!this.userid){n.next=11;break}return n.next=8,this.$api.page("jiankangxinxi",e);case 8:i=n.sent,n.next=14;break;case 11:return n.next=13,this.$api.list("jiankangxinxi",e);case 13:i=n.sent;case 14:1==t.num&&(this.list=[]),this.list=this.list.concat(i.data.list),0==i.data.list.length&&(this.hasNext=!1),t.endSuccess(t.size,this.hasNext);case 18:case"end":return n.stop()}}),n,this)})));function t(t){return n.apply(this,arguments)}return t}(),onDetailTap:function(n){uni.setStorageSync("useridTag",this.userid),this.$utils.jump("./detail?id=".concat(n.id,"&userid=")+this.userid)},onUpdateTap:function(n){uni.setStorageSync("useridTag",this.userid),this.$utils.jump("./add-or-update?id=".concat(n))},onAddTap:function(){uni.setStorageSync("useridTag",this.userid),this.$utils.jump("./add-or-update")},onDeleteTap:function(n){var t=this;uni.showModal({title:"提示",content:"是否确认删除",success:function(){var e=(0,a.default)(regeneratorRuntime.mark((function e(i){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(!i.confirm){e.next=5;break}return e.next=3,t.$api.del("jiankangxinxi",JSON.stringify([n]));case 3:t.hasNext=!0,t.mescroll.resetUpScroll();case 5:case"end":return e.stop()}}),e)})));function i(n){return e.apply(this,arguments)}return i}()})},search:function(){var n=(0,a.default)(regeneratorRuntime.mark((function n(){var t,e;return regeneratorRuntime.wrap((function(n){while(1)switch(n.prev=n.next){case 0:if(this.mescroll.num=1,t={page:this.mescroll.num,limit:this.mescroll.size},this.searchForm.shangbaobiaoti&&(t["shangbaobiaoti"]="%"+this.searchForm.shangbaobiaoti+"%"),this.searchForm.fengxiandiqu&&(t["fengxiandiqu"]="%"+this.searchForm.fengxiandiqu+"%"),this.searchForm.shangbaoriqi&&(t["shangbaoriqi"]="%"+this.searchForm.shangbaoriqi+"%"),e={},!this.userid){n.next=12;break}return n.next=9,this.$api.page("jiankangxinxi",t);case 9:e=n.sent,n.next=15;break;case 12:return n.next=14,this.$api.list("jiankangxinxi",t);case 14:e=n.sent;case 15:1==this.mescroll.num&&(this.list=[]),this.list=this.list.concat(e.data.list),0==e.data.list.length&&(this.hasNext=!1),this.mescroll.endSuccess(this.mescroll.size,this.hasNext);case 19:case"end":return n.stop()}}),n,this)})));function t(){return n.apply(this,arguments)}return t}()}};t.default=r},1755:function(n,t,e){"use strict";e.r(t);var i=e("d8f1"),a=e("598a");for(var r in a)"default"!==r&&function(n){e.d(t,n,(function(){return a[n]}))}(r);e("d28a");var o,s=e("f0c5"),d=Object(s["a"])(a["default"],i["b"],i["c"],!1,null,"c0441702",null,!1,i["a"],o);t["default"]=d.exports},4323:function(n,t,e){var i=e("24fb");t=i(!1),t.push([n.i,'\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t/* product */uni-page-body[data-v-c0441702]{background:#eee}uni-view[data-v-c0441702]{font-size:%?28?%}.uni-product-list[data-v-c0441702]{display:-webkit-box;display:-webkit-flex;display:flex;width:100%;-webkit-flex-wrap:wrap;flex-wrap:wrap;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-webkit-flex-direction:row;flex-direction:row;margin-top:%?0?%\n\t\t/* justify-content: space-around; */}.uni-product[data-v-c0441702]{padding:%?10?%;margin:%?10?%;display:-webkit-box;display:-webkit-flex;display:flex;-webkit-box-orient:vertical;-webkit-box-direction:normal;-webkit-flex-direction:column;flex-direction:column;background:#fff}.image-view[data-v-c0441702]{height:%?330?%;width:%?330?%;margin:%?12?% 0}.uni-product-image[data-v-c0441702]{height:%?330?%;width:%?330?%}.uni-product-title[data-v-c0441702]{width:%?300?%;word-break:break-all;display:-webkit-box;overflow:hidden;line-height:1.5;text-overflow:ellipsis;-webkit-box-orient:vertical;-webkit-line-clamp:2}.uni-product-price[data-v-c0441702]{margin-top:%?10?%;font-size:%?28?%;line-height:1.5;position:relative}.uni-product-price-original[data-v-c0441702]{color:#e80080}.uni-product-price-favour[data-v-c0441702]{color:#888;text-decoration:line-through;margin-left:%?10?%}.uni-product-tip[data-v-c0441702]{position:absolute;right:%?10?%;background-color:#f33;color:#fff;padding:0 %?10?%;border-radius:%?5?%}uni-image > div[data-v-c0441702], uni-image > img[data-v-c0441702]{width:100%;height:140px;object-fit:cover}.add-btn[data-v-c0441702]{position:fixed;left:%?30?%;right:%?30?%;\n\t\tbottom:%?106?%;\n\t\t\n\t\tz-index:95;display:-webkit-box;display:-webkit-flex;display:flex;-webkit-box-align:center;-webkit-align-items:center;align-items:center;-webkit-box-pack:center;-webkit-justify-content:center;justify-content:center;width:%?690?%;height:%?80?%;font-size:%?32?%;color:#fff;background-color:red;border-radius:%?10?%;box-shadow:1px 2px 5px rgba(219,63,96,.4)}.list[data-v-c0441702]{padding:%?20?% %?20?% %?20?%}.listm[data-v-c0441702]{background:#fff;border-radius:%?15?%;box-shadow:0 0 %?2?% rgba(0,0,0,.1);margin-bottom:%?20?%;padding:%?30?%}.listmpic[data-v-c0441702]{border-radius:%?10?%;width:%?166?%;margin-right:%?20?%}.listmr[data-v-c0441702]{\n\t\t/* width: 460upx; */display:inline-block;-webkit-box-flex:1;-webkit-flex:1;flex:1;display:-webkit-box;display:-webkit-flex;display:flex;-webkit-box-pack:justify;-webkit-justify-content:space-between;justify-content:space-between;-webkit-box-orient:vertical;-webkit-box-direction:normal;-webkit-flex-direction:column;flex-direction:column}.news-box6 .dian[data-v-c0441702]::before{content:"";display:block;width:8px;height:8px;background-color:red;position:absolute;top:-4px;left:50%;-webkit-transform:translateX(-50%);transform:translateX(-50%);border-radius:100%;z-index:1}.hide1[data-v-c0441702]{overflow:hidden;text-overflow:ellipsis;display:-webkit-box;-webkit-line-clamp:1;line-clamp:1;-webkit-box-orient:vertical}.hide2[data-v-c0441702]{overflow:hidden;text-overflow:ellipsis;display:-webkit-box;-webkit-line-clamp:2;line-clamp:2;-webkit-box-orient:vertical}.hide4[data-v-c0441702]{overflow:hidden;text-overflow:ellipsis;display:-webkit-box;-webkit-line-clamp:4;line-clamp:4;-webkit-box-orient:vertical}body.?%PAGE?%[data-v-c0441702]{background:#eee}',""]),n.exports=t},"598a":function(n,t,e){"use strict";e.r(t);var i=e("16be"),a=e.n(i);for(var r in i)"default"!==r&&function(n){e.d(t,n,(function(){return i[n]}))}(r);t["default"]=a.a},"5ab7":function(n,t,e){var i=e("4323");"string"===typeof i&&(i=[[n.i,i,""]]),i.locals&&(n.exports=i.locals);var a=e("4f06").default;a("b9dbb282",i,!0,{sourceMap:!1,shadowMode:!1})},d28a:function(n,t,e){"use strict";var i=e("5ab7"),a=e.n(i);a.a},d8f1:function(n,t,e){"use strict";var i={"mescroll-uni":e("f05e").default},a=function(){var n=this,t=n.$createElement,e=n._self._c||t;return e("mescroll-uni",{attrs:{up:n.upOption,down:n.downOption},on:{init:function(t){arguments[0]=t=n.$handleEvent(t),n.mescrollInit.apply(void 0,arguments)},down:function(t){arguments[0]=t=n.$handleEvent(t),n.downCallback.apply(void 0,arguments)},up:function(t){arguments[0]=t=n.$handleEvent(t),n.upCallback.apply(void 0,arguments)}}},[e("v-uni-view",{staticClass:"cu-bar bg-white search",style:[{top:n.CustomBar+"px"}]},[n.queryList.length>1?e("v-uni-picker",{staticStyle:{"padding-left":"20upx"},attrs:{mode:"selector",range:n.queryList,"range-key":"queryName",value:n.queryIndex},on:{change:function(t){arguments[0]=t=n.$handleEvent(t),n.queryChange.apply(void 0,arguments)}}},[e("v-uni-view",[e("v-uni-image",{staticStyle:{width:"20upx",height:"33upx"},attrs:{src:"../../static/center/to.png"}})],1)],1):n._e(),0==n.queryIndex?e("v-uni-view",{staticClass:"search-form round"},[e("v-uni-text",{staticClass:"cuIcon-search"}),e("v-uni-input",{attrs:{type:"text",placeholder:"上报标题"},model:{value:n.searchForm.shangbaobiaoti,callback:function(t){n.$set(n.searchForm,"shangbaobiaoti",t)},expression:"searchForm.shangbaobiaoti"}})],1):n._e(),1==n.queryIndex?e("v-uni-view",{staticClass:"search-form round"},[e("v-uni-text",{staticClass:"cuIcon-search"}),e("v-uni-input",{attrs:{type:"text",placeholder:"风险地区"},model:{value:n.searchForm.fengxiandiqu,callback:function(t){n.$set(n.searchForm,"fengxiandiqu",t)},expression:"searchForm.fengxiandiqu"}})],1):n._e(),2==n.queryIndex?e("v-uni-view",{staticClass:"search-form round"},[e("v-uni-text",{staticClass:"cuIcon-search"}),e("v-uni-input",{attrs:{type:"text",placeholder:"上报日期"},model:{value:n.searchForm.shangbaoriqi,callback:function(t){n.$set(n.searchForm,"shangbaoriqi",t)},expression:"searchForm.shangbaoriqi"}})],1):n._e(),e("v-uni-view",{staticClass:"action"},[e("v-uni-button",{staticClass:"cu-btn shadow-blur round",style:{width:"auto",borderRadius:"8rpx",height:"80rpx",fontSize:"28rpx",color:"#fff",backgroundColor:n.btnColor[0],borderColor:n.btnColor[0]},on:{click:function(t){arguments[0]=t=n.$handleEvent(t),n.search.apply(void 0,arguments)}}},[n._v("搜索")])],1)],1),e("v-uni-view",{style:""},[e("v-uni-view",{staticClass:"uni-product-list",staticStyle:{"box-sizing":"border-box"},style:{padding:"20rpx 0",boxShadow:"0 0 12rpx rgba(255,0,0,0)",margin:"0",borderColor:"red",backgroundColor:"rgba(255, 255, 255, 1)",borderRadius:0,borderWidth:"0",width:"100%",borderStyle:"solid",height:"auto"}},n._l(n.list,(function(t,i){return e("v-uni-view",{key:i,staticClass:"uni-product",style:{padding:"0px 20rpx 0",boxShadow:"0 0 12rpx rgba(255,0,0,0)",margin:"0 1% 20rpx 2%",borderColor:"rgba(130, 163, 157, 1)",backgroundColor:"#fff",borderRadius:"20rpx",borderWidth:"2rpx",width:"47%",borderStyle:"solid",height:"auto"},on:{click:function(e){arguments[0]=e=n.$handleEvent(e),n.onDetailTap(t)}}},[e("v-uni-view",{staticClass:"uni-product-title",style:{padding:"0",boxShadow:"0 0 12rpx rgba(255,0,0,0)",margin:"0",borderColor:"red",backgroundColor:"rgba(255,0,0,0)",color:"#333",textAlign:"center",borderRadius:"0",borderWidth:"0",width:"100%",fontSize:"28rpx",lineHeight:"56rpx",borderStyle:"solid"}},[n._v(n._s(t.shangbaobiaoti))]),e("v-uni-image",{staticClass:"uni-product-image",style:{padding:"0",boxShadow:"0 0 12rpx rgba(255,0,0,0)",margin:"0",borderColor:"red",backgroundColor:"rgba(255,0,0,0)",borderRadius:"8rpx",borderWidth:"0",width:"95%",borderStyle:"solid",height:"260rpx"},attrs:{mode:"aspectFill",src:t.shangbaotupian?n.baseUrl+t.shangbaotupian.split(",")[0]:""}}),e("v-uni-view",{staticStyle:{display:"flex","justify-content":"space-between"}},[n.userid&&n.isAuth("jiankangxinxi","修改")?e("v-uni-text",{staticClass:"cuIcon-edit",on:{click:function(e){e.stopPropagation(),arguments[0]=e=n.$handleEvent(e),n.onUpdateTap(t.id)}}},[n._v("修改")]):n._e(),!n.userid&&n.isAuthFront("jiankangxinxi","修改")?e("v-uni-text",{staticClass:"cuIcon-edit",on:{click:function(e){e.stopPropagation(),arguments[0]=e=n.$handleEvent(e),n.onUpdateTap(t.id)}}},[n._v("修改")]):n._e(),n.userid&&n.isAuth("jiankangxinxi","删除")?e("v-uni-text",{staticClass:"cuIcon-delete",on:{click:function(e){e.stopPropagation(),arguments[0]=e=n.$handleEvent(e),n.onDeleteTap(t.id)}}},[n._v("删除")]):n._e(),!n.userid&&n.isAuthFront("jiankangxinxi","删除")?e("v-uni-text",{staticClass:"cuIcon-delete",on:{click:function(e){e.stopPropagation(),arguments[0]=e=n.$handleEvent(e),n.onDeleteTap(t.id)}}},[n._v("删除")]):n._e()],1)],1)})),1)],1),n.userid&&n.isAuth("jiankangxinxi","新增")?e("v-uni-button",{staticClass:"add-btn",style:{padding:"0",boxShadow:"0 0 16rpx rgba(0,0,0,0) inset",margin:"0",backgroundColor:"rgba(130, 163, 157, 1)",borderColor:"rgba(130, 163, 157, 1)",borderRadius:"80rpx",color:"#fff",borderWidth:"1",width:"80%",fontSize:"28rpx",borderStyle:"solid",height:"80rpx"},on:{click:function(t){arguments[0]=t=n.$handleEvent(t),n.onAddTap()}}},[n._v("新增")]):n._e(),!n.userid&&n.isAuthFront("jiankangxinxi","新增")?e("v-uni-button",{staticClass:"add-btn",style:{padding:"0",boxShadow:"0 0 16rpx rgba(0,0,0,0) inset",margin:"0",backgroundColor:"rgba(130, 163, 157, 1)",borderColor:"rgba(130, 163, 157, 1)",borderRadius:"80rpx",color:"#fff",borderWidth:"1",width:"80%",fontSize:"28rpx",borderStyle:"solid",height:"80rpx"},on:{click:function(t){arguments[0]=t=n.$handleEvent(t),n.onAddTap()}}},[n._v("新增")]):n._e()],1)},r=[];e.d(t,"b",(function(){return a})),e.d(t,"c",(function(){return r})),e.d(t,"a",(function(){return i}))}}]);