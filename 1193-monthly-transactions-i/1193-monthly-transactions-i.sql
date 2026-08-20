# Write your MySQL query statement below
SELECT
COUNT(*) AS trans_count,
DATE_FORMAT(trans_date,'%Y-%m') AS month,
country,
SUM(state='approved') AS approved_count,
SUM(amount) as trans_total_amount,
SUM(IF(state='approved',amount,0)) AS approved_total_amount
FROM Transactions
GROUP BY DATE_FORMAT(trans_date,'%Y-%m'),country;


