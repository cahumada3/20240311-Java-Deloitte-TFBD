-- DATA Types -- 
/*
	SERIAL
	
	CHAR
	VARCHAR
	TEXT
	
	INTEGER
	SMALLINT
	BIGINT
	DECIMAL or DEC
	FLOAT
	
	BOOLEAN or BOOL
	
	DATE
	TIME
	TIMESTAMP
	
*/

-- AND operator --
SELECT * FROM track
WHERE genre_id = 2 AND milliseconds > 300000;

-- ORDER BY - used to sort a result in ascending order or descending order --
SELECT * FROM track
ORDER BY album_id DESC;

-- Built-in Functions --
-- AS - used as an alias, to change the column name of a retrieved record --
SELECT MAX(total) AS max_total
FROM invoice;

SELECT MIN(total) AS min_total
FROM invoice;

SELECT SUM(total) AS total_sum
FROM invoice;

SELECT AVG(total) AS total_avg
FROM invoice;

SELECT COUNT(total) AS total_count
FROM invoice;

SELECT * FROM invoice;

SELECT * FROM track;


-- 1. Provide a query showing Cutomers who are not in the US --
SELECT first_name, last_name, address, country
FROM customer
WHERE country != 'USA'; -- WHERE NOT also works --

-- 2. Provide a query showing the invoices of cutomers who are from Brazil --
SELECT * FROM invoice
WHERE billing_country = 'Brazil';


-- JOINS --

/*
INNER JOIN
- returns records that have matching values in both tables
*/

/*
LEFT JOIN
- return all records from your left table and any matching records from the right table
*/

/*
RIGHT JOIN
- Returns all records from your right table and any matching records from you left table
*/

/*
FULL JOIN
- Returns all records from both tables
*/

-- 3. Provide a query that shows the Invoice Total, Customer full name, Country, Sales agent name for all invoices and cutomers --
SELECT e.first_name AS Employee_First, e.last_name AS Employee_Last, c.first_name AS Customer_First, c.last_name AS Customer_Last, c.country, i.total
FROM employee AS e
JOIN customer AS c ON e.employee_id = c.support_rep_id
JOIN invoice AS i ON c.customer_id = i.customer_id;

-- 4. Provide a query that includes the purchased track name and the artist name with each invoice line item
SELECT i.*, t.name AS track_name, a.name AS artist_name
FROM invoice_line AS i
JOIN track AS t ON i.track_id = t.track_id
JOIN album AS al ON t.album_id = al.album_id
JOIN artist AS a ON al.artist_id = a.artist_id;

-- 5. Provide a query that find which sales agent made the most sales in 2021
SELECT MAX(total_sum) AS total_sum
FROM (SELECT e.*, SUM(i.total) AS Total_sum
FROM employee AS e
JOIN customer As c ON e.employee_id = c.support_rep_id
JOIN invoice AS i ON i.customer_id = c.customer_id
WHERE i.invoice_date BETWEEN '2021-01-01' AND '2021-12-31'
GROUP BY e.employee_id) AS total_sum;


-- clemente's query --
SELECT CONCAT(first_name, ' ', last_name) AS employee_name, total_sales_amt
FROM (
	SELECT SUM(i.total) AS total_sales_amt, e.*
	FROM employee AS e
	INNER JOIN customer AS c ON c.support_rep_id = e.employee_id
	INNER JOIN invoice AS i ON c.customer_id = i.customer_id
	WHERE i.invoice_date BETWEEN '2021-01-01' AND '2021-12-31'
	GROUP BY (e.employee_id)
) ORDER BY total_sales_amt DESC LIMIT 1;


SELECT * FROM customer;

