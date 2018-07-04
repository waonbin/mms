//在这里显示整体加载会员登录信息数据数据
$(document).ready(function () {
     
    $(".cont_t img").LoadImage({
        scaling: true,
        width: 800,
        height: 500,
        loadpic: "/static/images/loading.gif"
    });
});
function searchnews() {
    var searchkey = $('#txt_searchkey').val();
    alert("正在搜索" + searchkey + ",此功能正在开发中");
}
 