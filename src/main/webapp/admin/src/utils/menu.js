const menu = {
  list() {
    return [
      {
        backMenu: [
          {
            child: [
              {
                appFrontIcon: "cuIcon-copy",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "用户",
                menuJump: "列表",
                tableName: "yonghu",
              },
            ],
            menu: "用户管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-album",
                buttons: ["查看", "修改", "删除", "审核", "报表"],
                menu: "出入信息",
                menuJump: "列表",
                tableName: "churuxinxi",
              },
            ],
            menu: "出入信息管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-flashlightopen",
                buttons: ["查看", "修改", "删除", "审核"],
                menu: "疫情上报",
                menuJump: "列表",
                tableName: "yiqingshangbao",
              },
            ],
            menu: "疫情上报管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-similar",
                buttons: ["查看", "修改", "删除", "审核"],
                menu: "健康信息",
                menuJump: "列表",
                tableName: "jiankangxinxi",
              },
            ],
            menu: "健康信息管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-group",
                buttons: ["查看", "修改", "删除"],
                menu: "社区交流",
                tableName: "forum",
              },
            ],
            menu: "社区交流",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-paint",
                buttons: ["查看", "修改"],
                menu: "轮播图管理",
                tableName: "config",
              },
              {
                appFrontIcon: "cuIcon-news",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "公告信息",
                tableName: "news",
              },
            ],
            menu: "系统管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-paint",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "管理员列表",
                tableName: "admin",
              },
            ],
            menu: "管理员管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-news",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "区域列表",
                tableName: "area",
              },
            ],
            menu: "区域管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-news",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "物资列表",
                tableName: "materials",
              },
              {
                appFrontIcon: "cuIcon-news",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "商品管理",
                tableName: "goods",
              },
            ],
            menu: "物资管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-news",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "报备管理",
                tableName: "foreign",
              },
            ],
            menu: "人员报备管理",
          }
         
        ],
        frontMenu: [],
        hasBackLogin: "是",
        hasBackRegister: "否",
        hasFrontLogin: "否",
        hasFrontRegister: "否",
        roleName: "总管理员",
        tableName: "users",
      },
      {
        backMenu: [
          {
            child: [
              {
                appFrontIcon: "cuIcon-copy",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "用户",
                menuJump: "列表",
                tableName: "yonghu",
              },
            ],
            menu: "用户管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-album",
                buttons: ["查看", "修改", "删除", "审核", "报表"],
                menu: "出入信息",
                menuJump: "列表",
                tableName: "churuxinxi",
              },
            ],
            menu: "出入信息管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-flashlightopen",
                buttons: ["查看", "修改", "删除", "审核"],
                menu: "疫情上报",
                menuJump: "列表",
                tableName: "yiqingshangbao",
              },
            ],
            menu: "疫情上报管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-similar",
                buttons: ["查看", "修改", "删除", "审核"],
                menu: "健康信息",
                menuJump: "列表",
                tableName: "jiankangxinxi",
              },
            ],
            menu: "健康信息管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-group",
                buttons: ["查看", "修改", "删除"],
                menu: "社区交流",
                tableName: "forum",
              },
            ],
            menu: "社区交流",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-paint",
                buttons: ["查看", "修改"],
                menu: "轮播图管理",
                tableName: "config",
              },
              {
                appFrontIcon: "cuIcon-news",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "公告信息",
                tableName: "news",
              },
            ],
            menu: "系统管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-news",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "区域列表",
                tableName: "area",
              },
            ],
            menu: "区域管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-news",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "物资列表",
                tableName: "materials",
              },
              {
                appFrontIcon: "cuIcon-news",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "商品管理",
                tableName: "goods",
              },
            ],
            menu: "物资管理",
          },{
            child: [
              {
                appFrontIcon: "cuIcon-news",
                buttons: ["新增", "查看", "修改", "删除"],
                menu: "报备管理",
                tableName: "foreign",
              },
            ],
            menu: "人员报备管理",
          }
        ],
        frontMenu: [],
        hasBackLogin: "是",
        hasBackRegister: "否",
        hasFrontLogin: "否",
        hasFrontRegister: "否",
        roleName: "管理员",
        tableName: "users",
      },
      {
        backMenu: [
          {
            child: [
              {
                appFrontIcon: "cuIcon-album",
                buttons: ["新增", "查看"],
                menu: "出入信息",
                menuJump: "列表",
                tableName: "churuxinxi",
              },
            ],
            menu: "出入信息管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-flashlightopen",
                buttons: ["新增", "查看"],
                menu: "疫情上报",
                menuJump: "列表",
                tableName: "yiqingshangbao",
              },
            ],
            menu: "疫情上报管理",
          },
          {
            child: [
              {
                appFrontIcon: "cuIcon-similar",
                buttons: ["新增", "查看"],
                menu: "健康信息",
                menuJump: "列表",
                tableName: "jiankangxinxi",
              },
            ],
            menu: "健康信息管理",
          },
        ],
        frontMenu: [],
        hasBackLogin: "否",
        hasBackRegister: "否",
        hasFrontLogin: "是",
        hasFrontRegister: "是",
        roleName: "用户",
        tableName: "yonghu",
      },
    ];
  },
};
export default menu;
