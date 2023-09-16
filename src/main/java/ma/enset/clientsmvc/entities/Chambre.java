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

    public Chambre(Long id, String numeroChambre, int etage, int nombrePlaces) {
        this.id = id;
        this.numeroChambre = numeroChambre;
        this.etage = etage;
        this.nombrePlaces = nombrePlaces;
    }

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

}