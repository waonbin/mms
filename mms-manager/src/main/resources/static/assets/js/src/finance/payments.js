$(function() {
    new Vue({
        el:'#box-content',
        data() {
            return {
                invoiceType:'',
                starTime: '',
                endTime:'',
                isKP:'',
                tableData3: [
                    {
                    date: '2016-05-03',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1518 弄'
                }, {
                    date: '2016-05-02',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1518 弄'
                }, {
                    date: '2016-05-04',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1518 弄'
                }, {
                    date: '2016-05-01',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1518 弄'
                }, {
                    date: '2016-05-08',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1518 弄'
                }, {
                    date: '2016-05-06',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1518 弄'
                }, {
                    date: '2016-05-07',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1518 弄'
                }],
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
