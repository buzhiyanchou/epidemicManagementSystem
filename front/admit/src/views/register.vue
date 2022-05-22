<template>
  <div>
    <div class="container">
      <div class="login-form">
        <h1 class="h1">微信小程序社区防疫管理系统注册</h1>
        <el-form
          ref="registerForm"
          :rules="ruleForm"
          :model="rgsForm"
          label-width="100px"
        >
          <el-form-item label="用户名" class="input" prop="username">
            <el-input
              v-model="rgsForm.username"
              autocomplete="off"
              placeholder="用户名"
            />
          </el-form-item>

          <el-form-item label="用户类型" class="input">
            <el-radio-group v-model="rgsForm.role">
              <el-radio label="管理员" >管理员</el-radio>
              <el-radio label="总管理员">总管理员</el-radio>
            </el-radio-group>
          </el-form-item>

          <el-form-item label="密码" class="input" prop="password">
            <el-input
              v-model="rgsForm.password"
              autocomplete="off"
              placeholder="密码"
              type="password"
            />
          </el-form-item>
          <el-form-item label="确认密码" class="input" prop="repassword">
            <el-input
              v-model="rgsForm.repassword"
              autocomplete="off"
              placeholder="确认密码"
              type="password"
            />
          </el-form-item>

          <el-form-item label="手机" class="input" prop="phone">
            <el-input
              v-model="rgsForm.phone"
              autocomplete="off"
              placeholder="手机"
            />
          </el-form-item>

          <el-form-item label="授权码" class="input" prop="code">
            <el-input
              v-model="rgsForm.code"
              autocomplete="off"
              placeholder="授权码"
            />
          </el-form-item>
          <div
            style="
              display: flex;
              flex-wrap: wrap;
              width: 100%;
              justify-content: center;
            "
          >
            <el-button class="btn" type="primary" @click="login()"
              >注册</el-button
            >
            <el-button class="btn close" type="warning" @click="close()"
              >取消</el-button
            >
          </div>
        </el-form>
      </div>
      <!-- <div class="nk-navigation">
        <a href="#">
          <div @click="login()">注册</div>
        </a>
      </div> -->
    </div>
  </div>
</template>
<script>
export default {
  data() {
    // 手机号验证规则
    var checkTel = (rule, value, callback) => {
      const regTel = /^1[3456789]\d{9}$/;
      if (regTel.test(value)) {
        return callback();
      }
      callback(new Error("给我认真填！哼！"));
    };
    return {
      rgsForm: {
        username: "",
        role: '管理员',
        password: "",
        repassword: "",
        phone: "",
        code: "",
      },
      ruleForm: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
        ],
        password: [
          { required: true, message: "密码不能为空", trigger: "blur" },
        ],
        repassword: [
          { required: true, message: "确认密码不能为空", trigger: "blur" },
        ],
        phone: [
          { required: true, message: "手机号不能为空", trigger: "blur" },
          { validator: checkTel, trigger: "blur" },
        ],
        code: [
          {
            required: true,
            message: "授权码不能为空",
            trigger: "blur",
          },
        ],
      },
      tableName: "",
      rules: {},
      authCode: []
    };
  },
  mounted() {
    let table = this.$storage.get("loginTable");
    this.tableName = table;
  },
  created() {
    this.getAdminAuthCode()
  },
  methods: {
    // 获取uuid
    getUUID() {
      return new Date().getTime();
    },
    close() {
      this.$router.push({ path: "/login" });
    },
    async getAdminAuthCode() {
      const { data: res } = await this.$http({
        url: '/users/admin/auth/code',
        method: 'get',
      })
      if(res.code != 0) return this.$message.error('服务器开了个小差')
      res.data.forEach(item => {
        let temp = item.split(',')
        this.authCode = [
          ...this.authCode,
          ...temp
        ]
      })
    },
    // 注册
    login() {
      //   this.$http({
      //     url: url,
      //     method: "post",
      //     data: this.ruleForm,
      //   }).then(({ data }) => {
      //     if (data && data.code === 0) {
      //       this.$message({
      //         message: "注册成功",
      //         type: "success",
      //         duration: 1500,
      //         onClose: () => {
      //           this.$router.replace({ path: "/login" });
      //         },
      //       });
      //     } else {
      //       this.$message.error(data.msg);
      //     }
      //   });

      let that = this;
      this.$refs["registerForm"].validate((valid) => {
        if (valid) {
          if (that.rgsForm.password != that.rgsForm.repassword)
            return that.$message.error("密码不一致");
            let isAuthPass = false
            that.authCode.forEach(item => {
              if(item == that.rgsForm.code)isAuthPass = true 
            });
            if(isAuthPass)return this.$message.error('授权码不正确')
            that.rgsForm.code = ''
          that
            .$http({
              url: "/users/save",
              method: "post",
              data: that.rgsForm,
            })
            .then((res) => {
              console.log(res);
              if (res.data.code != 0) return that.$message.error("注册失败");
              that.$message.success("注册成功");
              that.$router.push("/login");
            });
        } else {
          return that.$message.error("其中包含必填项");
        }
      });
    },
  },
};
</script>
<style lang="scss" scoped>
.el-radio__input.is-checked .el-radio__inner {
  border-color: #00c292;
  background: #00c292;
}

