$.getJSONData = function(url){
    var json = undefined;
    $.ajax({
        url:url,
        type:'GET',
        async:false,
        contentType:'application/json',
        dataType:'json',
        data:{},
        success:function(result){
            json = result;
        },
        error:function(result){
            alert("<div>This request is error!</div>");
        }
    });
    return json;
}

$(function () {
    var url = "/xew/getAll"
    var userinfo=$.getJSONData(url)
    $.each(userinfo, function (i, val) {
        $("#inff").append("<tr><td>" + val.id + "</td><td>" + val.name + "</td><td>" + val.password + "</td><td>"+
            "<input type='button' value='delete' onclick='deleteUser("+val.id+")'></td><td>"+
            "<input type='button' value='update' onclick='updateUser("+val.id+")'></td></tr>")
    })
});

$("#sub").click(function () {
    $.ajax({
        url:"/xew/search",
        type:"get",
        data:{"id":$("#id").val()},
        success:function (data) {
            var info="";
            $.each(data,function (key, value) {
                info+=key+":"+value+" ";
            })
            alert(info);
        }
    })
})