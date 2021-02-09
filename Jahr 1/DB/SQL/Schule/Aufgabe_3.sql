SELECT f.Kürzel, l.Kürzel, Datum, Gewichtung FROM fach f, lehrer l, prüfung p
WHERE l.ID_Lehrer = p.ID_Lehrer 
AND p.ID_Fach = f.ID_Fach;