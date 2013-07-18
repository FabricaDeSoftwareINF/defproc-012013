<g:render template="/templates/abasProjeto" model="[aba:'minhasAtividades']">
    <div class="esquerda">
        <g:each in="${situacoes}" var="situacao">
            <input class="esquerda checkbox" data-situacao="${situacao}" type="checkbox" checked="true" >
            <label class="esquerda direita1" style="margin-left: 5px">${situacao.valor}</label>
        </g:each>
    </div>
    <div class="esquerda" style="width: 100%">
        <table width="100%" border="1">
            <tr style="background-color: #d3d3d3">
                <td>ID</td>
                <td>Situação</td>
                <td>Título</td>
                <td>Atribuido para</td>
            </tr>
            <g:each in="${atividades}" var="atividade" status="index">
                <tr class="${atividade.situacao}">
                    <td>${index+1}</td>
                    <td>${atividade.situacao.valor}</td>
                    <td>${atividade.nome}</td>
                    <td>${atividade.responsavel.nome}</td>
                </tr>

            </g:each>
        </table>
    </div>
</g:render>
<script type="text/javascript">
    $(".checkbox").change(function(){
        var situacao = $(this).attr("data-situacao");
        if($(this).is(":checked")){
            $("."+situacao).show();
        } else{
            $("."+situacao).hide();
        }
    })
</script>