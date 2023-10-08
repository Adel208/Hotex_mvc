package ma.enset.clientsmvc.repositories;

import ma.enset.clientsmvc.entities.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
//    Page<Reservation> findByNomIgnoreCaseContains(String keyword, PageRequest of);
}