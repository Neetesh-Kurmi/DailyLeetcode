# Write your MySQL query statement below
SELECT
r.contest_id,
ROUND(count(r.user_id)*100.0/(SELECT count(*) from Users),2 ) AS percentage
FROM Users u
JOIN Register r
ON u.user_id = r.user_id
Group by r.contest_id
ORDER BY percentage DESC , r.contest_id ;

