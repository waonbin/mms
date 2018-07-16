$(function() {
    new Vue({
        el:'#box-content',
        data: {
            list:{}
        },
        filters: {
            limitDate(val) {
                if(val) {
                    return val.substr(0,10)
                }
            }
        },
        methods: {
            getData: function() {
                var id = getQueryString('id');

                $.ajax({
                    url: ctxPath+'/admin/member/details/'+id
                }).done(function(data) {
                    this.list = data
                    console.log(this.message)
                }.bind(this)).fail(function() {
                    this.$message.error('获取数据失败,请检查网络');
                }.bind(this))
            }
        },
        mounted: function() {
            this.getData()
        }
    })
});