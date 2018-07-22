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
            uploadUrl: ctxPath+'/file/upload',
            step:1,
            //上传文件返回的id;
            uploadFileId:0,
            typeList: [],
            list:{}
        },
        methods:{
          onStep: function(page) {
              this.step = Number(page)
          },
          handlePreview: function() {

          },
          handleRemove: function(file, fileList) {
            console.log(file);
              $.ajax({
                  url:ctxPath+'/file/delete',
                  type:'post',
                  data: {
                      id: this.uploadFileId
                  }
              }).done(function() {
                  this.uploadFileId = '';
                  this.$message({
                      message: '删除成功',
                      type: 'success'
                  });
              }.bind(this))
          },
          handSuccess: function(data) {
            this.uploadFileId = data.id;
            this.$message({
                message: '上传成功',
                type: 'success'
            });
          },
          handError: function() {
              this.$message.error('上传失败');
          },
          handExceed: function(file) {
              this.$message.error('最多只能上传1个文件！');
          },
          getMessage: function() {
              $.ajax({
                  url:ctxPath+'/login/user'
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

          },
          //线下提交
          underLineSubmit: function() {
              var params = {
                  id: this.message.id,
                  orderNo: '',
                  memberId: '',
                  orderType: '',
                  orderAmount: '',
                  payStatus: '',
                  payType: this.payType,
                  onlineType: '',
                  offlineVoucher: this.uploadFileId,
                  payTime: ''
              };

              $.ajax({
                  url: ctxPath+'/payment/pay',
                  type: 'post',
                  data: params
              }).done(function() {
                  this.step = 3;
              }.bind(this)).fail(function() {
                  this.$message.error('提交失败');
              })
          }
        },
        mounted: function() {
            $(".payment-btn").addClass('cur');
            this.getMessage();
        }
    })
});