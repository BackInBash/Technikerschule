SELECT * FROM mitarbeiter m , lieferantenbestellungen l , lieferanten l2 
WHERE m.mitarbeiternummer = l.mitarbeiternummer 
AND l.lieferantennummer = l2.lieferernummer
AND l2.name = "Kurt Misper, Hardware";