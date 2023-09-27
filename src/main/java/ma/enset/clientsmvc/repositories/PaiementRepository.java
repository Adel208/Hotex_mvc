package ma.enset.clientsmvc.repositories;

import ma.enset.clientsmvc.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    // Vous pouvez ajouter des méthodes de requête personnalisées si nécessaire
}

