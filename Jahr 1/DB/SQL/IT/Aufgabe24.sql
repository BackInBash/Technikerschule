SELECT sum(a4.einstandspreis-a3.auftragspreis) as Gewinn
FROM auftraege a2, auftragspositionen a3, artikel a4 
WHERE a2.auftragsnummer = a3.auftragsnummer 
AND a3.artikelnummer = a4.ArtikelNr
AND a2.auftragsnummer = "VA00-006";