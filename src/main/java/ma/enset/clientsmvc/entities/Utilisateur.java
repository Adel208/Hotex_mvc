package ma.enset.clientsmvc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
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

    private String adresse;
    private String numeroTelephone;

    @Column(unique = true)
    private String eMail;

//    @ManyToOne
//    @JoinColumn(name = "chambre_id")
//    private Chambre chambre;

    @OneToMany(mappedBy = "utilisateur", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Reservation> reservations = new ArrayList<>();

    // Getter et setter pour l'adresseMail
    public String getAdresseMail() {
        return eMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.eMail = adresseMail;
    }

    // Getter et setter pour la chambre
//    public Chambre getChambre() {
//        return chambre;
//    }
//
//    public void setChambre(Chambre chambre) {
//        this.chambre = chambre;
//    }

    // Getter et setter pour les réservations
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }


}
