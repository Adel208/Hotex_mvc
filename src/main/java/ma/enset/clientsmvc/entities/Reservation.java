package ma.enset.clientsmvc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private String titre;
//    private String nom;
//    private String prenom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateArrivee;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDepart;

    private String statut;
    private String pdj;
    private String commentaire;

    @Pattern(regexp = "\\d+", message = "Le nombre de personnes doit être un nombre valide")
    private String nbrePersonne;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToMany
    @JoinTable(name = "reservation_chambres",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "chambres_id"))
    private List<Chambre> chambres = new ArrayList<>();

    // Getter et Setter pour id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    // Getter et Setter pour titre
//    public String getTitre() {
//        return titre;
//    }
//
//    public void setTitre(String titre) {
//        this.titre = titre;
//    }
//
//    // Getter et Setter pour nom
//    public String getNom() {
//        return nom;
//    }
//
//    public void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    // Getter et Setter pour prenom
//    public String getPrenom() {
//        return prenom;
//    }
//
//    public void setPrenom(String prenom) {
//        this.prenom = prenom;
//    }

    // Getter et Setter pour dateArrivee
    public LocalDate getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(LocalDate dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    // Getter et Setter pour dateDepart
    public LocalDate getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(LocalDate dateDepart) {
        this.dateDepart = dateDepart;
    }

    // Getter et Setter pour statut
    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    // Getter et Setter pour pdj
    public String getPdj() {
        return pdj;
    }

    public void setPdj(String pdj) {
        this.pdj = pdj;
    }

    // Getter et Setter pour commentaire
    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    // Getter et Setter pour nbrePersonne
    public String getNbrePersonne() {
        return nbrePersonne;
    }

    public void setNbrePersonne(String nbrePersonne) {
        this.nbrePersonne = nbrePersonne;
    }

    // Getter et Setter pour utilisateur
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    // Getter et Setter pour chambres
    public List<Chambre> getChambres() {
        return chambres;
    }

    public void setChambres(List<Chambre> chambres) {
        this.chambres = chambres;
    }
}
