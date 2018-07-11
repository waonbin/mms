$(function() {
    new Vue({
        el:"#membercard",
        data: {
            message: {
                id:'',
                name:'111'
            },
        },
        mounted: function() {
            $(".card-btn").addClass('cur');
            this.message = message || {name:'---'};
        }
    })
});