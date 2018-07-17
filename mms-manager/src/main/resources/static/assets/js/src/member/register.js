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
                    url: ctxPath+'/admin/member/register_check/page/'+(this.page-1),
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
            examine: function(id) {
                location.href=ctxPath+"/admin/member/details?id="+id+"&examine=true"
            },
            handleSelectionChange: function(val) {
                this.multipleSelection = val;
            }
        },
        mounted: function() {
            this.getData();
        }
    });

});
