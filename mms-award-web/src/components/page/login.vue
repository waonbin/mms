<template>
  <div class="login-wrap">
    <div class="ms-title">产品发布系统</div>
    <div class="ms-login">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="0px" class="demo-ruleForm">
        <el-form-item prop="uname">
          <el-input v-model="ruleForm.uname" placeholder="username"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input type="password" placeholder="password" v-model="ruleForm.password" @keyup.enter.native="submitForm('ruleForm')"></el-input>
        </el-form-item>
        <div class="login-btn">
          <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>
  import { loginIn } from 'src/apis/api';

  export default {
    data: function(){
      return {
        demo:'1',
        ruleForm: {
          uname: '',
          password: ''
        },
        rules: {
          uname: [
            { required: true, message: '请输入用户名', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      submitForm(formName) {
        let params = this.ruleForm;

        this.$refs[formName].validate((valid) => {
          if (valid) {
            $.ajax({
              type:'post',
              url:'/admin/login.php',
              data: this.ruleForm
            }).done(function(data) {
              let {code, msg} = data;

              if(code == 1) {
                sessionStorage.setItem('ms_username',this.ruleForm.uname);
                this.$router.push('/');
              } else {
                this.$message({message: msg, type: "error"});
              }
            }.bind(this));
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      }
    }
  }
</script>

<style scoped>
  .login-wrap{
    position: relative;
    width:100%;
    height:100%;
  }
  .ms-title{
    position: absolute;
    top:50%;
    width:100%;
    margin-top: -230px;
    text-align: center;
    font-size:30px;
    color: #fff;

  }
  .ms-login{
    position: absolute;
    left:50%;
    top:50%;
    width:300px;
    height:160px;
    margin:-150px 0 0 -190px;
    padding:40px;
    border-radius: 5px;
    background: #fff;
  }
  .login-btn{
    text-align: center;
  }
  .login-btn button{
    width:100%;
    height:36px;
  }
</style>
