# Write your MySQL query statement below
select unique_id ,name from Employees as e LEFT JOIN EmployeeUNI as eU on e.id = eU.id;