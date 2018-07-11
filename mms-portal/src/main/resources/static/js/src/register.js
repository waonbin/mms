
   new Vue({
     el:"#register",
       data:function() {
           var _this = this;

           var validatePass = function(rule, value, callback) {
               if (value === '') {
                   callback(new Error('请输入密码'));
               } else if(value.length >= 8 && value.length <= 20) {
                   if (_this.registerValidateForm.checkPass !== '') {
                       _this.$refs.registerValidateForm.validateField('checkPass');
                   }
                   callback();
               } else {
                   callback(new Error('请输入8到20位密码'));
               }
           };
           var validatePass2 = function(rule, value, callback) {
               if (value === '') {
                   callback(new Error('请再次输入密码'));
               } else if (value !== _this.registerValidateForm.pass) {
                   callback(new Error('两次输入密码不一致!'));
               } else {
                   callback();
               }
           };
           var validatePhone = function(rule, value, callback) {
               if(value.length === 0) {
                   callback(new Error('请输入手机号码'))
               } else {
                   callback();
               }
           };

           return {
               registerValidateForm: {
                   email:'',
                   pass:'',
                   checkPass:'',
                   name:'',
                   memberType:'1',
                   phone:'',
                   reference:'',
                   gender:'1',
                   born:'',
                   company:'',
                   zc:'',
                   nationality:'',
                   partisan:'1',
                   major:'',
                   education:'',
                   researchField:'',
                   memberNo:''
               },


               rules: {
                   pass: [
                       { required: true, validator: validatePass, trigger: ['blur'] }
                   ],
                   checkPass: [
                       { required: true, validator: validatePass2, trigger: ['blur'] }
                   ],
                   phone: [
                       { required: true, validator: validatePhone, trigger: 'change' }
                   ]
               }
           }
       },
       methods: {
           submitForm: function(formName) {
               var _this = this;

               this.$refs[formName].validate((valid) => {
                   if (valid) {
                       _this.submit();
                   } else {
                       console.log('error submit!!');
                       return false;
                   }
               });
           },
           changeTime(time) {
               var y = time.getFullYear(),
                   m = time.getMonth()+1,
                   d = time.getDate();

               if(m < 10) {
                   m = '0'+m
               }
               if(d < 10) {
                   d = '0'+d
               }
               return y+'-'+m+'-'+d
           },
           submit: function() {
               var param = {
                   email: this.registerValidateForm.email,
                   password: this.registerValidateForm.pass,
                   name: this.registerValidateForm.name,
                   memberType: this.registerValidateForm.memberType,
                   mobile: this.registerValidateForm.phone,
                   reference: this.registerValidateForm.reference,
                   gender: this.registerValidateForm.gender,
                   birthday: this.changeTime(this.registerValidateForm.born),
                   company: this.registerValidateForm.company,
                   title: this.registerValidateForm.zc,
                   nationality: this.registerValidateForm.nationality,
                   partisan: this.registerValidateForm.partisan,
                   major: this.registerValidateForm.major,
                   education: this.registerValidateForm.education,
                   researchField: this.registerValidateForm.researchField,
                   memberNo: this.registerValidateForm.memberNo
               };

               $.ajax({
                   url:'/member/register',
                   type:'post',
                   data:param
               }).done(function(data, status, xhr) {
                   var url = xhr.getResponseHeader('Location');
                   document.location = url;
               }.bind(this)).fail(function() {
                   this.$message.error('提交失败');
               }.bind(this))
           },
           resetForm: function(formName) {
               this.$refs[formName].resetFields();
           }
       }
   })
