$(function() {
    new Vue({
        el:"#pay-content",
        data: {
            page:1,
            message: {
                id:'',
                name:'111'
            },
            list:{}
        },
        methods:{
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
          }
        },
        mounted: function() {
            $(".payment-btn").addClass('cur');
            this.getMessage();
            this.getDate();
        }
    })
});