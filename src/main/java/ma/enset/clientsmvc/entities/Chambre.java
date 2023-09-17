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
    private String numeroChambre;
    private int etage;
    private int nombrePlaces;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    // Les getters et setters sont générés automatiquement par Lombok

    // Vous pouvez ajouter d'autres méthodes ou annotations ici si nécessaire
}
