SELECT Bezeichnung, Laborgruppe, count(Laborgruppe) as Anzahl FROM schüler s, klasse k2
WHERE s.ID_Klasse = k2.ID_Klasse
GROUP BY Bezeichnung, Laborgruppe
ORDER BY Bezeichnung ASC, Laborgruppe DESC