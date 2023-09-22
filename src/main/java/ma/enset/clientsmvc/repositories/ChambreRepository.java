package ma.enset.clientsmvc.repositories;

import ma.enset.clientsmvc.entities.Chambre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    //Page<Chambre> findByNomIgnoreCaseContains(String kw, Pageable pageable);
    //List<Chambre> findByEtage(int etage);

    List<Chambre> findByStatut(Chambre.Statut statut);

}