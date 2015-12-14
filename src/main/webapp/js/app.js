var showItem  = function(s, data){
    var list = $("."+s+"-list");
    list.empty();
    var source = $("#"+s+"-item").html();
    var template = Handlebars.compile(source);
    Handlebars.registerHelper('tableId', function(page, index) {
        return (page-1) * 15 + index + 1;
    });
    list.html(template(data));
};
function get_pagination(which, indexPage, totalPage, url, clazzName){
    $("#"+which+"-pagination" + " .am-pagination-indexpage").text(indexPage);
    $("#"+which+"-pagination" + " .am-pagination-totalpage").text(totalPage);
    var pages = [];
    var olis = "";
    if(totalPage <= 5){
        for(var a = 0; a < totalPage; a++){
            pages[a] = a + 1;
        }
    }else if(indexPage <= 3){
        for(var b = 0; b < 5; b++){
            pages[b] = b + 1;
        }
    }else if(indexPage >= totalPage - 2){
        for(var c = 0; c < 5; c++){
            pages[c] = totalPage + c - 4;
        }
    }else{
        for(var d = 0; d < 5; d++){
            pages[d] = indexPage + d - 2;
        }
    }
    $.each(pages, function (i, a) {
        olis += ("<li data-id='" + a + "'><a>" + a + "</a></li>");
    });
    $("#"+which+"-pagination" + " .am-pagination").html("<li class='' data-id='1'><a>首页</a></li>" + olis +"<li data-id='" + totalPage + "'><a>尾页</a></li>");
    $("#"+which+"-pagination" + " .am-pagination li[data-id='" + indexPage + "']").addClass("am-active");
    $("#"+which+"-pagination" + " .am-pagination li").click(function(){
        $.ajax({
            type: "POST",
            url: url,
            dataType: "json",
            data: {
                "page": $(this).attr("data-id"),
                "clazzName": clazzName
            },
            success: function(d){
                showItem(which, d);
                get_pagination(which, d.page, d.maxPage, url, showItem);
            }
        });
    });
}