# Write your MySQL query statement below
with allFriends AS(
    SELECT requester_id AS id From RequestAccepted
    UNION ALL
    SELECT accepter_id AS id from RequestAccepted
)
SELECT
id,
COUNT(*) AS num
From allFriends
GROUP BY id
ORDER BY num DESC
LIMIT 1;
