(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2517d998"],{a36a:function(e,t,a){},c046:function(e,t,a){e.exports=a.p+"img/logo.5b71fac1.jpg"},d6f5:function(e,t,a){"use strict";var s=a("a36a"),i=a.n(s);i.a},da5e:function(e,t,a){"use strict";a.r(t);var s=function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{staticClass:"layout"},[s("Layout",[s("Header",{staticStyle:{position:"absolute",width:"100%",background:"#fff",padding:"0 0","z-index":"1000"}},[s("Menu",{staticClass:"menu-layout",attrs:{mode:"horizontal",theme:"light","active-name":"interest"},on:{"on-select":function(t){e.menuSelect(t)}}},[s("div",{staticStyle:{width:"95%",margin:"0 auto"}},[s("div",{staticClass:"layout-logo"},[s("a",{on:{click:function(t){return e.backHome()}}},[s("img",{staticStyle:{width:"50px",height:"50px"},attrs:{src:a("c046"),align:"absmiddle"}})])]),s("div",{staticClass:"layout-title"},[s("MenuItem",{attrs:{name:"interest"}},[s("span",{staticClass:"home-text"},[e._v("\n                          主页\n                        ")])]),s("MenuItem",{attrs:{name:"article"}},[s("span",{staticClass:"home-text"},[e._v("\n                          文章\n                        ")])])],1),s("div",{staticClass:"layout-search"},[s("Input",{attrs:{icon:"android-search",placeholder:"Enter something..."},on:{"on-enter":function(t){return e.search()}},model:{value:e.searchValue,callback:function(t){e.searchValue=t},expression:"searchValue"}})],1),e.loginFlag?s("div",{staticClass:"layout-nav"},[s("MenuItem",{attrs:{name:"1"}},[e._v("\n                          "+e._s(e.user.name)+"\n                      ")]),s("MenuItem",{attrs:{name:"2"}},[s("Icon",{attrs:{type:"ios-mail"}}),e._v("\n                          邮件\n                      ")],1),s("Submenu",{attrs:{name:"3"}},[s("template",{slot:"title"},[s("Icon",{attrs:{type:"md-list-box"}}),e._v("\n                            文章\n                        ")],1),s("MenuItem",{attrs:{name:"31"}},[s("Icon",{attrs:{type:"md-create"}}),e._v("\n                          写文章\n                        ")],1),s("MenuItem",{attrs:{name:"32"}},[s("Icon",{attrs:{type:"md-list"}}),e._v("\n                          我的文章\n                        ")],1)],2),s("MenuItem",{attrs:{name:"4"}},[s("Icon",{attrs:{type:"md-log-out"}}),e._v("\n                          退出\n                      ")],1),e.consoleFlag?s("MenuItem",{attrs:{name:"5"}},[s("Icon",{attrs:{type:"md-settings"}}),e._v("\n                          控制台\n                      ")],1):e._e()],1):e._e(),s("div",{staticClass:"avatar-badge-wrapper",attrs:{type:"success"},on:{click:e.toMessages}},[e.loginFlag?s("img",{staticStyle:{width:"30px",height:"30px","margin-top":"16px","border-radius":"100%"},attrs:{src:e.user.headimg}}):e._e(),e.unreadMsgCount>0?s("span",{staticClass:"msg-num"},[e._v(e._s(e.unreadMsgCount))]):e._e()]),e.loginFlag?e._e():s("div",{staticClass:"layout-nav"},[s("MenuItem",{attrs:{name:"6"}},[s("Icon",{attrs:{type:"md-log-in"}}),e._v("\n                          登录\n                      ")],1)],1)])])],1),s("Content",{style:{margin:"80px 0 40px 0"}},[s("router-view")],1),s("Footer",{staticClass:"layout-footer-center"},[s("div",[s("a",{attrs:{href:"https://github.com/smallsnail-wh",target:"_blank"}},[s("Icon",{staticStyle:{color:"rebeccapurple"},attrs:{size:"40",type:"logo-github"}})],1)]),s("p",[e._v("2018-2020 © smallsail-wh")])])],1),s("Modal",{attrs:{"mask-closable":!1,visible:e.emailModal,loading:e.loading,width:"600",title:"联系管理员"},on:{"update:visible":function(t){e.emailModal=t},"on-ok":function(t){return e.emailOk("email")},"on-cancel":function(t){return e.cancel()}},model:{value:e.emailModal,callback:function(t){e.emailModal=t},expression:"emailModal"}},[s("Form",{ref:"email",attrs:{rules:e.emailRule,model:e.email,"label-width":80}},[s("FormItem",{attrs:{label:"标题",prop:"title"}},[s("Input",{attrs:{placeholder:"请输入标题"},model:{value:e.email.title,callback:function(t){e.$set(e.email,"title",t)},expression:"email.title"}})],1),s("FormItem",{attrs:{label:"email",prop:"email"}},[s("Input",{attrs:{placeholder:"请输入email"},model:{value:e.email.email,callback:function(t){e.$set(e.email,"email",t)},expression:"email.email"}})],1),s("FormItem",{attrs:{label:"姓名",prop:"name"}},[s("Input",{attrs:{placeholder:"请输入姓名"},model:{value:e.email.name,callback:function(t){e.$set(e.email,"name",t)},expression:"email.name"}})],1),s("FormItem",{attrs:{label:"内容",prop:"content"}},[s("Input",{attrs:{type:"textarea",autosize:{minRows:2,maxRows:5},placeholder:"Enter something..."},model:{value:e.email.content,callback:function(t){e.$set(e.email,"content",t)},expression:"email.content"}})],1)],1)],1)],1)},i=[],n={data:function(){return{loginFlag:!1,consoleFlag:!1,loading:!0,searchValue:"",emailModal:!1,unreadMsgCount:0,email:{title:"",email:"",name:"",content:""},user:{loginName:"",email:"",headimg:"",name:""},emailRule:{title:[{type:"string",required:!0,message:"请输入密码",trigger:"blur"}],email:[{required:!0,message:"输入邮箱",trigger:"blur"},{type:"email",message:"输入正确的邮箱格式",trigger:"blur"}],passwordAgain:[{type:"string",required:!0,message:"请输入再次输入密码",trigger:"blur"}],name:[{type:"string",required:!0,message:"请输入姓名",trigger:"blur"}],content:[{required:!0,message:"请输入内容",trigger:"blur"}]}}},created:function(){var e=this.$route.query.code,t=this.$route.query.state;if(this.$store.getters._isMobile)return null!=e&&""!=e&&null!=t&&""!=t?void this.$router.replace("/mobile?code="+e+"&state="+t):void this.$router.replace("/mobile");this.login(e,t)},methods:{userGet:function(){var e=this;this.axios({method:"get",url:"/public/user"}).then(function(e){return null!=e.data.data&&""!=e.data.data?(this.loginFlag=!0,this.userSet(e.data.data),1==e.data.data.usertype&&(this.consoleFlag=!0),this.axios({method:"get",url:"/msgrecords/unreadnum"})):Promise.resolve(0)}.bind(this)).then((function(t){e.unreadMsgCount=0===t?t:t.data.data})).catch(function(e){this.$Message.error("无权限")}.bind(this))},userSet:function(e){this.user.loginName=e.loginName,this.user.email=e.email,this.user.headimg=e.headimg,this.user.name=e.name},search:function(){"home"==this.$route.name||"page-home-title"==this.$route.name||"page-home"==this.$route.name?this.$router.push("/page/home/"+this.searchValue):"article-home"==this.$route.name&&this.$router.push("/article?searchValue="+this.searchValue)},menuSelect:function(e){1==e?this.$router.push("/page/user"):2==e?this.emailModal=!0:31==e?this.$router.push("/article/create"):32==e?this.$router.push("/article/user"):4==e?this.$store.dispatch("users/loginOUt",{router:this.$router}):5==e?this.$router.push("/base"):6==e?this.$router.push("/login"):"interest"==e?this.$router.push("/"):"article"==e&&this.$router.push("/article")},backHome:function(){this.$router.push("/page/home")},cancel:function(){},emailOk:function(e){var t=this;this.$refs[e].validate((function(e){e?(t.axios({method:"post",url:"/email",data:t.email}).then(function(e){this.$Message.info("发送成功")}.bind(t)).catch((function(e){alert(e)})),t.emailModal=!1):(t.$Message.error("表单验证失败!"),setTimeout((function(){t.loading=!1,t.$nextTick((function(){t.loading=!0}))}),1e3))}))},login:function(e,t){var a=this;null!=e&&""!=e&&null!=t&&""!=t?(this.$Spin.show({render:function(e){return e("div",[e("Icon",{style:{animation:"ani-demo-spin 1s linear infinite"},props:{type:"load-c",size:18}}),e("div","正在登录，请等待...")])}}),setTimeout((function(){a.$Spin.hide()}),1e4),"github"==t?this.githubLogin(e):"qq"==t?this.qqLogin(e):(this.$router.push({path:"/"}),location.reload())):this.userGet()},githubLogin:function(e){this.axios({method:"post",url:"/authentication/github",params:{code:e},auth:{username:"client",password:"secret"}}).then(function(e){localStorage.setItem("currentUser_token",e.data.access_token),localStorage.setItem("currentUser_refresh_token",e.data.refresh_token),this.axios.defaults.headers.common["Authorization"]="bearer "+localStorage.getItem("currentUser_token"),this.$router.push({path:"/"}),location.reload()}.bind(this)).catch(function(e){this.$Message.error("登陆失败")}.bind(this))},qqLogin:function(e){this.axios({method:"post",url:"/authentication/qq",params:{code:e},auth:{username:"client",password:"secret"}}).then(function(e){localStorage.setItem("currentUser_token",e.data.access_token),localStorage.setItem("currentUser_refresh_token",e.data.refresh_token),this.axios.defaults.headers.common["Authorization"]="bearer "+localStorage.getItem("currentUser_token"),this.$router.push({path:"/qq"}),this.$router.push({path:"/"}),location.reload()}.bind(this)).catch(function(e){this.$Message.error("登陆失败")}.bind(this))},toMessages:function(){console.log("to messages page"),this.$router.push({path:"/page/messages"})}}},r=n,o=(a("d6f5"),a("2877")),l=Object(o["a"])(r,s,i,!1,null,"6c660a6a",null);t["default"]=l.exports}}]);
//# sourceMappingURL=chunk-2517d998.86e82567.js.map