package ma.enset.clientsmvc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate dateArrive;
    private LocalDate dateDepart;
    private String statut;
    private String commentaire;
    @Pattern(regexp = "\\d+", message = "Le nombre de personnes doit être un nombre valide")
    private String nbrePersonne;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur client;

    @ManyToMany
    @JoinTable(name = "reservation_chambres",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "chambres_id"))
    private List<Chambre> chambres = new ArrayList<>();







}
