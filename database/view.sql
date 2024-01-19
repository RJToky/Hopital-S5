drop view v_medicaments_symptomes cascade;

create view v_medicaments_symptomes as(
    select row_number() over (order by m.id) id, m.id id_medicament, m.nom, m.prix, ef.id_symptome, ef.age_debut, ef.age_fin, ef.effet
    from effets_medicaments ef
    join medicaments m on m.id = ef.id_medicament
);