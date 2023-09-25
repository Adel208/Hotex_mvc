package ma.enset.clientsmvc.entities;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
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
    private String adresseMail;

    @OneToMany(mappedBy = "client", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Reservation> reservations = new ArrayList<>();

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}


