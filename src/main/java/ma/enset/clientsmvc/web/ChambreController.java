package ma.enset.clientsmvc.web;

import lombok.AllArgsConstructor;
import ma.enset.clientsmvc.entities.Chambre;
import ma.enset.clientsmvc.repositories.ChambreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/chambre")
@AllArgsConstructor
public class ChambreController {
    private final ChambreRepository chambreRepository;

    @GetMapping
    public String listerChambres(Model model) {
        List<Chambre> chambres = chambreRepository.findAll();
        model.addAttribute("chambres", chambres);
        model.addAttribute("chambre", new Chambre()); // Ajout d'un nouvel objet Chambre pour le formulaire
        return "chambre";
    }

    @PostMapping("/ajouterChambre")
    public String ajouterChambre(@ModelAttribute Chambre chambre) { // Utilisation de @ModelAttribute pour lier le formulaire à l'objet Chambre
        chambreRepository.save(chambre);
        return "redirect:/chambre";
    }

}
