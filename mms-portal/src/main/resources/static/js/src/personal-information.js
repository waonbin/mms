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
            }
        },
        mounted: function () {
            this.getDate()

        }
    })
});