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
    @RequestMapping(method = RequestMethod.GET)
    public String listerChambres(Model model) {
        List<Chambre> chambres = chambreRepository.findAll();
        model.addAttribute("chambres", chambres);
        return "chambre";
    }
    @PostMapping("/ajouterChambre")
    public String ajouterChambre(Chambre chambre) {
        chambreRepository.save(chambre);
        return "redirect:/chambre"; // Modifiez la redirection ici
    }
}
