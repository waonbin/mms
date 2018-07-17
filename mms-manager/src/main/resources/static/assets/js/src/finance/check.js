$(function() {
    new Vue({
        el:'#box-content',
        data() {
            return {
                page:1,
                tableData: [],
                multipleSelection: []
            }
        },
        computed: {

        },
        methods: {
            getData: function() {
                $.ajax({
                    url: ctxPath+'/admin/payment/payment_check/page/'+(this.page-1)
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
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            examine: function(id) {
                location.href=ctxPath+"/admin/finance/details?id="+id+"&examine=true"
            }
        },
        mounted: function() {
            this.getData();
        }
    });

});
