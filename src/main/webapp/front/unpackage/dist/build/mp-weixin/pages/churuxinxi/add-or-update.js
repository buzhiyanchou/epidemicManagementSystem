(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/churuxinxi/add-or-update"],{"0305":function(e,r,n){"use strict";n.r(r);var u=n("decf"),t=n.n(u);for(var i in u)"default"!==i&&function(e){n.d(r,e,(function(){return u[e]}))}(i);r["default"]=t.a},"2a52":function(e,r,n){},"6d01":function(e,r,n){"use strict";n.r(r);var u=n("d320"),t=n("0305");for(var i in t)"default"!==i&&function(e){n.d(r,e,(function(){return t[e]}))}(i);n("be25");var a,o=n("f0c5"),c=Object(o["a"])(t["default"],u["b"],u["c"],!1,null,"0a135be1",null,!1,u["a"],a);r["default"]=c.exports},"7dcb":function(e,r,n){"use strict";(function(e){n("5993");u(n("66fd"));var r=u(n("6d01"));function u(e){return e&&e.__esModule?e:{default:e}}e(r.default)}).call(this,n("543d")["createPage"])},be25:function(e,r,n){"use strict";var u=n("2a52"),t=n.n(u);t.a},d320:function(e,r,n){"use strict";n.d(r,"b",(function(){return t})),n.d(r,"c",(function(){return i})),n.d(r,"a",(function(){return u}));var u={wPicker:function(){return Promise.all([n.e("common/vendor"),n.e("components/w-picker/w-picker")]).then(n.bind(null,"5e31"))}},t=function(){var e=this,r=e.$createElement;e._self._c},i=[]},decf:function(e,r,n){"use strict";(function(e){Object.defineProperty(r,"__esModule",{value:!0}),r.default=void 0;var u=t(n("a34a"));function t(e){return e&&e.__esModule?e:{default:e}}function i(e,r,n,u,t,i,a){try{var o=e[i](a),c=o.value}catch(s){return void n(s)}o.done?r(c):Promise.resolve(c).then(u,t)}function a(e){return function(){var r=this,n=arguments;return new Promise((function(u,t){var a=e.apply(r,n);function o(e){i(a,u,t,o,c,"next",e)}function c(e){i(a,u,t,o,c,"throw",e)}o(void 0)}))}}var o=function(){Promise.all([n.e("common/vendor"),n.e("components/w-picker/w-picker")]).then(function(){return resolve(n("5e31"))}.bind(null,n)).catch(n.oe)},c={data:function(){return{cross:"",ruleForm:{churuleixing:"",churubiaoti:"",churutupian:"",churucishu:"1",xingchengshangbao:"",churushuoming:"",yonghuming:"",xingming:"",shouji:"",zhuzhi:"",sfsh:"",shhf:"",userid:""},churuleixingOptions:[],churuleixingIndex:0,user:{},ro:{churuleixing:!1,churubiaoti:!1,churutupian:!1,churucishu:!1,xingchengshangbao:!1,churushuoming:!1,yonghuming:!1,xingming:!1,shouji:!1,zhuzhi:!1,sfsh:!1,shhf:!1,userid:!1}}},components:{wPicker:o},computed:{baseUrl:function(){return this.$base.url}},onLoad:function(r){var n=this;return a(u.default.mark((function t(){var i,a,o,c;return u.default.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return n.ruleForm.xingchengshangbao=n.$utils.getCurDateTime(),i=e.getStorageSync("nowTable"),t.next=4,n.$api.session(i);case 4:if(a=t.sent,n.user=a.data,n.ruleForm.yonghuming=n.user.yonghuming,n.ro.yonghuming=!0,n.ruleForm.xingming=n.user.xingming,n.ro.xingming=!0,n.ruleForm.shouji=n.user.shouji,n.ro.shouji=!0,n.ruleForm.zhuzhi=n.user.zhuzhi,n.ro.zhuzhi=!0,n.ro.churucishu=!0,n.churuleixingOptions="出,入".split(","),n.ruleForm.userid=e.getStorageSync("userid"),r.refid&&(n.ruleForm.refid=r.refid,n.ruleForm.nickname=e.getStorageSync("nickname")),!r.id){t.next=24;break}return n.ruleForm.id=r.id,t.next=22,n.$api.info("churuxinxi",n.ruleForm.id);case 22:a=t.sent,n.ruleForm=a.data;case 24:if(n.cross=r.cross,!r.cross){t.next=76;break}o=e.getStorageSync("crossObj"),t.t0=u.default.keys(o);case 28:if((t.t1=t.t0()).done){t.next=76;break}if(c=t.t1.value,"churuleixing"!=c){t.next=34;break}return n.ruleForm.churuleixing=o[c],n.ro.churuleixing=!0,t.abrupt("continue",28);case 34:if("churubiaoti"!=c){t.next=38;break}return n.ruleForm.churubiaoti=o[c],n.ro.churubiaoti=!0,t.abrupt("continue",28);case 38:if("churutupian"!=c){t.next=42;break}return n.ruleForm.churutupian=o[c],n.ro.churutupian=!0,t.abrupt("continue",28);case 42:if("churucishu"!=c){t.next=46;break}return n.ruleForm.churucishu=o[c],n.ro.churucishu=!0,t.abrupt("continue",28);case 46:if("xingchengshangbao"!=c){t.next=50;break}return n.ruleForm.xingchengshangbao=o[c],n.ro.xingchengshangbao=!0,t.abrupt("continue",28);case 50:if("churushuoming"!=c){t.next=54;break}return n.ruleForm.churushuoming=o[c],n.ro.churushuoming=!0,t.abrupt("continue",28);case 54:if("yonghuming"!=c){t.next=58;break}return n.ruleForm.yonghuming=o[c],n.ro.yonghuming=!0,t.abrupt("continue",28);case 58:if("xingming"!=c){t.next=62;break}return n.ruleForm.xingming=o[c],n.ro.xingming=!0,t.abrupt("continue",28);case 62:if("shouji"!=c){t.next=66;break}return n.ruleForm.shouji=o[c],n.ro.shouji=!0,t.abrupt("continue",28);case 66:if("zhuzhi"!=c){t.next=70;break}return n.ruleForm.zhuzhi=o[c],n.ro.zhuzhi=!0,t.abrupt("continue",28);case 70:if("userid"!=c){t.next=74;break}return n.ruleForm.userid=o[c],n.ro.userid=!0,t.abrupt("continue",28);case 74:t.next=28;break;case 76:n.styleChange();case 77:case"end":return t.stop()}}),t)})))()},methods:{styleChange:function(){this.$nextTick((function(){}))},xingchengshangbaoConfirm:function(e){console.log(e),this.ruleForm.xingchengshangbao=e.result,this.$forceUpdate()},churuleixingChange:function(e){this.churuleixingIndex=e.target.value,this.ruleForm.churuleixing=this.churuleixingOptions[this.churuleixingIndex]},churutupianTap:function(){var e=this;this.$api.upload((function(r){e.ruleForm.churutupian="upload/"+r.file,e.$forceUpdate(),e.$nextTick((function(){e.styleChange()}))}))},getUUID:function(){return(new Date).getTime()},onSubmitTap:function(){var r=this;return a(u.default.mark((function n(){var t,i,a,o,c,s,h,l,g,f;return u.default.wrap((function(n){while(1)switch(n.prev=n.next){case 0:if(r.ruleForm.churuleixing){n.next=3;break}return r.$utils.msg("出入类型不能为空"),n.abrupt("return");case 3:if(r.ruleForm.churubiaoti){n.next=6;break}return r.$utils.msg("出入标题不能为空"),n.abrupt("return");case 6:if(!r.ruleForm.churucishu||r.$validate.isIntNumer(r.ruleForm.churucishu)){n.next=9;break}return r.$utils.msg("出入次数应输入整数"),n.abrupt("return");case 9:if(!r.ruleForm.shouji||r.$validate.isMobile(r.ruleForm.shouji)){n.next=12;break}return r.$utils.msg("手机应输入手机格式"),n.abrupt("return");case 12:if(!r.cross){n.next=28;break}if(o=e.getStorageSync("statusColumnName"),c=e.getStorageSync("statusColumnValue"),""==o){n.next=28;break}if(s=e.getStorageSync("crossObj"),o.startsWith("[")){n.next=24;break}for(h in s)h==o&&(s[h]=c);return l=e.getStorageSync("crossTable"),n.next=22,r.$api.update("".concat(l),s);case 22:n.next=28;break;case 24:t=Number(e.getStorageSync("userid")),i=s["id"],a=e.getStorageSync("statusColumnName"),a=a.replace(/\[/,"").replace(/\]/,"");case 28:if(!i||!t){n.next=50;break}return r.ruleForm.crossuserid=t,r.ruleForm.crossrefid=i,g={page:1,limit:10,crossuserid:t,crossrefid:i},n.next=34,r.$api.list("churuxinxi",g);case 34:if(f=n.sent,!(f.data.total>=a)){n.next=40;break}return r.$utils.msg(e.getStorageSync("tips")),n.abrupt("return",!1);case 40:if(!r.ruleForm.id){n.next=45;break}return n.next=43,r.$api.update("churuxinxi",r.ruleForm);case 43:n.next=47;break;case 45:return n.next=47,r.$api.add("churuxinxi",r.ruleForm);case 47:r.$utils.msgBack("提交成功");case 48:n.next=58;break;case 50:if(!r.ruleForm.id){n.next=55;break}return n.next=53,r.$api.update("churuxinxi",r.ruleForm);case 53:n.next=57;break;case 55:return n.next=57,r.$api.add("churuxinxi",r.ruleForm);case 57:r.$utils.msgBack("提交成功");case 58:case"end":return n.stop()}}),n)})))()},optionsChange:function(e){this.index=e.target.value},bindDateChange:function(e){this.date=e.target.value},getDate:function(e){var r=new Date,n=r.getFullYear(),u=r.getMonth()+1,t=r.getDate();return"start"===e?n-=60:"end"===e&&(n+=2),u=u>9?u:"0"+u,t=t>9?t:"0"+t,"".concat(n,"-").concat(u,"-").concat(t)},toggleTab:function(e){this.$refs[e].show()}}};r.default=c}).call(this,n("543d")["default"])}},[["7dcb","common/runtime","common/vendor"]]]);