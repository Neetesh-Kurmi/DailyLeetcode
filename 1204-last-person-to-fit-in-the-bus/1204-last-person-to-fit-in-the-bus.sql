# Write your MySQL query statement below
WITH CumulativeQueue AS(
    SELECT
person_name,
turn,
SUM(weight) OVER (ORDER BY turn ASC) AS total_weight
FROM Queue
)
SELECT 
person_name
FROM CumulativeQueue
WHERE total_weight <=1000
ORDER BY turn DESC
LIMIT 1;

