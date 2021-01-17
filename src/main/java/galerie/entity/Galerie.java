package galerie.entity;
import java.util.List;
import javax.persistence.*;
import lombok.*;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Galerie {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;
    
    @OneToMany (mappedBy = "organisateur")
    private List<Exposition> evenements;
    
    public float CAannuel (int annee){
        float vCAannuel = 0.0f;
        if(!evenements.isEmpty()){
            for(Exposition e : evenements){
                if(e.getDebut().getYear() == annee || e.getDebut().plusDays(e.getDuree()).getYear() == annee ||
                        (e.getDebut().plusDays(e.getDuree()).getYear() > annee && e.getDebut().getYear() < annee)){
                    for(Transaction t : e.getVentes()){
                        if(t.getVenduLe().getYear() == annee){
                            vCAannuel += t.getPrixVente();
                        }
                    }
                }
            }
        }
        return vCAannuel;
    }
    
}
