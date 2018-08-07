$(function() {
    Vue.component('parallelSessions',{
        template: '#bmfy',
        props: {},
        data() {
            return {
                tableData: [],
                dialogFormVisible: false,
                dictionaryList: [],
                form: {
                    memberType: '',
                    endTime: '',
                    starTime: '',
                    money: ''
                }
            }
        },
        computed: {
            start_time: function(){
                let endTime = this.form.endTime;
                if(endTime){
                    endTime = new Date(endTime);
                }
                return {
                    disabledDate(date) {
                        return (endTime && endTime < date);
                    }
                };
            },
            end_time: function(){
                let startTime = this.form.starTime;
                if(startTime){
                    startTime = new Date(startTime);
                }
                return {
                    disabledDate(date) {
                        return (startTime && startTime > date);
                    }
                };
            },
            memberList: function() {
                return this.dictionaryList.filter(function(item) {
                    return item.dictionaryId === 2
                })
            }
        },
        methods: {
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
            getList() {
                var success = function(data) {
                    this.tableData = data;
                };

                this.connect('/admin/dictionary',null,success,'get')
            },
            del(id) {
                var params = {
                    id: id
                };

                var success = function() {
                    this.getList();

                    this.$message({
                        message: '保存成功！',
                        type: 'success'
                    });
                };

                this.connect('/admin/meeting/dues/delete',params,success,'post')
            },
            getDictionary: function() {
                var _this = this;

                var success =function(data) {
                        _this.dictionaryList = data;
                    };

                this.connect('/admin/dictionary',null,success,'get')
            },
            info() {
                this.getDictionary();
                this.$refs['ruleForm'].resetFields();
            },
            save() {
                var params = {
                    memberType: this.form.memberType,
                    startDate: this.changeTime(this.form.starTime),
                    endDate: this.changeTime(this.form.endTime),
                    dues: this.form.money
                };

                var success = function() {
                    this.$message({
                        message: '保存成功！',
                        type: 'success'
                    });
                    this.dialogFormVisible = false;
                };

                this.connect('/admin/meeting/dues/save',params,success,'post');
            },
            connect(url = '', params={}, success =() => {}, type = 'get') {
              return $.ajax({
                          url: ctxPath+url,
                          type: type,
                          data: params
                      }).done(function(data) {
                          success(data)
                      }).fail(function() {
                          this.$message.error('操作失败！');
                      }.bind(this))

            },
            check() {
                var _this = this;

                this.$refs['ruleForm'].validate((valid) => {
                    if (valid) {
                        _this.save();
                    } else {
                        return false;
                    }
                });
            }
        }
    });
});