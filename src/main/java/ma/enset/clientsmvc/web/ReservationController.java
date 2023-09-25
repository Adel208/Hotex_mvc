package ma.enset.clientsmvc.web;

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
    public String index(Model model){
        List<Reservation> reservations = this.reservationService.getAll();
        model.addAttribute("reservations",reservations);
        return "/admin/reservation/index";
    }

    @GetMapping("/admin/reservation/add")
    public String add(Model model){
        Reservation reservation = new Reservation();
        List<Chambre> chambres = chambreRepository.findByStatut(Chambre.Statut.LIBRE);
        List<Utilisateur> clients = clientRepository.findAll();
        model.addAttribute("reservation",reservation);
        model.addAttribute("clients",clients);
        model.addAttribute("chambres",chambres);
        return "/admin/reservation/create";
    }

//    @PostMapping("/enregistrerReservation")
//    public String enregistrerReservation(@ModelAttribute("utilisateur") @Valid Utilisateur utilisateur, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            List<Chambre> chambresLibres = chambreRepository.findByStatut(Chambre.Statut.LIBRE);
//            model.addAttribute("chambresLibres", chambresLibres);
//            return "formClients";
//        }
//
//        Chambre chambre = chambreRepository.findById(utilisateur.getChambre().getId()).orElse(null);
//        if (chambre == null) {
//            throw new RuntimeException("Chambre introuvable");
//        }
//
//        utilisateur.setChambre(chambre);
//        clientRepository.save(utilisateur);
//        chambre.setStatut(Chambre.Statut.OCCUPEE);
//        chambreRepository.save(chambre);
//        // Charger à nouveau la liste des clients après avoir enregistré la réservation
//        Page<Utilisateur> pageClients = clientRepository.findByNomIgnoreCaseContains("", PageRequest.of(0, 5));
//        model.addAttribute("listClients", pageClients.getContent());
//
//        return "redirect:/index";
//    }
}
