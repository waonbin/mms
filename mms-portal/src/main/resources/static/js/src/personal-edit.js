$(function() {
   new Vue({
       el:'#edit-content',
       data: function() {
           var _this = this;

           return {
               registerValidateForm: {
                   birthday:"",
                   company: "",
                   education: "",
                   email: "",
                   gender: '',
                   id: null,
                   major: "",
                   memberNo: "",
                   memberType: null,
                   mobile: "",
                   name: "",
                   nationality: "",
                   partisan: null,
                   reference: " ",
                   researchField: "",
                   title: "",
                   province:"",
                   city:"",
                   address:"",
                   first_name:"",
                   last_name:""
               },
               required:{
                   name:"会员姓名",
                   gender:"会员性别",
                   school:"毕业学校",
                   partisan:"党派信息",
                   company:"工作单位",
                   title:"职称",
                   level:"等级",
                   memberType:"会员类型",
                   birthday:"出生日期",
                   major:"所学专业",
                   workNature:"工作性质",
                   workajor:"工作专业",
                   education:"学历",
                   jobPerformance:"业务成绩",
                   mobile:"手机号",
                   zipcode:"邮编",
                   email:"邮箱",
                   reference:"推荐单位",
                   province:"省份",
                   city:"市",
                   first_name:"名",
                   last_name:"姓"
               },
               params:{},
               cityList:[],
               dictionaryList:[]
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
            check: function() {
                var allGroup = Object.keys(this.registerValidateForm),
                    group = Object.keys(this.required),
                    meilReq = new RegExp("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$");

                this.params.id = this.registerValidateForm.id;
                if(this.registerValidateForm['email'] && !meilReq.test(this.registerValidateForm['email'])) {
                    this.$message.error('邮箱格式不正确！');
                    return
                }

                for(var i=0; i<allGroup.length; i++) {
                    var obj = this.registerValidateForm[allGroup[i]];

                    if(obj) {
                        this.params[allGroup[i]] = obj;
                    }
                }

                for (var i=0; i<group.length; i++) {
                    var obj = this.registerValidateForm[group[i]];

                    if(this.registerValidateForm['birthday']) {
                        var time = this.registerValidateForm['birthday'].toString();
                        this.registerValidateForm['birthday'] = this.changeTime(new Date(time))
                    }
                    if(!obj || (isNaN(obj) && !obj.length) ) {
                        this.$message.error('请填写必填字段: '+ this.required[group[i]]);
                        break;
                    } else if(obj) {
                        this.params[group[i]] = obj
                    }
                    if(i === group.length-1 ) {
                        this.submit()
                    }
                }
            },
           getDate: function() {
               $.ajax({
                   url: ctxPath + '/login/user'
               }).done(function (message) {
                   message.gender = message.gender.toString();
                   message.memberType = message.memberType.toString();
                   message.partisan= message.partisan.toString();
                   message.birthday= (new Date(message.birthday)).toString();
                   message.province = message.province || "";
                   message.city = message.city || "";

                   this.registerValidateForm = message;
               }.bind(this)).fail(function () {
                   this.$message.error('获取用户信息失败！');
               }.bind(this))
           },
           getCity: function() {
               $.ajax({
                   url:ctxPath+'/division/data'
               }).done(function(data) {
                   this.cityList = data;
               }.bind(this))
           },
           getDictionary: function() {
               $.ajax({
                   url:ctxPath+'/dictionary'
               }).done(function(data) {
                   this.dictionaryList = data;
               }.bind(this))
           },
           submit: function() {
                $.ajax({
                    url:ctxPath+"/member/edit",
                    type:"post",
                    data: this.params
                }).done(function(){
                    this.$message({
                        message: '修改成功',
                        type: 'success'
                    });
                }.bind(this)).fail(function(){
                    this.$message.error('提交失败');
                }.bind(this))
           }
       },
       mounted: function() {
           this.getCity();
           this.getDictionary();
           this.getDate();
           $(".edit-btn").addClass('cur');
       }
   })
});