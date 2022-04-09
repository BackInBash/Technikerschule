# Stored Procedures
Exemplarischer Aufbau eines Stored Procedures.

## Variablen Deklaration
Die Variablendeklaration leitet den gebinn eines Stored Procedures ein.
Variablen sollten zu allererst deklariert werden.

Beispielhafte Variablendeklaraion:
```SQL
DECLARE test VARCHAR(256);
DECLARE test1 INTEGER;
DECLARE test2 BOOLEAN DEFAULT TRUE;
```

Datentypen:
Datentyp|Initialisierung
--|--|
INTEGER|-|
VARCHAR|1-265
BOOLEAN|True, False


## Cursor
Unter die Variablendeklaration fält auch die `CURSOSR` Deklaration.
Diese ist für den Loop eine Liste an werden die iteriert werden kann.

Beispieldeklaration: 
```SQL
DECLARE iterator CURSOR FOR
    SELECT id
    FROM tabelle
    WHERE wert1 = wert2;
```

Um den `CURSOR` später verwenden zu können, muss dieser erst geöffnet werden:
```SQL
OPEN iterator;
```

Im Anschluss kann dieser in einer Schleife verwendet werden.
```SQL
DECLARE testVar VARCHAR(256);
schleife: LOOP
    FETCH iterator INTO testVar;
END LOOP;
```

## Continue Handler
Handler sind Ereignese / Fehler die abgefangen werden.
Für eine Schleife ist es nötige einen `NOT FOUND` Handler zu erstellen, damit das ende einer Schleife detektiert werden kann.

Beispiel einer Handlerdeklaration: 
```SQL
DECLARE CONTINUE HANDLER
    FOR NOT FOUND SET weitermachen = FALSE;
```

Beispiel einer Handlerabfrage:
```SQL
IF weitermachen = FALSE THEN
    LEAVE schleife;
END IF;
```