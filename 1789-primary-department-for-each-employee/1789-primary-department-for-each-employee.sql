# Write your MySQL query statement below
SELECT
employee_id,
department_id
FROM Employee e

where primary_flag='Y'
OR employee_id IN(
    SELECT 
    employee_id
    from employee
    group by employee_id
    having count(distinct department_id)='1'
);