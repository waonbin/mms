$(function() {
    new Vue({
        el:'#information',
        data: {
            message:{}
        },
        filters: {
            memberType: function(type) {
                if (type === 1 ) {
                    return '普通会员'
                } else if (type === 2 ) {
                    return '学生会员'
                } else if (type === 3 ) {
                    return '团体会员'
                }
            }
        },

        methods: {
            getDate: function() {
                this.message = message || {};
            },
            logout: function() {
                this.$alert('确定退出？', '提示', {
                    confirmButtonText: '确定',
                    callback: action => {
                        $.ajax({
                            url:'/logout'
                        }).done(function(data, status, xhr) {
                            location.href='/logout'
                            // var url = xhr.getResponseHeader('Location');
                            // document.location = url;
                        })
                    }
                });
            }
        },
        mounted: function () {
            this.getDate()
            $(".info-btn").addClass('cur');
        }
    })
});