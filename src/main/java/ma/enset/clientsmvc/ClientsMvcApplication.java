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

import java.sql.Date;
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
			clientRepository.save(new Utilisateur(null, "Mme.", "Dupont", "Alice", "3", null, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), 3, "100", "12 Rue Seine, Lille, France 69000", "+33 6 81 45 56 45", "alice.dupont@email.com"));
			clientRepository.save(new Utilisateur(null, "Mr.", "Albert", "Camus", "2", null,Date.valueOf( LocalDate.now()), Date.valueOf(LocalDate.now()), 2, "101", "34 Rue de Lyon, Brest, France  34000", "+33 6 34 45 45 56 ", "lb.dupont@email.com"));
			clientRepository.save(new Utilisateur(null, "Mr.", "Daniel", "Benammou", "2", null,Date.valueOf( LocalDate.now()),Date.valueOf( LocalDate.now()), 2, "102", "34 Rue de Lyon, Strasbourg, France  67000", "+33 6 81 45 56 21", "alice.dupont@email.com"));

			chambreRepository.save(new Chambre(null, "100", 1, 2, 80.00, Chambre.Statut.LIBRE));
			chambreRepository.save(new Chambre(null, "101", 1, 3, 95.00, Chambre.Statut.LIBRE));
			chambreRepository.save(new Chambre(null, "102", 1, 3, 95.00, Chambre.Statut.LIBRE));
			chambreRepository.save(new Chambre(null, "103", 1, 3, 95.00, Chambre.Statut.LIBRE));
			chambreRepository.save(new Chambre(null, "104", 1, 3, 95.00, Chambre.Statut.LIBRE));
			chambreRepository.save(new Chambre(null, "105", 1, 3, 95.00, Chambre.Statut.LIBRE));
			chambreRepository.save(new Chambre(null, "200", 1, 3, 95.00, Chambre.Statut.LIBRE));
			chambreRepository.save(new Chambre(null, "201", 1, 3, 95.00, Chambre.Statut.LIBRE));
			chambreRepository.save(new Chambre(null, "202", 1, 3, 95.00, Chambre.Statut.LIBRE));
			chambreRepository.save(new Chambre(null, "203", 1, 3, 95.00, Chambre.Statut.LIBRE));
			chambreRepository.save(new Chambre(null, "204", 1, 3, 95.00, Chambre.Statut.LIBRE));
			chambreRepository.save(new Chambre(null, "205", 1, 3, 95.00, Chambre.Statut.LIBRE));
			chambreRepository.save(new Chambre(null, "300", 1, 3, 95.00, Chambre.Statut.LIBRE));
			chambreRepository.save(new Chambre(null, "301", 1, 3, 95.00, Chambre.Statut.LIBRE));
			chambreRepository.save(new Chambre(null, "302", 1, 3, 95.00, Chambre.Statut.LIBRE));
			chambreRepository.save(new Chambre(null, "303", 1, 3, 95.00, Chambre.Statut.LIBRE));
			chambreRepository.save(new Chambre(null, "304", 1, 3, 95.00, Chambre.Statut.LIBRE));
			chambreRepository.save(new Chambre(null, "305", 1, 3, 95.00, Chambre.Statut.LIBRE));
		};
	}
}

