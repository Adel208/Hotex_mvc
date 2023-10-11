
package ma.enset.clientsmvc.repositories;

import ma.enset.clientsmvc.entities.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Page<Utilisateur> findByNomIgnoreCaseContains(String kw, Pageable pageable);
    Utilisateur findByeMail(String email);
}



