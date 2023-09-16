package ma.enset.clientsmvc.entities;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String nom;
    private String prenom;
    private String nbrePersonne;
    private String chambreType;
    private LocalDate dateArrivee;
    private LocalDate dateDepart;
    private int petitDejeuner;
    private String numeroDeChambre;
    private String adresse;
    private String numeroTelephone;
    private String adresseMail;
    private LocalDate dateInscription;
    private String statut;
    private String numeroCarte;
    private String titulaireCarte;
    private String dateExpiration;
    private String codeSecurite;





}
