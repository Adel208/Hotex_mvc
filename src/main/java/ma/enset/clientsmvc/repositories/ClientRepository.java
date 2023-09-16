package ma.enset.clientsmvc.repositories;

import ma.enset.clientsmvc.entities.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Utilisateur,Long> {
    Page<Utilisateur> findByNomIgnoreCaseContains(String kw, Pageable pageable);
    //methode qui permet de retorner une page qui contient un String keyword et omme la methode retourne une
    //page pas une liste il faut rajouter un parametre de type Pageable

}


