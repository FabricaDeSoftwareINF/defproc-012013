package br.inf.ufg.defproc

/**
 * Created with IntelliJ IDEA.
 * User: Hirako
 * Date: 14/07/13
 * Time: 14:00
 * To change this template use File | Settings | File Templates.
 */
class UsuarioController {

    def index(){
        Usuario usuario = new Usuario(nome:"Henrique", nivelPermissao: NivelPermissao.ADMIN)
    }

    def lista(){
        def listaUsuarios = []
        (1 ..10).each {
            listaUsuarios.add(new Usuario(nome: "${params.tipo.capitalize()} ${it}"))
        }
        [lista:listaUsuarios]
    }

    def novo(){

    }
}
