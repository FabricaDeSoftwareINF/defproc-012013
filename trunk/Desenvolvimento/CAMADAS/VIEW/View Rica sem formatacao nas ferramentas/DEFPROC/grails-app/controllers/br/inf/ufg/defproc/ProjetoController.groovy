package br.inf.ufg.defproc

/**
 * Created with IntelliJ IDEA.
 * User: Hirako
 * Date: 14/07/13
 * Time: 15:59
 * To change this template use File | Settings | File Templates.
 */
class ProjetoController {

    def lista(){
        def listaProjetos = []
        (1 ..5).each {
            Projeto projeto = new Projeto()
            projeto.nome = "${it} Projeto"
            projeto.descricao = "Projeto de número: ${it}"
            projeto.id = it
            listaProjetos.add projeto
        }
        [lista:listaProjetos]
    }

    def novo(){

    }

    def visao(){
        Projeto projeto = new Projeto(descricao: "Mussum ipsum cacilds, vidis litro abertis. Consetis adipiscings elitis. " +
                "Pra lá , depois divoltis porris, paradis. Paisis, filhis, espiritis santis. Mé faiz elementum girarzis, " +
                "nisi eros vermeio, in elementis mé pra quem é amistosis quis leo. Manduma pindureta quium dia nois paga. " +
                "Sapien in monti palavris qui num significa nadis i pareci latim. Interessantiss quisso pudia ce receita de " +
                "bolis, mais bolis eu num gostis.",
        nome: "Projeto ${params.id}")
        [projeto:projeto]
    }

    def atividades(){
        def atividades = []
        Situacao.values().eachWithIndex {situacao, index ->
            atividades.add(new Atividade(
                    situacao: situacao,
                    projeto: new Projeto(
                            nome: "Projeto ${params.id}"
                    ),
                    nome: "Atividade ${index + 1}",
                    id:index,
                    responsavel: new Usuario(nome:"Usuario ${index + 1}")

            ))
        }
        [atividades:atividades, situacoes:Situacao.values()]
    }

    def minhasAtividades(){
        def atividades = []
        atividades.add(new Atividade(
                situacao: Situacao.ABERTA,
                projeto: new Projeto(
                        nome: "Projeto ${params.id}"
                ),
                nome: "Atividade 1",
                id:1,
                responsavel: new Usuario(nome:"Usuario 1")

        ))
        [atividades:atividades, situacoes:Situacao.values()]
    }

    def participantes(){
        [:]
    }
}
