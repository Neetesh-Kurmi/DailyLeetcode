# Write your MySQL query statement below
SELECT 
query_name,
ROUND(SUM(rating<3)*100/COUNT(*),2) AS poor_query_percentage,
ROUND (AVG(rating/position),2) AS quality
FROM Queries
GROUP BY query_name
ORDER by query_name;