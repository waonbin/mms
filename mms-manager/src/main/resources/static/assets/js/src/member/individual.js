$(function() {
    new Vue({
        el:'#box-content',
        data() {
            return {
                param: {
                    memberType: 1,
                    name: '',
                    reference: '',
                    level: '',
                    partisan: '',
                    // memberType: '',
                    education: '',
                    school: '',
                    memberNo: '',
                    admitDateStart: '',
                    admitDateEnd: '',
                    birthdayStart: '',
                    birthdayEnd: '',
                    province: ''
                },
                page:1,
                show:true,
                startTime: '',
                endTime:'',
                starBirstTime:'',
                endBirstTime:'',
                dictionaryList: [],
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
            changeTime(time) {
                if(!time) return '';

                var y = time.getFullYear(),
                    m = time.getMonth()+1,
                    d = time.getDate();

                if(m < 10) {
                    m = '0'+m
                }
                if(d < 10) {
                    d = '0'+d
                }
                return y+'-'+m+'-'+d
            },
            getData: function() {
                var param = this.param;

                param.admitDateStart = this.changeTime(this.startTime);
                param.admitDateEnd = this.changeTime(this.endTime);
                param.birthdayStart = this.changeTime(this.starBirstTime);
                param.birthdayEnd = this.changeTime(this.endBirstTime);

                $.ajax({
                    url: ctxPath+'/admin/member/query/'+(this.page-1),
                    data: param
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
            search: function() {
                this.page = 1;
                this.getData();
            }
        },
        mounted: function() {
            this.getData();
            this.getProvince();
            this.getDictionary();
        }
    });

});
