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
public class Tableau {
    
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column(unique=true)
    @NonNull
    private String titre;
    
    @Column
    @NonNull
    private String support;
    
    @Column
    @NonNull
    private int largeur;
    
    @Column
    @NonNull
    private int hauteur;
    
    @ManyToOne
    private Artiste auteur;
    
    @ManyToMany (mappedBy="oeuvres")
    @NonNull
    private List<Exposition> accrochage;
    
    @OneToOne (mappedBy = "oeuvre")
    private Transaction vendu;
    
}
