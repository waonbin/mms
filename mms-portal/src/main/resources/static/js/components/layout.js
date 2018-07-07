$(function() {
    Vue.component('layout', {
        template: '#per_left',
        props:{
            name:{
                type: String,
                default: '无'
            }
        },
        data: function () {
            return {

            }
        }
    });
});