<ul class="nav nav-tabs abas-usuarios resolucao" style="border: 1px solid #d3d3d3; margin: 0;">
    <li class="${aba == 'visao' ? 'active' : ''}"><a href="/projeto/visao/${params.id}" rel="async">Visão Geral</a></li>
    <li class="${aba == 'atividades' ? 'active' : ''}"><a href="/projeto/atividades/${params.id}" rel="async">Atividades</a></li>
    <li class="${aba == 'minhasAtividades' ? 'active' : ''}"><a href="/projeto/minhasAtividades/${params.id}" rel="async">Minhas Atividades</a></li>
    <li class="${aba == 'participantes' ? 'active' : ''}"><a href="/projeto/participantes/${params.id}" rel="async">Participantes</a></li>
</ul>

<div class="resolucao" style="border: 1px solid #d3d3d3; position: relative; float: left; padding-bottom: 21px">
    <div class="esquerda1 direita1 topo1">
        ${body()}
    </div>
</div>