# Stored Procedures
Stored Procedures sind SQL Queries die auf dem Server abgespeichert sind. Vorteile und Funktionalitäten von Stored Procedures sind:
### Funktionalitäten
+ Es können Übergabeparamter übergeben werden
+ Es können Statements eingebaut werden wie `IF` `CASE` oder `LOOP`
+ Es können andere Stored Procedures aufberufen werden. (Modularität)

### Vorteile
+ Schnellere Ausführung, da das Query Kompiled im Cache gehalten wird
+ Weniger Traffic zum SQL Server, da nur der Name der Funktion und nicht das Query selbst übertragen werden muss
+ Business Logik zentral im SQL Server
+ Security, es können nur festgelegte Queries auf der Datenbank ausgeführt werden.

### Nachteile
+ Erhöhter Ressourcenverbrauch auf dem Server, durch die Verarbeitung der Queries.
+ Schlechte Debugging Möglichkeiten
+ Der Betrieb und die Wartung der Queries erfordert geschultes Personal.

### Aufbau

In der Datenbank:
```sql
CREATE PROCEDURE GetCustomers()
BEGIN
	SELECT 
		customerName, 
		city, 
		state, 
		postalCode, 
		country
	FROM
		customers
	ORDER BY customerName;    
END
```

Im Client:
```sql
CALL GetCustomers()
```