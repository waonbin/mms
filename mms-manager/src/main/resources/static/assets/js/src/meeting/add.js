$(function() {
    new Vue({
        el:'#box-content',
        data() {
            return {
                activeName: 'first',
                style:'',
                base:{
                    name:''
                }
            }
        },
        methods: {
            handleClick(tab, event) {
                console.log(tab, event);
            },
            baseSubmit() {
                var meeting = this.base;

                if(this.base.name.length == 0) {
                    this.$message.error('会议名称不能为空！');
                    return
                }
                this.save(meeting)
            },
            save(meeting) {
                $.ajax({
                    url:'/admin/meeting/save',
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
            }
        },
        mounted: function() {
            var editor = new Quill('#editor', {
                modules: { toolbar: '#toolbar' },
                theme: 'snow'
            });
        }
    });

});
