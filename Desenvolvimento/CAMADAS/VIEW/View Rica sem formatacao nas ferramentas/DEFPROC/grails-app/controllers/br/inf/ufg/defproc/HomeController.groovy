package br.inf.ufg.defproc

/**
 * Created with IntelliJ IDEA.
 * User: Hirako
 * Date: 14/07/13
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
class HomeController {
    def index(){
        def usuarioLogado = getSession().getAttribute(Usuario.USUARIO_LOGADO)

        [usuario:usuarioLogado]
    }
}