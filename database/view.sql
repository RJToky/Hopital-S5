create view v_medicaments_symptomes as(
    select m.*, ef.id_symptome, ef.age_debut, ef.age_fin, ef.effet
    from effets_medicaments ef
    join medicaments m on m.id = ef.id_medicament
);