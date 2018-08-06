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
                    url: ctxPath+'/admin/meeting/enroll/page/'+(this.page-1),
                }).done(function(data) {
                    this.tableData = data;
                }.bind(this)).fail(function() {
                    this.$message.error('保存失败');
                }.bind(this))
            },
            changePage: function(val) {
                this.page = val;
                this.getData()
            },
            del() {
                this.$alert('确定要删除此条信息？', '提示', {
                    confirmButtonText: '确定',
                    callback: action => {
                        this.$message({
                            type: 'info',
                            message: `action: ${ action }`
                        });
                    }
                });
            },
            detail: function(id) {
                location.href=ctxPath+"/admin/baoming/details?id="+id
            }
        },
        mounted: function() {
            this.getData();
        }
    });

});
