# Write your MySQL query statement below
SELECT
e.name
FROM Employee AS e
JOIN Employee AS m
ON e.id= m.managerId
GROUP By
m.managerId
HAVING COUNT(m.id)>=5;