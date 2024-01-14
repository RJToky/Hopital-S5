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
