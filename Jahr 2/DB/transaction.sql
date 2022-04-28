CREATE PROCEDURE transaction()
BEGIN
    # SupplierID Variabel
	DECLARE SID INTEGER DEFAULT 1;
	START TRANSACTION;
	
    # Disable Autocommit
	SET AUTOCOMMIT = OFF;
	
    # Select SupplierID from Name
	SELECT 
	    SupplierID
	INTO
		SID
	FROM
	    suppliers
	WHERE
	    CompanyName = "Nord-Ost-Fisch Handelsgesellschaft mbH";
	
    # Insert new Product with Supplier Infos
	INSERT INTO products
	    (ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued)
	VALUES
	    ('Lakritz', SID, 3, 10, 1.2, 100, 0, 10, 0);
	
    # Check if SupplierID is valid
	IF SID > 1 THEN
        # Commit Changes
	    COMMIT;
	ELSE
        # Rollback Changes
		ROLLBACK;
	END IF;
END