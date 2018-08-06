$(function() {
    Vue.component('parallelSessions',{
        template: '#bmfy',
        props: {},
        data() {
            return {
                tableData: [],
                dialogFormVisible: true,
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
            getDictionary: function() {
                $.ajax({
                    url:ctxPath+'/admin/dictionary'
                }).done(function(data) {
                    this.dictionaryList = data;
                }.bind(this))
            },
            info() {
                this.getDictionary();
                this.$refs['ruleForm'].resetFields();
            },
            save() {
                var _this = this;

                this.$refs['ruleForm'].validate((valid) => {
                    if (valid) {
                        _this.dialogFormVisible = false;
                    } else {
                        return false;
                    }
                });
            }
        }
    });
});