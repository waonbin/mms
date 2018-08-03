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
                step: 1,
                names: 'demo',
                dialogVisible:false,
                style:'',
                dialogImageUrl:'',
                imageUrl:'',
                //会务设置状态： 0-编辑，1-设置
                hwState: 1,
                etitors: [],
                base: {
                    name:'',
                    startDate:'',
                    endDate:'',
                    sponsor:'',
                    organizer:'',
                    address:'',
                    duesType:'1',
                    chargeInSystem:'1'
                },
                baseTip: ['会议名称','举办开始时间','举办结束时间','主办单位','承办单位','举办地点'],
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
                let endTime = this.base.endDate;
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
                let startTime = this.base.startDate;
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
            checkBase() {
                var keys = Object.keys(this.base);

                for (let i=0; i<keys.length; i++) {
                    if(!this.base[keys[i]]) {
                        this.$message.warning(this.baseTip[i]+'不能为空！');
                        break;
                    }

                    if (i === keys.length-1) {
                        this.baseSubmit()
                    }
                }
            },
            //会务状态调整为富文本
            hwStateEdit() {
              this.hwState = 0;
              this.generateValue.map(function(item) {
                  this.etitors.push(this.generateData.filter(function (n) {
                      return n.key === item
                  })[0])
              }.bind(this));

              setTimeout(function() {
                  console.log(this.$refs.editors.init())
              }.bind(this))
            },
            next() {
                if (this.step == 0) {
                    this.checkBase()
                } else if(this.step == 2){

                } else {
                    this.step++
                }
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
                    this.step = 1
                }.bind(this)).fail(function() {
                    this.$message.error('保存失败！');
                }.bind(this))
            },
            baseSubmit() {
                var meeting = this.base;
                meeting.startDate = this.changeTime(meeting.startDate);
                meeting.endDate = this.changeTime(meeting.endDate);

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
