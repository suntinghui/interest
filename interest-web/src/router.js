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
	    component: resolve => require(["./views/rainbow/yjzb/zhkjsc.vue"], resolve),
	  },
	  {
	    path: "rainbow/sbda",
	    name: "rainbow/sbda",
	    component: resolve => require(["./views/rainbow/yjzb/sbda.vue"], resolve),
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
	  {
	    path: "rainbow/rxse", // 日销售统计-日销售额
	    name: "rainbow/rxse",
	    component: resolve => require(["./views/rainbow/rxsetj/rxse.vue"], resolve)
	  },
	  {
	    path: "rainbow/sblxtj", // 日销售统计-按设备类型统计
	    name: "rainbow/sblxtj",
	    component: resolve => require(["./views/rainbow/rxsetj/sblxtj.vue"], resolve)
	  },
	  {
	    path: "rainbow/acztj", // 日销售统计-按彩种统计
	    name: "rainbow/acztj",
	    component: resolve => require(["./views/rainbow/rxsetj/acztj.vue"], resolve)
	  },
	  {
	    path: "rainbow/dtpjxstj", // 日销售统计-单台平均销售统计
	    name: "rainbow/dtpjxstj",
	    component: resolve => require(["./views/rainbow/rxsetj/dtpjxstj.vue"], resolve)
	  },
	  {
	    path: "rainbow/dtxlpm", // 日销售统计-单台销量排名
	    name: "rainbow/dtxlpm",
	    component: resolve => require(["./views/rainbow/rxsetj/dtxlpm.vue"], resolve)
	  },
	  {
	    path: "rainbow/lxlsbzbtj", // 日销售统计-零销量设备占比统计
	    name: "rainbow/lxlsbzbtj",
	    component: resolve => require(["./views/rainbow/rxsetj/lxlsbzbtj.vue"], resolve)
	  },
	  {
	    path: "rainbow/jkppsgk", // 即开票配送概况
	    name: "rainbow/jkppsgk",
	    component: resolve => require(["./views/rainbow/kcqktj/jkppsgk.vue"], resolve)
	  },
	  {
	    path: "rainbow/jkppsmx", // 即开票配送明细
	    name: "rainbow/jkppsmx",
	    component: resolve => require(["./views/rainbow/kcqktj/jkppsmx.vue"], resolve)
	  },
	  {
	    path: "rainbow/pcssyl", // 票仓实时余量
	    name: "rainbow/pcssyl",
	    component: resolve => require(["./views/rainbow/kcqktj/pcssyl.vue"], resolve)
	  },
	  {
	    path: "rainbow/ckbgs", // 出库包裹数
	    name: "rainbow/ckbgs",
	    component: resolve => require(["./views/rainbow/kcqktj/ckbgs.vue"], resolve)
	  },
	  {
	    path: "rainbow/ztbgs", // 在途包裹数
	    name: "rainbow/ztbgs",
	    component: resolve => require(["./views/rainbow/kcqktj/ztbgs.vue"], resolve)
	  },
	  {
	    path: "rainbow/jkpydcgzjz", // 即开票月度采购总价值
	    name: "rainbow/jkpydcgzjz",
	    component: resolve => require(["./views/rainbow/kcqktj/jkpydcgzjz.vue"], resolve)
	  },
	  {
	    path: "rainbow/jkpydcgpzmx", // 即开票月度采购票种明细
	    name: "rainbow/jkpydcgpzmx",
	    component: resolve => require(["./views/rainbow/kcqktj/jkpydcgpzmx.vue"], resolve)
	  },
	  {
	    path: "rainbow/jkpkcs", // 即开票库存数(截止24时)
	    name: "rainbow/jkpkcs",
	    component: resolve => require(["./views/rainbow/kcqktj/jkpkcs.vue"], resolve)
	  },
	  {
	    path: "rainbow/jkpkcsmx", // 即开票库存数明细(截止24时)
	    name: "rainbow/jkpkcsmx",
	    component: resolve => require(["./views/rainbow/kcqktj/jkpkcsmx.vue"], resolve)
	  },
	  
	  {
	    path: "rainbow/xsetjy", // 销售额情况统计（按月）
	    name: "rainbow/xsetjy",
	    component: resolve => require(["./views/rainbow/srtj/xsetjy.vue"], resolve)
	  },
	  {
	    path: "rainbow/srtjr", // 收入情况统计（按日）
	    name: "rainbow/srtjr",
	    component: resolve => require(["./views/rainbow/srtj/srtjr.vue"], resolve)
	  },
	  {
	    path: "rainbow/fqdsbsl", // 分渠道设备数量
	    name: "rainbow/fqdsbsl",
	    component: resolve => require(["./views/rainbow/srtj/fqdsbsl.vue"], resolve)
	  },
	  {
	    path: "rainbow/mdfcjer", // 门店分成金额
	    name: "rainbow/mdfcjer",
	    component: resolve => require(["./views/rainbow/srtj/mdfcjer.vue"], resolve)
	  },
	  {
	    path: "rainbow/qdfcjer", // 渠道分成金额（按日）
	    name: "rainbow/qdfcjer",
	    component: resolve => require(["./views/rainbow/srtj/qdfcjer.vue"], resolve)
	  }, 
	  {
	    path: "rainbow/qdfcbl", // 渠道分成比例
	    name: "rainbow/qdfcbl",
	    component: resolve => require(["./views/rainbow/srtj/qdfcbl.vue"], resolve)
	  },
	  {
	    path: "rainbow/srqktj", // 收入情况统计
	    name: "rainbow/srqktj",
	    component: resolve => require(["./views/rainbow/srtj/srqktj.vue"], resolve)
	  },
	  {
	    path: "rainbow/tkqktjhj", // 退款合计
	    name: "rainbow/tkqktjhj",
	    component: resolve => require(["./views/rainbow/srtj/tkqktjhj.vue"], resolve)
	  },
	  {
	    path: "rainbow/tkqktjy", // 退款情况统计（按月）
	    name: "rainbow/tkqktjy",
	    component: resolve => require(["./views/rainbow/srtj/tkqktjy.vue"], resolve)
	  },
	  {
	    path: "rainbow/tkqktjr", // 退款情况统计（按日）
	    name: "rainbow/tkqktjr",
	    component: resolve => require(["./views/rainbow/srtj/tkqktjr.vue"], resolve)
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
