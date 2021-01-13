/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;
import java.time.LocalDate;
import javax.persistence.*;
import lombok.*;
import java.util.List;

/**
 *
 * @author Denoëla
 */
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Exposition {
    
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idExposition;
    
    @Column(unique=true)
    @NonNull
    private LocalDate debut;
    
    @Column(unique=true)
    @NonNull
    private String intitule;
    
    @Column(unique=true)
    @NonNull
    private int duree;
    
    @ManyToOne
    private Galerie organisateur;
    
    @OneToMany (mappedBy="lieuDeVente")
    private List<Transaction> ventes;
    
    @ManyToMany
    private List<Tableau> oeuvres;
    
}
