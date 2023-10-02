package ma.enset.clientsmvc.service;

import ma.enset.clientsmvc.dto.UtilisateurEtReservationDTO;
import ma.enset.clientsmvc.entities.Chambre;
import ma.enset.clientsmvc.entities.Reservation;
import ma.enset.clientsmvc.repositories.ChambreRepository;
import ma.enset.clientsmvc.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;
    private ChambreRepository chambreRepository;

    public ReservationService(ReservationRepository reservationRepository, ChambreRepository chambreRepository) {
        this.reservationRepository = reservationRepository;
        this.chambreRepository = chambreRepository;
    }

    public void saveUserAndReservation(UtilisateurEtReservationDTO dto){
        //Sauvegarder le utilisateur

        // dto.getReservation().setUtilisateur()
        this.saveReservation(dto.getReservation());
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
