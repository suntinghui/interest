(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-5a514ce6"],{"9cc2":function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticStyle:{margin:"40px"}},[a("div",[a("Row",{staticStyle:{"margin-bottom":"25px"}},[a("Col",{attrs:{span:"8"}},[t._v("日期：\n\t\t\t"),a("DatePicker",{staticStyle:{width:"250px"},attrs:{type:"date",placeholder:"选择日期"},model:{value:t.dateModel,callback:function(e){t.dateModel=e},expression:"dateModel"}})],1),a("Col",{attrs:{span:"8"}},[t._v("设备：\n\t\t\t"),a("Select",{staticStyle:{width:"250px"},attrs:{filterable:"",clearable:""},model:{value:t.deviceModel,callback:function(e){t.deviceModel=e},expression:"deviceModel"}},t._l(this.$store.state.param.deviceTypeList,(function(e){return a("Option",{key:e.paramKey,attrs:{value:e.paramKey}},[t._v(t._s(e.paramValue))])})),1)],1),a("Col",{attrs:{span:"8"}},[t._v("所属地区：\n\t\t\t"),a("Select",{staticStyle:{width:"250px"},attrs:{filterable:"",clearable:""},model:{value:t.areaModel,callback:function(e){t.areaModel=e},expression:"areaModel"}},t._l(this.$store.state.param.areaList,(function(e){return a("Option",{key:e.paramKey,attrs:{value:e.paramKey}},[t._v(t._s(e.paramValue))])})),1)],1)],1),a("Row",{staticStyle:{"margin-bottom":"25px"}},[a("Col",{attrs:{span:"8"}},[t._v("渠道：\n\t\t\t"),a("Select",{staticStyle:{width:"250px"},attrs:{filterable:"",clearable:""},model:{value:t.channelModel,callback:function(e){t.channelModel=e},expression:"channelModel"}},t._l(this.$store.state.param.channelList,(function(e){return a("Option",{key:e.paramKey,attrs:{value:e.paramKey}},[t._v(t._s(e.paramValue))])})),1)],1),a("Col",{attrs:{span:"8"}},[t._v("网点：\n\t\t\t"),a("Select",{staticStyle:{width:"250px"},attrs:{filterable:"",clearable:""},model:{value:t.shopModel,callback:function(e){t.shopModel=e},expression:"shopModel"}},t._l(this.$store.state.param.shopList,(function(e){return a("Option",{key:e.paramKey,attrs:{value:e.paramKey}},[t._v(t._s(e.paramValue)+" ("+t._s(e.paramKey)+")")])})),1)],1),a("Col",{attrs:{span:"8"}},[t._v("网点类型：\n\t\t\t"),a("Select",{staticStyle:{width:"250px"},attrs:{filterable:"",clearable:""},model:{value:t.shopTypeModel,callback:function(e){t.shopTypeModel=e},expression:"shopTypeModel"}},t._l(this.$store.state.param.shopTypeList,(function(e){return a("Option",{key:e.paramKey,attrs:{value:e.paramKey}},[t._v(t._s(e.paramValue))])})),1)],1)],1),a("Row",{staticStyle:{"margin-bottom":"25px","text-align":"right"}},[a("Col",{attrs:{span:"22"}},[a("Button",{attrs:{type:"primary",shape:"circle",icon:"ios-search"},on:{click:function(e){return t.search()}}},[t._v("搜索")])],1)],1)],1),t.showSpin?a("Spin",{attrs:{size:"large",fix:""}}):t._e(),a("div",{staticStyle:{padding:"10px 0"}},[a("Table",{attrs:{border:"",columns:t.columns1,data:t.data1,height:350,search:!0}})],1),a("div",{staticStyle:{"margin-top":"0.3125rem","text-align":"right"}},[t._v("\n\t\t备注：2019年8月14日前无数据\n\t")])],1)},r=[],l=a("e0eb"),i=(a("f601"),a("09bd")),o=a.n(i);o.a.shim();var s={data:function(){return{showSpin:!1,date:null,searchContent:null,groupId:[],columns1:[{title:"指标",key:"title",align:"center"},{title:"数值",key:"value",align:"center"}],data1:[]}},mounted:function(){this.$store.dispatch("queryAllParam"),this.search()},methods:{search:function(){this.showSpin=!0,this.axios({method:"get",url:"/rainbow/fhgjl",timeout:12e4,params:{}}).then(function(t){console.log(JSON.stringify(t)),this.data1=[{title:"复合关机率",value:l["a"].toPercent(t.data.data)}]}.bind(this)).catch((function(t){alert(t)})).finally(function(){this.showSpin=!1}.bind(this))}}},c=s,u=a("2877"),p=Object(u["a"])(c,n,r,!1,null,null,null);e["default"]=p.exports},e0eb:function(t,e,a){"use strict";e["a"]={toPercent:function(t){if(0==t)return 0;var e=Number(100*t).toFixed(2);return e+="%",e},lastWeek:function(t){var e=new Date;return e.setTime(t.getTime()-6048e5),e},lastMonth:function(t){var e=t.getFullYear(),a=t.getMonth()+1;return 1==a?(e-=1,a=12):a-=1,a<10?e+"-0"+a:e+"-"+a},yestoday:function(){var t=new Date;return t.setTime(t.getTime()-864e5),t},dateFormat:function(t){var e=t.getFullYear(),a=t.getMonth()+1<10?"0"+(t.getMonth()+1):t.getMonth()+1,n=t.getDate()<10?"0"+t.getDate():t.getDate();return e+"-"+a+"-"+n},datetimeFormat:function(t){var e=t.getFullYear(),a=t.getMonth()+1<10?"0"+(t.getMonth()+1):t.getMonth()+1,n=t.getDate()<10?"0"+t.getDate():t.getDate(),r=t.getHours()<10?"0"+t.getHours():t.getHours(),l=t.getMinutes()<10?"0"+t.getMinutes():t.getMinutes(),i=t.getSeconds()<10?"0"+t.getSeconds():t.getSeconds();return e+"-"+a+"-"+n+" "+r+":"+l+":"+i},numFixed:function(t){try{return t.toFixed(2)}catch(e){return 0}},arr2Str:function(t){return JSON.stringify(t).replace(/\[/g,"").replace(/]/g,"")}}},f601:function(t,e,a){"use strict"}}]);
//# sourceMappingURL=chunk-5a514ce6.a783a2d0.js.map