$(function() {
    new Vue({
        el:'#box-content',
        data() {
            return {
                qull:null,
                hyList:[],
                activeName: 'first',
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
                    address:''
                }
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
