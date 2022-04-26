# MySQL Transaktionen
SQL Transaktionen bilden einen Verbund aus mehreren SQL-Statements, die in direktem Zusammenhang stehen.
Beispielsweise bei einer Bestellung hier wäre es von Nöten, Einträge in der Tabelle, Bestellungen und Produkte zu erstellen.

Da dies in separaten SQL Statements passiert, diese aber direkt voneinander abhängig sind, könnte es durch einen
Fehler in einen der SQL-Statements zu einem inkonsistenten Zustand der Datenbank kommen.

Um dies zu verhindern, werden Transaktionen eingeführt. In Transaktionen werden mehrere voneinander anhängige SQL Statements zusammengefasst.
Sollte die Ausführung eines Statements in einer Transaktion fehlschlagen, werden alle bis dahin durchgeführten Änderungen auf der Datenbank
rückgängig gemacht. Somit wird verhindert, dass es hier zu einem inkonsistenten Zustand in der Datenbank kommen kann.

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

Dies bedeutet, dass die Änderungen, die in einer Transaktion ausgeführt werden, bis zum `COMMIT` oder `ROLLBACK` nur in der aktuellen Session bestehen.

Zum Rollback wird anstatt `COMMIT` das `ROLLBACK` Statement ausgeführt.
```sql
ROLLBACK;
```