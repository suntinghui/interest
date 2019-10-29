import Vue from "vue";
import VueRouter from "vue-router";
import iView from "iview";

Vue.use(VueRouter);

const routers = [
  {
    path: "/image-capture",
    component: resolve => require(["./views/template/image-capture.vue"], resolve)
  },
  {
    path: "*",
    component: resolve => require(["./views/error404.vue"], resolve)
  },
  {
    path: "/",
    meta: {
      title: "smallsnail-wh"
    },
    component: resolve => require(["./views/login.vue"], resolve),
    children: [
      {
        path: "",
        name: "login",
        component: resolve => require(["./views/login.vue"], resolve),
        meta: {
          title: "login"
        }
      }
    ]
  },
  {
    path: "/qq",
    meta: {
      title: "smallsnail-wh"
    },
    component: resolve => require(["./views/template/index.vue"], resolve),
    children: [
      {
        path: "",
        name: "qq-home",
        component: resolve => require(["./views/template/home.vue"], resolve),
        meta: {
          title: "home"
        }
      }
    ]
  },
  {
    path: "/login",
    meta: {
      title: "smallsnail-wh"
    },
    component: resolve => require(["./views/login.vue"], resolve)
  },
  {
    path: "/page",
    meta: {
      title: "smallsnail-wh"
    },
    component: resolve => require(["./views/template/index.vue"], resolve),
    children: [
      {
        path: "home",
        name: "page-home",
        component: resolve => require(["./views/template/home.vue"], resolve),
        meta: {
          title: "home"
        }
      },
      {
        path: "home/:title",
        name: "page-home-title",
        component: resolve => require(["./views/template/home.vue"], resolve),
        meta: {
          title: "home"
        }
      },
      {
        path: "detail/:id",
        name: "page-detail-id",
        component: resolve => require(["./views/template/detail.vue"], resolve),
        meta: {
          title: "detail"
        }
      },
      {
        path: "card/:id",
        name: "page-card-id",
        component: resolve => require(["./views/template/card.vue"], resolve),
        meta: {
          title: "card"
        }
      },
      {
        path: "messages",
        name: "page-messages",
        component: resolve =>
          require(["./views/template/messages.vue"], resolve),
        meta: {
          title: "messages"
        }
      },
      {
        path: "user",
        name: "page-user",
        component: resolve =>
          require(["./views/template/user-info.vue"], resolve),
        meta: {
          title: "user"
        }
      },
      {
        path: "user/:id",
        name: "page-user-id",
        component: resolve =>
          require(["./views/template/user-page.vue"], resolve),
        meta: {
          title: "user"
        }
      }
    ]
  },
  {
    path: "/mlogin",
    meta: {
      title: "smallsnail-wh"
    },
    component: resolve => require(["./views/mlogin.vue"], resolve)
  },
  {
    path: "/mobile",
    meta: {
      title: "smallsnail-wh"
    },
    component: resolve => require(["./views/mobile/index.vue"], resolve),
    children: [
      {
        path: "",
        name: "mobile-home",
        component: resolve => require(["./views/mobile/home.vue"], resolve),
        meta: {
          title: "home"
        }
      },
      {
        path: "home/:title",
        name: "mobile-home-title",
        component: resolve => require(["./views/mobile/home.vue"], resolve),
        meta: {
          title: "home"
        }
      },
      {
        path: "detail/:id",
        name: "mobile-detail-id",
        component: resolve => require(["./views/mobile/detail.vue"], resolve),
        meta: {
          title: "detail"
        }
      },
      {
        path: "card/:id",
        name: "mobile-card-id",
        component: resolve => require(["./views/mobile/card.vue"], resolve),
        meta: {
          title: "card"
        }
      },

      {
        path: "messages",
        name: "mobile-messages",
        component: resolve => require(["./views/mobile/messages.vue"], resolve),
        meta: {
          title: "messages"
        }
      }
    ]
  },
  {
    path: "/base",
    meta: {
      title: "base",
      requiresAuth: true
    },
    component: resolve => require(["./views/sys/base.vue"], resolve),
    children: [
      {
        path: "",
        name: "welcome",
        component: resolve => require(["./views/sys/welcome.vue"], resolve),
        meta: {
          title: "welcome"
        }
      },
      {
        path: "menu",
        name: "menu",
        component: resolve => require(["./views/sys/menu.vue"], resolve),
        meta: {
          title: "menu"
        }
      },
      {
        path: "role",
        name: "role",
        component: resolve => require(["./views/sys/role.vue"], resolve),
        meta: {
          title: "role"
        }
      },
      {
        path: "user",
        name: "user",
        component: resolve => require(["./views/sys/user.vue"], resolve),
        meta: {
          title: "user"
        }
      },
      {
        path: "email",
        name: "email",
        component: resolve => require(["./views/sys/email.vue"], resolve),
        meta: {
          title: "email"
        }
      },
      {
        path: "card",
        name: "cardmanage",
        component: resolve => require(["./views/sys/card.vue"], resolve),
        meta: {
          title: "card"
        }
      },
      {
        path: "i-edit",
        name: "interest-edit",
        component: resolve =>
          require(["./views/sys/interest/interest-edit.vue"], resolve),
        meta: {
          title: "interest"
        }
      },
      {
        path: "i-create",
        name: "interest-create",
        component: resolve =>
          require(["./views/sys/interest/interest-create.vue"], resolve),
        meta: {
          title: "interest"
        }
      },
      {
        path: "i-delete",
        name: "interest-delete",
        component: resolve =>
          require(["./views/sys/interest/interest-delete.vue"], resolve),
        meta: {
          title: "interest"
        }
      },
      {
        path: "banner",
        name: "banner",
        component: resolve => require(["./views/sys/banner.vue"], resolve)
      },
      {
        path: "article",
        name: "article",
        component: resolve => require(["./views/sys/article.vue"], resolve)
      },
	  {
	    path: "rainbow/fhgjl",
	    name: "rainbow/fhgjl",
	    component: resolve => require(["./views/rainbow/yjzb/fhgjl.vue"], resolve),
	  },
	  {
	    path: "rainbow/wxltj",
	    name: "rainbow/wxltj",
	    component: resolve => require(["./views/rainbow/yjzb/wxltj.vue"], resolve),
	  },
	  {
	    path: "rainbow/kcscbl",
	    name: "rainbow/kcscbl",
	    component: resolve => require(["./views/rainbow/yjzb/kcscbl.vue"], resolve),
	  },
	  {
	    path: "rainbow/djrxpj",
	    name: "rainbow/djrxpj",
	    component: resolve => require(["./views/rainbow/yjzb/djrxpj.vue"], resolve),
	  },
	  {
	    path: "rainbow/zhkjsc",
	    name: "rainbow/zhkjsc",
	    component: resolve => require(["./views/rainbow/zhkjsc.vue"], resolve),
	  },
	  {
	    path: "rainbow/sbda",
	    name: "rainbow/sbda",
	    component: resolve => require(["./views/rainbow/sbda.vue"], resolve),
	  },
	  {
	    path: "rainbow/jqsxxx", // 单机器档案统计 - 机器属性信息
	    name: "rainbow/jqsxxx",
	    component: resolve => require(["./views/rainbow/djqdatj/jqsxxx.vue"], resolve)
	  },
	  {
	    path: "rainbow/rbxhjkpjytj", // 日报表细化 - 即开票交易统计
	    name: "rainbow/rbxhjkpjytj",
	    component: resolve => require(["./views/rainbow/rbbxh/jkpjytj.vue"], resolve)
	  },
	  {
	    path: "rainbow/rbxhjkpjy50", // 日报表细化 - 即开票交易Top50
	    name: "rainbow/rbxhjkpjy50",
	    component: resolve => require(["./views/rainbow/rbbxh/jkpjy50.vue"], resolve)
	  },
	  {
	    path: "rainbow/mrzwsbsl", // 日报表细化 - 每日在网设备数量
	    name: "rainbow/mrzwsbsl",
	    component: resolve => require(["./views/rainbow/rbbxh/mrzwsbsl.vue"], resolve)
	  },
	  {
	    path: "rainbow/mrxrwsbsl", // 日报表细化 - 每日新入网设备数量
	    name: "rainbow/mrxrwsbsl",
	    component: resolve => require(["./views/rainbow/rbbxh/mrxrwsbsl.vue"], resolve)
	  },
	  {
	    path: "rainbow/mrwkjsl", // 日报表细化 - 每日未开机设备数量
	    name: "rainbow/mrwkjsl",
	    component: resolve => require(["./views/rainbow/rbbxh/mrwkjsl.vue"], resolve)
	  },
	  {
	    path: "rainbow/cjsbs", // 日报表细化 - 撤机设备数
	    name: "rainbow/cjsbs",
	    component: resolve => require(["./views/rainbow/rbbxh/cjsbs.vue"], resolve)
	  },
	  
	  
	  
    ]
  },
  {
    path: "/article",
    meta: {
      title: "smallsnail-wh"
    },
    component: resolve => require(["./views/template/index.vue"], resolve),
    children: [
      {
        path: "",
        name: "article-home",
        component: resolve => require(["./views/article/pc/home.vue"], resolve),
        meta: {
          title: "article"
        }
      },
      {
        path: "create",
        name: "article-create",
        component: resolve => require(["./views/article/pc/create-article.vue"], resolve),
        meta: {
          title: "article"
        }
      },
      {
        path: "create/success",
        name: "article-create",
        component: resolve => require(["./views/article/pc/create-article-success.vue"], resolve),
        meta: {
          title: "article"
        }
      },
      {
        path: "detail/:id",
        name: "article-detail-id",
        component: resolve => require(["./views/article/pc/article-detail.vue"], resolve),
        meta: {
          title: "article"
        }
      },
      {
        path: "user",
        name: "article-user",
        component: resolve => require(["./views/article/pc/user-article.vue"], resolve),
        meta: {
          title: "article"
        }
      },
      {
        path: "update/:id",
        name: "article-update-id",
        component: resolve => require(["./views/article/pc/update-article.vue"], resolve),
        meta: {
          title: "article"
        }
      }
    ]
  }
];

// 路由配置
const RouterConfig = {
  mode: "history",
  routes: routers
};
const router = new VueRouter(RouterConfig);

router.beforeEach((to, from, next) => {
  // let token = window.localStorage.getItem("currentUser_token");
  // if (
  //   to.matched.some(record => record.meta.requiresAuth) &&
  //   (!token || token === null)
  // ) {
  //   next({
  //     path: "/",
  //     query: { redirect: to.fullPath }
  //   });
  // }
  iView.LoadingBar.start();
  next();
});

router.afterEach(() => {
  iView.LoadingBar.finish();
  window.scrollTo(0, 0);
});

export default router;
