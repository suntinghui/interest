(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-611baa22"],{5959:function(t,e,a){"use strict";var n=a("90a9"),l=a.n(n);l.a},"6ed6":function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticStyle:{margin:"40px"}},[a("div",[a("Row",{staticStyle:{"margin-bottom":"25px"}},[a("Col",{attrs:{span:"8"}},[t._v("日期：\n\t\t\t"),a("DatePicker",{staticStyle:{width:"250px"},attrs:{type:"date",placeholder:"选择日期"},model:{value:t.dateModel,callback:function(e){t.dateModel=e},expression:"dateModel"}})],1),a("Col",{attrs:{span:"8"}},[t._v("设备：\n\t\t\t"),a("Select",{staticStyle:{width:"250px"},attrs:{filterable:"",clearable:""},model:{value:t.deviceModel,callback:function(e){t.deviceModel=e},expression:"deviceModel"}},t._l(this.$store.state.param.deviceTypeList,(function(e){return a("Option",{key:e.paramKey,attrs:{value:e.paramKey}},[t._v(t._s(e.paramValue))])})),1)],1),a("Col",{attrs:{span:"8"}},[t._v("所属地区：\n\t\t\t"),a("Select",{staticStyle:{width:"250px"},attrs:{filterable:"",clearable:""},model:{value:t.areaModel,callback:function(e){t.areaModel=e},expression:"areaModel"}},t._l(this.$store.state.param.areaList,(function(e){return a("Option",{key:e.paramKey,attrs:{value:e.paramKey}},[t._v(t._s(e.paramValue))])})),1)],1)],1),a("Row",{staticStyle:{"margin-bottom":"25px"}},[a("Col",{attrs:{span:"8"}},[t._v("渠道：\n\t\t\t"),a("Select",{staticStyle:{width:"250px"},attrs:{filterable:"",clearable:""},model:{value:t.channelModel,callback:function(e){t.channelModel=e},expression:"channelModel"}},t._l(this.$store.state.param.channelList,(function(e){return a("Option",{key:e.paramKey,attrs:{value:e.paramKey}},[t._v(t._s(e.paramValue))])})),1)],1),a("Col",{attrs:{span:"8"}},[t._v("网点：\n\t\t\t"),a("Select",{staticStyle:{width:"250px"},attrs:{filterable:"",clearable:""},model:{value:t.shopModel,callback:function(e){t.shopModel=e},expression:"shopModel"}},t._l(this.$store.state.param.shopList,(function(e){return a("Option",{key:e.paramKey,attrs:{value:e.paramKey}},[t._v(t._s(e.paramValue)+"\n\t\t\t\t\t("+t._s(e.paramKey)+")")])})),1)],1),a("Col",{attrs:{span:"8"}},[t._v("网点类型：\n\t\t\t"),a("Select",{staticStyle:{width:"250px"},attrs:{filterable:"",clearable:""},model:{value:t.shopTypeModel,callback:function(e){t.shopTypeModel=e},expression:"shopTypeModel"}},t._l(this.$store.state.param.shopTypeList,(function(e){return a("Option",{key:e.paramKey,attrs:{value:e.paramKey}},[t._v(t._s(e.paramValue))])})),1)],1)],1),a("Row",{staticStyle:{"margin-bottom":"25px","text-align":"right"}},[a("Col",{attrs:{span:"22"}},[a("Button",{attrs:{type:"primary",shape:"circle",icon:"ios-search"},on:{click:function(e){return t.search()}}},[t._v("搜索")])],1)],1)],1),t.showSpin?a("Spin",{attrs:{size:"large",fix:""}}):t._e(),a("div",{staticStyle:{padding:"10px 0"}},[a("Table",{attrs:{border:"",columns:t.columns0,data:t.dataList,height:350}})],1),a("div",{staticStyle:{"text-align":"right"}},[a("Page",{attrs:{total:t.total,"page-size":t.pageInfo.pageSize,"show-sizer":"","show-total":""},on:{"on-page-size-change":function(e){t.pageSizeChange(e)},"on-change":function(e){t.pageSearch(e)}}})],1),a("Modal",{attrs:{closable:"",scrollable:"","mask-closable":!1,width:"60%",title:"详情信息"},model:{value:t.showDetailModel,callback:function(e){t.showDetailModel=e},expression:"showDetailModel"}},[a("Tabs",{attrs:{value:t.tabCheck,animated:!0,type:"card"},model:{value:t.tabCheck,callback:function(e){t.tabCheck=e},expression:"tabCheck"}},[a("Tab-pane",{attrs:{label:"机器信息",name:"name1"}},t._l(this.detailInfo.deviceInfo,(function(e,n){return a("div",{key:n,staticClass:"detailDiv"},[a("span",{staticClass:"keyDetail"},[t._v(t._s(n)+"：")]),a("span",{staticClass:"valueDetail"},[t._v(t._s(e))])])})),0),a("Tab-pane",{attrs:{label:"门店信息",name:"name2"}},t._l(this.detailInfo.shopInfo,(function(e,n){return a("div",{key:n,staticClass:"detailDiv"},[a("span",{staticClass:"keyDetail"},[t._v(t._s(n)+"：")]),a("span",{staticClass:"valueDetail"},[t._v(t._s(e))])])})),0),a("Tab-pane",{attrs:{label:"运营状态",name:"name3"}},[a("Table",{attrs:{border:"",size:"small",columns:t.columns31,data:t.data31}})],1),a("Tab-pane",{attrs:{label:"维护信息",name:"name4"}}),a("Tab-pane",{staticStyle:{height:"400px","overflow-y":"auto","overflow-x":"hidden"},attrs:{label:"交易信息",name:"name5"}},[a("p",{staticClass:"subTitle"},[t._v("销售")]),a("Table",{attrs:{border:"",size:"small",columns:t.columns51,data:t.data51}}),a("p",{staticClass:"subTitle"},[t._v("退款")]),a("Table",{attrs:{border:"",size:"small",columns:t.columns52,data:t.data52}}),a("p",{staticClass:"subTitle"},[t._v("退款订单比率")]),a("Table",{attrs:{border:"",size:"small",columns:t.columns53,data:t.data53}}),a("p",{staticClass:"subTitle"},[t._v("当日销售")]),a("Table",{attrs:{border:"",size:"small",columns:t.columns54,data:t.data54}}),a("p",{staticClass:"subTitle"},[t._v("当日退款")]),a("Table",{attrs:{border:"",size:"small",columns:t.columns55,data:t.data55}}),a("p",{staticClass:"subTitle"},[t._v("当日票种数量")]),a("Table",{attrs:{border:"",size:"small",columns:t.columns56,data:t.data56}})],1)],1),a("div",{attrs:{slot:"footer"},slot:"footer"})],1)],1)},l=[],i=a("09bd"),s=a.n(i);function o(t,e){return p(t)||c(t,e)||r()}function r(){throw new TypeError("Invalid attempt to destructure non-iterable instance")}function c(t,e){if(Symbol.iterator in Object(t)||"[object Arguments]"===Object.prototype.toString.call(t)){var a=[],n=!0,l=!1,i=void 0;try{for(var s,o=t[Symbol.iterator]();!(n=(s=o.next()).done);n=!0)if(a.push(s.value),e&&a.length===e)break}catch(r){l=!0,i=r}finally{try{n||null==o["return"]||o["return"]()}finally{if(l)throw i}}return a}}function p(t){if(Array.isArray(t))return t}s.a.shim();var u={data:function(){var t=this;return{showDetailModel:!1,detailInfo:{},tabCheck:"name1",showSpin:!1,searchContent:null,groupId:[],total:0,pageInfo:{page:0,pageSize:10},columns0:[{title:"机器编号",key:"机器编号",align:"center"},{title:"网点编号",key:"网点编号",align:"center",sortable:!0,width:150},{title:"启用时间",key:"启用时间",align:"center",sortable:!0},{title:"设备类型",key:"设备类型",align:"center",sortable:!0,width:120},{title:"设备位置",key:"设备位置",align:"center"},{title:"操作",key:"Action",align:"center",width:150,render:function(e,a){return e("Button",{props:{type:"primary"},on:{click:function(){t.showDetailInfo(a.row)}}},"详情")}}],dataList:[],columns31:[],data31:[],columns51:[{title:"累计销售金额（元）",key:"累计销售金额（元）",align:"center"},{title:"累计销售票数（张）",key:"累计销售票数（张）",align:"center"},{title:"累计订单数（单）",key:"累计订单数（单）",align:"center"}],data51:[{"累计销售金额（元）":"100","累计销售票数（张）":"2","累计订单数（单）":"30"}],columns52:[{title:"累计退款订单数",key:"累计退款订单数",align:"center"},{title:"累计退款额",key:"累计退款额",align:"center"},{title:"累计退款人数",key:"累计退款人数",align:"center"}],data52:[{"累计退款订单数":"300","累计退款额":"1000","累计退款人数":"520"}],columns53:[{title:"退款订单比率",key:"退款订单比率",align:"center"}],data53:[{"退款订单比率":"30%"}],columns54:[{title:"当日销售额（元）",key:"当日销售额（元）",align:"center"},{title:"当日销售票数（张）",key:"当日销售票数（张）",align:"center"},{title:"当日订单数（单）",key:"当日订单数（单）",align:"center"},{title:"当日最大订单额度",key:"当日最大订单额度",align:"center"}],data54:[{"当日销售额（元）":"3000","当日销售票数（张）":"200","当日订单数（单）":"230","当日最大订单额度":"7800"}],columns55:[{title:"当日退款订单数",key:"当日退款订单数",align:"center"},{title:"当日退款额",key:"当日退款额",align:"center"},{title:"当日退款人数",key:"当日退款人数",align:"center"}],data55:[{"当日退款订单数":"100","当日退款额":"200","当日退款人数":"800"}],columns56:[{title:"票种名称",key:"票种名称",align:"center"},{title:"票种单价",key:"票种单价",align:"center"},{title:"累计销售张数",key:"累计销售张数",align:"center"},{title:"累计销售金额",key:"累计销售金额",align:"center"}],data56:[{"票种名称":"五元票","票种单价":"5","累计销售张数":"1200","累计销售金额":"6000"},{"票种名称":"十元票","票种单价":"10","累计销售张数":"500","累计销售金额":"5000"}]}},mounted:function(){this.$store.dispatch("queryAllParam"),this.getTable({pageInfo:this.pageInfo})},methods:{initPageInfo:function(){this.pageInfo.page=0,this.pageInfo.pageSize=10},getTable:function(t){this.showSpin=!0,this.axios({method:"get",url:"/rainbow/jqsxxx",timeout:12e4,params:{searchContent:this.searchContent,page:t.pageInfo.page,pageSize:t.pageInfo.pageSize}}).then(function(t){console.log(JSON.stringify(t)),this.total=t.data.data.totalCount,this.dataList=t.data.data.data}.bind(this)).catch((function(t){alert(t)})).finally(function(){this.showSpin=!1}.bind(this))},search:function(){this.initPageInfo(),this.getTable({pageInfo:this.pageInfo})},pageSearch:function(t){this.pageInfo.page=t-1,this.getTable({pageInfo:this.pageInfo})},pageSizeChange:function(t){this.pageInfo.pageSize=t,this.pageInfo.page=0,this.getTable({pageInfo:this.pageInfo})},showDetailInfo:function(t){this.tabCheck="name1",console.log(JSON.stringify(t)),this.showDetailModel=!0,this.queryDetailInfo(t.shopNo)},queryDetailInfo:function(t){this.axios({method:"get",url:"/rainbow/mdsxxx",params:{shopNo:t}}).then(function(t){console.log(JSON.stringify(t)),this.detailInfo=t.data.data,this.showYunyingInfo()}.bind(this)).catch((function(t){alert(t)})).finally(function(){}.bind(this))},showYunyingInfo:function(){var t=this;this.data31=[{"设备编号":"0001","网点编号":"A1001","设备启用时间":"2019-10-01","网点申请时间":"2019-10-21","设备配送时间":"2019-10-23"}],this.data31.forEach((function(e){t.columns31=[];for(var a=0,n=Object.entries(e);a<n.length;a++){var l=o(n[a],2),i=l[0];l[1];t.columns31.push({title:i,key:i,align:"center",fixed:"设备编号"==i?"left":""})}}))}}},d=u,h=(a("5959"),a("2877")),f=Object(h["a"])(d,n,l,!1,null,null,null);e["default"]=f.exports},"90a9":function(t,e,a){}}]);
//# sourceMappingURL=chunk-611baa22.3e31e5a7.js.map