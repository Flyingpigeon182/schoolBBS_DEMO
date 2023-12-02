let com = document.getElementById("newslist");
let total = document.getElementById("alltest");
let newslist;

function refresh_all_list(){
    total.value=newslist;
    com.innerHTML = null;
    var ID_list=JSON.parse(newslist)["newslist"].map(function(item) {
        return item.newsid;
    });
    for( let i = 0;i<ID_list.length;i++){
        com.options.add(new Option(ID_list[i],ID_list[i]));
    }
}

function show_selected(){
    let all_list=JSON.parse(newslist)["newslist"].map(function(item) {
        return item;
    });
    let ID_now=Number(document.getElementById("newslist").value);
    let news_now;
    for(var i=0;i<all_list.length;i++){
        if(all_list[i].newsid==ID_now){
            console.log(all_list[i]);
            news_now=all_list[i];
            document.getElementById("inid").value=ID_now;
            break;
        }
    }
    document.getElementById("instring").value=news_now.newsTitle;
    document.getElementById("intest").value=news_now.newsTest;
}