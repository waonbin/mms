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
                   reference: "",
                   researchField: "",
                   title: ""
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
                   reference:"推荐单位"
               },
               params:{}
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
                var group = Object.keys(this.required),
                    meilReq = new RegExp("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$");

                if(this.registerValidateForm['email'] && !meilReq.test(this.registerValidateForm['email'])) {
                    this.$message.error('邮箱格式不正确！');
                    return
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
           submit: function() {
                $.ajax({
                    url:"./edit",
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
           $(".edit-btn").addClass('cur');
           message.gender = message.gender.toString();
           message.memberType = message.memberType.toString();
           message.partisan= message.partisan.toString();
           message.birthday= (new Date(message.birthday)).toString();
           this.registerValidateForm = message;
       }
   })
});