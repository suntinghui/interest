(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4e09f2d9"],{"54ed":function(t,e,a){"use strict";var n=a("de5d"),i=a.n(n);i.a},6668:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticStyle:{margin:"40px"}},[a("div",[a("Row",{staticStyle:{"margin-bottom":"25px"}},[a("Col",{attrs:{span:"9"}},[t._v("搜索：\n            "),a("Input",{staticStyle:{width:"300px"},attrs:{placeholder:"请输入..."},model:{value:t.searchContent,callback:function(e){t.searchContent=e},expression:"searchContent"}})],1),a("Col",{attrs:{span:"6"}},[a("DatePicker",{staticStyle:{width:"200px"},attrs:{type:"date",placeholder:"Select date"},model:{value:t.date,callback:function(e){t.date=e},expression:"date"}})],1),a("Col",{attrs:{span:"4"}},[a("Button",{attrs:{type:"primary",shape:"circle",icon:"ios-search"},on:{click:function(e){return t.search()}}},[t._v("搜索")])],1)],1)],1),a("div",{staticClass:"del-select"},[a("span",[t._v("删除：")]),a("i-switch",{attrs:{size:"large"},on:{"on-change":function(e){return t.switchChange()}},model:{value:t.del,callback:function(e){t.del=e},expression:"del"}},[a("span",{attrs:{slot:"open"},slot:"open"},[t._v("开启")]),a("span",{attrs:{slot:"close"},slot:"close"},[t._v("关闭")])])],1),a("div",[a("ul",[a("li",[t.del?t._e():a("Button",{staticClass:"botton-layout",attrs:{type:"error",icon:"md-trash"},on:{click:function(e){return t.clickDel()}}},[t._v("删除")]),t.del?a("Button",{staticClass:"botton-layout",attrs:{type:"success",icon:"md-build"},on:{click:function(e){return t.republish()}}},[t._v("恢复")]):t._e(),a("Button",{staticClass:"botton-layout",attrs:{type:"info",icon:"md-build"},on:{click:function(e){return t.top(1)}}},[t._v("置顶")]),a("Button",{staticClass:"botton-layout",attrs:{type:"info",icon:"md-build"},on:{click:function(e){return t.top(0)}}},[t._v("取消置顶")])],1),a("li",[a("div",{staticStyle:{padding:"10px 0"}},[a("Table",{attrs:{border:"",columns:t.columns1,data:t.data1,height:400},on:{"on-selection-change":function(e){t.change(e)}}})],1)]),a("li",[a("div",{staticStyle:{"text-align":"right"}},[a("Page",{attrs:{total:t.total,"page-size":t.pageInfo.pageSize,"show-elevator":"","show-total":""},on:{"on-change":function(e){t.pageSearch(e)}}})],1)])])])])},i=[],o={data:function(){var t=this;return{date:null,searchContent:null,del:!1,groupId:[],total:0,pageInfo:{page:0,pageSize:10},columns1:[{type:"selection",width:60,align:"center"},{title:"文章ID",key:"id",width:75},{title:"创建者ID",key:"userid",width:90},{title:"创建时间",key:"createTime",width:140},{title:"标题",key:"title",width:150},{title:"置顶",align:"center",key:"action",width:70,render:function(t,e){return 1==e.row.top?t("div",[t("strong",{style:{color:"#2b85e4"}},"是")]):0==e.row.top?t("div",[t("strong",{style:{color:"#f90"}},"否")]):void 0}},{title:"简介",key:"info"},{title:"操作",align:"center",key:"action",width:100,render:function(e,a){return e("a",{attrs:{href:t.$store.state.domainName+"/article/detail/"+a.row.id,target:"_blank"}},[e("Button",{props:{type:"info"}},"查看")])}}],data1:[]}},mounted:function(){this.getTable({pageInfo:this.pageInfo})},methods:{initPageInfo:function(){this.pageInfo.page=0,this.pageInfo.pageSize=10},getTable:function(t){var e=null;null!=this.date&&""!=this.date&&(e=this.date.getTime());var a=0;this.del&&(a=1),this.axios({method:"get",url:"/admin/articles",params:{dateTimestamp:e,searchContent:this.searchContent,del:a,page:t.pageInfo.page,pageSize:t.pageInfo.pageSize}}).then(function(t){this.data1=t.data.data.data,this.total=t.data.data.totalCount;for(var e=this.data1.length-1;e>=0;e--)this.data1[e].createTime=this.dateGet(this.data1[e].createTime)}.bind(this)).catch((function(t){alert(t)}))},search:function(){this.initPageInfo(),this.getTable({pageInfo:this.pageInfo})},pageSearch:function(t){this.pageInfo.page=t-1,this.getTable({pageInfo:this.pageInfo})},clickDel:function(){null!=this.groupId&&""!=this.groupId&&this.axios({method:"delete",url:"/admin/articles",data:this.groupId}).then(function(t){this.getTable({pageInfo:this.pageInfo}),this.groupId=[],this.$Message.info("删除成功")}.bind(this)).catch((function(t){alert(t)}))},republish:function(){null!=this.groupId&&""!=this.groupId&&this.axios({method:"patch",url:"/admin/articles",data:this.groupId}).then(function(t){this.getTable({pageInfo:this.pageInfo}),this.groupId=[],this.$Message.info("重新发布成功")}.bind(this)).catch((function(t){alert(t)}))},change:function(t){this.setGroupId(t)},setGroupId:function(t){this.groupId=[];for(var e=0;e<=t.length-1;e++)this.groupId.push(t[e].id)},switchChange:function(){this.groupId=[],this.getTable({pageInfo:this.pageInfo})},top:function(t){this.axios({method:"patch",url:"/admin/articles/top",data:this.groupId,params:{top:t}}).then(function(t){this.getTable({pageInfo:this.pageInfo}),this.groupId=[],this.$Message.info("修改成功")}.bind(this)).catch((function(t){alert(t)}))}}},s=o,l=(a("54ed"),a("2877")),c=Object(l["a"])(s,n,i,!1,null,null,null);e["default"]=c.exports},de5d:function(t,e,a){}}]);
//# sourceMappingURL=chunk-4e09f2d9.e2ed4959.js.map