(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0e970a"],{"8e18":function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticStyle:{margin:"40px"}},[t.showSpin?a("Spin",{attrs:{size:"large",fix:""}}):t._e(),a("div",{staticStyle:{padding:"10px 0"}},[a("Table",{attrs:{border:"",columns:t.columns1,data:t.data1,height:500}})],1),a("div",{staticStyle:{"text-align":"right"}},[a("Page",{attrs:{total:t.total,"page-size":t.pageInfo.pageSize,"show-elevator":"","show-total":""},on:{"on-change":function(e){t.pageSearch(e)}}})],1)],1)},i=[],o=a("09bd"),s=a.n(o);s.a.shim();var l={data:function(){return{showSpin:!1,date:null,searchContent:null,groupId:[],total:0,pageInfo:{page:0,pageSize:10},columns1:[{title:"网点名称",key:"name",align:"center"},{title:"所属渠道",key:"channel",align:"center",sortable:!0},{title:"意向时间",key:"yixiangTime",align:"center",sortable:!0},{title:"关联时间",key:"guanlianTime",align:"center",sortable:!0},{title:"装票开启时间",key:"openTime",align:"center",sortable:!0}],data1:[]}},mounted:function(){this.getTable({pageInfo:this.pageInfo})},methods:{initPageInfo:function(){this.pageInfo.page=0,this.pageInfo.pageSize=10},getTable:function(t){this.showSpin=!0,this.axios({method:"get",url:"/rainbow/sbda",timeout:12e4,params:{searchContent:this.searchContent,page:t.pageInfo.page,pageSize:t.pageInfo.pageSize}}).then(function(t){console.log(JSON.stringify(t)),this.total=t.data.data.totalCount,this.data1=t.data.data.data}.bind(this)).catch((function(t){alert(t)})).finally(function(){this.showSpin=!1}.bind(this))},search:function(){this.initPageInfo(),this.getTable({pageInfo:this.pageInfo})},pageSearch:function(t){this.pageInfo.page=t-1,this.getTable({pageInfo:this.pageInfo})}}},g=l,h=a("2877"),p=Object(h["a"])(g,n,i,!1,null,null,null);e["default"]=p.exports}}]);
//# sourceMappingURL=chunk-2d0e970a.33d96ae3.js.map