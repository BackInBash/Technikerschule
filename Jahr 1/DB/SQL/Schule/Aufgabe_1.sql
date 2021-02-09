SELECT Nachname, Kürzel, Bezeichnung FROM lehrer, klasse
WHERE lehrer.ID_Lehrer = klasse.ID_Lehrer;