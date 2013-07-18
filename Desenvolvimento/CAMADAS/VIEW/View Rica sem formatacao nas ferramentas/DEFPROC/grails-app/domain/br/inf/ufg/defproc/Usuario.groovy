package br.inf.ufg.defproc

/**
 * Created with IntelliJ IDEA.
 * User: Hirako
 * Date: 14/07/13
 * Time: 13:43
 * To change this template use File | Settings | File Templates.
 */
class Usuario {
    String nome
    String login
    String password
    NivelPermissao nivelPermissao

    public static final String USUARIO_LOGADO = "usuarioLogado"

    static constraints = {
        nome(blank: false)
        login(blank: false)
        password(blank: false, minSize: 6)
    }
}
