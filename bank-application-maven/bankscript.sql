CREATE TABLE account_info(
	account_number INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, 
	account_type VARCHAR(10), 
	current_balance NUMERIC(6,2));

CREATE TABLE customer_info(
	customer_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, 
	password VARCHAR(20) NOT NULL,
	account_login );

CREATE TABLE transaction_info(
	transaction_number INT GENERATED ALWAYS AS IDENTITY, 
	account_number INT, 
	transaction_amount INT, 
	PRIMARY KEY (transaction_number), 
	FOREIGN KEY (account_number) REFERENCES account_info(account_number));