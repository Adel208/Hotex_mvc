package ma.enset.clientsmvc.repositories;

import ma.enset.clientsmvc.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}