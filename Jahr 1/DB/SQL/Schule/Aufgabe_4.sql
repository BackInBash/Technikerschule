SELECT l.Kürzel, f.Kürzel, f.Bezeichnung FROM lehrer l, klasse k, fach f, lehrt l2 
WHERE l.ID_Lehrer = l2.ID_Lehrer 
AND l2.ID_Fach = f.ID_Fach
AND l.ID_Lehrer = k.ID_Lehrer;