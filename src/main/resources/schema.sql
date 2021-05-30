DROP TABLE IF EXISTS coupon;
CREATE TABLE coupon(
    id INT PRIMARY KEY, 
    use_min_amount INT,  
    discount_amount INT,  
    usable_from DATE,
    usable_until DATE,
    status VARCHAR(10)
);
