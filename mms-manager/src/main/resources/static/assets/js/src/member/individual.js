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
                dictionaryList: [],
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
                provinceGroup: [],
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
            },
            partisanList: function() {
                return this.dictionaryList.filter(function(item) {
                    return item.dictionaryId === 3
                })
            },
            memberList: function() {
                return this.dictionaryList.filter(function(item) {
                    return item.dictionaryId === 2
                })
            },
            educationList: function() {
                return this.dictionaryList.filter(function(item) {
                    return item.dictionaryId === 5
                })
            },
            levelList: function() {
                return this.dictionaryList.filter(function(item) {
                    return item.dictionaryId === 6
                })
            },
            referenceList: function() {
                return this.dictionaryList.filter(function(item) {
                    return item.dictionaryId === 7
                })
            }
        },
        methods: {
            getData: function() {
                $.ajax({
                    url: ctxPath+'/admin/member/page/'+(this.page-1),
                    data: {
                        memberType: 1
                    }
                }).done(function(data) {
                    this.tableData = data;
                }.bind(this)).fail(function() {
                    this.$message.error('获取数据失败,请检查网络');
                }.bind(this))
            },
            detail: function(id) {
              location.href=ctxPath+"/admin/member/details?id="+id
            },
            getProvince: function() {
                $.ajax({
                    url:ctxPath+'/admin/division/data'
                }).done(function(data) {
                    if(data.length) {
                        this.provinceGroup = data.filter(function(item) {
                            return item.parentId === 0
                        })
                    }
                }.bind(this))
            },
            getDictionary: function() {
                $.ajax({
                    url:ctxPath+'/admin/dictionary'
                }).done(function(data) {
                    this.dictionaryList = data;
                }.bind(this))
            },
            changePage: function(val) {
                this.page = val;
                this.getData()
            },
        },
        mounted: function() {
            this.getData();
            this.getProvince();
            this.getDictionary();
        }
    });

});
