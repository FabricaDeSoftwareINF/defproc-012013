$(".btnLogar").click(function(){
    $.ajax({
        url:"/login/login",
        data:{login:$("#login").val(), password:$("#password").val()},
        success:function(resposta){
            if(resposta.sucesso){
                window.location.reload()
            } else{
                $("#mensagem").text(resposta.mensagem)
            }
        }
    })
});

$(".btnLimpar").click(function(){
    $("input").val("");
});