$(function() {
    new Vue({
        el:'#box-content',
        data() {
            //穿梭框
            const generateData = _ => {
                const data = [];
                const cities = ['上海', '北京', '广州', '深圳', '南京', '西安', '成都'];
                cities.forEach((city, index) => {
                    data.push({
                        label: city,
                        key: index
                    });
                });
                return data;
            };

            const  modelData = _=> {
                const data = [];
                const cities = ['模版1', '模版2', '模版3', '模版4', '模版5'];
                cities.forEach((city, index) => {
                    data.push({
                        label: city,
                        key: index
                    });
                });
                return data;
            };

            return {
                qull:null,
                step: 0,
                dialogVisible:false,
                style:'',
                dialogImageUrl:'',
                imageUrl:'',
                base:{
                    name:'',
                    enrollmentLimit:'',
                    meetingType:'',
                    vipPrice:'',
                    price:'',
                    enrollStartDate:'',
                    enrollEndDate:'',
                    checkinDate:'',
                    address:'',
                    type:'1',
                    isSF:'1'
                },
                //穿梭框
                generateData: generateData(),
                generateValue: [],
                modelData: modelData(),
                modelValue: [],
                filterMethod(query, item) {
                    return item.label.indexOf(query) > -1;
                },
                //报名设置-状态
                settingState:'commond'
            }
        },
        computed: {
            scheduled_time_start_time: function(){
                let endTime = this.base.enrollEndDate;
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
                let startTime = this.base.enrollStartDate;
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
            stateSwitch(stateName) {
                this.settingState = stateName;
            },
            changeTime(time) {
                if(!time || time.length <= 0) {
                    return time
                }
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
            next() {
              this.step++
            },
            handleClick(tab, event) {
                console.log(tab, event);
            },
            handleExceed(files, fileList) {
                this.$message.warning('当前限制选择 1 个文件');
            },
            handlePictureCardPreview(file) {
                this.dialogImageUrl = file.url;
                this.dialogVisible = true;
            },
            save(meeting) {
                $.ajax({
                    url:ctxPath+'/admin/meeting/save',
                    type:'post',
                    data:meeting
                }).done(function() {
                    this.$message({
                        message: '保存成功！',
                        type: 'success'
                    });
                }.bind(this)).fail(function() {
                    this.$message.error('保存失败！');
                }.bind(this))
            },
            baseSubmit() {
                var meeting = this.base;
                meeting.enrollStartDate = this.changeTime(meeting.enrollStartDate);
                meeting.enrollEndDate = this.changeTime(meeting.enrollEndDate);
                meeting.checkinDate = this.changeTime(meeting.checkinDate);

                if(this.base.name.length == 0) {
                    this.$message.error('会议名称不能为空！');
                    return
                }
                this.save(meeting)
            }
        },
        mounted: function() {

        }
    });

});
