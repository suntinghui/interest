(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-f27cd1b0"],{"25c1":function(t,e,n){"use strict";n.r(e);var i=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"content-background"},[n("Form",{ref:"entity",staticClass:"form",attrs:{model:t.entity,rules:t.ruleNew,"label-width":80}},[n("Form-item",{attrs:{label:"标题：",prop:"title"}},[n("Input",{model:{value:t.entity.title,callback:function(e){t.$set(t.entity,"title",e)},expression:"entity.title"}})],1),n("Form-item",{attrs:{label:"详情：",prop:"content"}},[n("interest-quill-editor",{staticClass:"editor",attrs:{interestContent:t.interestContent},on:{"editor-change":function(e){t.contentGet(e)}}})],1),n("FormItem",[n("Button",{attrs:{type:"primary"},on:{click:function(e){return t.submit("entity")}}},[t._v("发布")])],1)],1),n("Modal",{attrs:{width:"360"},model:{value:t.modal,callback:function(e){t.modal=e},expression:"modal"}},[n("p",{staticStyle:{color:"#f60","text-align":"center"},attrs:{slot:"header"},slot:"header"},[n("Icon",{attrs:{type:"ios-information-circle"}}),n("span",[t._v("温馨提示")])],1),n("div",{staticStyle:{"text-align":"center"}},[n("p",[t._v("是否修改？")])]),n("div",{attrs:{slot:"footer"},slot:"footer"},[n("Button",{attrs:{type:"error",size:"large",long:"",loading:t.modal_loading},on:{click:function(e){return t.updateArticle()}}},[t._v("确认")])],1)])],1)},o=[],a=n("74ac"),s={components:{"interest-quill-editor":a["a"]},data:function(){return{articleId:null,modal:!1,modal_loading:!1,interestContent:"",entity:{title:null,content:null},ruleNew:{title:[{type:"string",required:!0,message:"填写标题",trigger:"blur"}],content:[{type:"string",required:!0,message:"填写内容",trigger:"blur"}]}}},mounted:function(){this.articleId=this.$route.params.id,this.getArticle(this.articleId)},methods:{getArticle:function(t){this.axios({method:"get",url:"/public/articles/article/"+t}).then(function(t){this.entitySet(t.data.data),this.interestContent=t.data.data.content}.bind(this)).catch(function(t){}.bind(this))},initEntity:function(){this.entity.title=null,this.entity.content=null},entitySet:function(t){this.entity.title=t.title,this.entity.content=t.content},contentGet:function(t){this.entity.content=t},submit:function(t){var e=this;this.$refs[t].validate((function(t){t&&(e.modal=!0)}))},updateArticle:function(){this.modal_loading=!0,this.axios({method:"put",url:"/article",data:{id:this.articleId,title:this.entity.title,content:this.entity.content}}).then(function(t){var e=this;"2000"==t.data.status?(this.interestContent=this.interestContent+".",this.initEntity(),setTimeout((function(){e.modal_loading=!1,e.modal=!1,e.$router.push("/article/create/success")}),2e3)):"6001"==t.data.status&&(this.modal_loading=!1,this.$Message.error(t.data.message))}.bind(this)).catch(function(t){this.$Message.error("新建失败")}.bind(this))}}},r=s,l=(n("badc"),n("2877")),c=Object(l["a"])(r,i,o,!1,null,null,null);e["default"]=c.exports},badc:function(t,e,n){"use strict";var i=n("c001"),o=n.n(i);o.a},c001:function(t,e,n){}}]);
//# sourceMappingURL=chunk-f27cd1b0.647eade1.js.map