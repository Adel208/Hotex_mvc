package ma.enset.clientsmvc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.enset.clientsmvc.entities.Reservation;
import ma.enset.clientsmvc.entities.Utilisateur;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UtilisateurEtReservationDTO {
    private Utilisateur utilisateur;
    private Reservation reservation;
}
