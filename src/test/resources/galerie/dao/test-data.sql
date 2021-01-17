-- Initialisation spécifiques pour un jeu de test
INSERT INTO Galerie(id, nom, adresse) VALUES (1, 'Saatchi', 'King''s Road, Londres');
INSERT INTO Galerie(id, nom, adresse) VALUES (2, 'Vonhart', 'Liebschter strasse, Berlin');
INSERT INTO Galerie(id, nom, adresse) VALUES (3, 'L''art-bre', 'Rue de Trumon, Paris');
INSERT INTO Galerie(id, nom, adresse) VALUES (4, 'Galerie Pierre & François', 'Avenue d''été, Genêve');


INSERT INTO Personne(id, nom, adresse) VALUES (1, 'Guennoc', 'Castres');
INSERT INTO Personne(id, nom, adresse) VALUES (2, 'Kervella', 'Brest');
INSERT INTO Personne(id, nom, adresse) VALUES (3, 'Dumont', 'Paris');
INSERT INTO Personne(id, nom, adresse) VALUES (4, 'Smith', 'Londres');
INSERT INTO Personne(id, nom, adresse) VALUES (5, 'Holmes', 'New Castle');
INSERT INTO Personne(id, nom, adresse) VALUES (6, 'Schweins', 'Hambourg');


INSERT INTO Exposition(id, debut, intitule, duree) VALUES (1, TO_DATE('2021-01-03', 'YYYY-MM-DD'), 'Renaissance italienne', 15);
INSERT INTO Exposition(id, debut, intitule, duree) VALUES (2, TO_DATE('2020-10-12', 'YYYY-MM-DD'), 'La photographie noire et blanc', 48);
INSERT INTO Exposition(id, debut, intitule, duree) VALUES (3, TO_DATE('2021-02-23', 'YYYY-MM-DD'), 'L''Hyperréalisme', 26);
INSERT INTO Exposition(id, debut, intitule, duree) VALUES (4, TO_DATE('2020-12-05', 'YYYY-MM-DD'), 'Cubisme et collages', 57);
