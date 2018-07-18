$(function() {
    new Vue({
        el:'#box-content',
        data: {
            isExamine: false,
            examineState:'1',
            list:{}
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
                    url: ctxPath+'/admin/member/details/'+id
                }).done(function(data) {
                    this.list = data;
                }.bind(this)).fail(function() {
                    this.$message.error('获取数据失败,请检查网络');
                }.bind(this))
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
                $("#register_member").addClass("m-menu__item--active");
            } else {
                $("#person_member").addClass("m-menu__item--active");
            }
        }
    })
});