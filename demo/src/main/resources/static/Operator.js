let out = document.getElementById("output");
function add_string() {
    let treestring = document.getElementById("instring").value;
    console.log("正在上传！" + treestring);
    $.ajax({
        data: {
            string: treestring
        },
        dataType: "text",
        success: function (data) {
            console.log("上传成功！" + treestring);
            if(data=='true'){
                out.value = "成功上传字符串 " + treestring + " 至数据库中。"
            }
            else{
                out.value = "无法上传字符串 "+treestring+" ，检查该字符串是否满足建树要求。"
            }
        },
        type: "post",
        url: "operate/add"
    });
}
function get_map() {
    let id = document.getElementById("ID").value;
    console.log("正在上传！" + id);
    $.ajax({
        data: {
            ID: id
        },
        dataType: "text",
        success: function (data) {
            console.log("上传成功！" + data);
            if (data == 'error!!!') {
                out.value = "无法获得ID为 " + id + " 的字符串：该项不存在于数据库中。"
            } else {
                console.log("获得成功！建树字符串id号： " + id+" ,建树字符串："+data);
                out.value="获得成功！建树字符串id号： " + id+" ,建树字符串："+data;
                getQueryString();
            }
        },
        type: "post",
        url: "operate/get"
    });
}
function delete_string() {
    id = document.getElementById("ID").value;
    console.log("正在操作！" + id);
    $.ajax({
        data: {
            ID: id
        },
        dataType: "text",
        success: function (data) {
            console.log("操作成功！" + data);
            if (data == '0') {
                out.value = "无法获得ID为 " + id + " 的字符串：该项不存在于数据库中。"
            } else {
                out.value = "成功删除ID为 " + id + " 的字符串。"
            }
        },
        type: "post",
        url: "operate/delete"
    });
}
function get_all() {
    $.ajax({
        dataType: "text",
        success: function (data) {
            out.value = "已经获取所有建树字符串，请打开或刷新 该项目目录/operate/show 以查看"
        },
        type: "post",
        url: "operate/show"
    });
}