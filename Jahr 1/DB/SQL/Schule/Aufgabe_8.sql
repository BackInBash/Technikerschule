SELECT Ort, count(ort) as Anzahl FROM schüler
GROUP BY Ort
HAVING count(Ort) > 3;