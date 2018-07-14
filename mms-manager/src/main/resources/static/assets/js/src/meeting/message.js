$(function() {
    new Vue({
        el:'#box-content',
        data() {
            return {
                page:1,
                starTime: '',
                endTime:'',
                tableData: []
            }
        },
        computed: {
            scheduled_time_start_time: function(){
                let endTime = this.endTime;
                if(endTime){
                    endTime = new Date(endTime);
                }
                return {
                    disabledDate(date) {
                        return (endTime && endTime < date);
                    }
                };
            },
            scheduled_time_end_time: function(){
                let startTime = this.starTime;
                if(startTime){
                    startTime = new Date(startTime);
                }
                return {
                    disabledDate(date) {
                        return (startTime && startTime > date);
                    }
                };
            }
        },
        methods: {
            getData: function() {
                $.ajax({
                    url: './meeting/page/'+(this.page-1),
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
            del: function() {
                this.$alert('确定要删除此条信息？', '提示', {
                    confirmButtonText: '确定',
                    callback: action => {
                        this.$message({
                            type: 'info',
                            message: `action: ${ action }`
                        });
                    }
                });
            }
        },
        mounted: function() {
            this.getData();
        }
    });

});
