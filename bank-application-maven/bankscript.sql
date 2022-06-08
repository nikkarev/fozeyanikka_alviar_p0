CREATE TABLE account_info(
	account_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, 
	customer_id INT,
	balance NUMERIC(6,2),
	CONSTRAINT fk_customer
      FOREIGN KEY(customer_id) 
	  REFERENCES customer(customer_id)
	  ON DELETE SET NULL
	);

CREATE TABLE customer_info(
	customer_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	account_id INT,
	first_name VARCHAR(15) NOT NULL,
	last_name VARCHAR(15) NOT NULL,
	username VARCHAR(20) NOT NULL, 
	password VARCHAR(20) NOT NULL
	);
