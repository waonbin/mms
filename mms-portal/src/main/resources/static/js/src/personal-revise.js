$(function () {
    new Vue({
        el:'#revise-content',
        data: function() {
            var _this = this;

            var validatePass = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入密码'));
                } else if(value.length >= 8 && value.length <= 20) {
                    if (_this.ruleForm.checkPass !== '') {
                        _this.$refs.ruleForm.validateField('checkPass');
                    }
                    callback();
                }else {
                    callback(new Error('请输入8到20位密码'));
                }
            };
            var validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入密码'));
                } else if (value !== this.ruleForm.pass) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };

            return {
                tip: false,
                message: {
                    id:'',
                    name:'111'
                },
                ruleForm: {
                    old:'',
                    pass: '',
                    checkPass: '',
                    age: ''
                },
                rules2: {
                    pass: [
                        { required: true, validator: validatePass, trigger: 'blur' }
                    ],
                    checkPass: [
                        { required: true, validator: validatePass2, trigger: 'blur' }
                    ]
                }
            };

        },
        methods:{
            check() {
               var params = {
                   password:this.ruleForm.old
               };

              $.ajax({
                  url:"/member/check/password",
                  data: params
              }).done(function() {
                  this.submit();
              }.bind(this)).fail(function(data) {
                  this.$message.error(data.responseText);
              }.bind(this))
            },
            submit: function() {
                var params = {
                    newPassword: this.ruleForm.pass
                };

                $.ajax({
                    url:"/member/check/name",
                    data: params
                }).done(function() {
                    this.$message({
                        message: '修改成功',
                        type: 'success'
                    });
                }.bind(this)).fail(function() {
                    this.$message.error('提交失败');
                }.bind(this))
            },
            submitForm(formName) {
                var _this = this;

                this.$refs[formName].validate((valid) => {
                    if (valid) {
                       _this.check()
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        },
        mounted: function() {
            $(".revise-btn").addClass('cur');
            this.message = message || {name:'---'};
        }
    })
})