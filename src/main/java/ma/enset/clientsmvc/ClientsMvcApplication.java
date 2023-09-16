package ma.enset.clientsmvc;

import ma.enset.clientsmvc.entities.Chambre;
import ma.enset.clientsmvc.entities.Utilisateur;
import ma.enset.clientsmvc.repositories.ChambreRepository;
import ma.enset.clientsmvc.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@SpringBootApplication
public class ClientsMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientsMvcApplication.class, args);
	}
}
@Component
class DatabaseLoader {
	private final ClientRepository clientRepository;
	private final ChambreRepository chambreRepository;

	public DatabaseLoader(ClientRepository clientRepository, ChambreRepository chambreRepository) {
		this.clientRepository = clientRepository;
		this.chambreRepository = chambreRepository;
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			clientRepository.save(new Utilisateur(null, "Mme.", "Dupont", "Alice", "101", "simple", LocalDate.now(), LocalDate.now(), 1, "123", "123 Rue Principale, Ville, Pays 12345", "(555) 555-5555", "alice.dupont@email.com", LocalDate.now(), "Actif", "1234567890123456", "Alice Dupont", "12/24", "456"));
			clientRepository.save(new Utilisateur(null, "M.", "Martin", "Jean", "102", "double", LocalDate.now(), LocalDate.now(), 2, "124", "124 Rue de la Libération, Ville, Pays 23456", "(555) 555-5556", "jean.martin@email.com", LocalDate.now(), "Inactif", "2345678901234567", "Jean Martin", "09/23", "789"));
			clientRepository.save(new Utilisateur(null, "Mme.", "Lefebvre", "Marie", "103", "simple", LocalDate.now(), LocalDate.now(), 1, "125", "125 Avenue des Fleurs, Ville, Pays 34567", "(555) 555-5557", "marie.lefebvre@email.com", LocalDate.now(), "Actif", "3456789012345678", "Marie Lefebvre", "03/26", "567"));
			clientRepository.save(new Utilisateur(null, "M.", "Robert", "Paul", "104", "suite", LocalDate.now(), LocalDate.now(), 4, "126", "126 Boulevard des Arts, Ville, Pays 45678", "(555) 555-5558", "paul.robert@email.com", LocalDate.now(), "Actif", "4567890123456789", "Paul Robert", "11/25", "789"));
			clientRepository.save(new Utilisateur(null, "Mme.", "Garcia", "Sophie", "105", "simple", LocalDate.now(), LocalDate.now(), 1, "127", "127 Rue du Soleil, Ville, Pays 56789", "(555) 555-5559", "sophie.garcia@email.com", LocalDate.now(), "Inactif", "5678901234567890", "Sophie Garcia", "02/28", "456"));
			clientRepository.save(new Utilisateur(null, "M.", "Dumont", "Luc", "106", "double", LocalDate.now(), LocalDate.now(), 2, "128", "128 Avenue de la Lune, Ville, Pays 67890", "(555) 555-5560", "luc.dumont@email.com", LocalDate.now(), "Actif", "6789012345678901", "Luc Dumont", "07/27", "567"));
			clientRepository.save(new Utilisateur(null, "Mme.", "Roux", "Isabelle", "107", "simple", LocalDate.now(), LocalDate.now(), 1, "129", "129 Rue de l'Étoile, Ville, Pays 78901", "(555) 555-5561", "isabelle.roux@email.com", LocalDate.now(), "Inactif", "7890123456789012", "Isabelle Roux", "05/22", "456"));
			clientRepository.save(new Utilisateur(null, "M.", "Lemoine", "Pierre", "108", "suite", LocalDate.now(), LocalDate.now(), 3, "130", "130 Boulevard de la Mer, Ville, Pays 89012", "(555) 555-5562", "pierre.lemoine@email.com", LocalDate.now(), "Actif", "8901234567890123", "Pierre Lemoine", "08/21", "789"));
			clientRepository.save(new Utilisateur(null, "Mme.", "Moreau", "Laura", "109", "simple", LocalDate.now(), LocalDate.now(), 1, "131", "131 Avenue des Montagnes, Ville, Pays 90123", "(555) 555-5563", "laura.moreau@email.com", LocalDate.now(), "Actif", "9012345678901234", "Laura Moreau", "04/30", "456"));
			clientRepository.save(new Utilisateur(null, "M.", "Girard", "Thomas", "110", "double", LocalDate.now(), LocalDate.now(), 2, "132", "132 Rue de la Rivière, Ville, Pays 01234", "(555) 555-5564", "thomas.girard@email.com", LocalDate.now(), "Inactif", "0123456789012345", "Thomas Girard", "10/29", "789"));
			clientRepository.save(new Utilisateur(null, "Mme.", "Dubois", "Sophie", "201", "simple", LocalDate.now(), LocalDate.now(), 1, "133", "133 Rue de la Plage, Ville, Pays 12345", "(555) 555-5565", "sophie.dubois@email.com", LocalDate.now(), "Actif", "1234567890123456", "Sophie Dubois", "12/24", "456"));
			clientRepository.save(new Utilisateur(null, "M.", "Lefort", "David", "202", "double", LocalDate.now(), LocalDate.now(), 2, "134", "134 Avenue des Arbres, Ville, Pays 23456", "(555) 555-5566", "david.lefort@email.com", LocalDate.now(), "Inactif", "2345678901234567", "David Lefort", "09/23", "789"));
			clientRepository.save(new Utilisateur(null, "Mme.", "Meyer", "Julie", "203", "simple", LocalDate.now(), LocalDate.now(), 1, "135", "135 Rue du Jardin, Ville, Pays 34567", "(555) 555-5567", "julie.meyer@email.com", LocalDate.now(), "Actif", "3456789012345678", "Julie Meyer", "03/26", "567"));
			clientRepository.save(new Utilisateur(null, "M.", "Thomas", "François", "204", "suite", LocalDate.now(), LocalDate.now(), 4, "136", "136 Boulevard des Collines, Ville, Pays 45678", "(555) 555-5568", "francois.thomas@email.com", LocalDate.now(), "Actif", "4567890123456789", "François Thomas", "11/25", "789"));
			clientRepository.save(new Utilisateur(null, "Mme.", "Durand", "Camille", "205", "simple", LocalDate.now(), LocalDate.now(), 1, "137", "137 Avenue des Étoiles, Ville, Pays 56789", "(555) 555-5569", "camille.durand@email.com", LocalDate.now(), "Inactif", "5678901234567890", "Camille Durand", "02/28", "456"));
			clientRepository.save(new Utilisateur(null, "M.", "Caron", "Éric", "206", "double", LocalDate.now(), LocalDate.now(), 2, "138", "138 Rue de la Montagne, Ville, Pays 67890", "(555) 555-5570", "eric.caron@email.com", LocalDate.now(), "Actif", "6789012345678901", "Éric Caron", "07/27", "567"));
			clientRepository.save(new Utilisateur(null, "Mme.", "Gauthier", "Marine", "207", "simple", LocalDate.now(), LocalDate.now(), 1, "139", "139 Avenue de la Mer, Ville, Pays 78901", "(555) 555-5571", "marine.gauthier@email.com", LocalDate.now(), "Inactif", "7890123456789012", "Marine Gauthier", "05/22", "456"));
			clientRepository.save(new Utilisateur(null, "M.", "Lemoine", "Philippe", "208", "suite", LocalDate.now(), LocalDate.now(), 3, "140", "140 Boulevard de la Forêt, Ville, Pays 89012", "(555) 555-5572", "philippe.lemoine@email.com", LocalDate.now(), "Actif", "8901234567890123", "Philippe Lemoine", "08/21", "789"));
			clientRepository.save(new Utilisateur(null, "Mme.", "Roy", "Émilie", "209", "simple", LocalDate.now(), LocalDate.now(), 1, "141", "141 Rue des Érables, Ville, Pays 90123", "(555) 555-5573", "emilie.roy@email.com", LocalDate.now(), "Actif", "9012345678901234", "Émilie Roy", "04/30", "456"));
			clientRepository.save(new Utilisateur(null, "M.", "Dufresne", "Alexandre", "210", "double", LocalDate.now(), LocalDate.now(), 2, "142", "142 Rue de la Plaine, Ville, Pays 01234", "(555) 555-5574", "alexandre.dufresne@email.com", LocalDate.now(), "Inactif", "0123456789012345", "Alexandre Dufresne", "10/29", "789"));

			// Ajout autant de chambres que nécessaire
			chambreRepository.save(new Chambre(null, "101", 1, 2)); // Exemple de chambre
			chambreRepository.save(new Chambre(null, "102", 1, 3)); // Exemple de chambre
			chambreRepository.save(new Chambre(null, "103", 2, 2)); // Exemple de chambre


			//  pas oublier de sauvegarder les chambres
		};
	}
}

