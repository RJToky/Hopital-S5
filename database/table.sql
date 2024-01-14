create database hopital;
\c hopital

drop table maladies cascade;
drop table symptomes cascade;
drop table maladies_symptomes cascade;
drop table medicaments cascade;
drop table effets_medicaments cascade;

create table maladies(
    id serial primary key,
    nom varchar(100) not null
);

create table symptomes(
    id serial primary key,
    nom varchar(100) not null
);

create table maladies_symptomes(
    id serial primary key,
    id_maladie int references maladies(id),
    id_symptome int references symptomes(id),
    age_debut int not null,
    age_fin int not null,
    effet_min int not null,
    effet_max int not null
);

create table medicaments(
    id serial primary key,
    nom varchar(100) not null,
    prix int not null
);

create table effets_medicaments(
    id serial primary key,
    id_medicament int references medicaments(id),
    id_symptome int references symptomes(id),
    age_debut int not null,
    age_fin int not null,
    effet int not null
);