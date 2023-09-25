package ma.enset.clientsmvc;

import ma.enset.clientsmvc.entities.Chambre;
import ma.enset.clientsmvc.entities.Reservation;
import ma.enset.clientsmvc.entities.Utilisateur;
import ma.enset.clientsmvc.repositories.ChambreRepository;
import ma.enset.clientsmvc.repositories.ClientRepository;
import ma.enset.clientsmvc.repositories.ReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

	private final ReservationRepository reservationRepository;

	public DatabaseLoader(ClientRepository clientRepository, ChambreRepository chambreRepository,ReservationRepository reservationRepository) {
		this.clientRepository = clientRepository;
		this.chambreRepository = chambreRepository;
		this.reservationRepository= reservationRepository;
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			Utilisateur client1= new Utilisateur(null, "Mme.", "Dupont", "Alice" , "12 Rue Seine, Lille, France 69000", "+33 6 81 45 56 45", "alice.dupont@email.com",new ArrayList<>());
			clientRepository.save(client1);
			clientRepository.save(new Utilisateur(null, "Mr.", "Albert", "Camus", "34 Rue de Lyon, Brest, France  34000", "+33 6 34 45 45 56 ", "lb.dupont@email.com",new ArrayList<>()));
			clientRepository.save(new Utilisateur(null, "Mr.", "Daniel", "Benammou", "34 Rue de Lyon, Strasbourg, France  67000", "+33 6 81 45 56 21", "alice.dupont@email.com",new ArrayList<>()));

			Chambre chambre101= new Chambre(null, "100", 1, 2, 80.00, Chambre.Statut.LIBRE,new ArrayList<>());
			chambreRepository.save(chambre101);
			chambreRepository.save(new Chambre(null, "102", 1, 3, 95.00, Chambre.Statut.LIBRE,new ArrayList<>()));
			chambreRepository.save(new Chambre(null, "101", 1, 3, 95.00, Chambre.Statut.LIBRE,new ArrayList<>()));
			chambreRepository.save(new Chambre(null, "103", 1, 3, 95.00, Chambre.Statut.LIBRE,new ArrayList<>()));
			chambreRepository.save(new Chambre(null, "104", 1, 3, 95.00, Chambre.Statut.LIBRE,new ArrayList<>()));
			chambreRepository.save(new Chambre(null, "105", 1, 3, 95.00, Chambre.Statut.LIBRE,new ArrayList<>()));
			chambreRepository.save(new Chambre(null, "200", 1, 3, 95.00, Chambre.Statut.LIBRE,new ArrayList<>()));
			chambreRepository.save(new Chambre(null, "201", 1, 3, 95.00, Chambre.Statut.LIBRE,new ArrayList<>()));
			chambreRepository.save(new Chambre(null, "202", 1, 3, 95.00, Chambre.Statut.LIBRE,new ArrayList<>()));
			chambreRepository.save(new Chambre(null, "203", 1, 3, 95.00, Chambre.Statut.LIBRE,new ArrayList<>()));
			chambreRepository.save(new Chambre(null, "204", 1, 3, 95.00, Chambre.Statut.LIBRE,new ArrayList<>()));
			chambreRepository.save(new Chambre(null, "205", 1, 3, 95.00, Chambre.Statut.LIBRE,new ArrayList<>()));
			chambreRepository.save(new Chambre(null, "300", 1, 3, 95.00, Chambre.Statut.LIBRE,new ArrayList<>()));
			chambreRepository.save(new Chambre(null, "301", 1, 3, 95.00, Chambre.Statut.LIBRE,new ArrayList<>()));
			chambreRepository.save(new Chambre(null, "302", 1, 3, 95.00, Chambre.Statut.LIBRE,new ArrayList<>()));
			chambreRepository.save(new Chambre(null, "303", 1, 3, 95.00, Chambre.Statut.LIBRE,new ArrayList<>()));
			chambreRepository.save(new Chambre(null, "304", 1, 3, 95.00, Chambre.Statut.LIBRE,new ArrayList<>()));
			chambreRepository.save(new Chambre(null, "305", 1, 3, 95.00, Chambre.Statut.LIBRE,new ArrayList<>()));

			reservationRepository.save(new Reservation(null,LocalDate.now(),null,"en cours", "","2",client1, List.of(chambre101)));
		};
	}
}

