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

@Controller
public class ReservationController {

    private ReservationService reservationService;
    private ChambreRepository chambreRepository;
    private ClientRepository clientRepository;

    public ReservationController(ReservationService reservationService, ChambreRepository chambreService, ClientRepository clientRepository) {
        this.reservationService = reservationService;
        this.chambreRepository = chambreService;
        this.clientRepository = clientRepository;
    }

    @GetMapping("/admin/reservation")
    public String index(Model model) {
        List<Reservation> reservations = this.reservationService.getAll();
        model.addAttribute("reservations", reservations);
        return "/admin/reservation/index";
    }

    // Formulaire de reservation pour un client inscrit
    @GetMapping("/admin/reservation/add")
    public String add(Model model) {
        Reservation reservation = new Reservation();
        List<Chambre> chambres = chambreRepository.findByStatut(Chambre.Statut.LIBRE);
        List<Utilisateur> clients = clientRepository.findAll();
        model.addAttribute("reservation", reservation);
        model.addAttribute("clients", clients);
        model.addAttribute("chambres", chambres);
        return "/admin/reservation/create";
    }
    // Formulaire de reservation pour un client non inscrit
    @GetMapping("/admin/clientetreservation/add")
    public String addUserAndReservation(Model model) {
        Reservation reservation = new Reservation();
        Utilisateur utilisateur = new Utilisateur();
        UtilisateurEtReservationDTO dto=new UtilisateurEtReservationDTO(utilisateur,reservation);
        List<Chambre> chambres = chambreRepository.findByStatut(Chambre.Statut.LIBRE);
        List<Utilisateur> clients = clientRepository.findAll();
        model.addAttribute("dto",dto );
        model.addAttribute("clients", clients);
        model.addAttribute("chambres", chambres);
        return "/admin/reservation/addClientEtReservation";
    }

    /**
     * Traitement d'un formulaire de reservation pour un nouveau client
     * @param dto qui contient les informations du client et de la reservation
     * @param bindingResult la liste des erreurs du formulaire
     * @return une redirection vers ...
     */
    @PostMapping("/admin/clientetreservation")
    public String storeClientEtReservation(@ModelAttribute UtilisateurEtReservationDTO dto, BindingResult bindingResult){

        //TODO Verification des erreus de validationn
        //TODO Avant de sauvegarder le client verifier que il existe pas deja un client avec la même adresse mail
        //TODO  set le client de la reservation dto.reservation.setClient(dto.utilisateur)
        //TODO  Sauvegarder le client (en premier) avec clientRepository puis la reservation en utilisant reservationRepository
        System.out.println(dto);
        return "";
    }

    /**
     *  Traitement d'un formulaire de reservation pour un client deja enregistrer
     * @param reservation
     * @param bindingResult
     * @param model
     * @return
     */
    @PostMapping("/admin/reservation")
    public String store(@ModelAttribute("reservation") @Valid Reservation reservation, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Chambre> chambresLibres = chambreRepository.findByStatut(Chambre.Statut.LIBRE);
            List<Utilisateur> clients = clientRepository.findAll();
            model.addAttribute("chambresLibres", chambresLibres);
            model.addAttribute("clients", clients);
            return "/admin/reservation/create";
        }
        // TODO enregistrer la reservation via le service ou repository
//        Chambre chambre = chambreRepository.findById(utilisateur.getChambre().getId()).orElse(null);
//        if (chambre == null) {
//            throw new RuntimeException("Chambre introuvable");
//        }
//
//        reservation.setChambre(chambre);
//        clientRepository.save(utilisateur);
//        chambre.setStatut(Chambre.Statut.OCCUPEE);
//        chambreRepository.save(chambre);
//        // Charger à nouveau la liste des clients après avoir enregistré la réservation
//        Page<Utilisateur> pageClients = clientRepository.findByNomIgnoreCaseContains("", PageRequest.of(0, 5));
//        model.addAttribute("listClients", pageClients.getContent());

        return "redirect:/index";
    }
}
