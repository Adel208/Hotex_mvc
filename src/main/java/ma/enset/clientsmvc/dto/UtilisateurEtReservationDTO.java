package ma.enset.clientsmvc.dto;

import ma.enset.clientsmvc.entities.Reservation;
import ma.enset.clientsmvc.entities.Utilisateur;

public class UtilisateurEtReservationDTO {
    private Utilisateur utilisateur;
    private Reservation reservation;

    public UtilisateurEtReservationDTO(Utilisateur utilisateur, Reservation reservation) {
        this.utilisateur = utilisateur;
        this.reservation = reservation;
    }

    // Getter et Setter pour utilisateur
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    // Getter et Setter pour reservation
    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
