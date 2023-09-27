package ma.enset.clientsmvc.web;

import ma.enset.clientsmvc.entities.Paiement;
import ma.enset.clientsmvc.service.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/paiements")
public class PaiementController {

    private final PaiementService paiementService;

    @Autowired
    public PaiementController(PaiementService paiementService) {
        this.paiementService = paiementService;
    }

    @PostMapping("/creer")
    public String creerPaiement(@RequestBody Paiement paiement) {
        paiementService.creerPaiement(paiement);
        return "redirect:/paiements";
    }

    @GetMapping("/liste")
    public String listePaiements(Model model) {
        List<Paiement> paiements = paiementService.getTousLesPaiements();
        model.addAttribute("paiements", paiements);
        return "liste_paiements";
    }


}
