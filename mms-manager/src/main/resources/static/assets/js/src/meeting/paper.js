$(function() {
    new Vue({
        el:'#box-content',
        data() {
            return {
                state:'',
                tableData:[],
                multipleSelection: []
            }
        },
        methods: {
            handleSelectionChange(val) {
                this.multipleSelection = val;
            }
        },
        mounted: function() {

        }
    });

});
