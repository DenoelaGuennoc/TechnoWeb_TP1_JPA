/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.dao;

import galerie.entity.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import galerie.dao.PersonneRepository;
import java.util.List;
import java.util.Optional;

@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class PersonneRepositoryTest {
    
    @Autowired
    private PersonneRepository galerieDAO;

    @Test
    @Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Personne'");
        int combienDansLeJeuDeTest = 6; 
        long nombre = galerieDAO.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 6 personnes" );
    }
    
    @Test
    public void listerLesEnregistrements(){
        log.info("On liste les enregistrement de la table 'Personne'");
        List<Personne> personnes = galerieDAO.findAll();
        log.info("Liste des enregistrements : {}", personnes);
    }
    
    @Test
    @Sql("test-data.sql")
    public void trouverEnregistrementParClé(){
        log.info("On cherche un enregistrement en fonction de sa clé primaire");
        int cleRecherchee = 3;
        Optional<Personne> trouve = galerieDAO.findById(cleRecherchee);
        assertTrue(trouve.isPresent(), "Cette personne devrait exister");
        Personne personneTrouvee = trouve.get();
        assertEquals("Dumont", personneTrouvee.getNom(), "Le nom associé à cette clé est erroné");
        assertEquals("Paris", personneTrouvee.getAdresse(), "L'adresse associée à cette clé est erronée");
    }
    
    @Test
    public void chercherEnregistrementInexistant(){
        log.info("recherche d'un enregistrement par une clé inexistante");
        int cleInconnue = 22;
        Optional<Personne> resultat = galerieDAO.findById(cleInconnue);
        assertFalse(resultat.isPresent(), "Aucune personne ne doit avoir cet ID");
    }
    
    @Test
    public void creerEnregistrement(){
        log.info("création d'un enregistrement");
        Personne newPersonne = new Personne();
        newPersonne.setNom("testNom");
        newPersonne.setAdresse("testAdresse");
        assertNull(newPersonne.getId(), "la personne ne doit pas encore avoir de clé");
        galerieDAO.save(newPersonne);
        Integer newCle = newPersonne.getId();
        assertNotNull(newCle, "La nouvelle clé doit avoir été générée");
        assertEquals("testNom",newPersonne.getNom());
        assertEquals("testAdresse", newPersonne.getAdresse());
    }
}
