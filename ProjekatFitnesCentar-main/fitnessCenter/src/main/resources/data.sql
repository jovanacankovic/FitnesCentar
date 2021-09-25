insert into ADMINISTRATOR(id,aktivan,da_li_je_registrovan,DATUMRODJENJA,email,ime,korisnickoime,lozinka,prezime,telefon,uloga)
values (7,'true','true','1998-08-11','jcankovic98@gmail.com','Jovana','jcankovic','jovana1','Cankovic','0691108898',0);
insert into ADMINISTRATOR(id,aktivan,da_li_je_registrovan,DATUMRODJENJA,email,ime,korisnickoime,lozinka,prezime,telefon,uloga)
values (2,'true','true','1997-01-01','markoal@gmail.com','Marko','almarko','123456','Aleksic','065487577',0);

insert into CLAN(id,aktivan,da_li_je_registrovan,DATUMRODJENJA,email,ime,korisnickoime,lozinka,prezime,telefon,uloga)
values (10,'true','true','1994-02-03','marijana@gmail.com','Marijana','pmarijana','mp1212','Peric','062545875',2);
insert into CLAN(id,aktivan,da_li_je_registrovan,DATUMRODJENJA,email,ime,korisnickoime,lozinka,prezime,telefon,uloga)
values (11,'false','true','1994-02-03','biljana@gmail.com','Biljana','mbiljna','bbbb','Marinkov','062545875',2);

insert into TRENER(id,aktivan,da_li_je_registrovan,DATUMRODJENJA,email,ime,korisnickoime,lozinka,prezime,telefon,uloga,prosecna_ocena)
values (20,'true','true','1994-02-03','trener1@gmail.com','Aleksa','aleksam','alex','Mirkov','062545875',1,5);
insert into TRENER(id,aktivan,da_li_je_registrovan,DATUMRODJENJA,email,ime,korisnickoime,lozinka,prezime,telefon,uloga,prosecna_ocena)
values (21,'true','true','1994-02-03','trener2@gmail.com','Milena','milenad ','md','Dragic','062545875',1,3);

insert into TRENING(id,naziv,opis,tiptreninga,trajanje,trener_id)
values (30,'Kardio','Kardio trening za zene','KARDIO',30,20);
insert into TRENING(id,naziv,opis,tiptreninga,trajanje,trener_id)
values (31,'Joga','Joga za zene','JOGA',60,20);
insert into TRENING(id,naziv,opis,tiptreninga,trajanje,trener_id)
values (32,'Pilates','Pilates lagani trening','PILATES',70,20);
insert into TRENING(id,naziv,opis,tiptreninga,trajanje,trener_id)
values (33,'Crossfit','Tezak trening','CROSSFIT',70,20);
insert into TRENING(id,naziv,opis,tiptreninga,trajanje,trener_id)
values (34,'Crossfit','Lagani crossfit','CROSSFIT',30,20);
insert into TRENING(id,naziv,opis,tiptreninga,trajanje,trener_id)
values (35,'Joga','Jutarnja joga','JOGA',30,20);


insert into FITNESS_CENTAR(id,naziv_centra,adresa_centra,broj_telefona_centrale,email_centra)
values (101,'BeFit1','Vojvodjanskih Brigada 10','0698574584','befit1@yahoo.com');
insert into FITNESS_CENTAR(id,naziv_centra,adresa_centra,broj_telefona_centrale,email_centra)
values (102,'BeFit2','Marsala Tita 32','03254685','befit2@yahoo.com');
insert into FITNESS_CENTAR(id,naziv_centra,adresa_centra,broj_telefona_centrale,email_centra)
values (103,'BeFit3','Borisa Kidrica 58','02145789','befit3@yahoo.com');

insert into SALA(id,oznaka,kapacitet,fitness_centar_id)
values (301,'S1',30,103);
insert into SALA(id,oznaka,kapacitet,fitness_centar_id)
values (302,'S2',30,103);
insert into SALA(id,oznaka,kapacitet,fitness_centar_id)
values (303,'S3',30,103);


insert into LISTA_TRENINGA(id,broj_prijavljenih,cena,datum_kraja_treninga,datum_pocetka_treninga,fitness_centar_id,sala_id,trening2_id)
values (801,30,500,'2021-02-03','2021-02-03',103,301,35);
insert into LISTA_TRENINGA(id,broj_prijavljenih,cena,datum_kraja_treninga,datum_pocetka_treninga,fitness_centar_id,sala_id,trening2_id)
values (802,70,200,'2021-03-03','2021-03-03',103,301,34);

insert into OCENA_TRENINGA(id,ocena,clan_id,termin_id,trening_id)
values(555,5,10,801,801);





insert into ODRADJENI_TRENINZI(clan_id,trening_id)
values (10,801);
insert into ODRADJENI_TRENINZI(clan_id,trening_id)
values (10,802);
insert into ODRADJENI_TRENINZI(clan_id,trening_id)
values (11,801);
insert into ODRADJENI_TRENINZI(clan_id,trening_id)
values (11,802);

insert into PRIJAVLJENI_TRENINZI(clan_id,trening_id)
values (10,801);
insert into PRIJAVLJENI_TRENINZI(clan_id,trening_id)
values (11,801);
insert into PRIJAVLJENI_TRENINZI(clan_id,trening_id)
values (10,802);



