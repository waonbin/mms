$(function() {
    new Vue({
        el:"#pay-content",
        data: {
            page:1,
            message: {
                id:'',
                name:''
            },
            payType: '1',
            step:1,
            list:{}
        },
        methods:{
          onStep: function(page) {
              this.step = Number(page)
          },
          handlePreview: function() {

          },
          handleRemove: function() {

          },
          handExceed: function(file) {
              this.$message.error('最多只能上传1个文件！');
          },
          getDate: function() {
              $.ajax({
                  url:'/payment/page/'+(this.page-1)
              }).done(function(date) {
                this.list = date;
              }.bind(this)).fail(function() {
                  this.$message.error('提交失败');
              }.bind(this))
          },
          getMessage: function() {
              $.ajax({
                  url:'/login/user'
              }).done(function(date) {
                  this.message = date;
              }.bind(this)).fail(function() {
                  this.$message.error('获取用户信息失败！');
              }.bind(this))
          },
          changePage: function(val) {
              this.page = val;
              this.getDate()
          },
            beforeUpload(file){
                let fd = new FormData();
                fd.append('file',file);//传文件;
                $.ajax({
                    url:'/file/upload',
                    type:"post",
                    contentType: false,
                    processData: false,
                    data:fd
                })
                return false
            },
          //线下提交
          underLineSubmit: function() {
              this.$refs.upload.submit()
              // this.$refs.upload.submit()
              // var file = this.$refs.upload.uploadFiles;
              //
              // if(file.length === 0) {
              //     this.$message({
              //         showClose: true,
              //         message: '请选择要提交的文件',
              //         type: 'warning'
              //     });
              //     return;
              // }
              // var formData = new FormData();
              // formData.append('file', file[0]);
              // $.ajax({
              //     url:'/file/upload',
              //     type:'post',
              //     contentType: false,
              //     processData: false,
              //     data:formData
              // }).done(function() {
              //
              // }.bind(this)).fail(function() {
              //     this.$message.error('提交失败！');
              // }.bind(this))
          }
        },
        mounted: function() {
            $(".payment-btn").addClass('cur');
            this.getMessage();
            this.getDate();
        }
    })
});