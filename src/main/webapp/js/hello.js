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

function updateUser(uid) {
}

function deleteUser(uid) {
    if(confirm("Delete this Info?")) {
        $.ajax({
            url: "/xew/delete" ,
            type: "get",
            data: {"id":uid},
            success: function (data) {
                if (data) {
                    alert("Delete Succ")
                    location.reload()
                } else {
                    alert("Error")
                    location.reload()
                }
            }
        })
    }
}

function searchUser(id){
    var url = "/xew/search?id="+id
    var data = $.getJSONData(url)
    var info = ""
    $.each(data, function (key, val) {
        info+= key+":"+val+"  ";
    });
    alert(info)
}

$("#sub").click(function () {
    var id = $("#id").val()
    if(id == "" || id == null){
        alert("please input id")
    }else {
        searchUser(id)
    }
});

