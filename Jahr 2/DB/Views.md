# Database Views

Views sind SQL Queries die in auf dem DB Server gespeichert werden und somit mit einem einfachen Aufruf der View wiederverwendet werden können.

Beispiel View:
```sql
CREATE VIEW customerPayments
AS 
SELECT 
    customerName, 
    checkNumber, 
    paymentDate, 
    amount
FROM
    customers
INNER JOIN
    payments USING (customerNumber);
```

## Vor und Nachteile von Views
**Pro:**
1. Komplexe SQL Queries können in Views gespeichert werden somit kann der erneute Aufruf verinfacht werden.
1. Business Logik zentralisieren, greifen mehrere Programme auf die gleiche Datenbank zu und benötigen die selben Daten. So kann eine View dabei helfen die Queries Programmübergreifend konsistent zu halten.
1. Zugriffsbeschränkung man kann einem Benutzer gestatten nur die View ausführen zu können, somit ist dieser nicht in der Lage andere Informationen aus der Datenbank zu extrahieren.
1. Bei Schemaänderungen kann eine View mit dem alten Namen der Tabelle erstellt werden, somit funktionieren Queries die auf das alte Schema referenzieren noch.

**Con:**
1. Auf Views können keine Indexes erstellt werden.
1. Views mit Sub-Queries, Joins oder Aggregatsfunktionen können nicht angepasst werden.

## Views Verwalten

### Views Erstellen
Syntax:
```SQL
CREATE [OR REPLACE] VIEW [db_name.]view_name [(column_list)]
AS
  select-statement;
```

Beispiel:
```SQL
CREATE VIEW salePerOrder AS
```

Mit dem `WITH CHECK OPTION` Parameter wird der Scope der View auf die Daten die die View (dessen WHERE Klausel) ausgibt beschränkt.
Somit können keine Datensätze außerhab diese Scopes ausgegeben, gelöscht oder bearbeitet werden.

Da Views auch verschachtelt werden können, gibt es die Möglichkeit die `WITH CHECK OPTION` weiter zu Bearbeiten mit den Parametern `LOCAL` und `CASCADED` ist es Möglich den Scope der Checks einzuschränken.

Mit der `WITH LOCAL CHECK OPTION` Option werden nur Bedingungen in der Aufgerufenen View beachtet. Mit der `WITH CASCADED CHECK OPTION` Option dagegen werden alle Bedingungen aller verschachtelten Views beachtet.

**Algorithm**
Der Algorithmus Parameter bestimmt wie die View beim Aufruf durch MySQL verarbeitet werden soll.
Zur Auswahl stehen `MERGE`, `TEMPTABLE` und `UNDEFINDE`.

Syntax:
```SQL
CREATE [OR REPLACE][ALGORITHM = {MERGE | TEMPTABLE | UNDEFINED}] VIEW 
   view_name[(column_list)]
AS 
   select-statement;
```

### Views Entfernen
Syntax:
```SQL
DROP VIEW [IF EXISTS] view_name;
```

Beispiel:
```SQL
DROP VIEW IF EXISTS customerPayments;
```

### Auflisten aller Views
```SQL
SHOW FULL TABLES 
WHERE table_type = 'VIEW';
```
> Da `SHOW FULL Tables` alle Tabellen der Datenbank zurückgibt wird die `WHERE` Klausel benötigt um die Views zu Filtern.

### Views Umbenennen
Syntax:
```SQL
RENAME TABLE original_view_name 
TO new_view_name;
```

Beispiel:
```SQL
RENAME TABLE productLineSales 
TO productLineQtySales;
```

### View Update Queries
Um ein `UPDATE` Query auf einer View auszuführen, darf die View keine Sub-Queries, Joins oder Aggregatsfunktionen enthalten. Sollte die der Fall sein kann ein `UPDATE` Query auf der View ausgeführt werden.

Beispiel:
```SQL
UPDATE officeInfo 
SET 
    phone = '+33 14 723 5555'
WHERE
    officeCode = 4;
```