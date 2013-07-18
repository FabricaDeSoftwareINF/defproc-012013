<g:if test="${usuario}">
    <g:render template="/templates/template" model="[usuario:usuario]">

    </g:render>
</g:if>
<g:else>
    <g:render template="/templates/corpo">
        <div class="centralizado" style="width: 230px; margin-top: 50px;">
            <h5>Login</h5>
            <label id="mensagem" class="label label-important"></label>
            <input id="login" type="text" placeholder="Usuário">
            <input type="password" id="password" placeholder="Senha">
            <div class="btn-group">
                <div class="btn btnLogar">
                    <i class="icon-user"></i>
                    Logar
                </div>
                <div class="btn btnLimpar">
                    <i class="icon-trash"></i>
                    Limpar
                </div>
            </div>
        </div>
    </g:render>
    <script type="text/javascript" src="/js/index.js"></script>
</g:else>