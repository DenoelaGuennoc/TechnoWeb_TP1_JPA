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
    private Integer id;
    
    @Column
    @NonNull
    private LocalDate debut;
    
    @Column
    @NonNull
    private String intitule;
    
    @Column
    @NonNull
    private int duree;
    
    @ManyToOne
    @NonNull
    private Galerie organisateur;
    
    @OneToMany (mappedBy="lieuDeVente")
    private List<Transaction> ventes;
    
    @ManyToMany
    private List<Tableau> oeuvres;
    
    public float CA(){
        float vCA = 0.0f;
        if(!ventes.isEmpty()){
            for(Transaction t : ventes){
                vCA += t.getPrixVente();
            }
        }
        return vCA;
    }
    
}
