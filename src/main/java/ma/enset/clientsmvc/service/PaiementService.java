package ma.enset.clientsmvc.service;

import ma.enset.clientsmvc.entities.Paiement;
import ma.enset.clientsmvc.repositories.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementService {

    private final PaiementRepository paiementRepository;

    @Autowired
    public PaiementService(PaiementRepository paiementRepository) {
        this.paiementRepository = paiementRepository;
    }

    public void creerPaiement(Paiement paiement) {
        // enregistrer le paiement dans la base de données
        paiementRepository.save(paiement);
    }

    public List<Paiement> getTousLesPaiements() {
        return paiementRepository.findAll();
    }


}

