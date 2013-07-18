package br.inf.ufg.defproc

import grails.converters.JSON

/**
 * Created with IntelliJ IDEA.
 * User: Hirako
 * Date: 14/07/13
 * Time: 14:41
 * To change this template use File | Settings | File Templates.
 */
class LoginController {

    def index(){
        def usuarioLogado = getSession().getAttribute(Usuario.USUARIO_LOGADO)
        if(usuarioLogado){
            [usuario:usuarioLogado]
        } else{
            []
        }

    }

    def login(){
        Usuario usuario = new Usuario()
        if(params.password == "admin" && params.login == "admin"){
            usuario.nome = "Henrique Hirako"
            usuario.password = params.password
            usuario.login = params.login
            usuario.nivelPermissao = NivelPermissao.ADMIN
            getSession().setAttribute(Usuario.USUARIO_LOGADO,usuario)
            def resposta = [sucesso:true, mensagem:"Usuário logado com sucesso"]
            render resposta as JSON
        } else{
            def resposta = [sucesso: false, mensagem: "Login ou senha inválidos"]
            render resposta as JSON
        }
    }

    def logout(){
        getSession().setAttribute(Usuario.USUARIO_LOGADO,null)
        redirect(uri: "/")
    }
}
