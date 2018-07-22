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
            isKaipiao: '1',
            uploadUrl: ctxPath+'/file/upload',
            step:1,
            dues:'', //会费金额-每年
            duration: '', //会费金额-年
            //上传文件返回的id;
            uploadFileId:0,
            typeList: [],
            cityList:[],
            order: {
                deliveryType: '1',
                invoiceType: '1',
                titleType: '1',
                province: '',
                city: ''
            },
            list:{}
        },
        computed: {
            provinceList: function() {
                return this.cityList.filter(function(item) {
                    return item.parentId === 0
                })
            },
            citiesList: function() {
                return this.cityList.filter(function(item) {
                    return item.parentId === this.order.province
                }.bind(this))
            }
        },
        methods:{
          onStep: function(page) {
              if(page === 2) {
                this.submitPost()
              }
              this.step = Number(page)
          },
          submitPost: function() {
              var parms = this.order;

              if(this.order.titleType == 1) {
                  parms.taitleType = null
              }
              if(this.dues && this.duration) {
                  parms.amount = Number(this.dues)*Number(this.duration)
              }
              $.ajax({
                  url: ctxPath+'/payment/order',
                  type: 'post',
                  data: parms
              })

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
          getDues: function() {
              $.ajax({
                  url:ctxPath+'/payment/dues'
              }).done(function(date) {
                  this.dues = date;
              }.bind(this))
          },
          getDuration: function() {
              $.ajax({
                  url:ctxPath+'/payment/duration'
              }).done(function(date) {
                  this.duration = date;
              }.bind(this))
          },
          getCity: function() {
              $.ajax({
                  url:ctxPath+'/division/data'
              }).done(function(data) {
                  this.cityList = data;
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
                  orderAmount: '100',
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
            this.getDues();
            this.getDuration();
            this.getCity();
        }
    })
});