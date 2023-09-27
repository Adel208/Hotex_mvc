package ma.enset.clientsmvc.entities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.jupiter.api.condition.EnabledIf;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate datePaiement;
//    private CarteBancaire carteBancaire;

    @ManyToOne
    @JoinColumn(name = "reservation_id") // Clé étrangère
    private Reservation reservation;

    // Constructeur
    public Paiement(int id, LocalDate datePaiement, CarteBancaire carteBancaire) {
        this.id = id;
        this.datePaiement = datePaiement;
//        this.carteBancaire = carteBancaire;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDate datePaiement) {
        this.datePaiement = datePaiement;
    }



    @Override
    public String toString() {
        return "Paiement{" +
                "id=" + id +
                ", datePaiement=" + datePaiement +
                '}';
    }
}
