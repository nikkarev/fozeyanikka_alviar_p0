CREATE TABLE account_info(
	account_number INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, 
	customer_id INT,
	account_type VARCHAR(10), 
	balance NUMERIC(6,2),
	amount NUMERIC(6,2)
	);
	
	ALTER TABLE account_info 
		ADD CONSTRAINT customer_fk 
			FOREIGN KEY (customer_id) 
				REFERENCES customer_info(customer_id);


CREATE TABLE customer_info(
	customer_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	account_number INT,
	first_name VARCHAR(15) NOT NULL,
	last_name VARCHAR(15) NOT NULL,
	username VARCHAR(20) NOT NULL, 
	password VARCHAR(20) NOT NULL
	);
	
	ALTER TABLE customer_info 
		ADD CONSTRAINT foreign_key 
			FOREIGN KEY (account_number) 
				REFERENCES account_info (account_number);
				
CREATE TABLE deleted_customer(
	
	);

CREATE TABLE transaction_info(
	transaction_number INT GENERATED ALWAYS AS IDENTITY, 
	account_number INT, 
	transaction_amount INT, 
	PRIMARY KEY (transaction_number), 
	FOREIGN KEY (account_number) REFERENCES account_info(account_number));