.el-radio__input.is-checked .el-radio__inner {
  border-color: #00c292;
  background: #00c292;
}

.el-radio__input.is-checked .el-radio__inner {
  border-color: #00c292;
  background: #00c292;
}

.el-radio__input.is-checked + .el-radio__label {
  color: #00c292;
}

.el-radio__input.is-checked + .el-radio__label {
  color: #00c292;
}

.el-radio__input.is-checked + .el-radio__label {
  color: #00c292;
}

.h1 {
  margin-top: 10px;
}

body {
  padding: 0;
  margin: 0;
}

// .container {
//    min-height: 100vh;
//    text-align: center;
//    // background-color: #00c292;
//    padding-top: 20vh;
//    background-image: url(../assets/img/bg.jpg);
//    background-size: 100% 100%;
//    opacity: 0.9;
//  }

// .login-form:before {
// 	vertical-align: middle;
// 	display: inline-block;
// }

// .login-form {
// 	max-width: 500px;
// 	padding: 20px 0;
// 	width: 80%;
// 	position: relative;
// 	margin: 0 auto;

// 	.label {
// 		min-width: 60px;
// 	}

// 	.input-group {
// 		max-width: 500px;
// 		padding: 20px 0;
// 		width: 80%;
// 		position: relative;
// 		margin: 0 auto;
// 		display: flex;
// 		align-items: center;

// 		.input-container {
// 			display: inline-block;
// 			width: 100%;
// 			text-align: left;
// 			margin-left: 10px;
// 		}

// 		.icon {
// 			width: 30px;
// 			height: 30px;
// 		}

// 		.input {
// 			position: relative;
// 			z-index: 2;
// 			float: left;
// 			width: 100%;
// 			margin-bottom: 0;
// 			box-shadow: none;
// 			border-top: 0px solid #ccc;
// 			border-left: 0px solid #ccc;
// 			border-right: 0px solid #ccc;
// 			border-bottom: 1px solid #ccc;
// 			padding: 0px;
// 			resize: none;
// 			border-radius: 0px;
// 			display: block;
// 			width: 100%;
// 			height: 34px;
// 			padding: 6px 12px;
// 			font-size: 14px;
// 			line-height: 1.42857143;
// 			color: #555;
// 			background-color: #fff;
// 		}

// 	}
// }

.nk-navigation {
  margin-top: 15px;

  a {
    display: inline-block;
    color: #fff;
    background: rgba(255, 255, 255, 0.2);
    width: 100px;
    height: 50px;
    border-radius: 30px;
    text-align: center;
    display: flex;
    align-items: center;
    margin: 0 auto;
    justify-content: center;
    padding: 0 20px;
  }

  .icon {
    margin-left: 10px;
    width: 30px;
    height: 30px;
  }
}

.register-container {
  margin-top: 10px;

  a {
    display: inline-block;
    color: #fff;
    max-width: 500px;
    height: 50px;
    border-radius: 30px;
    text-align: center;
    display: flex;
    align-items: center;
    margin: 0 auto;
    justify-content: center;
    padding: 0 20px;

    div {
      margin-left: 10px;
    }
  }
}

