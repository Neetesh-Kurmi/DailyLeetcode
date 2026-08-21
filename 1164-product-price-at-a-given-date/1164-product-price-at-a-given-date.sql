WITH LatestPrices AS(
    SELECT 
    product_id,
    new_price,
    RANK() OVER(
        PARTITION BY product_id
        ORDER BY change_date DESC
    ) AS rnk
    FROM Products
    WHERE change_date <= '2019-08-16'
)
SELECT
P.PRODUCT_ID,
IFNULL(lp.new_price,10) AS price
FROM (
    SELECT DISTINCT product_id
    FROM Products
) p
LEFT JOIN LatestPrices lp
ON p.product_id= lp.product_id
AND lp.rnk = 1;