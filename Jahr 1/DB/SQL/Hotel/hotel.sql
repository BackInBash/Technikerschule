-- bestellung definition

CREATE TABLE bestellung (
	BestellID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	ProduktID INTEGER NOT NULL,
	Tischnummer INTEGER NOT NULL,
	Anzahl INTEGER NOT NULL,
	Bestellzeitpunkt TEXT NOT NULL,
	Servicezeitpunkt TEXT NOT NULL
);


-- produkt definition

CREATE TABLE produkt (
	produktID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
, Bezeichnung TEXT NOT NULL, Preis INTEGER NOT NULL);


-- tisch definition

CREATE TABLE tisch (
	tischID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
, AnzahlPlätze INTEGER NOT NULL);