<div id="listaProjetos">

</div>

<div class="topo1">
    <div class="btn-group esquerda">
        <a href="/projeto/novo" destino="conteudo-inferior" rel="async" class="btn btn-large btnNovoProjeto">
            <i class="icon-tag"></i>
            Cadastrar novo projeto
        </a>
    </div>

    <div href="/usuario/novo" destino="conteudo-inferior" rel="async" class="btn-group direita">
        <div class="btn btn-large">
            <i class="icon-user"></i>
            Cadastrar novo usuário
        </div>
    </div>
</div>

<hr width="100%" class="esquerda" style="border: dashed; height: 0; margin-top: 10px;"/>

<div id="conteudo-inferior" class="esquerda" style="border: 1px solid #000000">

</div>
<script type="text/javascript">
    carregueNaDiv("/projeto/lista",$("#listaProjetos"));
    $(".btn-large").click(function(){
        $(".btn-large").removeClass("btn-success");
        $(this).addClass("btn-success");
    })
</script>