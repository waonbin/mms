$(function() {
    Vue.component('hyGroup',{
        template: '#hw',
        name:'jajja',
        props: {
            List:{
                type: Array,
                default: []
            }
        },
        data() {
            return {
                quill: {},
            }
        },
        methods: {
            init() {
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

                this.List.forEach(function(item,i) {
                    var id = '#editor'+i;

                    this.quill[i] = new Quill(id, {
                        modules: {
                            toolbar: toolbarOptions
                        },
                        theme: 'snow'
                    });
                }.bind(this));
            }
        }
    });
});