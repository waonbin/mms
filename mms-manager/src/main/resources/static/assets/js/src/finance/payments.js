$(function() {
    new Vue({
        el:'#box-content',
        data() {
            return {
                page:1,
                invoiceType:'',
                starTime: '',
                endTime:'',
                isKP:'',
                tableData: [],
                invoiceTypeList: [
                    {
                        value: '',
                        label: '全部'
                    }, {
                        value: '1',
                        label: '会费'
                    },{
                        value: '2',
                        label: '审稿费'
                    },{
                        value: '3',
                        label: '版面费'
                    },{
                        value: '4',
                        label: '技术咨询费'
                    }
                 ],
                multipleSelection: []
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
                    url: ctxPath+'/admin/payment/member_payments/page/'+(this.page-1)
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
                location.href=ctxPath+"/admin/payment/details?id="+id
            }
        },
        mounted: function() {
            this.getData();
        }
    });

});
