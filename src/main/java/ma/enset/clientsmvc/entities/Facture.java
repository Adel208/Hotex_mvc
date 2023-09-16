package ma.enset.clientsmvc.entities;

import ma.enset.clientsmvc.entities.Reservation;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;


    private String numeroFacture;
    private Date dateFacturation;
    private double prixChambre;
    private double prixPetitDejeuner;
    private double prixExtras;
    private double tva;
    private double montantTotal;
    private String nomClient;
    private String prenomClient;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public double getPrixChambre() {
        return prixChambre;
    }

    public void setPrixChambre(double prixChambre) {
        this.prixChambre = prixChambre;
    }

    public double getPrixPetitDejeuner() {
        return prixPetitDejeuner;
    }

    public void setPrixPetitDejeuner(double prixPetitDejeuner) {
        this.prixPetitDejeuner = prixPetitDejeuner;
    }

    public double getPrixExtras() {
        return prixExtras;
    }

    public void setPrixExtras(double prixExtras) {
        this.prixExtras = prixExtras;
    }

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(String numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public Date getDateFacturation() {
        return dateFacturation;
    }

    public void setDateFacturation(Date dateFacturation) {
        this.dateFacturation = dateFacturation;
    }
}
