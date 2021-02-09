SELECT Nachname, Kürzel, Bezeichnung FROM lehrer, amt, ausübung
WHERE lehrer.ID_Lehrer = ausübung.ID_Lehrer 
AND ausübung.ID_Amt = amt.ID_Amt;