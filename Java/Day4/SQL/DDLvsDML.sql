-- DML vs DDL -- 

/*
DDL - Data Definition Language 
	-> SQL commands that are used create, drop, and modify database objects (not the data itself, but the where data sits)
		- CREATE - creates a new table
		- ALTER - modify the structure of an existing table
		- DROP	- deletes a table and all of its data 
		- TRUNCATE - removes all the data from the table, but keeps the table
		
		
DML - Data Manipulation Language
	-> SQL commands that are used to add, delete, and edit data in your tables
		- INSERT - adds new data into your table
		- UPDATE - modifies the data of an existing table
		- DELETE - removes specified data from a table
		- SELECT - retrieves data from one or more tables

*/

 -- Inserts values into a table --
INSERT INTO library (Name, Location)
VALUES ('Piedmont Library', 'Georgia'),
	('Memorial Library', 'Texas'),
	('Little Free Library', 'Georgia'),
	('Golden Gate Library', 'California'),
	('Willow Creek Library', 'North Carolina');


-- deletes a specific row --
DELETE FROM library
WHERE Library_Id = 1;

-- deletes a specified range --
DELETE FROM library
WHERE library_id BETWEEN 2 AND 4;

-- modifies a value of a specified row -- 
UPDATE library
SET Name = 'Shallow Creek Library'
WHERE library_Id = 10;

-- modifies the value of specified rows using LIKE --
-- LIKE returns records that contain a specific letter or phrase --
-- %GEO , GEO%, %GEO% --
UPDATE library
SET Name = 'Georgia Library'
WHERE Location LIKE '%Geo%';

SELECT * FROM library;






