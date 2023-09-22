package ma.enset.clientsmvc.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    public enum Statut {
        LIBRE, OCCUPEE
    }
}

