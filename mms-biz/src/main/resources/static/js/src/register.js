
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
                   resource:'1',
                   phone:'',
                   region:'',
                   sex:'1',
                   born:'',
                   dw:'',
                   zc:'',
                   mz:'',
                   dp:'1',
                   zy:'',
                   xl:'',
                   yjly:'',
                   memberId:''
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
               this.$refs[formName].validate((valid) => {
                   if (valid) {
                       alert('submit!');
                   } else {
                       console.log('error submit!!');
                       return false;
                   }
               });
           },
           resetForm: function(formName) {
               this.$refs[formName].resetFields();
           }
       }
   })
