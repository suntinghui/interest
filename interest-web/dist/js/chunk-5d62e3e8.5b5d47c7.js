(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-5d62e3e8"],{9822:function(e,t,a){"use strict";a.r(t);var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticStyle:{margin:"40px"}},[a("div",[a("Row",{staticStyle:{"margin-bottom":"25px"}},[a("Col",{attrs:{span:"8"}},[e._v("日期：\n\t\t\t"),a("Date-picker",{staticStyle:{width:"250px"},attrs:{value:e.dateValue,clearable:!1,type:"daterange",editable:"false",options:e.dateOptions,placement:"bottom-start",placeholder:"选择日期"},on:{"on-change":e.handleDateChange}})],1),a("Col",{attrs:{span:"8"}},[e._v("所属地区：\n\t\t\t"),a("Select",{staticStyle:{width:"250px"},attrs:{filterable:"",clearable:""},model:{value:e.selectValue.areaValue,callback:function(t){e.$set(e.selectValue,"areaValue",t)},expression:"selectValue.areaValue"}},e._l(this.$store.state.param.areaList,(function(t){return a("Option",{key:t.paramKey,attrs:{value:t.paramKey}},[e._v(e._s(t.paramValue))])})),1)],1),a("Col",{attrs:{span:"8"}},[e._v("设备：\n\t\t\t"),a("Select",{staticStyle:{width:"250px"},attrs:{filterable:"",clearable:""},model:{value:e.selectValue.deviceTypeValue,callback:function(t){e.$set(e.selectValue,"deviceTypeValue",t)},expression:"selectValue.deviceTypeValue"}},e._l(this.$store.state.param.deviceTypeList,(function(t){return a("Option",{key:t.paramKey,attrs:{value:t.paramKey}},[e._v(e._s(t.paramValue))])})),1)],1)],1),a("Row",{staticStyle:{"margin-bottom":"25px"}},[a("Col",{attrs:{span:"8"}},[e._v("渠道：\n\t\t\t"),a("Select",{staticStyle:{width:"250px"},attrs:{filterable:"",clearable:""},model:{value:e.selectValue.channelValue,callback:function(t){e.$set(e.selectValue,"channelValue",t)},expression:"selectValue.channelValue"}},e._l(this.$store.state.param.channelList,(function(t){return a("Option",{key:t.paramValue,attrs:{value:t.paramValue}},[e._v(e._s(t.paramValue))])})),1)],1),a("Col",{staticStyle:{display:"none"},attrs:{span:"8"}},[e._v("网点：\n\t\t\t"),a("Select",{staticStyle:{width:"250px"},attrs:{filterable:"",clearable:""},model:{value:e.selectValue.shopValue,callback:function(t){e.$set(e.selectValue,"shopValue",t)},expression:"selectValue.shopValue"}},e._l(this.$store.state.param.shopList,(function(t){return a("Option",{key:t.paramKey,attrs:{value:t.paramKey}},[e._v(e._s(t.paramValue)+"-"+e._s(t.paramKey))])})),1)],1),a("Col",{attrs:{span:"8"}},[e._v("网点类型：\n\t\t\t"),a("Select",{staticStyle:{width:"250px"},attrs:{filterable:"",clearable:""},model:{value:e.selectValue.shopTypeValue,callback:function(t){e.$set(e.selectValue,"shopTypeValue",t)},expression:"selectValue.shopTypeValue"}},e._l(this.$store.state.param.shopTypeList,(function(t){return a("Option",{key:t.paramValue,attrs:{value:t.paramValue}},[e._v(e._s(t.paramValue))])})),1)],1),a("Col",{staticStyle:{"text-align":"left"},attrs:{span:"8"}},[a("Button",{attrs:{type:"primary",shape:"circle",icon:"ios-search"},on:{click:function(t){return e.search()}}},[e._v("搜索")])],1)],1)],1),e.showSpin?a("Spin",{attrs:{size:"large",fix:""}}):e._e(),a("div",{staticStyle:{padding:"10px 0"}},[a("Table",{attrs:{border:"",columns:e.columns1,data:e.data1,height:450,search:!0}})],1),a("div",{staticStyle:{"text-align":"right"}},[a("Page",{attrs:{total:e.total,"page-size":e.pageInfo.pageSize,"show-sizer":"","show-total":""},on:{"on-page-size-change":function(t){e.pageSizeChange(t)},"on-change":function(t){e.pageSearch(t)}}})],1)],1)},n=[],s=a("e0eb"),i=(a("f601"),a("09bd")),r=a.n(i);r.a.shim();var o={data:function(){return{selectValue:{},dateValue:[s["a"].dateFormat(s["a"].lastWeek(new Date)),s["a"].dateFormat(new Date)],showSpin:!1,date:null,searchContent:null,groupId:[],total:0,pageInfo:{page:0,pageSize:10},columns1:[{title:"设备类型",key:"设备类型",align:"center",sortable:!0},{title:"在网设备日均销售额",key:"在网设备日均销售额",align:"center",sortable:!0},{title:"开机在网设备日均销量",key:"开机在网设备日均销量",align:"center",sortable:!0}],data1:[]}},mounted:function(){this.$store.dispatch("queryAllParam"),this.getTable({pageInfo:this.pageInfo})},methods:{initPageInfo:function(){this.pageInfo.page=0,this.pageInfo.pageSize=10},search:function(){this.initPageInfo(),this.getTable({pageInfo:this.pageInfo})},getTable:function(e){this.showSpin=!0,this.axios({method:"get",url:"/rainbow/dtpjxstj",timeout:12e4,params:{page:e.pageInfo.page,pageSize:e.pageInfo.pageSize,filterMap:{startDate:this.dateValue[0],endDate:this.dateValue[1],deviceTypeValue:this.selectValue.deviceTypeValue,areaValue:this.selectValue.areaValue,channelValue:this.selectValue.channelValue,shopValue:this.selectValue.shopValue,shopTypeValue:this.selectValue.shopTypeValue}}}).then(function(e){console.log(JSON.stringify(e)),this.data1=e.data.data.data,this.total=e.data.data.totalCount}.bind(this)).catch((function(e){alert(e)})).finally(function(){this.showSpin=!1}.bind(this))},pageSearch:function(e){this.pageInfo.page=e-1,this.getTable({pageInfo:this.pageInfo})},pageSizeChange:function(e){this.pageInfo.pageSize=e,this.pageInfo.page=0,this.getTable({pageInfo:this.pageInfo})},handleDateChange:function(e){this.dateValue=e}}},u=o,c=a("2877"),p=Object(c["a"])(u,l,n,!1,null,null,null);t["default"]=p.exports},e0eb:function(e,t,a){"use strict";t["a"]={toPercent:function(e){if(0==e)return"0.00%";var t=Number(100*e).toFixed(2);return t+="%",t},lastWeek:function(e){var t=new Date;return t.setTime(e.getTime()-6048e5),t},lastMonth:function(e){var t=e.getFullYear(),a=e.getMonth()+1;return 1==a?(t-=1,a=12):a-=1,a<10?t+"-0"+a:t+"-"+a},yestoday:function(){var e=new Date;return e.setTime(e.getTime()-864e5),e},dateFormat:function(e){var t=e.getFullYear(),a=e.getMonth()+1<10?"0"+(e.getMonth()+1):e.getMonth()+1,l=e.getDate()<10?"0"+e.getDate():e.getDate();return t+"-"+a+"-"+l},datetimeFormat:function(e){var t=e.getFullYear(),a=e.getMonth()+1<10?"0"+(e.getMonth()+1):e.getMonth()+1,l=e.getDate()<10?"0"+e.getDate():e.getDate(),n=e.getHours()<10?"0"+e.getHours():e.getHours(),s=e.getMinutes()<10?"0"+e.getMinutes():e.getMinutes(),i=e.getSeconds()<10?"0"+e.getSeconds():e.getSeconds();return t+"-"+a+"-"+l+" "+n+":"+s+":"+i},numFixed:function(e){try{return e.toFixed(2)}catch(t){return 0}},arr2Str:function(e){return JSON.stringify(e).replace(/\[/g,"").replace(/]/g,"")}}},f601:function(e,t,a){"use strict"}}]);
//# sourceMappingURL=chunk-5d62e3e8.5b5d47c7.js.map