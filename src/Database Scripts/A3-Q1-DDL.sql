CREATE TABLE students (
	student_id	SERIAL PRIMARY KEY,
	first_name	varchar(225) NOT NULL,
	last_name	varchar(225)	NOT NULL,
	email		varchar(225)	NOT NULL,
	enrollment_date	Date	DEFAULT CURRENT_DATE
);