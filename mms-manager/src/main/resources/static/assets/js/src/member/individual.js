$(function() {
    new Vue({
        el:'#box-content',
        data() {
            return {
                page:1,
                show:true,
                startTime: '',
                endTime:'',
                jg:'',
                zc:'',
                starBirstTime:'',
                endBirstTime:'',
                partisan:'',
                province:'',
                memberType:'',
                education:'',
                jgGroup: [
                    {
                        value: '1',
                        label: 'CT理论及应用分会'
                    }, {
                        value: '2',
                        label: '材料科学分会'
                    }],
                zcGroup: [
                    {
                        value: '1',
                        label: '初级'
                    }, {
                        value: '2',
                        label: '中级'
                    }, {
                        value: '3',
                        label: '副高级'
                    }, {
                        value: '4',
                        label: '正高级'
                    }, {
                        value: '5',
                        label: '无'
                    }],
                memberTypeGroup: [
                    {
                        value: '',
                        label: '请选择会员类型'
                    },{
                        value: '1',
                        label: '普通会员'
                    }, {
                        value: '2',
                        label: '学生会员'
                    }, {
                        value: '3',
                        label: '团体会员'
                    }],
                educationGroup: [
                    {
                        value: '',
                        label: '请选择'
                    },{
                        value: '1',
                        label: '博士'
                    },{
                        value: '2',
                        label: '硕士'
                    },{
                        value: '3',
                        label: '本科'
                    },{
                        value: '4',
                        label: '专科'
                    },{
                        value: '5',
                        label: '其他'
                    }],
                partisanGroup: [
                    {
                        value: '',
                        label: '请选择'
                    }, {
                        value: '1',
                        label: '中共党员'
                    }, {
                        value: '2',
                        label: '群众'
                    }
                ],
                provinceGroup: [
                    {
                        value: '',
                        label: '请选择'
                    },{
                        value: '1',
                        label: '北京市'
                    },{
                        value: '2',
                        label: '天津市'
                    },{
                        value: '3',
                        label: '河北省'
                    },{
                        value: '4',
                        label: '山西省'
                    },{
                        value: '5',
                        label: '内蒙古自治区'
                    },{
                        value: '6',
                        label: '辽宁省'
                    },{
                        value: '7',
                        label: '吉林省'
                    },{
                        value: '8',
                        label: '黑龙江省'
                    },{
                        value: '9',
                        label: '上海市'
                    },{
                        value: '10',
                        label: '江苏省'
                    },{
                        value: '11',
                        label: '浙江省'
                    },{
                        value: '12',
                        label: '安徽省'
                    },{
                        value: '13',
                        label: '福建省'
                    },{
                        value: '14',
                        label: '江西省'
                    },{
                        value: '15',
                        label: '山东省'
                    },{
                        value: '16',
                        label: '河南省'
                    },{
                        value: '17',
                        label: '湖北省'
                    },{
                        value: '18',
                        label: '湖南省'
                    },{
                        value: '19',
                        label: '广东省'
                    },{
                        value: '20',
                        label: '广西壮族自治区'
                    },{
                        value: '21',
                        label: '海南省'
                    },{
                        value: '22',
                        label: '重庆市'
                    },{
                        value: '23',
                        label: '四川省'
                    },{
                        value: '24',
                        label: '贵州省'
                    },{
                        value: '25',
                        label: '云南省'
                    },{
                        value: '26',
                        label: '西藏自治区'
                    },{
                        value: '27',
                        label: '陕西省'
                    },{
                        value: '28',
                        label: '甘肃省'
                    },{
                        value: '29',
                        label: '青海省'
                    },{
                        value: '30',
                        label: '宁夏回族自治区'
                    },{
                        value: '31',
                        label: '新疆维吾尔自治区'
                    },{
                        value: '32',
                        label: '香港特别行政区'
                    },{
                        value: '33',
                        label: '澳门特别行政区'
                    },{
                        value: '34',
                        label: '台湾省'
                    }],
                tableData: [],
                fullscreenLoading: false
            }
        },
        computed: {
            scheduled_time_start_opts: function(){
                let endTime = this.endBirstTime;
                if(endTime){
                    endTime = new Date(endTime);
                }
                return {
                    disabledDate(date) {
                        return (endTime && endTime < date);
                    }
                };
            },
            scheduled_time_end_born: function(){
                let startTime = this.starBirstTime;
                if(startTime){
                    startTime = new Date(startTime);
                }
                return {
                    disabledDate(date) {
                        return (startTime && startTime > date);
                    }
                };
            },
            scheduled_time_end_opts: function(){
                let startTime = this.startTime;
                if(startTime){
                    startTime = new Date(startTime);
                }
                return {
                    disabledDate(date) {
                        return (startTime && startTime > date);
                    }
                };
            },
            scheduled_time_start_born: function(){
                let endTime = this.endTime;
                if(endTime){
                    endTime = new Date(endTime);
                }
                return {
                    disabledDate(date) {
                        return (endTime && endTime < date);
                    }
                };
            }
        },
        methods: {
            getData: function() {
                $.ajax({
                    url: '/admin/member/page/'+(this.page-1),
                    data: {
                        memberType: 1
                    }
                }).done(function(data) {
                    this.tableData = data;
                }.bind(this)).fail(function() {
                    this.$message.error('获取数据失败,请检查网络');
                }.bind(this))
            },
            changePage: function(val) {
                this.page = val;
                this.getData()
            }
        },
        mounted: function() {
            this.getData();
        }
    });

});
