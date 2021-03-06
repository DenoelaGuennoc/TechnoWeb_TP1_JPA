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
@PrimaryKeyJoinColumn(name="id")
public class Artiste extends Personne{
   
    @Column(unique=true)
    @NonNull
    private String biographie;
    
    @OneToMany (mappedBy="auteur")
    private List<Tableau> oeuvres;
    
}
