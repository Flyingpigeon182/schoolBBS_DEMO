const canvas = document.getElementById("myCanvas");
var ctx = canvas.getContext("2d");
ctx.fillStyle='#000000';
var body;
function getQueryString() {
    $.ajax({
        url: "getset",
        type: "GET",
        dataType: "text",
        success:
            function (data) {
                body=data;
                displayData(body)
                printtree();
            }
    });
}
function displayData(data){
    console.log(data);
}
function printtree(){
    ctx.fillStyle='#FFFFFF'
    ctx.fillRect(0, 0, canvas.width, canvas.height);
    body=JSON.parse(body);
    var nodelist=body.node;
    var linelist=body.line;
    for(var i=0;i<linelist.length;i++){
        ctx.moveTo(linelist[i].x1,linelist[i].y1);
        ctx.lineTo(linelist[i].x2,linelist[i].y2);
        ctx.stroke();
    }
    for(var k=0;k<nodelist.length;k++){
        ctx.fillStyle='#FFFFFF'
        ctx.beginPath();
        ctx.arc(nodelist[k].x,nodelist[k].y,50,0,2*Math.PI);
        ctx.fill();
        ctx.stroke();
        ctx.font="30px Arial";
        ctx.fillStyle='#000000';
        ctx.fillText(nodelist[k].i,nodelist[k].x-40,nodelist[k].y+10);
    }
}
function showerror(){
    ctx.fillStyle='#FFFFFF'
    ctx.fillRect(0, 0, canvas.width, canvas.height);
    ctx.font="30px Arial";
    ctx.fillStyle='#000000';
    ctx.fillText("cannot print tree with the string "+document.getElementById("instring").value,500,500);
}
