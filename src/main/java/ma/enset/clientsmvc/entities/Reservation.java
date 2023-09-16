package ma.enset.clientsmvc.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "chambre_id")
    private Chambre chambre;

    @Temporal(TemporalType.DATE)
    private Date dateArrivee;

    @Temporal(TemporalType.DATE)
    private Date dateDepart;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur getClient() {
        return utilisateur;
    }

    public void setClient(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }
}
