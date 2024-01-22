-- Données pour la table maladies_symptomes
insert into maladies values
    (default, 'Grippe'),
    (default, 'Vavony'),
    (default, 'Indigestion');

-- Données pour la table symptomes
insert into symptomes values
    (default, 'Kibo'),
    (default, 'Caca'),
    (default, 'Andoha'),
    (default, 'Temperature'),
    (default, 'Fatigue'),
    (default, 'Lelo');

-- Données pour la table maladies_symptomes
insert into maladies_symptomes values
    (default, 1, 4, 1, 100, 3, 5),   -- Grippe, Fièvre, 1-100 ans, effets min-max
    (default, 1, 6, 1, 100, 5, 8),   -- Grippe, Toux, 1-100 ans, effets min-max
    (default, 1, 3, 1, 100, 5, 7),   -- Grippe, Fatigue, 1-100 ans, effets min-max
    
    (default, 2, 1, 1, 100, 5, 7),   -- Rhume, Fièvre, 1-100 ans, effets min-max
    (default, 2, 4, 1, 100, 3, 6),   -- Rhume, Toux, 1-100 ans, effets min-max

    (default, 3, 1, 1, 100, 5, 8),   -- Tuberculose, Toux, 1-100 ans, effets min-max
    (default, 3, 2, 1, 100, 6, 8),   -- Tuberculose, Douleurs musculaires, 1-100 ans, effets min-max
    (default, 3, 5, 1, 100, 3, 7);  -- Diabète, Polyurie, 1-100 ans, effets min-max

insert into medicaments values
    (default, 'F1', 20000),
    (default, 'F2', 15000),
    (default, 'F3', 40000);

insert into effets_medicaments values
-- F1
    (default, 1, 4, 1, 100, 2),   -- Aspirine, Fièvre, 1-100 ans, effet 2
    (default, 1, 6, 1, 100, 3),   -- Paracétamol, Fièvre, 1-100 ans, effet 3
    (default, 1, 3, 1, 100, 3),   -- Ibuprofène, Fièvre, 1-100 ans, effet 2
    (default, 1, 1, 1, 100, 1),   -- Doliprane, Fièvre, 1-100 ans, effet 4

-- F2
    (default, 2, 1, 1, 100, 3),   -- Aspirine, Toux, 1-100 ans, effet 3
    (default, 2, 3, 1, 100, 1),   -- Paracétamol, Toux, 1-100 ans, effet 2
    (default, 2, 2, 1, 100, 2),   -- Ibuprofène, Toux, 1-100 ans, effet 1

-- F3
    (default, 3, 5, 1, 100, 2),   -- Aspirine, Fatigue, 1-100 ans, effet 2
    (default, 3, 6, 1, 100, 2),   -- Paracétamol, Fatigue, 1-100 ans, effet 1
    (default, 3, 3, 1, 100, 3),   -- Ibuprofène, Fatigue, 1-100 ans, effet 1
    (default, 3, 4, 1, 100, 2),   -- Doliprane, Fatigue, 1-100 ans, effet 2
    (default, 3, 1, 1, 100, 2);   -- Efferalgan, Fatigue, 1-100 ans, effet 3