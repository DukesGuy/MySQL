-- How many employees with each title were born after 1965-01-01?

SELECT COUNT(*) AS 'Num Titles', title 
FROM employees e
INNER JOIN titles t ON t.emp_no = e.emp_no
WHERE birth_date > '1965-01-01'
GROUP BY t.title


-- What is the average salary per title?

SELECT format(avg(s.salary),2) AS 'Average Salary', title AS Title
FROM salaries s
INNER JOIN titles t USING (emp_no)
GROUP BY t.title 


-- How much money was spent on salary for the marketing department from 1990 to 1992?

SELECT dept_name AS Department, sum(s.salary) AS 'Total Salary'
FROM salaries s 
INNER JOIN dept_emp de ON s.emp_no = de.emp_no
INNER JOIN departments d ON d.dept_no = de.dept_no
WHERE d.dept_name = 'Marketing'
AND YEAR(s.from_date) >= 1990 AND YEAR(s.to_date) <= 1992