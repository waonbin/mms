
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
                   login:'',
                   email:'',
                   pass:'',
                   checkPass:'',
                   name:'',
                   first_name:'',
                   last_name:'',
                   memberType:1,
                   phone:'',
                   reference:'',
                   gender:1,
                   born:'',
                   company:'',
                   zc:'',
                   nationality:'',
                   partisan:'',
                   major:'',
                   education:'',
                   researchField:'',
                   memberNo:''
               },
               dictionaryList: [],

               rules: {
                   pass: [
                       { required: true, validator: validatePass, trigger: ['blur'] }
                   ],
                   checkPass: [
                       { required: true, validator: validatePass2, trigger: ['blur'] }
                   ],
                   phone: [
                       { required: true, validator: validatePhone, trigger: 'change' }
                   ],
                   first_name: [
                       {required: true, message: '请输入名', trigger: 'blur' }
                   ],
                   last_name: [
                       { required: true, message: '请输入姓', trigger: 'blur' }
                   ],
               }
           }
       },
       computed:{
           provinceList: function() {
               return this.cityList.filter(function(item) {
                   return item.parentId === 0
               })
           },
           citiesList: function() {
               return this.cityList.filter(function(item) {
                   return item.parentId === this.registerValidateForm.province
               }.bind(this))
           },
           genderList: function() {
               return this.dictionaryList.filter(function(item) {
                   return item.dictionaryId === 1
               })
           },
           memberList: function() {
               return this.dictionaryList.filter(function(item) {
                   return item.dictionaryId === 2
               })
           },
           partisanList: function() {
               return this.dictionaryList.filter(function(item) {
                   return item.dictionaryId === 3
               })
           },
           workNatureList: function() {
               return this.dictionaryList.filter(function(item) {
                   return item.dictionaryId === 4
               })
           },
           educationList: function() {
               return this.dictionaryList.filter(function(item) {
                   return item.dictionaryId === 5
               })
           },
           levelList: function() {
               return this.dictionaryList.filter(function(item) {
                   return item.dictionaryId === 6
               })
           },
           referenceList: function() {
               return this.dictionaryList.filter(function(item) {
                   return item.dictionaryId === 7
               })
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
           getDictionary: function() {
               $.ajax({
                   url:ctxPath+'/dictionary'
               }).done(function(data) {
                   this.dictionaryList = data;
               }.bind(this))
           },
           submit: function() {
               var param = {
                   login: this.registerValidateForm.login,
                   email: this.registerValidateForm.email,
                   password: this.registerValidateForm.pass,
                   firstName: this.registerValidateForm.first_name,
                   lastName: this.registerValidateForm.last_name,
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
                   url:ctxPath+'/member/register',
                   type:'post',
                   data:param
               }).done(function(data, status, xhr) {
                   // var url = xhr.getResponseHeader('Location');
                   // document.location = url;
                   document.location = ctxPath + '/member/register3';
               }.bind(this)).fail(function() {
                   this.$message.error('提交失败');
               }.bind(this))
           },
           resetForm: function(formName) {
               this.$refs[formName].resetFields();
           }
       },
       mounted: function() {
           this.getDictionary();
       }
   })
