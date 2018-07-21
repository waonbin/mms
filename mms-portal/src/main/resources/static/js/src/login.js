//登录页面

(function() {
   var draw = VerificationCode.setCode;

   var login = new Vue({
       el:'#login-box',
       data: {
           tip: false,
           tipContent:'密码或者账户名错误',
           name:'',
           password:'',
           code:''
       },
       methods: {
          changeCode: function() {
              draw('canvas');
          },
          submit: function() {
              var param = {
                  name: this.name,
                  password: this.password
              };

              $.ajax({
                  url:ctxPath+'/login',
                  type:'post',
                  data: param
              }).done(function(data, status, xhr) {
                  var url = xhr.getResponseHeader('Location');
                  document.location = '.' + url;
              }.bind(this)).fail(function(data,statue) {
                  draw('canvas');
                  this.tip = true;
                  this.tipContent = data.responseText;
              }.bind(this))
          },
          login: function() {
              var code = VerificationCode.getCode.join("");

              if(this.name.length === 0 ) {
                  this.tip = true;
                  this.tipContent = "用户名不能为空";
                  return
              } else if (this.password.length === 0) {
                  this.tip = true;
                  this.tipContent = "密码不能为空";
                  return
              } else if (this.code.length === 0) {
                  this.tip = true;
                  this.tipContent = "请输入验证码";
                  return;
              } else if (this.code.toLocaleLowerCase() !== code) {
                  this.tip = true;
                  this.tipContent = "验证码不正确";
                  draw('canvas');
                  return;
              } else {
                  this.tip = false;
                  this.submit();
              }
          }
       },
       mounted: function () {
           draw('canvas');
       }
   });


})();