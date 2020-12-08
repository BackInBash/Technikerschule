SELECT anrede, name, count(auftragsnummer) as aufträge
FROM auftraege a2, kunde k2 
WHERE a2.kundennummer = k2.kundennummer;