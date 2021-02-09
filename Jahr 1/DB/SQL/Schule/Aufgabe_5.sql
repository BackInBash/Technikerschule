SELECT Nachname, l.Kürzel, Bezeichnung FROM lehrer l, fach f, lehrt l2 
WHERE l.ID_Lehrer = l2.ID_Lehrer 
AND l2.ID_Lehrer = l.ID_Lehrer;