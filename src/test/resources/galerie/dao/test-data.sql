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
INSERT INTO Personne(id, nom, adresse) VALUES (7, 'Gilbert', 'Reims');


INSERT INTO Exposition(id, debut, intitule, duree, organisateur_id) VALUES (1, TO_DATE('2020-01-03', 'YYYY-MM-DD'), 'Romantisme et peinture', 15, 2);
INSERT INTO Exposition(id, debut, intitule, duree, organisateur_id) VALUES (2, TO_DATE('2020-08-12', 'YYYY-MM-DD'), 'La photographie noire et blanc', 48, 4);
INSERT INTO Exposition(id, debut, intitule, duree, organisateur_id) VALUES (3, TO_DATE('2020-02-23', 'YYYY-MM-DD'), 'L''Hyperréalisme, photographier au crayon', 26, 4);
INSERT INTO Exposition(id, debut, intitule, duree, organisateur_id) VALUES (4, TO_DATE('2020-11-05', 'YYYY-MM-DD'), 'Paysages gravés', 107, 3);
INSERT INTO Exposition(id, debut, intitule, duree, organisateur_id) VALUES (5, TO_DATE('2021-02-18', 'YYYY-MM-DD'), 'Post-modernisme', 20, 1);


INSERT INTO Artiste(id, biographie) VALUES (2, 'Photographe');
INSERT INTO Artiste(id, biographie) VALUES (6, 'Peintre');
INSERT INTO Artiste(id, biographie) VALUES (3, 'Sculpteur et graveur sur bois');
INSERT INTO Artiste(id, biographie) VALUES (7, 'dessinateur hyperréaliste');


INSERT INTO Tableau(id, hauteur, largeur, support, titre, auteur_id) VALUES (1, 80, 120, 'Impression sur papier photographique', 'The drunken sailor', 2);
INSERT INTO Tableau(id, hauteur, largeur, support, titre, auteur_id) VALUES (2, 150, 100, 'Huile sur toile', 'Soirée d''été', 6);
INSERT INTO Tableau(id, hauteur, largeur, support, titre, auteur_id) VALUES (3, 120, 120, 'Fusain sur papier à dessin', 'L''Inconnu du café', 7);
INSERT INTO Tableau(id, hauteur, largeur, support, titre, auteur_id) VALUES (4, 80, 120, 'Gravure sur merisier', 'Pourtant que la montagne est belle', 3);
INSERT INTO Tableau(id, hauteur, largeur, support, titre, auteur_id) VALUES (5, 50, 60, 'Impression sur papier photographique', 'Jour de marché', 2);
INSERT INTO Tableau(id, hauteur, largeur, support, titre, auteur_id) VALUES (6, 100, 160, 'Acrylique sur bois', 'Cueillette aux champignons', 6);
INSERT INTO Tableau(id, hauteur, largeur, support, titre, auteur_id) VALUES (7, 20, 50, 'Gravure sur bois', 'Le village s''endort', 3);
INSERT INTO Tableau(id, hauteur, largeur, support, titre, auteur_id) VALUES (8, 190, 300, 'Huile sur toile', 'Innocent devant l''océan bleu profond', 6);
INSERT INTO Tableau(id, hauteur, largeur, support, titre, auteur_id) VALUES (9, 110, 200, 'Impression sur toile', 'Vieux loup de mer', 2);
INSERT INTO Tableau(id, hauteur, largeur, support, titre, auteur_id) VALUES (10, 30, 80, 'Gravure sur écorces de chêne', 'Comme un arbre dans la ville', 3);
INSERT INTO Tableau(id, hauteur, largeur, support, titre, auteur_id) VALUES (11, 130, 85, 'Stylo sur papier à dessin', 'Ma mère', 7);
INSERT INTO Tableau(id, hauteur, largeur, support, titre, auteur_id) VALUES (12, 80, 56, 'Impression sur papier photographique', 'La femme du marin', 2);


INSERT INTO Exposition_oeuvres (accrochage_id, oeuvres_id) VALUES (2,1);
INSERT INTO Exposition_oeuvres (accrochage_id, oeuvres_id) VALUES (1,2);
INSERT INTO Exposition_oeuvres (accrochage_id, oeuvres_id) VALUES (3,3);
INSERT INTO Exposition_oeuvres (accrochage_id, oeuvres_id) VALUES (4,4);
INSERT INTO Exposition_oeuvres (accrochage_id, oeuvres_id) VALUES (2,5);
INSERT INTO Exposition_oeuvres (accrochage_id, oeuvres_id) VALUES (1,6);
INSERT INTO Exposition_oeuvres (accrochage_id, oeuvres_id) VALUES (4,7);
INSERT INTO Exposition_oeuvres (accrochage_id, oeuvres_id) VALUES (1,8);
INSERT INTO Exposition_oeuvres (accrochage_id, oeuvres_id) VALUES (2,9);
INSERT INTO Exposition_oeuvres (accrochage_id, oeuvres_id) VALUES (4,10);
INSERT INTO Exposition_oeuvres (accrochage_id, oeuvres_id) VALUES (3,11);
INSERT INTO Exposition_oeuvres (accrochage_id, oeuvres_id) VALUES (2,12);


INSERT INTO Transaction(id, prix_vente, vendu_le, client_id, lieu_de_vente_id, oeuvre_id) VALUES (1, 1500, TO_DATE('2020-10-02', 'YYYY-MM-DD'), 5, 2, 1);
INSERT INTO Transaction(id, prix_vente, vendu_le, client_id, lieu_de_vente_id, oeuvre_id) VALUES (2, 3000, TO_DATE('2020-01-08', 'YYYY-MM-DD'), 1, 1, 8);
INSERT INTO Transaction(id, prix_vente, vendu_le, client_id, lieu_de_vente_id, oeuvre_id) VALUES (3, 9600, TO_DATE('2020-03-16', 'YYYY-MM-DD'), 5, 3, 3);
INSERT INTO Transaction(id, prix_vente, vendu_le, client_id, lieu_de_vente_id, oeuvre_id) VALUES (4, 560, TO_DATE('2020-11-10', 'YYYY-MM-DD'), 4, 4, 10);
INSERT INTO Transaction(id, prix_vente, vendu_le, client_id, lieu_de_vente_id, oeuvre_id) VALUES (5, 288, TO_DATE('2020-08-23', 'YYYY-MM-DD'), 1, 2, 9);
INSERT INTO Transaction(id, prix_vente, vendu_le, client_id, lieu_de_vente_id, oeuvre_id) VALUES (6, 1512, TO_DATE('2020-08-23', 'YYYY-MM-DD'), 1, 2, 12);
INSERT INTO Transaction(id, prix_vente, vendu_le, client_id, lieu_de_vente_id, oeuvre_id) VALUES (7, 1236.50, TO_DATE('2021-01-16', 'YYYY-MM-DD'), 4, 4, 4);
