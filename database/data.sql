-- Données pour la table maladies_symptomes
insert into maladies values
    (default, 'Grippe'),
    (default, 'Rhume'),
    (default, 'Tuberculose'),
    (default, 'Diabète');

-- Données pour la table symptomes
insert into symptomes values
    (default, 'Fièvre'),
    (default, 'Toux'),
    (default, 'Fatigue'),
    (default, 'Maux de tête'),
    (default, 'Nez qui coule'),
    (default, 'Éternuements'),
    (default, 'Douleurs musculaires'),
    (default, 'Essoufflement'),
    (default, 'Perte de poids'),
    (default, 'Polyurie'), -- Polyurie est un symptôme lié au diabète
    (default, 'Température');

-- Données pour la table maladies_symptomes
insert into maladies_symptomes values
    (default, 1, 1, 1, 20, 3, 6),   -- Grippe, Fièvre, 1-20 ans, effets min-max
    (default, 1, 2, 1, 20, 2, 5),   -- Grippe, Toux, 1-20 ans, effets min-max
    (default, 1, 3, 1, 20, 1, 4),   -- Grippe, Fatigue, 1-20 ans, effets min-max
    (default, 1, 4, 1, 20, 2, 7),   -- Grippe, Maux de tête, 1-20 ans, effets min-max
    (default, 1, 11, 1, 20, 1, 5),  -- Grippe, Température, 1-20 ans, effets min-max
    (default, 2, 1, 1, 20, 2, 6),   -- Rhume, Fièvre, 1-20 ans, effets min-max
    (default, 2, 2, 1, 20, 2, 5),   -- Rhume, Toux, 1-20 ans, effets min-max
    (default, 2, 5, 1, 20, 1, 4),   -- Rhume, Nez qui coule, 1-20 ans, effets min-max
    (default, 3, 2, 1, 20, 3, 8),   -- Tuberculose, Toux, 1-20 ans, effets min-max
    (default, 3, 7, 1, 20, 2, 6),   -- Tuberculose, Douleurs musculaires, 1-20 ans, effets min-max
    (default, 4, 10, 1, 20, 3, 9);  -- Diabète, Polyurie, 1-20 ans, effets min-max

insert into medicaments values
    (default, 'Aspirine', 1000),
    (default, 'Paracétamol', 500),
    (default, 'Ibuprofène', 1500),
    (default, 'Doliprane', 2000),
    (default, 'Efferalgan', 2500),
    (default, 'Fervex', 4500);

insert into effets_medicaments values
-- Fièvre
    (default, 1, 1, 1, 20, 4),   -- Aspirine, Fièvre, 1-20 ans, effet 2
    (default, 2, 1, 1, 20, 3),   -- Paracétamol, Fièvre, 1-20 ans, effet 3
    (default, 3, 1, 1, 20, 2),   -- Ibuprofène, Fièvre, 1-20 ans, effet 2
    (default, 4, 1, 1, 20, 4),   -- Doliprane, Fièvre, 1-20 ans, effet 4
    (default, 5, 1, 1, 20, 5),   -- Efferalgan, Fièvre, 1-20 ans, effet 5
    (default, 6, 1, 1, 20, 6),   -- Fervex, Fièvre, 1-20 ans, effet 6

-- Toux
    (default, 1, 2, 1, 20, 3),   -- Aspirine, Toux, 1-20 ans, effet 3
    (default, 2, 2, 1, 20, 2),   -- Paracétamol, Toux, 1-20 ans, effet 2
    (default, 3, 2, 1, 20, 1),   -- Ibuprofène, Toux, 1-20 ans, effet 1
    (default, 4, 2, 1, 20, 3),   -- Doliprane, Toux, 1-20 ans, effet 3
    (default, 5, 2, 1, 20, 4),   -- Efferalgan, Toux, 1-20 ans, effet 4
    (default, 6, 2, 1, 20, 5),   -- Fervex, Toux, 1-20 ans, effet 5

