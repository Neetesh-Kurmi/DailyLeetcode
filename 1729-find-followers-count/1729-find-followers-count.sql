# Write your MySQL query statement below
SELECT 
user_id,
COUNT(follower_id) AS Followers_count
FROM Followers
GROUP By user_id
ORDER BY user_id ASC;
