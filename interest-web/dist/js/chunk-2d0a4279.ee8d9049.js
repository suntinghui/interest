(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0a4279"],{"04dc":function(t,o,e){"use strict";e.r(o);var a=function(){var t=this,o=t.$createElement,e=t._self._c||o;return e("div",[e("a",{staticClass:"btn",on:{click:t.toggleShow}},[t._v("设置头像")]),e("my-upload",{attrs:{field:"picture",width:200,height:200,url:"/interest/upload/picture",headers:t.headers,"img-format":"png"},on:{"crop-upload-success":t.cropUploadSuccess,"crop-upload-fail":t.cropUploadFail},model:{value:t.show,callback:function(o){t.show=o},expression:"show"}}),e("img",{attrs:{src:t.imgDataUrl}})],1)},s=[],c=e("0b4d"),i={components:{"my-upload":c["a"]},data:function(){return{show:!1,headers:{Authorization:"bearer "+localStorage.getItem("currentUser_token")},imgDataUrl:""}},mounted:function(){},watch:{},methods:{toggleShow:function(){this.show=!this.show},cropUploadSuccess:function(t,o){this.imgDataUrl=t.data,this.show=!1,this.$Notice.success({title:"头像修改成功"})},cropUploadFail:function(t,o){this.$Notice.error({title:"头像修改失败"})}}},r=i,n=e("2877"),l=Object(n["a"])(r,a,s,!1,null,null,null);o["default"]=l.exports}}]);
//# sourceMappingURL=chunk-2d0a4279.ee8d9049.js.map