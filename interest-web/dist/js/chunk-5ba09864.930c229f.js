(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-5ba09864"],{b559:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticStyle:{margin:"40px"}},[a("div",[a("Row",{staticStyle:{"margin-bottom":"25px"}},[a("Col",{attrs:{span:"8"}},[t._v("日期：\n\t\t\t"),a("Date-picker",{staticStyle:{width:"250px"},attrs:{value:t.dateValue,type:"daterange",editable:"false",options:t.dateOptions,placement:"bottom-start",placeholder:"选择日期"},on:{"on-change":t.handleDateChange}})],1),a("Col",{attrs:{span:"8"}},[t._v("设备类型：\n\t\t\t"),a("Select",{staticStyle:{width:"250px"},attrs:{filterable:"",clearable:"",multiple:""},model:{value:t.deviceModel,callback:function(e){t.deviceModel=e},expression:"deviceModel"}},t._l(this.$store.state.param.deviceTypeList,(function(e){return a("Option",{key:e.paramKey,attrs:{value:e.paramKey}},[t._v(t._s(e.paramValue))])})),1)],1),a("Col",{attrs:{span:"8"}},[t._v("所属地区：\n\t\t\t"),a("Select",{staticStyle:{width:"250px"},attrs:{filterable:"",clearable:""},model:{value:t.areaModel,callback:function(e){t.areaModel=e},expression:"areaModel"}},t._l(this.$store.state.param.areaList,(function(e){return a("Option",{key:e.paramKey,attrs:{value:e.paramKey}},[t._v(t._s(e.paramValue))])})),1)],1)],1),a("Row",{staticStyle:{"margin-bottom":"25px"}},[a("Col",{attrs:{span:"8"}},[t._v("渠道：\n\t\t\t"),a("Select",{staticStyle:{width:"250px"},attrs:{filterable:"",clearable:""},model:{value:t.channelModel,callback:function(e){t.channelModel=e},expression:"channelModel"}},t._l(this.$store.state.param.channelList,(function(e){return a("Option",{key:e.paramKey,attrs:{value:e.paramKey}},[t._v(t._s(e.paramValue))])})),1)],1),a("Col",{attrs:{span:"8"}},[t._v("网点类型：\n\t\t\t"),a("Select",{staticStyle:{width:"250px"},attrs:{filterable:"",clearable:""},model:{value:t.shopTypeModel,callback:function(e){t.shopTypeModel=e},expression:"shopTypeModel"}},t._l(this.$store.state.param.shopTypeList,(function(e){return a("Option",{key:e.paramKey,attrs:{value:e.paramKey}},[t._v(t._s(e.paramValue))])})),1)],1),a("Col",{staticStyle:{"text-align":"center"},attrs:{span:"8"}},[a("Button",{attrs:{type:"primary",shape:"circle",icon:"ios-search"},on:{click:function(e){return t.search()}}},[t._v("搜索")])],1)],1)],1),t.showSpin?a("Spin",{attrs:{size:"large",fix:""}}):t._e(),a("div",{staticStyle:{padding:"10px 0"}},[a("Table",{attrs:{border:"",columns:t.columns1,data:t.data1,height:420,search:!0}})],1)],1)},i=[],l=a("e0eb"),r=(a("f601"),a("09bd")),o=a.n(r);o.a.shim();var s={data:function(){return{deviceModel:[],dateValue:[l["a"].dateFormat(l["a"].lastWeek(new Date)),l["a"].dateFormat(new Date)],showSpin:!1,date:null,searchContent:null,groupId:[],columns1:[{type:"index",title:"序号",width:80,fixed:"left",align:"center"},{title:"设备编号",key:"设备编号",align:"center",fixed:"left",sortable:!0,width:150},{title:"网点编号",key:"网点编号",align:"center",sortable:!0,width:150},{title:"设备位置",key:"设备位置",align:"center",width:200},{title:"启用时间",key:"启用时间",align:"center",width:200},{title:"设备类型",key:"设备类型",align:"center",sortable:!0,width:150},{title:"设备交易笔数",key:"设备交易笔数",align:"center",width:150,sortable:!0},{title:"交易额",key:"交易额",align:"center",sortable:!0,width:150},{title:"产生退订单数",key:"产生退订单数",align:"center",sortable:!0,width:150},{title:"产生退款金额",key:"产生退款金额",align:"center",sortable:!0,width:150},{title:"订单退款率",key:"订单退款率",align:"center",sortable:!0,width:150},{title:"交易额退款率",key:"交易额退款率",align:"center",sortable:!0,width:150}],data1:[]}},mounted:function(){this.$store.dispatch("queryAllParam"),this.search()},methods:{search:function(){this.showSpin=!0,this.axios({method:"get",url:"/rainbow/rbxhjkpjy50",timeout:12e4,params:{startDate:this.dateValue[0],endDate:this.dateValue[1],deviceModel:this.deviceModel.toString()}}).then(function(t){console.log(JSON.stringify(t)),this.data1=t.data.data}.bind(this)).catch((function(t){alert(t)})).finally(function(){this.showSpin=!1}.bind(this))},handleDateChange:function(t){console.log(t),this.dateValue=t}}},c=s,u=a("2877"),d=Object(u["a"])(c,n,i,!1,null,null,null);e["default"]=d.exports},e0eb:function(t,e,a){"use strict";e["a"]={toPercent:function(t){if(0==t)return 0;var e=Number(100*t).toFixed(2);return e+="%",e},lastWeek:function(t){var e=new Date;return e.setTime(t.getTime()-6048e5),e},lastMonth:function(t){var e=t.getFullYear(),a=t.getMonth()+1;return 1==a?(e-=1,a=12):a-=1,a<10?e+"-0"+a:e+"-"+a},yestoday:function(){var t=new Date;return t.setTime(t.getTime()-864e5),t},dateFormat:function(t){var e=t.getFullYear(),a=t.getMonth()+1<10?"0"+(t.getMonth()+1):t.getMonth()+1,n=t.getDate()<10?"0"+t.getDate():t.getDate();return e+"-"+a+"-"+n},datetimeFormat:function(t){var e=t.getFullYear(),a=t.getMonth()+1<10?"0"+(t.getMonth()+1):t.getMonth()+1,n=t.getDate()<10?"0"+t.getDate():t.getDate(),i=t.getHours()<10?"0"+t.getHours():t.getHours(),l=t.getMinutes()<10?"0"+t.getMinutes():t.getMinutes(),r=t.getSeconds()<10?"0"+t.getSeconds():t.getSeconds();return e+"-"+a+"-"+n+" "+i+":"+l+":"+r},numFixed:function(t){try{return t.toFixed(2)}catch(e){return 0}},arr2Str:function(t){return JSON.stringify(t).replace(/\[/g,"").replace(/]/g,"")}}},f601:function(t,e,a){"use strict"}}]);
//# sourceMappingURL=chunk-5ba09864.930c229f.js.map