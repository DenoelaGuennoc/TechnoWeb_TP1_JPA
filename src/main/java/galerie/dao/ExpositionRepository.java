package galerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import galerie.entity.Exposition;
import org.springframework.data.jpa.repository.Query;

// This will be AUTO IMPLEMENTED by Spring 

public interface ExpositionRepository extends JpaRepository<Exposition, Integer> {
    
    /**
    * Calculer le chiffre d'affaires pour une exposition
    * @param id la clé primaire de l'exposition
    * @return le chiffre d'affaires de cette exposition
    */
    
    @Query(
        value = "SELECT SUM(prix_vente)"
            + "FROM Transaction INNER JOIN Exposition "
            + "ON(Transaction.lieu_de_vente_id = Exposition.id)"
            + "WHERE Exposition.id = :id",
        nativeQuery = true
    ) //requête SQL beaucoup plus courte et simple que celle générée par la méthode JAVA
    
    float chiffreAffairePour(Integer id);
    
}
