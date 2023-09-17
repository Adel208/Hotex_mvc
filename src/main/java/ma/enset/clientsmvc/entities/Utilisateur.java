package ma.enset.clientsmvc.entities;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

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

    // Exemple d'annotation de validation
    @NotBlank(message = "Le titre ne peut pas être vide")
    private String titre;

    @NotBlank(message = "Le nom ne peut pas être vide")
    private String nom;

    @NotBlank(message = "Le prénom ne peut pas être vide")
    private String prenom;

    @Pattern(regexp = "\\d+", message = "Le nombre de personnes doit être un nombre valide")
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