.container {
  height: 100vh;
  background-position: center center;
  background-size: cover;
  background-repeat: no-repeat;
  background-image: url(http://codegen.caihongy.cn/20220103/25bd44f101214694bc1a8ecdbef11462.png);

  .login-form {
    right: 50%;
    top: 50%;
    transform: translate3d(50%, -50%, 0);
    border-radius: 10px;
    background-color: rgba(255, 255, 255, 0.5);
    font-size: 14px;
    font-weight: 500;
    box-sizing: border-box;

    width: 410px;
    height: auto;
    padding: 15px;
    margin: 0 auto;
    border-radius: 30px;
    border-width: 5px;
    border-style: solid;
    border-color: rgba(198, 223, 209, 1);
    background-color: rgba(255, 255, 255, 1);
    box-shadow: 0px 0px 0px 29px #fffdee;

    .h1 {
      width: 90%;
      height: auto;
      line-height: auto;
      color: #000;
      font-size: 28px;
      padding: 0;
      margin: 0 auto 20px;
      border-radius: 0;
      border-width: 0;
      border-style: solid;
      border-color: rgba(255, 0, 0, 0);
      background-color: rgba(255, 0, 0, 0);
      box-shadow: 0 0 6px rgba(255, 0, 0, 0);
      text-align: center;
    }

    .rgs-form {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;

      .el-form-item {
        width: 100%;
        display: flex;

        & /deep/ .el-form-item__content {
          flex: 1;
          display: flex;
        }
      }

      .input {
        width: 90%;
        height: auto;
        padding: 0;
        margin: 0 0 12px 0;
        border-radius: 0;
        border-width: 0;
        border-style: solid;
        border-color: rgba(255, 0, 0, 0);
        background-color: rgba(255, 0, 0, 0);
        box-shadow: 0 0 6px rgba(255, 0, 0, 0);

        & /deep/ .el-form-item__label {
          width: 70px;
          line-height: 44px;
          color: #606266;
          font-size: 14px;
          padding: 0 10px 0 0;
          margin: 0;
          border-radius: 0;
          border-width: 0;
          border-style: solid;
          border-color: rgba(255, 0, 0, 0);
          background-color: rgba(255, 0, 0, 0);
          box-shadow: 0 0 6px rgba(255, 0, 0, 0);
        }

        & /deep/ .el-input__inner {
          width: 100%;
          height: 44px;
          line-height: 44px;
          color: #606266;
          font-size: 14px;
          padding: 0 12px;
          margin: 0;
          border-radius: 4px;
          border-width: 0;
          border-style: solid;
          border-color: #606266;
          background-color: #fff;
          box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.16);
          text-align: left;
        }
      }

      .send-code {
        & /deep/ .el-input__inner {
          width: 180px;
          height: 44px;
          line-height: 44px;
          color: #606266;
          font-size: 14px;
          padding: 0 12px;
          margin: 0;
          border-radius: 0;
          border-width: 0;
          border-style: solid;
          border-color: #606266;
          background-color: #fff;
          box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.16);
          text-align: left;
        }

        .register-code {
          margin: 0;
          padding: 0;
          width: 86px;
          height: 44px;
          line-height: 44px;
          color: #fff;
          font-size: 14px;
          border-width: 0;
          border-style: solid;
          border-color: rgba(198, 223, 209, 1);
          border-radius: 0 5px 5px 0;
          background-color: rgba(242, 237, 194, 1);
          box-shadow: 0 0 6px rgba(255, 0, 0, 0);
        }
      }

      .btn {
        margin: 0 10px;
        padding: 0;
        width: 88px;
        height: 44px;
        line-height: 44px;
        color: #fff;
        font-size: 14px;
        border-width: 0;
        border-style: solid;
        border-color: rgba(198, 223, 209, 1);
        border-radius: 4px;
        background-color: rgba(242, 237, 194, 1);
        box-shadow: 0px 0px 0px 0px rgba(198, 223, 209, 1);
      }

      .close {
        margin: 0 10px;
        padding: 0;
        width: 88px;
        height: 44px;
        line-height: 44px;
        color: rgba(198, 223, 209, 1);
        font-size: 14px;
        border-width: 1px;
        border-style: solid;
        border-color: rgba(198, 223, 209, 1);
        border-radius: 4px;
        background-color: #fff;
        box-shadow: 0 0 6px rgba(255, 0, 0, 0);
      }
    }
  }
}
</style>
