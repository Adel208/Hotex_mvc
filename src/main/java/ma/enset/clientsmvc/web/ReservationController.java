package ma.enset.clientsmvc.web;

import ma.enset.clientsmvc.dto.UtilisateurEtReservationDTO;
import ma.enset.clientsmvc.entities.Chambre;
import ma.enset.clientsmvc.entities.Reservation;
import ma.enset.clientsmvc.entities.Utilisateur;
import ma.enset.clientsmvc.repositories.ChambreRepository;
import ma.enset.clientsmvc.repositories.ClientRepository;
import ma.enset.clientsmvc.service.ChambreService;
import ma.enset.clientsmvc.service.ReservationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller // Indique que cette classe est un contrôleur Spring MVC
public class ReservationController {

    private ReservationService reservationService;
    private ChambreRepository chambreRepository;
    private ClientRepository clientRepository;

    // Constructeur du contrôleur avec injection de dépendances
    public ReservationController(ReservationService reservationService, ChambreRepository chambreService, ClientRepository clientRepository) {
        this.reservationService = reservationService;
        this.chambreRepository = chambreService;
        this.clientRepository = clientRepository;
    }

    // Affiche la liste des réservations dans l'interface d'administration
    @GetMapping("/admin/reservation") // Lorsqu'une requête GET est reçue sur /admin/reservation, cette méthode est appelée
    public String index(Model model) { // Le modèle est utilisé pour passer des données à la vue
        List<Reservation> reservations = this.reservationService.getAll(); // Récupère toutes les réservations
        model.addAttribute("reservations", reservations); // Ajoute la liste des réservations au modèle avec la clé "reservations"
        return "/admin/reservation/index"; // Retourne le nom de la vue à afficher
    }

    // Affiche le formulaire de réservation pour un client inscrit
    @GetMapping("/admin/reservation/add")
    public String add(Model model) {
        Reservation reservation = new Reservation(); // Crée une nouvelle réservation
        List<Chambre> chambres = chambreRepository.findByStatut(Chambre.Statut.LIBRE); // Récupère les chambres libres
        List<Utilisateur> clients = clientRepository.findAll(); // Récupère tous les clients
        model.addAttribute("reservation", reservation); // Ajoute la réservation au modèle avec la clé "reservation"
        model.addAttribute("clients", clients); // Ajoute la liste des clients au modèle avec la clé "clients"
        model.addAttribute("chambres", chambres); // Ajoute la liste des chambres au modèle avec la clé "chambres"
        return "/admin/reservation/create"; // Retourne le nom de la vue à afficher
    }

    // Affiche le formulaire de réservation pour un client non inscrit
    @GetMapping("/admin/clientetreservation/add")
    public String addUserAndReservation(Model model) {
        Reservation reservation = new Reservation(); // Crée une nouvelle réservation
        Utilisateur utilisateur = new Utilisateur(); // Crée un nouvel utilisateur
        UtilisateurEtReservationDTO dto = new UtilisateurEtReservationDTO(utilisateur, reservation); // Crée un DTO avec l'utilisateur et la réservation
        List<Chambre> chambres = chambreRepository.findByStatut(Chambre.Statut.LIBRE); // Récupère les chambres libres
        List<Utilisateur> clients = clientRepository.findAll(); // Récupère tous les clients
        model.addAttribute("dto", dto); // Ajoute le DTO au modèle avec la clé "dto"
        model.addAttribute("clients", clients); // Ajoute la liste des clients au modèle avec la clé "clients"
        model.addAttribute("chambres", chambres); // Ajoute la liste des chambres au modèle avec la clé "chambres"
        return "/admin/reservation/addClientEtReservation";
    }

    // Traite le formulaire de réservation pour un nouveau client (enregistrement d'un client non inscrit)
    @PostMapping("/admin/clientetreservation") // Lorsqu'une requête POST est reçue sur /admin/clientetreservation, cette méthode est appelée
    public String storeClientEtReservation(@ModelAttribute UtilisateurEtReservationDTO dto, BindingResult bindingResult) {
        // TODO: Effectue la validation des erreurs
        // TODO: Avant d'enregistrer le client, vérifie s'il n'existe pas déjà un client avec la même adresse e-mail

        // TODO: Enregistre d'abord le client avec clientRepository
        // TODO: Définit le client de la réservation (dto.reservation.setClient(dto.utilisateur))
        //TODO : Enregistre la reservation

        System.out.println(dto); // Affiche les informations du DTO dans la console
        return ""; // Redirection vers une page spécifique après le traitement du formulaire
    }

    // Traite le formulaire de réservation pour un client déjà enregistré
    @PostMapping("/admin/reservation") // Lorsqu'une requête POST est reçue sur /admin/reservation, cette méthode est appelée
    public String store(@ModelAttribute("reservation") @Valid Reservation reservation, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) { // Si des erreurs de validation sont présentes dans la réservation
            List<Chambre> chambresLibres = chambreRepository.findByStatut(Chambre.Statut.LIBRE); // Récupère les chambres libres
            List<Utilisateur> clients = clientRepository.findAll(); // Récupère tous les clients
            model.addAttribute("chambresLibres", chambresLibres); // Ajoute la liste des chambres libres au modèle avec la clé "chambresLibres"
            model.addAttribute("clients", clients); // Ajoute la liste des clients au modèle avec la clé "clients"
            return "/admin/reservation/create"; // Redirige vers le formulaire de création en cas d'erreurs de validation
        }
        reservationService.saveReservation(reservation);

        // TODO: Enregistre la réservation via le service ou le repository
        // Exemple de code pour enregistrer la réservation (à décommenter et personnaliser selon la logique métier)
        /*
        Chambre chambre = chambreRepository.findById(utilisateur.getChambre().getId()).orElse(null);
        if (chambre == null) {
            throw new RuntimeException("Chambre introuvable");
        }

        reservation.setChambre(chambre);
        clientRepository.save(utilisateur);
        chambre.setStatut(Chambre.Statut.OCCUPEE);
        chambreRepository.save(chambre);

        // Rechargez la liste des clients après avoir enregistré la réservation
        Page<Utilisateur> pageClients = clientRepository.findByNomIgnoreCaseContains("", PageRequest.of(0, 5));
        model.addAttribute("listClients", pageClients.getContent());
        */

        return "redirect:/index"; // Redirection vers une autre page après le traitement du formulaire
    }
}
