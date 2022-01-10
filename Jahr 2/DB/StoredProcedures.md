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

### Parameter

**IN**
Der `IN` Parameter ist der Standardparameter, dabei werden den Procedure Parameter die in das Query eingebau werden übergeben.

Wird im Stored Procedure der `IN` Parameter verändert, geschiet dies nur zur Laufzeit die eventuellen Änderungen werden nicht zum Anfrager zurückübertragen.

__Statement__:
```sql
CREATE PROCEDURE GetOfficeByCountry(
	IN countryName VARCHAR(255)
)
BEGIN
	SELECT * 
 	FROM offices
	WHERE country = countryName;
END
```
__Call__:
```sql
CALL GetOfficeByCountry('USA');
```

**OUT**
Der `OUT` Parameter kann zur Laufzeit im Stored Procedure abgeändert werden, dabei werden die Änderungen auch an den Client zurückgemeldet.
Der `OUT` Parameter kann nicht im Query verwendet werden, er dient lediglich zum extrahieren von Daten.

__Statement__:
```sql
CREATE PROCEDURE GetOrderCountByStatus (
	IN  orderStatus VARCHAR(25),
	OUT total INT
)
BEGIN
	SELECT COUNT(orderNumber)
	INTO total
	FROM orders
	WHERE status = orderStatus;
END
```

__Call__:
```sql
CALL GetOrderCountByStatus('Shipped',@total);
SELECT @total as total_in_process;
```

**INOUT**
Der `INOUT` Parameter bietet zum einen die Möglichkeit Übergabeparameter an das Query zu übergeben und zum anderen lässt sich der veränderte Parameter nach ausführung des Queries mit den veränderten Werten an den Client zurückügertragen.

__Statement__:
```sql
CREATE PROCEDURE SetCounter(
	INOUT counter INT,
    IN inc INT
)
BEGIN
	SET counter = counter + inc;
END
```

__Call__:
```sql
SET @counter = 1;
CALL SetCounter(@counter,1); -- 2
CALL SetCounter(@counter,1); -- 3
CALL SetCounter(@counter,5); -- 8
SELECT @counter; -- 8
```

## Statements

**IF**

> IF Statements haben einen Bash ähnlichen Syntax

```sql
CREATE PROCEDURE GetCustomerLevel(
    IN  pCustomerNumber INT, 
    OUT pCustomerLevel  VARCHAR(20))
BEGIN
    DECLARE credit DECIMAL(10,2) DEFAULT 0;

    SELECT creditLimit 
    INTO credit
    FROM customers
    WHERE customerNumber = pCustomerNumber;

    IF credit > 50000 THEN
        SET pCustomerLevel = 'PLATINUM';
    END IF;
END
```

Erweiterungen `ELSE` und `ELSEIF`

**CASE**

SQL Switch Case Statement

```sql
    CASE customerCountry
		WHEN  'USA' THEN
		   SET pShipping = '2-day Shipping';
		WHEN 'Canada' THEN
		   SET pShipping = '3-day Shipping';
		ELSE
		   SET pShipping = '5-day Shipping';
	END CASE;
```

Es können auch vergleiche als CASE Statment verwendert werden.

```sql
CASE 
		WHEN waitingDay = 0 THEN 
			SET pDeliveryStatus = 'On Time';
        WHEN waitingDay >= 1 AND waitingDay < 5 THEN
			SET pDeliveryStatus = 'Late';
		WHEN waitingDay >= 5 THEN
			SET pDeliveryStatus = 'Very Late';
		ELSE
			SET pDeliveryStatus = 'No Information';
	END CASE;
```

**LOOP**

Endlosschlefe mit Austiegsbedingung

```sql
CREATE PROCEDURE LoopDemo()
BEGIN
	DECLARE x  INT;
	DECLARE str  VARCHAR(255);
        
	SET x = 1;
	SET str =  '';
        
	loop_label:  LOOP # <-- Start Loop
		IF  x > 10 THEN 
			LEAVE  loop_label; # <-- Break
		END  IF;
            
		SET  x = x + 1;
		IF  (x mod 2) THEN
			ITERATE  loop_label;
		ELSE
			SET  str = CONCAT(str,x,',');
		END  IF;
	END LOOP; # <-- End Loop
	SELECT str;
END
```

**WHILE**

While Loop in SQL

```sql
CREATE PROCEDURE LoadCalendars(
    startDate DATE, 
    day INT
)
BEGIN
    
    DECLARE counter INT DEFAULT 1;
    DECLARE dt DATE DEFAULT startDate;

    WHILE counter <= day DO # <-- While loop mit Bedingung
        CALL InsertCalendar(dt);
        SET counter = counter + 1;
        SET dt = DATE_ADD(dt,INTERVAL 1 day);
    END WHILE; # <-- End Loop
END
```

**LEAVE**

SQL equivalent zu `Break`

```sql
CREATE PROCEDURE sp_name()
sp: BEGIN
    IF condition THEN
        LEAVE sp; # <-- Leave sp Label
    END IF;
    -- other statement
END
```

*Error Handling**

```sql
CREATE PROCEDURE InsertSupplierProduct(
    IN inSupplierId INT, 
    IN inProductId INT
)
BEGIN
    -- exit if the duplicate key occurs
    DECLARE EXIT HANDLER FOR 1062
    BEGIN
 	SELECT CONCAT('Duplicate key (',inSupplierId,',',inProductId,') occurred') AS message;
    END;
    
    -- insert a new row into the SupplierProducts
    INSERT INTO SupplierProducts(supplierId,productId)
    VALUES(inSupplierId,inProductId);
    
    -- return the products supplied by the supplier id
    SELECT COUNT(*) 
    FROM SupplierProducts
    WHERE supplierId = inSupplierId;
    
END
```