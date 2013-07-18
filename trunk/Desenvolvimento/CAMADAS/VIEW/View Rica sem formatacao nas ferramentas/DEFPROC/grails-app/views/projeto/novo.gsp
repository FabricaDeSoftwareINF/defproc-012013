<div class="centralizado resolucao">
    <h4 class="bg-cinza" style="margin:0; padding: 10px 0;border-bottom: 1px solid #000000">Cadastrar novo projeto</h4>
    <div class="bg-branco topo1">
        <div class="esquerda bottom1" style="width: 300px; margin-left: 21px; border-right: 1px dashed #000000">
            <label>Nome</label>
            <input type="text">
            <label>Descrição</label>
            <textarea rows="5" style="resize: none"></textarea>
            <br>
            <div class="btn-group">
                <div class="btn">
                    <i class="icon-ok"></i>
                    Cadastrar Projeto
                </div>
            </div>
        </div>
        <div class="esquerda" style="width: 644px; padding-left: 21px;">
            <label>Participantes</label>
            <div style="border: 1px solid #d3d3d3; height: 225px; width: 621px; margin-bottom: 21px;">
                <ul class="nav nav-tabs abas-usuarios">
                    <li><a href="/usuario/lista?tipo=gerente" destino="incluir-participante" rel="async">Gerentes</a></li>
                    <li><a href="/usuario/lista?tipo=participante" destino="incluir-participante" rel="async">Participantes</a></li>
                    <li><a href="/usuario/lista?tipo=aprovadores" destino="incluir-participante" rel="async">Aprovadores</a></li>
                    <li><a href="/usuario/lista?tipo=observadores" destino="incluir-participante" rel="async">Observadores</a></li>
                </ul>
                <script type="text/javascript">
                    $(".abas-usuarios li").click(function(){
                        $(".abas-usuarios li").removeClass("active");
                        $(this).addClass("active");
                    })
                </script>
                <div id="incluir-participante">

                </div>
                <div style="width: 95%; border-top: 1px dashed #d3d3d3">
                    <ul class="listaItensParticipantes">

                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>