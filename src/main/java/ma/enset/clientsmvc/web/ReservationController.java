package ma.enset.clientsmvc.web;

import ma.enset.clientsmvc.dto.UtilisateurEtReservationDTO;
import ma.enset.clientsmvc.entities.Chambre;
import ma.enset.clientsmvc.entities.Reservation;
import ma.enset.clientsmvc.entities.Utilisateur;
import ma.enset.clientsmvc.repositories.ChambreRepository;
import ma.enset.clientsmvc.repositories.ReservationRepository;
import ma.enset.clientsmvc.repositories.UtilisateurRepository;
import ma.enset.clientsmvc.service.ReservationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ReservationController {

    private ReservationService reservationService;
    private ChambreRepository chambreRepository;
    private UtilisateurRepository utilisateurRepository;
    private final ReservationRepository reservationRepository;

    // Constructeur du contrôleur avec injection de dépendances
    public ReservationController(ReservationService reservationService, ChambreRepository chambreService, UtilisateurRepository utilisateurRepository,
                                 ReservationRepository reservationRepository) {
        this.reservationService = reservationService;
        this.chambreRepository = chambreService;
        this.utilisateurRepository = utilisateurRepository;
        this.reservationRepository = reservationRepository;
    }

   /* @GetMapping("/index")
    public String clients(Model model,
                          @RequestParam(name = "page", defaultValue = "0") int page,
                          @RequestParam(name = "size", defaultValue = "5") int size,
                          @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Reservation> pageClients = reservationRepository.findByNomIgnoreCaseContains(keyword, PageRequest.of(page, size));
        model.addAttribute("listClients", pageClients.getContent());
        model.addAttribute("pages", new int[pageClients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "clients";
    }*/

    // Affiche la liste des réservations dans l'interface d'administration
    @GetMapping("/admin/reservation")
    public String index(Model model) {
        List<Reservation> reservations = this.reservationService.getAll(); // Récupère toutes les réservations
        model.addAttribute("reservations", reservations);
        return "/admin/reservation/index";
    }

    // Affiche le formulaire de réservation pour un client inscrit
    @GetMapping("/admin/reservation/add")
    public String add(Model model) {
        Reservation reservation = new Reservation();
        List<Chambre> chambres = chambreRepository.findByStatut(Chambre.Statut.LIBRE); // Récupère les chambres libres
        List<Utilisateur> clients = utilisateurRepository.findAll(); // Récupère tous les clients
        model.addAttribute("reservation", reservation);
        model.addAttribute("clients", clients);
        model.addAttribute("chambres", chambres);
        return "/admin/reservation/create";
    }

    // Affiche le formulaire de réservation pour un client non inscrit
    @GetMapping("/admin/clientetreservation/add")
    public String addUserAndReservation(Model model) {
        Reservation reservation = new Reservation();
        Utilisateur utilisateur = new Utilisateur();
        UtilisateurEtReservationDTO dto = new UtilisateurEtReservationDTO(utilisateur, reservation);
        List<Chambre> chambres = chambreRepository.findByStatut(Chambre.Statut.LIBRE); // Récupère les chambres libres
        List<Utilisateur> clients = utilisateurRepository.findAll();
        model.addAttribute("dto", dto); // Ajoute le DTO au modèle avec la clé "dto"
        model.addAttribute("clients", clients);
        model.addAttribute("chambres", chambres);
        return "/admin/reservation/addClientEtReservation";
    }

    // Traite le formulaire de réservation pour un nouveau client (enregistrement d'un client non inscrit)
    /*@PostMapping("/admin/clientetreservation")
    public String storeClientEtReservation(@ModelAttribute UtilisateurEtReservationDTO dto, BindingResult bindingResult) {
        // TODO: Effectue la validation des erreurs
        // TODO: Avant d'enregistrer le client, vérifie s'il n'existe pas déjà un client avec la même adresse e-mail

        // TODO: Enregistre d'abord le client avec UtilisateurRepository
        // TODO: Définit le client de la réservation (dto.reservation.setClient(dto.utilisateur))
        //TODO : Enregistre la reservation

        System.out.println(dto);
        return "";
    }*/

    @PostMapping("/admin/clientetreservation")
    public String storeClientEtReservation(@ModelAttribute @Valid UtilisateurEtReservationDTO dto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/admin/reservation/addClientEtReservation";
        }

        Utilisateur existingUser = utilisateurRepository.findByEmail(dto.getUtilisateur().getAdresseMail());
        if (existingUser != null) {
            bindingResult.rejectValue("utilisateur.adresseMail", "error.user", "Cet email est déjà utilisé.");
            return "/admin/reservation/addClientEtReservation";
        }

        Utilisateur savedUser = utilisateurRepository.save(dto.getUtilisateur());
        Reservation reservation = dto.getReservation();
        reservation.setUtilisateur(savedUser); // Utilise la méthode setUtilisateur au lieu de setClient

        // Save  réservation avec le service  (avoir  méthode saveReservation dans le service)
        reservationService.saveReservation(reservation);
        return "redirect:/admin/reservation";
    }

    @PostMapping("/admin/reservation")
    public String store(@ModelAttribute("reservation") @Valid Reservation reservation, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Chambre> chambresLibres = chambreRepository.findByStatut(Chambre.Statut.LIBRE);
            List<Utilisateur> clients = utilisateurRepository.findAll();
            model.addAttribute("chambresLibres", chambresLibres);
            model.addAttribute("clients", clients);
            return "/admin/reservation/create";
        }

        Chambre chambre = chambreRepository.findById(reservation.getUtilisateur().getChambre().getId()).orElse(null);
        if (chambre == null) {
            throw new RuntimeException("Chambre introuvable");
        }
        chambre.setStatut(Chambre.Statut.OCCUPEE);
        chambreRepository.save(chambre);
        reservationService.saveReservation(reservation);
        Page<Utilisateur> pageClients = utilisateurRepository.findByNomIgnoreCaseContains("", PageRequest.of(0, 5));
        model.addAttribute("listClients", pageClients.getContent());
        return "redirect:/index";
    }


}
