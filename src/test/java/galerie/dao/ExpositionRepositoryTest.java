/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.dao;

import galerie.entity.Exposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import galerie.dao.ExpositionRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class ExpositionRepositoryTest {
    
    @Autowired
    private ExpositionRepository galerieDAO;

    @Test
    @Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Exposition'");
        int combienDansLeJeuDeTest = 4; 
        long nombre = galerieDAO.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 4 expositions" );
    }
    
    @Test
    public void listerLesEnregistrements(){
        log.info("On liste les enregistrement de la table 'Exposition'");
        List<Exposition> expo = galerieDAO.findAll();
        log.info("Liste des enregistrements : {}", expo);
    }
    
    @Test
    @Sql("test-data.sql")
    public void trouverEnregistrementParClé(){
        log.info("On cherche un enregistrement en fonction de sa clé primaire");
        int cleRecherchee = 2;
        Optional<Exposition> trouve = galerieDAO.findById(cleRecherchee);
        assertTrue(trouve.isPresent(), "Cette exposition devrait exister");
        Exposition expoTrouvee = trouve.get();
        assertEquals("La photographie noire et blanc", expoTrouvee.getIntitule(), "L'intitulé associé à cette clé est erroné");
    }
    
    @Test
    public void chercherEnregistrementInexistant(){
        log.info("recherche d'un enregistrement par une clé inexistante");
        int cleInconnue = 22;
        Optional<Exposition> resultat = galerieDAO.findById(cleInconnue);
        assertFalse(resultat.isPresent(), "Aucune exposition ne doit avoir cet ID");
    }
    
    @Test
    public void creerEnregistrement(){
        log.info("création d'un enregistrement");
        Exposition newExpo = new Exposition();
        newExpo.setIntitule("testIntitule");
        newExpo.setDebut(LocalDate.parse("2022-10-08"));
        newExpo.setDuree(53);
        assertNull(newExpo.getId(), "la galerie ne doit pas encore avoir de clé");
        galerieDAO.save(newExpo);
        Integer newCle = newExpo.getId();
        assertNotNull(newCle, "La nouvelle clé doit avoir été générée");
        assertEquals("testIntitule",newExpo.getIntitule(),"L'intitule associé est erroné");
        assertEquals(LocalDate.parse("2022-10-08"), newExpo.getDebut(), "Le début associé est erroné");
        assertEquals(53,newExpo.getDuree(),"La durée associée est erronée");
    }
    
}
