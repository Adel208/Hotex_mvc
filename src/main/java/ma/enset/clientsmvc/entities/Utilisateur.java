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
    private String titre;
    private String nom;
    private String prenom;
    private String adresse;
    private String numeroTelephone;
    @Column(unique = true)
    private String eMail;
    @OneToMany(mappedBy = "utilisateur", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Reservation> reservations = new ArrayList<>();


    public String getAdresseMail() {
        return eMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.eMail = adresseMail;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }


}
