let out = document.getElementById("output");
let news_list;

function add_news(){
    let inputtitle = document.getElementById("instring").value;
    let inputtest = document.getElementById("intest").value;
    console.log("正在上传！");
    $.ajax({
        data: {
            title: inputtitle,
            test: inputtest
        },
        dataType: "text",
        success: function (data) {
            console.log("连接成功！");
            if(data=='true'){
                out.value = "成功上传新闻内容至数据库中。"
            }
            else{
                out.value = "无法上传新闻内容至数据库中。"
            }
        },
        type: "post",
        url: "operate/add"
    });
}

function delete_news(){
    let id = document.getElementById("inid").value;
    console.log("正在上传！");
    $.ajax({
        data: {
            ID:id
        },
        dataType: "text",
        success: function (data) {
            console.log("连接成功！"+data);
            if(data==1){
                out.value = "成功删除ID为"+id+" 的新闻内容！"
            }
            else{
                out.value = "无法删除ID为"+id+" 的新闻内容！"
            }
        },
        type: "post",
        url: "operate/delete"
    });
}

function chenge_news(){
    let id = document.getElementById("inid").value;
    let inputtitle = document.getElementById("instring").value;
    let inputtest = document.getElementById("intest").value;
    console.log("正在上传！");
    $.ajax({
        data: {
            id:id,
            title: inputtitle,
            test: inputtest
        },
        dataType: "text",
        success: function (data) {
            console.log("连接成功！");
            if(data=='true'){
                out.value = "成功修改id为"+id+"的新闻内容至数据库中。"
            }
            else{
                out.value = "无法修改id为"+id+"的新闻内容至数据库中。"
            }
        },
        type: "post",
        url: "operate/change"
    });
}

function get_all_news(){
    $.ajax({
        dataType: "text",
        success: function (news_list) {
            out.value = "已经获取所有新闻内容！"
            newslist=news_list;
            refresh_all_list();
        },
        type: "post",
        url: "operate/getall"
    });
}