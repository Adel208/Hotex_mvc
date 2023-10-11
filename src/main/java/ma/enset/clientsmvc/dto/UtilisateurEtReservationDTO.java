package ma.enset.clientsmvc.dto;

import ma.enset.clientsmvc.entities.Reservation;
import ma.enset.clientsmvc.entities.Utilisateur;

import javax.validation.constraints.Email;

public class UtilisateurEtReservationDTO {
    private Utilisateur utilisateur;
    private Reservation reservation;


    public UtilisateurEtReservationDTO(Utilisateur utilisateur, Reservation reservation) {
        this.utilisateur = utilisateur;
        this.reservation = reservation;
    }


    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
