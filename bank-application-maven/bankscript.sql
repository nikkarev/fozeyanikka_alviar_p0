CREATE TABLE account_info(
	account_number INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, 
	account_type VARCHAR(10), 
	balance NUMERIC(6,2)
	amount NUMERIC(6,2)
	);

CREATE TABLE customer_info(
	first_name VARCHAR(15) NOT NULL,
	last_name VARCHAR(15) NOT NULL
	username VARCHAR(20) NOT NULL, 
	password VARCHAR(20) NOT NULL,
	account_login 
	);

CREATE TABLE transaction_info(
	transaction_number INT GENERATED ALWAYS AS IDENTITY, 
	account_number INT, 
	transaction_amount INT, 
	PRIMARY KEY (transaction_number), 
	FOREIGN KEY (account_number) REFERENCES account_info(account_number));