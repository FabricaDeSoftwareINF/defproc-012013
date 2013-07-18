$(document).on("click","[rel=async]",function(e){
    e.preventDefault();
    e.stopPropagation();
    var destino = $(this).attr("destino") == undefined ? "conteudo" : $(this).attr("destino");
    carregueNaDiv($(this).attr("href"), $("#"+destino));
});

function carregueNaDiv(url, $div,callback){
    $.ajax({
        url:url,
        success:function(resposta){
            $div.html(resposta);
        }
    })
//    $div.load(url, function(){
//        if(callback) callback();
//    });
}