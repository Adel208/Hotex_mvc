package ma.enset.clientsmvc.web;

import ma.enset.clientsmvc.entities.Utilisateur;
import ma.enset.clientsmvc.repositories.ClientRepository;
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
    private final ClientRepository clientRepository;

    // Constructeur du contrôleur, injecte le repository pour gérer les utilisateurs
    public ClientsController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Gestion de la requête GET sur "/index"
    @GetMapping("/index")
    public String clients(Model model,
                          @RequestParam(name = "page", defaultValue = "0") int page,
                          @RequestParam(name = "size", defaultValue = "5") int size,
                          @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        // Récupère une liste paginée d'utilisateurs en fonction du mot-clé et de la pagination
        Page<Utilisateur> pageClients = clientRepository.findByNomIgnoreCaseContains(keyword, PageRequest.of(page, size));

        // Ajoute les données à envoyer à la vue dans le modèle
        model.addAttribute("listClients", pageClients.getContent()); // Liste des utilisateurs affichés sur la page
        model.addAttribute("pages", new int[pageClients.getTotalPages()]); // Pagination
        model.addAttribute("currentPage", page); // Page actuelle
        model.addAttribute("keyword", keyword); // Mot-clé de recherche

        // Retourne le nom de la vue à afficher
        return "clients"; // La vue "clients.html" sera rendue avec les données
    }

    // Gestion de la requête GET sur "/delete"
    @GetMapping("/delete")
    public String delete(@RequestParam Long id,
                         @RequestParam String keyword,
                         @RequestParam int page) {
        // Supprime un utilisateur en fonction de son ID
        clientRepository.deleteById(id);

        // Redirige vers la page d'index avec la pagination et le mot-clé
        return "redirect:/index?page=" + page + "&keyword=" + keyword;
    }

    // Gestion de la requête GET sur "/"
    @GetMapping("/")
    public String home() {
        // Retourne la vue "home.html"
        return "home";
    }

    // Gestion de la requête GET sur "/clients" avec réponse JSON
    @GetMapping("/clients")
    @ResponseBody
    public List<Utilisateur> listClient() {
        // Récupère et renvoie la liste de tous les utilisateurs au format JSON
        return clientRepository.findAll();
    }

    // Gestion de la requête GET sur "/formClients"
    @GetMapping("/formClients")
    public String formClients(Model model) {
        // Ajoute un nouvel utilisateur au modèle pour le formulaire
        model.addAttribute("utilisateur", new Utilisateur());

        // Retourne la vue du formulaire "formClients.html"
        return "formClients";
    }

    // Gestion de la requête POST sur "/save"
    @PostMapping("/save")
    public String save(@Valid Utilisateur utilisateur,
                       BindingResult bindingResult) {
        // Valide les données du formulaire, si des erreurs sont présentes, retourne le formulaire
        if (bindingResult.hasErrors()) {
            return "formClients"; // Recharge le formulaire avec des messages d'erreur
        }

        // Sauvegarde l'utilisateur dans le repository et redirige vers la liste des utilisateurs
        clientRepository.save(utilisateur);
        return "redirect:/clients";
    }

    // Gestion de la requête GET sur "/editClient"
    @GetMapping("/editClient")
    public String editClient(Model model,
                             @RequestParam Long id,
                             @RequestParam String keyword,
                             @RequestParam int page) {
        // Recherche l'utilisateur par son ID
        Utilisateur utilisateur = clientRepository.findById(id).orElse(null);
        if (utilisateur == null) {
            throw new RuntimeException("Utilisateur introuvable");
        }

        // Ajoute l'utilisateur au modèle pour la modification
        model.addAttribute("utilisateur", utilisateur);

        // Retourne la vue d'édition "editClient.html"
        return "editClient";
    }
}
