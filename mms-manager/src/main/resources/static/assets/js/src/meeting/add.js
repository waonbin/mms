$(function() {
    new Vue({
        el:'#box-content',
        data() {
            return {
                qull:null,
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
            }
        },
        mounted: function() {
            var toolbarOptions = [
                ['bold', 'italic', 'underline', 'strike'],        // toggled buttons
                ['blockquote', 'code-block'],

                [{ 'header': 1 }, { 'header': 2 }],               // custom button values
                [{ 'list': 'ordered'}, { 'list': 'bullet' }],
                [{ 'script': 'sub'}, { 'script': 'super' }],      // superscript/subscript
                [{ 'indent': '-1'}, { 'indent': '+1' }],          // outdent/indent
                [{ 'direction': 'rtl' }],                         // text direction

                [{ 'size': ['small', false, 'large', 'huge'] }],  // custom dropdown
                [{ 'header': [1, 2, 3, 4, 5, 6, false] }],

                [{ 'color': [] }, { 'background': [] }],          // dropdown with defaults from theme
                [{ 'font': [] }],
                [{ 'align': [] }],

                ['clean'],
                ['image', 'code-block']
            ];

            this.quill = new Quill('#editor', {
                modules: {
                    toolbar: toolbarOptions
                },
                theme: 'snow'
            });
        }
    });

});
