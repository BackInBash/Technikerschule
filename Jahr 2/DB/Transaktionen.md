# MySQL Transaktionen
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
        @orderNumber:=MAX(orderNUmber)+1
    FROM
        orders;
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

## Optionen

Die bei MySQL als Standard gesetzte Option `AUTOCOMMIT` speichert nach erfolgreicher Ausführung der Transaktion die Daten in der Datenbank persistent ab.

Um dies abzuschalten, muss in einer Transaktion das folgende Statement enthalten sein, damit wird es nötig, das speichern der Daten manuell zu veranlassen.
```sql
SET AUTOCOMMIT OFF;
```
