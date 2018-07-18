$(function() {
    Vue.component('layout', {
        template: '#per_left',
        props:{
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

            }
        }
    });
});