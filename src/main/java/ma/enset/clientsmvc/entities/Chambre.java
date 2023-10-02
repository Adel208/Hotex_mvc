package ma.enset.clientsmvc.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private int etage;
    private int nombrePlaces;
    private double prix;
    @Enumerated(EnumType.STRING)
    private Statut statut;

    @ManyToMany(mappedBy = "chambres")
    private List<Reservation> reservations = new ArrayList<>();

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {

        this.reservations = reservations;
    }

    public enum Statut {
        LIBRE, OCCUPEE
    }
}

