$(function() {
   new Vue({
       el:'#edit-content',
       data: function() {
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
                   birthday:"2018-07-10T00:00:00.000+08:00",
                   company: "123",
                   education: "123",
                   email: "546052344@qq.com",
                   gender: '1',
                   id: 10016,
                   major: "123",
                   memberNo: "11111",
                   memberType: 1,
                   mobile: "18876335111",
                   name: "",
                   nationality: "123",
                   partisan: 1,
                   reference: 2,
                   researchField: "123",
                   title: "123"
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
                      // _this.submit();
                   } else {
                       console.log('error submit!!');
                       return false;
                   }
               });
           },
           resetForm: function(formName) {
               this.$refs[formName].resetFields();
           }
       },
       mounted: function() {
           $(".edit-btn").addClass('cur');
           message.gender = message.gender.toString();
           message.memberType = message.memberType.toString();
           message.partisan= message.partisan.toString();
           this.registerValidateForm = message;
       }
   })
});