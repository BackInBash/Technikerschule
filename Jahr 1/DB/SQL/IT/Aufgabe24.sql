SELECT a3.auftragspreis-a4.einstandspreis as Gewinn
FROM auftraege a2, auftragspositionen a3, artikel a4 
WHERE a2.auftragsnummer = a3.auftragsnummer 
AND a3.artikelnummer = a4.ArtikelNr
AND a2.auftragsnummer = "VA00-006"
GROUP BY a2.auftragsnummer;