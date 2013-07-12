package br.ufg.inf.fs.defproc.controller;

import br.ufg.inf.fs.defproc.domain.Atividade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Jonathan Silva Pereira
 */

@Controller
public class AtividadesController extends AbstractController {
    
    public AtividadesController(Atividade atividade) {
        super(atividade);        
    }
    
    @RequestMapping("/newActivity")
    public String newActivity() {
        return "index";
    }
    
}


