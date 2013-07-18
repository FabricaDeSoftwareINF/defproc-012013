<g:render template="/templates/corpo">
    <div class="centralizado resolucao">
        <div class="topo bg-cinza">
            <h6 class="esquerda" style="margin-left: 21px;">DEFPROC - Sistema de Gestão de Processos de Software</h6>
            <h6 class="direita" style="margin: 10px 21px"><a href="/login/logout">Sair</a></h6>
            <h6 class="direita">${usuario.nivelPermissao} - ${usuario.login}</h6>
        </div>
        <div class="menu bg-cinza">
            <ul>
                <li><a href="/home" rel="async">HOME</a></li>
                <li><a href="/projetos" rel="async">PROJETOS</a></li>
                <li><a href="/bancoAtividades" rel="async">BANCO DE ATIVIDADES</a> </li>
            </ul>
        </div>
        <div id="conteudo" style="margin-top: 21px;;">

        </div>
    </div>
</g:render>
