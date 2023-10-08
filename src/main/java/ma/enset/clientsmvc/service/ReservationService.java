package ma.enset.clientsmvc.service;

import ma.enset.clientsmvc.dto.UtilisateurEtReservationDTO;
import ma.enset.clientsmvc.entities.Chambre;
import ma.enset.clientsmvc.entities.Reservation;
import ma.enset.clientsmvc.entities.Utilisateur;
import ma.enset.clientsmvc.repositories.ChambreRepository;
import ma.enset.clientsmvc.repositories.UtilisateurRepository;
import ma.enset.clientsmvc.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;


import ma.enset.clientsmvc.dto.UtilisateurEtReservationDTO;
import ma.enset.clientsmvc.entities.Chambre;
import ma.enset.clientsmvc.entities.Reservation;
import ma.enset.clientsmvc.entities.Utilisateur;
import ma.enset.clientsmvc.repositories.ChambreRepository;
import ma.enset.clientsmvc.repositories.UtilisateurRepository;
import ma.enset.clientsmvc.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;
    private ChambreRepository chambreRepository;
    private UtilisateurRepository utilisateurRepository; // Ajout de UtilisateurRepository

    public ReservationService(ReservationRepository reservationRepository,
                              ChambreRepository chambreRepository,
                              UtilisateurRepository utilisateurRepository) { // Injection de UtilisateurRepository via le constructeur
        this.reservationRepository = reservationRepository;
        this.chambreRepository = chambreRepository;
        this.utilisateurRepository = utilisateurRepository; // Initialisation de UtilisateurRepository
    }

    public void saveUserAndReservation(UtilisateurEtReservationDTO dto) {
        Utilisateur utilisateur = utilisateurRepository.save(dto.getUtilisateur());
        Reservation reservation = dto.getReservation();
        reservation.setClient(utilisateur);
        this.saveReservation(reservation);
    }


    public Reservation saveReservation(Reservation reservation){

        Reservation uneReservation=reservationRepository.save(reservation);

        List<Chambre> chambres = reservation.getChambres();
        for (Chambre uneChambre:chambres
        ) {
            uneChambre.setStatut(Chambre.Statut.OCCUPEE);
            uneChambre.getReservations().add(uneReservation);
            chambreRepository.save(uneChambre);
        }
        return reservation;
    }

    public List<Reservation> getAll() {
        return this.reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id){
        return  this.reservationRepository.findById(id).orElseThrow();
    }
}
