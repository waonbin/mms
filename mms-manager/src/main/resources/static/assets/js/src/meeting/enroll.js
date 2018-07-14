$(function() {
    new Vue({
        el:'#box-content',
        data() {
            return {
                page:1,
                tableData:[]
            }
        },
        methods: {
            getData: function() {
                $.ajax({
                    url: '/admin/meeting/enroll/page/'+(this.page-1),
                }).done(function(data) {
                    this.tableData = data;
                }.bind(this)).fail(function() {
                    this.$message.error('获取数据失败,请检查网络');
                }.bind(this))
            },
            changePage: function(val) {
                this.page = val;
                this.getData()
            },
        },
        mounted: function() {
            this.getData();
        }
    });

});
