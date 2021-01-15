/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;
import java.util.List;
import javax.persistence.*;
import lombok.*;

/**
 *
 * @author Denoëla
 */
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {
    
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;
    
    @OneToMany (mappedBy="client")
    private List<Transaction> achats;
    
    public float budgetArt(int annee){
        float vBudget = 0.0f;
        for(Transaction t : achats){
            if (t.getVenduLe().getYear() == annee){
                vBudget += t.getPrixVente();
            }
        }
        return vBudget;
    }
        
}
