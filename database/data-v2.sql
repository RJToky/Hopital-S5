-- Données pour la table maladies_symptomes
insert into maladies values
    (default, 'Grippe'),
    (default, 'Indigestion'),
    (default, 'Fatique');

-- Données pour la table symptomes
insert into symptomes values
    (default, 'Loha'),
    (default, 'Tanana'),
    (default, 'Tenda'),
    (default, 'lelo'),
    (default, 'Tongotra'),
    (default, 'Kibo');

-- Données pour la table maladies_symptomes
insert into maladies_symptomes values
    (default, 1, 1, 0, 100, 5, 8),
    (default, 1, 3, 0, 100, 4, 7),
    (default, 1, 4, 0, 100, 6, 9),

    (default, 2, 2, 0, 100, 3, 6),
    (default, 2, 2, 0, 100, 2, 7),
    (default, 2, 3, 0, 100, 5, 8),
    (default, 2, 6, 0, 100, 6, 9),

    (default, 3, 1, 0, 100, 3, 6),
    (default, 3, 2, 0, 100, 2, 6),
    (default, 3, 3, 0, 100, 2, 5),
    (default, 3, 5, 0, 100, 4, 7);

insert into medicaments values
    (default, 'Paracetamol', 200),
    (default, 'Sirop', 23000),
    (default, 'Doliprane', 30000),
    (default, 'MagneB6', 35000);

insert into effets_medicaments values
    (default, 1, 1, 0, 100, 2),
    (default, 3, 1, 0, 100, 3),
    (default, 4, 1, 0, 100, 4),

    (default, 4, 2, 0, 100, 3),
    (default, 2, 2, 0, 100, 1),

    (default, 4, 3, 0, 100, 3),
    (default, 2, 3, 0, 100, 3),

    (default, 2, 4, 0, 100, 1),
    (default, 3, 4, 0, 100, 4),
    
    (default, 2, 5, 0, 100, 2),

    (default, 2, 6, 0, 100, 4);

-- Contre indication
insert into effets_medicaments values
    (default, 2, 1, 0, 100, -4);