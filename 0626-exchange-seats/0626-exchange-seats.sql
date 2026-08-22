# Write your MySQL query statement below
SELECT 
id,
CASE
WHEN id % 2 = 1 THEN COALESCE(LEAD(student)OVER (ORDER by id),student)
ELSE LAG(student) OVER (ORDER BY id)
END AS student
FROM seat
ORDER by id ASC
