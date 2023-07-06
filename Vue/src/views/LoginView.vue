
<template>
  <div class="login-container">
    <div class="login-box">
      <div class="login-logo">
        <a href="#">
          <img src="../assets/logo.png" alt="logo">
        </a>
      </div>
      <div class="login-form">
        <h3>用户登录</h3>
        <el-form ref="form" :model="loginForm" :rules="rules" label-position="left" label-width="0">
          <el-form-item prop="username">
            <el-input v-model="loginForm.username" placeholder="请输入用户名"></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input type="password" v-model="loginForm.password" placeholder="请输入密码"></el-input>
          </el-form-item>

<!--          验证码-->
          <el-form-item prop="captchaText">
            <el-input name="captchaText" style="width: 48%" type="text"
              v-model="loginForm.captchaText" placeholder="请输入验证码" prefix-icon="el-icon-picture">
            </el-input>&nbsp;&nbsp;
            <!--这里的src路径得看后端对应的Controller路径-->
            <img src="http://localhost:28080/admin-api/auth/captcha" 
              id="captchaText" height=30px width=150px 
              @click="getCaptcha()" />
          </el-form-item>

          <el-form-item>
            <el-button type="primary" @click="do_login" :loading="loading">登录</el-button>
<!--            <el-button type="primary" @click="to_register">注册</el-button>-->
          </el-form-item>

        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
import {login, captcha} from '@/api/login.js'
import {removeToken, setToken} from '@/utils/auth'
export default {
  data() {
    return {
      loginForm: {
        username: '',
        password: '',
        captchaText: ''
      },
      rules: {
        username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
        password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
        captchaText: [{ required: true, message: '请输入验证码', trigger: 'blur' }],
      },
      loading: false,
    
    }
  },

  // created() {
  //   this.getCaptcha();
  // },

  methods: {
    do_login() {
      this.$refs.form.validate(valid => {
        if (valid) {
          this.loading = true
          //发起网络请求，登录成功则跳转到主页面
          //传信息项目全通之后加一下验证码字段
          login(this.loginForm.username,this.loginForm.password,this.loginForm.captchaText).then(res =>{
            console.log(res.data.token)
            if(res.code==50006){
                this.$message.error("验证码错误")
                document.getElementById("captchaText").src="http://localhost:28080/admin-api/auth/captcha?"+new Date().getTime();
                this.loading=false
                return
              }
            setToken(res.data.accessToken)
            this.$router.push({ path: '/' })
          }).catch(() => {
            // 登录失败，显示错误提示
            this.$message.error('登录错误')
            this.loading = false
          })
        }
      })
    },

    getCaptcha() {
      document.getElementById("captchaText").src = "http://localhost:28080/admin-api/auth/captcha?" + new Date().getTime();
    },

    to_register() {
      this.$router.push({ path: '/register'})
    },
  }
}
</script>

<style lang="scss">
.login-container {
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;

  .login-box {
    width: 400px;
    height: 400px;
    border-radius: 5px;
    box-shadow: 0px 0px 10px #ccc;

    .login-logo {
      height: 100px;
      display: flex;
      justify-content: center;
      align-items: center;

      img {
        height: 80%;
      }
    }

    .login-form {
      padding: 20px;

      h3 {
        font-size: 24px;
        margin-bottom: 20px;
        text-align: center;
      }
    }
  }
}
</style>