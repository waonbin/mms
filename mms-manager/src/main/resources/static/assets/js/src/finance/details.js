$(function() {
    new Vue({
        el:'#box-content',
        data: {
            isExamine: false,
            examineState:'1',
            PZUrl:'',
            list:{},
            dialogVisible: false
        },
        filters: {
            limitDate(val) {
                if(val) {
                    return val.substr(0,10)
                }
            }
        },
        methods: {
            getData: function() {
                var id = getQueryString('id');

                $.ajax({
                    url: ctxPath+'/admin/payment/details/'+id
                }).done(function(data) {
                    this.list = data;
                    this.getDisplay(data.offlineVoucher);
                }.bind(this)).fail(function() {
                    this.$message.error('获取数据失败,请检查网络');
                }.bind(this))
            },
            getDisplay: function(offlineVoucher) {
                var url = ctxPath+'/admin/file/display?id='+this.list.offlineVoucher;

                this.PZUrl = url;
                $.ajax({
                    url: ctxPath+'/admin/file/display',
                    data: {
                        id: offlineVoucher
                    }
                }).done(function(data) {

                })
            },
            returnList: function() {
                history.go(-1)
            }
        },
        mounted: function() {
            var isExamine = getQueryString('examine');
            this.getData();
            if(isExamine) {
                this.isExamine = true;
                $("#payment_finance").addClass("m-menu__item--active");
            } else {
                $("#member_finance").addClass("m-menu__item--active");
            }
        }
    })
});