package ma.enset.clientsmvc.entities;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;

public class Paiement {
    private int id;
    private LocalDate datePaiement;
    private CarteBancaire carteBancaire;

    @ManyToOne
    @JoinColumn(name = "reservation_id") // Clé étrangère
    private Reservation reservation;

    // Constructeur
    public Paiement(int id, LocalDate datePaiement, CarteBancaire carteBancaire) {
        this.id = id;
        this.datePaiement = datePaiement;
        this.carteBancaire = carteBancaire;
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

    public CarteBancaire getCarteBancaire() {
        return carteBancaire;
    }

    public void setCarteBancaire(CarteBancaire carteBancaire) {
        this.carteBancaire = carteBancaire;
    }

    @Override
    public String toString() {
        return "Paiement{" +
                "id=" + id +
                ", datePaiement=" + datePaiement +
                ", carteBancaire=" + carteBancaire +
                '}';
    }
}
