SELECT Kürzel, AVG(Gewichtung) as Durchschnittsgewichtung FROM fach f, prüfung p
WHERE f.ID_Fach = p.ID_Fach
GROUP BY Kürzel
ORDER BY Kürzel DESC;