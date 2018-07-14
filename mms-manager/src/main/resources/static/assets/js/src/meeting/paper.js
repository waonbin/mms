$(function() {
    new Vue({
        el:'#box-content',
        data() {
            return {
                page:1,
                state:'',
                tableData:[],
                multipleSelection: []
            }
        },
        methods: {
            getData: function() {
                $.ajax({
                    url: '/admin/meeting/paper/page/'+(this.page-1),
                }).done(function(data) {
                    this.tableData = data;
                }.bind(this)).fail(function() {
                    this.$message.error('获取数据失败,请检查网络');
                }.bind(this))
            },
            handleSelectionChange(val) {
                this.multipleSelection = val;
            }
        },
        mounted: function() {
            this.getData();
        }
    });

});
