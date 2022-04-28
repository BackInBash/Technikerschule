# SQL Transaktionen
SQL Transaktionen bilden einen Verbund aus mehreren SQL-Statements, die in direktem Zusammenhang stehen.
Beispielsweise bei einer Bestellung hier wäre es von Nöten, Einträge in der Tabelle, Bestellungen und Produkte zu erstellen.

Da dies in separaten SQL Statements passiert, diese aber direkt voneinander abhängig sind, könnte es durch einen
Fehler in einen der SQL-Statements zu einem inkonsistenten Zustand der Datenbank kommen.

Um dies zu verhindern, werden Transaktionen eingeführt. In Transaktionen werden mehrere voneinander anhängige SQL Statements zusammengefasst.
Sollte die Ausführung eines Statements in einer Transaktion fehlschlagen, werden alle bis dahin durchgeführten Änderungen auf der Datenbank
rückgängig gemacht. Somit wird verhindert, dass es hier zu einem inkonsistenten Zustand in der Datenbank kommen kann.

Transaktionen sind nach dem **ACID**-Prinzip aufgebaut.
Dies bedeutet, sie besitzen **Atomarität**, sollte die Transaktion abgebrochen werden, hinterlässt diese keine Änderungen auf dem System.
Transaktionen sind **konsistent** nach dem Commit oder Rollback ist die Datenbank in einem Konsistenten zustand ohne Anomalien oder Redundanzen.
Transaktionen sind voneinander **isoliert**, sie können sich gegenseitig nicht beeinflussen.
Transaktionen sind **dauerhaft**, sie speichern Daten nach erfolgreicher Ausführung persistent ab.

## Aufbau einer Transaktion

1. Start der Transaktion
    ```sql
    START TRANSACTION;
    ```

1. Ausführen der SQL Statements
    ```sql
    SELECT
        CompanyName
    FROM 
        products p, suppliers s
    WHERE 
        p.SupplierID = s.SupplierID
    AND 
        p.ProductID = 14;
    ```

1. Abschliesen der Transaktion
    ```sql
    COMMIT;
    ```

## Rollback
Durch einen Rollback, werden die Änderungen, die in der Transaktion ausgeführt wurden, rückgängig gemacht.

Dies bedeutet, dass die Änderungen, die in einer Transaktion ausgeführt werden, bis zum `COMMIT` oder `ROLLBACK` nur in der aktuellen Session bestehen und keine persistenten Auswirkungen auf die Daten haben.

Zum Rollback wird anstatt `COMMIT` das `ROLLBACK` Statement ausgeführt.
```sql
ROLLBACK;
```

### Savepoints
Sogenannte Savepoints sind Zwischenergebnisse in einer Transaktion.
Sie legen fest, bis wohin bei einem Rollback Änderungen zurückgesetzt werden sollen.

Um einen Savepoint anzulegen, genügt es innerhalb einer Transaktion den Befehl und einen Namen für den Savepoint abzusetzen.

```sql
SAVEPOINT xyz;
```

Um zu einem solchen Savepoint zurückzuspringen, muss das Rollback Statement mit dem Zusatz des Savepointnamens aufgerufen werden.

```sql
ROLLBACK xyz;
```


**JDBC Implementierung**

```java
public static void executeTransaction(Connection con) {
    /*
     Create SQL Statement
    */
    try(Statement stmt = con.createStatement();) {
        con.setAutoCommit(false);
        stmt.executeUpdate("INSERT INTO categories(CategoryID, CategoryName, Description) VALUES(3, 'Sweets', 'Desserts and candies')");
        /*
            Create Savepoint
        */
        Savepoint save = con.setSavepoint();
        stmt.executeUpdate("INSERT INTO products(ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued) VALUES('Lakritz', 14, 3, 10, 1.2, 100, 0, 10, 0)");
        /*
            Rollback Changes to Savepoint
        */
        con.rollback(save);
        /*
            Commit Changes
        */
        con.commit();
        System.out.println("Transaction succeeded.");
    }
    catch (SQLException ex) {
        ex.printStackTrace();
        try {
            System.out.println("Transaction failed.");
            con.rollback();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
```

## Optionen

Die bei MySQL als Standard gesetzte Option `AUTOCOMMIT` speichert nach erfolgreicher Ausführung der Transaktion die Daten in der Datenbank persistent ab.

Um dies abzuschalten, muss in einer Transaktion das folgende Statement enthalten sein, damit wird es nötig, das speichern der Daten manuell zu veranlassen.
```sql
SET AUTOCOMMIT OFF;
```

## Isolations Level
Das Isolationslevel hat keine Auswirkung auf die Sperrung der Datenbank, die durch die eigene Transaktion verursacht wurde.
Vielmehr legt es das Verhalten fest, wie auf andere laufende Transaktionen reagiert werden soll.

So ist z. B. bei dem Isolationslevel `READ UNCOMMITTED` ganz egal, ob die von einer anderen Transaktion gerade bearbeitete Tabelle noch nicht vollständig beschrieben ist. So wird die Transaktion dennoch ausgeführt es kann hier unter Umständen zu Inkonsistenten kommen.
Dies wird auch als `dirty read` bezeichnet.

Im Gegenzug werden aber nicht viele Systemressourcen benötigt, da weder ein Lock noch eine revisionssichere Verarbeitung nötig ist.

Dieses Isolationslevel sollte daher nicht eingesetzt werden, höchstens bei Daten, deren Konsistenz keine Priorität haben.

`READ COMMITTED` gibt, an das nur Daten verarbeitet werden können, die momentan nicht von anderen Transaktionen verwendet werden.
Dabei versucht die Datenbank nur so wenig Entitäten wie nötig zu sperren.

Dies geschieht mit einer Mischung aus Index und Row Locks. Hintergrund ist, dass es ansonsten zu Phantom Einträgen in der Datenbank können könnte. Beider neue Datensätze zwischen den in der Transaktion angefragten Datensätze eingeschleust werden könnten.
Somit wären dann in zwei zeitlich voneinander getrennten SELECT Statements jeweils zwei unterschiedliche Datensätze zurückgegeben worden.

Bei `UPDATE` und `DELETE` Statements werden die Locks auf die Datenbank durch die parallele Auswertung der `WHERE` Klausel neben der Ausführung des Queries reduziert indem nicht zu bearbeitende Entitäten werden wieder freigegeben.
Dies hat den Hintergrund, die Wahrscheinlichkeit von Deadlocks zu verringern.

Deadlocks treten auf, wenn zwei Transaktionen auf den Abschluss der jeweils anderen Transaktion warten. Da dies aber nicht eintreten wird, da sich die beiden Transaktionen gegenseitig sperren, spricht man in diesem Zusammenhang von einem Deadlock.

Bei `REPEATABLE READ` werden nur die Datensätze gesperrt, die durch eine eindeutige Suche dem Statement zugeordnet werden können.

Bei der `SERIALIZABLE` Isolationsstufe können keine Daten gelesen werden, für die noch ein Commit Statement aussteht, auch können andere Transaktionen erst auf die Daten zugreifen, wenn die aktuelle Transaktion vollständig abgeschlossen ist.


Eine Übersicht der einzelnen Isolationsstufen und deren Eigenschaften:

Isolationsstufe	|Dirty Read|	Non-Repeatable Read	|Phantom
|--|--|--|--|
Read Uncommitted|	Ja|	Ja|	Ja
Read Committed|	Nein	|Ja|	Ja
Repeatable Read|	Nein|	Nein|	Ja
Serializable	|Nein	|Nein	|Nein
