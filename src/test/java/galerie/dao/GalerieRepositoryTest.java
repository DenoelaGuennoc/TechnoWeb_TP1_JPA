package galerie.dao;

import galerie.entity.Galerie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import galerie.dao.GalerieRepository;
import java.util.List;
import java.util.Optional;

@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class GalerieRepositoryTest {

    @Autowired
    private GalerieRepository galerieDAO;

    @Test
    @Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Galerie'");
        int combienDansLeJeuDeTest = 4; 
        long nombre = galerieDAO.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 4 galeries" );
    }
    
    @Test
    public void listerLesEnregistrements(){
        log.info("On liste les enregistrement de la table 'Galerie'");
        List<Galerie> galeries = galerieDAO.findAll();
        log.info("Liste des enregistrements : {}", galeries);
    }
    
    @Test
    @Sql("test-data.sql")
    public void trouverEnregistrementParClé(){
        log.info("On cherche un enregistrement en fonction de sa clé primaire");
        int cleRecherchee = 3;
        Optional<Galerie> trouve = galerieDAO.findById(cleRecherchee);
        assertTrue(trouve.isPresent(), "Cette galerie devrait exister");
        Galerie galerieTrouvee = trouve.get();
        assertEquals("L'art-bre", galerieTrouvee.getNom(), "Le nom associé à cette clé est erroné");
        assertEquals("Rue de Trumon, Paris", galerieTrouvee.getAdresse(), "L'adresse associée à cette clé est erronée");
    }
    
    @Test
    public void chercherEnregistrementInexistant(){
        log.info("recherche d'un enregistrement par une clé inexistante");
        int cleInconnue = 22;
        Optional<Galerie> resultat = galerieDAO.findById(cleInconnue);
        assertFalse(resultat.isPresent(), "Aucune galerie ne doit avoir cet ID");
    }
    
    @Test
    public void creerEnregistrement(){
        log.info("création d'un enregistrement");
        Galerie newGalerie = new Galerie();
        newGalerie.setNom("testNom");
        newGalerie.setAdresse("testAdresse");
        assertNull(newGalerie.getId(), "la galerie ne doit pas encore avoir de clé");
        galerieDAO.save(newGalerie);
        Integer newCle = newGalerie.getId();
        assertNotNull(newCle, "La nouvelle clé doit avoir été générée");
        assertEquals("testNom",newGalerie.getNom());
        assertEquals("testAdresse", newGalerie.getAdresse());
    }
    
    @Test
    @Sql("test-data.sql")
    public void testCAannuel(){
        float caAnnuel = 560;
        Optional<Galerie> vGalerie = galerieDAO.findById(3);
        assertTrue(vGalerie.isPresent(), "Cette galerie devrait exister");
        Galerie galerie = vGalerie.get();
        assertEquals(caAnnuel, galerie.CAannuel(2020), "Le calcul du CA annuel de la galerie est inexacte");
    }

}
