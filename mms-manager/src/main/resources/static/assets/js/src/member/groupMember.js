$(function() {
    new Vue({
        el:'#box-content',
        data() {
            return {
                show:true,
                jg:'',
                zc:'',
                partisan:'',
                province:'',
                memberType:'',
                education:'',
                jgGroup: [
                    {
                        value: '1',
                        label: 'CT理论及应用分会'
                    }, {
                        value: '2',
                        label: '材料科学分会'
                    }],
                zcGroup: [
                    {
                        value: '1',
                        label: '初级'
                    }, {
                        value: '2',
                        label: '中级'
                    }, {
                        value: '3',
                        label: '副高级'
                    }, {
                        value: '4',
                        label: '正高级'
                    }, {
                        value: '5',
                        label: '无'
                    }],
                tableData: [],
                fullscreenLoading: false
            }
        },
        methods: {
            getData: function() {
                $.ajax({
                    url: '/admin/member/register_check/data',
                }).done(function(data) {
                    this.tableData = data;
                }.bind(this)).fail(function() {
                    this.$message.error('获取数据失败,请检查网络');
                }.bind(this))
            }
        },
        mounted: function() {
            this.getData();
        }
    });

});