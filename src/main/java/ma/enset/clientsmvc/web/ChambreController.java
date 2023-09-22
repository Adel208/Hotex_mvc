package ma.enset.clientsmvc.web;

import lombok.AllArgsConstructor;
import ma.enset.clientsmvc.entities.Chambre;
import ma.enset.clientsmvc.entities.Utilisateur;
import ma.enset.clientsmvc.repositories.ChambreRepository;
import ma.enset.clientsmvc.service.ChambreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/chambre")
@AllArgsConstructor
public class ChambreController {
    private final ChambreRepository chambreRepository;
    private final ChambreService chambreService;

    @GetMapping
    public String listerChambres(Model model) {
       List<Chambre> chambresLibres = chambreRepository.findByStatut(Chambre.Statut.LIBRE);
        List<Chambre> lesChambres = this.chambreService.getAll();
        System.out.println("Nombre de chambres libres : " + chambresLibres.size()); // Vérif taille liste
        model.addAttribute("lesChambres", lesChambres);
        model.addAttribute("chambre",new Chambre());
        model.addAttribute("utilisateur", new Utilisateur());
        return "/chambre";
    }

    @PostMapping("/ajouterChambre")
    public String ajouterChambre(@ModelAttribute Chambre chambre) {
        chambreRepository.save(chambre);
        return "redirect:/chambre";
    }

    @GetMapping("/liste-des-chambres")
    public String listeDesChambres(Model model) {
        List<Chambre> chambres = chambreRepository.findAll();
        model.addAttribute("listChambres", chambres);
        return "/chambre"; // Rediriger vers la liste des chambres
    }

    //  méthodes pour marquer les chambres occupée ou libre
    @PostMapping("/{chambreId}/occupee")
    public String marquerChambreOccupee(@PathVariable Long chambreId) {
        chambreService.marquerChambreOccupee(chambreId);
        return "redirect:/chambre";
    }

    @PostMapping("/{chambreId}/libre")
    public String marquerChambreLibre(@PathVariable Long chambreId) {
        chambreService.marquerChambreLibre(chambreId);
        return "redirect:/chambre";
    }
}
