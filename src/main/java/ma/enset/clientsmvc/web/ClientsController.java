package ma.enset.clientsmvc.web;

import ma.enset.clientsmvc.entities.Utilisateur;
import ma.enset.clientsmvc.entities.Chambre;
import ma.enset.clientsmvc.repositories.UtilisateurRepository;
import ma.enset.clientsmvc.repositories.ChambreRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ClientsController {
    private final UtilisateurRepository utilisateurRepository;
    private final ChambreRepository chambreRepository;

    public ClientsController(UtilisateurRepository utilisateurRepository, ChambreRepository chambreRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.chambreRepository = chambreRepository;
    }

    @GetMapping("/index")
    public String clients(Model model,
                          @RequestParam(name = "page", defaultValue = "0") int page,
                          @RequestParam(name = "size", defaultValue = "5") int size,
                          @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Utilisateur> pageClients = utilisateurRepository.findByNomIgnoreCaseContains(keyword, PageRequest.of(page, size));
        model.addAttribute("listClients", pageClients.getContent());
        model.addAttribute("pages", new int[pageClients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "clients";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id,
                         @RequestParam String keyword,
                         @RequestParam int page) {
        utilisateurRepository.deleteById(id);
        return "redirect:/index?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/clients")
    public String listClient(Model model) {
        List<Utilisateur> clients = utilisateurRepository.findAll();
        model.addAttribute("clients",clients);
        return "/admin/utilisateur/index" ;
    }

    @GetMapping("/formClients")
    public String enregistrerReservation(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        List<Chambre> chambresLibres = chambreRepository.findByStatut(Chambre.Statut.LIBRE);
        model.addAttribute("chambresLibres", chambresLibres);
        return "formClients";
    }

    @GetMapping("/editClient")
    public String editClient(Model model,
                             @RequestParam Long id,
                             @RequestParam String keyword,
                             @RequestParam int page) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElse(null);
        if (utilisateur == null) {
            throw new RuntimeException("Utilisateur introuvable");
        }
        model.addAttribute("utilisateur", utilisateur);
        model.addAttribute("keyword", keyword);
        model.addAttribute("currentPage", page);
        return "editClient";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute("utilisateur") @Valid Utilisateur utilisateur, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editClient";
        }
        utilisateurRepository.save(utilisateur);
        return "redirect:/index";
    }
}
