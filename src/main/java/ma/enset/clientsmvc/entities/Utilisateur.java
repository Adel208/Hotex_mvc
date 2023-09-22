package ma.enset.clientsmvc.entities;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Le titre ne peut pas être vide")
    private String titre;
    @NotBlank(message = "Le nom ne peut pas être vide")
    private String nom;
    @NotBlank(message = "Le prénom ne peut pas être vide")
    private String prenom;
    @Pattern(regexp = "\\d+", message = "Le nombre de personnes doit être un nombre valide")
    private String nbrePersonne;
    @ManyToOne
    private Chambre chambre;

    @Nullable
    private Date dateArrivee;
    @Nullable
    private Date dateDepart;
    private int petitDejeuner;
    private String numeroDeChambre;
    private String adresse;
    private String numeroTelephone;
    private String adresseMail;

    public enum Statut {
        LIBRE, OCCUPEE
    }
}