-- Fatigue
    (default, 1, 3, 1, 20, 2),   -- Aspirine, Fatigue, 1-20 ans, effet 2
    (default, 2, 3, 1, 20, 1),   -- Paracétamol, Fatigue, 1-20 ans, effet 1
    (default, 3, 3, 1, 20, 1),   -- Ibuprofène, Fatigue, 1-20 ans, effet 1
    (default, 4, 3, 1, 20, 2),   -- Doliprane, Fatigue, 1-20 ans, effet 2
    (default, 5, 3, 1, 20, 3),   -- Efferalgan, Fatigue, 1-20 ans, effet 3
    (default, 6, 3, 1, 20, 4),   -- Fervex, Fatigue, 1-20 ans, effet 4

-- Maux de tête
    (default, 1, 4, 1, 20, 4),   -- Aspirine, Maux de tête, 1-20 ans, effet 4
    (default, 2, 4, 1, 20, 3),   -- Paracétamol, Maux de tête, 1-20 ans, effet 3
    (default, 3, 4, 1, 20, 2),   -- Ibuprofène, Maux de tête, 1-20 ans, effet 2
    (default, 4, 4, 1, 20, 4),   -- Doliprane, Maux de tête, 1-20 ans, effet 4
    (default, 5, 4, 1, 20, 5),   -- Efferalgan, Maux de tête, 1-20 ans, effet 5
    (default, 6, 4, 1, 20, 6),   -- Fervex, Maux de tête, 1-20 ans, effet 6

-- Nez qui coule
    (default, 2, 5, 1, 20, 1),   -- Paracétamol, Nez qui coule, 1-20 ans, effet 1
    (default, 3, 5, 1, 20, 2),   -- Ibuprofène, Nez qui coule, 1-20 ans, effet 2
    (default, 5, 5, 1, 20, 3),   -- Efferalgan, Nez qui coule, 1-20 ans, effet 3

-- Éternuements
    (default, 2, 6, 1, 20, 1),   -- Paracétamol, Éternuements, 1-20 ans, effet 1
    (default, 3, 6, 1, 20, 5),   -- Ibuprofène, Éternuements, 1-20 ans, effet 5

-- Douleurs musculaires
    (default, 3, 7, 1, 20, 2),   -- Ibuprofène, Douleurs musculaires, 1-20 ans, effet 2

-- Essoufflement
    (default, 3, 8, 1, 20, 1),   -- Ibuprofène, Essoufflement, 1-20 ans, effet 1

-- Perte de poids
    (default, 4, 9, 1, 20, 1),   -- Doliprane, Perte de poids, 1-20 ans, effet 1

-- Polyurie
    (default, 5, 10, 1, 20, 1),  -- Efferalgan, Polyurie, 1-20 ans, effet 1

-- Température
    (default, 1, 11, 1, 20, 2),  -- Aspirine, Température, 1-20 ans, effet 2
    (default, 2, 11, 1, 20, 1),  -- Paracétamol, Température, 1-20 ans, effet 1
    (default, 3, 11, 1, 20, 1),  -- Ibuprofène, Température, 1-20 ans, effet 1
    (default, 4, 11, 1, 20, 2),  -- Doliprane, Température, 1-20 ans, effet 2
    (default, 5, 11, 1, 20, 3),  -- Efferalgan, Température, 1-20 ans, effet 3
    (default, 6, 11, 1, 20, 4);  -- Fervex, Température, 1-20 ans, effet 4

-- Contre indication
insert into effets_medicaments values
    (default, 1, 5, 1, 20, -3),  -- Aspirine, Nez qui coule, 1-20 ans, effet -3
    (default, 2, 9, 1, 20, -2),  -- Paracétamol, Perte de poids, 1-20 ans, effet -2
    (default, 3, 10, 1, 20, -1), -- Ibuprofène, Polyurie, 1-20 ans, effet -1
    (default, 4, 6, 1, 20, -3),  -- Doliprane, Éternuements, 1-20 ans, effet -3
    (default, 5, 7, 1, 20, -2),  -- Efferalgan, Douleurs musculaires, 1-20 ans, effet -2
    (default, 6, 8, 1, 20, -1);  -- Fervex, Essoufflement, 1-20 ans, effet -1