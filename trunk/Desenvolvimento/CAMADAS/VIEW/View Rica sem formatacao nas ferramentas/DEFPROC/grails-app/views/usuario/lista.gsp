<div style="margin-left: 21px;">
    <select class="pessoas" style="margin-top:12px;">
        <g:each in="${lista}" var="usuario">
            <option>${usuario.nome}</option>
        </g:each>
    </select>
    <div class="btn-group">
        <div class="btn btnAdicionarPessoa">
            <i class="icon-plus"></i>
            Adicionar
        </div>
    </div>
</div>
<script type="text/javascript">
    $(".btnAdicionarPessoa").click(function(){
        var nome = $(".pessoas").val();
        var dataNome = nome.replace(' ','');

        if($("[data-nome="+dataNome+"]").size() > 0)
            return

        $(".listaItensParticipantes").append("<li data-nome='"+dataNome+"'>"+nome+"</li>");
    })
</script>