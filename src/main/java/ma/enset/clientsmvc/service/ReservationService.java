package ma.enset.clientsmvc.service;

import ma.enset.clientsmvc.entities.Reservation;
import ma.enset.clientsmvc.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAll() {
        return this.reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id){
        return  this.reservationRepository.findById(id).orElseThrow();
    }
}
