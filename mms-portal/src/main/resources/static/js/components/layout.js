$(function() {
    Vue.component('layout', {
        template: '#per_left',
        props: {
            name:{
                type: String,
                default: '无'
            },
            message:{
                type: Object,
                default: {
                    name: '--',
                    memberType: 1
                }
            }
        },
        data: function () {
            return {
                dictionaryList:[]
            }
        },
        filters: {
            memberFilter: function(val) {
                console.log(val)
            }
        },
        computed: {
            memberList: function() {
                return this.dictionaryList.filter(function(item) {
                    return item.dictionaryId === 2
                })
            },
            memberType: function() {
                var memberObj =  this.memberList.filter(function(item) {
                   return item.value == this.message.memberType
                });

                if(memberObj.length) {
                    return memberObj[0].name
                }
            }
        },
        methods: {
            getDictionary: function() {
                $.ajax({
                    url:ctxPath+'/dictionary'
                }).done(function(data) {
                    this.dictionaryList = data;
                }.bind(this))
            }
        },
        mounted() {
            this.getDictionary();
        }
    });
});