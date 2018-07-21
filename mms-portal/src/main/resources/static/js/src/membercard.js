$(function() {
    new Vue({
        el:"#membercard",
        data: {
            message: {
                id:'',
                name:'111'
            },
        },
        methods: {
            getMessage: function () {
                $.ajax({
                    url: ctxPath+'/login/user'
                }).done(function (date) {
                    this.message = date;
                }.bind(this)).fail(function () {
                    this.$message.error('获取用户信息失败！');
                }.bind(this))
            }
        },
        mounted: function() {
            $(".card-btn").addClass('cur');
            this.getMessage();
        }
    })
});