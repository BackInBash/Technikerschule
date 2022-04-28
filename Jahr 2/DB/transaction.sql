CREATE PROCEDURE transaction()
BEGIN
	DECLARE SID INTEGER DEFAULT 1;
	START TRANSACTION;
	
	SET AUTOCOMMIT = OFF;
	
	SELECT 
	    SupplierID
	INTO
		SID
	FROM
	    suppliers
	WHERE
	    CompanyName = "Nord-Ost-Fisch Handelsgesellschaft mbH";
	
	INSERT INTO products
	    (ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued)
	VALUES
	    ('Lakritz', SID, 3, 10, 1.2, 100, 0, 10, 0);
	
	IF SID > 1 THEN
	    COMMIT;
	ELSE
		ROLLBACK;
	END IF;
END