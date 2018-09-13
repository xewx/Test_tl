
$("#add").click(function () {
    var userdata={"name":$("#name").val(),"password":$("#password").val()}
    $.ajax({
        url : "/xew/save",
        type:"post",
        // contentType:'application/json',
        // data:JSON.stringify(userdata),
        data:userdata,
        success:function (data) {
            if(data){
                alert("Add Success")
                $(location).attr("href","succ.jsp")
            }else{
                alert("error")
            }
        }
    })
})