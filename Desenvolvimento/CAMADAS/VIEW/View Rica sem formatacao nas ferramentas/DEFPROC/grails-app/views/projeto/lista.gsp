<div class="centralizado resolucao">
    <div style="border: 1px solid #000000;" class="bg-cinza">
        <h4>Projetos</h4>
        <table style="border-top: 1px solid #000000; width: 100%; background-color: white">
            <g:each in="${lista}" var="projeto">
                <tr>
                    <td>Aprovador</td>
                    <td><a href="/projeto/visao/${projeto.id}" rel="async">${projeto.nome}</a></td>
                    <td>${projeto.descricao}</td>
                    <td>Ativo</td>
                    <td><i class="icon-ok"></i></td>
                </tr>
            </g:each>
        </table>
    </div>
</div>