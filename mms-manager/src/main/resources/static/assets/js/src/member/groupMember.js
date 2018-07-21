$(function() {
    new Vue({
        el:'#box-content',
        data() {
            return {
                param: {
                    memberType: 3,
                    name: '',
                    memberNo: '',
                    reference: ''
                },
                page:1,
                show:true,
                tableData: [],
                dictionaryList: [],
                fullscreenLoading: false
            }
        },
        computed: {
            referenceList: function() {
                return this.dictionaryList.filter(function(item) {
                    return item.dictionaryId === 7
                })
            }
        },
        methods: {
            getData: function() {
                var param = this.param;

                $.ajax({
                    url: ctxPath+'/admin/member/query/'+(this.page-1),
                    data: param
                }).done(function(data) {
                    this.tableData = data;
                }.bind(this)).fail(function() {
                    this.$message.error('获取数据失败,请检查网络');
                }.bind(this))
            },
            detail: function(id) {
                location.href=ctxPath+"/admin/member/details?id="+id
            },
            getDictionary: function() {
                $.ajax({
                    url:ctxPath+'/admin/dictionary'
                }).done(function(data) {
                    this.dictionaryList = data;
                    this.getData();
                }.bind(this))
            },
            changePage: function(val) {
                this.page = val;
                this.getData()
            },
            search: function() {
                this.page = 1;
                this.getData();
            },
            //获取单挑数据-推荐机构
            getReference: function(val) {
                var obj = this.referenceList.filter(function(item) {
                    return item.value === val
                });

                if(!obj.length) return;
                return obj[0].name
            },
            //获取单挑数据-会员类型
            getMemberType: function(val) {
                var obj = this.memberList.filter(function(item) {
                    return item.value === val
                });

                if(!obj.length) return;
                return obj[0].name
            },
        },
        mounted: function() {
            this.getDictionary();
        }
    });

});
