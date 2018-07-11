$(function() {
    new Vue({
        el:"#payment",
        data: {
            message: {
                id:'',
                name:'111'
            },
        },
        mounted: function() {
            $(".payment-btn").addClass('cur');
            this.message = message || {name:'---'};
        }
    })
});