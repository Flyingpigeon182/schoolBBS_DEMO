function send_string() {
    treestring = document.getElementById("instring").value;
    console.log("正在上传！" + treestring);

    $.ajax({
        data: {
            Treestring: treestring
        },
        dataType: "text",
        success: function (json) {
            console.log("上传成功！" + treestring);
            getstatus();
        },
        type: "post",
        url: "getstring"
    });
}