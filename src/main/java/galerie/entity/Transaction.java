/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;
import java.time.LocalDate;
import javax.persistence.*;
import lombok.*;

/**
 *
 * @author Denoëla
 */
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Transaction {
    
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column
    @NonNull
    private LocalDate venduLe;
    
    @Column
    @NonNull
    private float prixVente;
    
    @ManyToOne
    @NonNull
    private Personne client;
    
    @ManyToOne
    @NonNull
    private Exposition lieuDeVente;
    
    @OneToOne
    @NonNull
    private Tableau oeuvre;
    
}
