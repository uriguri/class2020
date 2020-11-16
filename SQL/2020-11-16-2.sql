-- SELECT 추가문제
DESC book;
DESC customer;
DESC orders;

--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.

--(1) 도서번호가 1인 도서의 이름

SELECT *
FROM book
WHERE bookid = 1
;

--(2) 가격이20,000원이상인도서의이름

SELECT bookname
FROM book
WHERE price >= 20000
;

--(3) 박지성의총구매액(박지성의고객번호는1번으로놓고작성)

SELECT *
FROM orders
WHERE custid = 1
;

SELECT SUM(saleprice) AS totalPrice
FROM orders
WHERE custid = (SELECT custid FROM customer WHERE name = '박지성')
;

--(4) 박지성이구매한도서의수(박지성의고객번호는1번으로놓고작성)
-- 박지성의 구매 횟수 = 구매한 도서의 수

SELECT COUNT(*) AS "구매횟수"
FROM orders
WHERE custid = 1
;
​

--2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.

--(1) 마당서점도서의총개수 : book의 총 row의 개수

SELECT COUNT(*) AS "총 개수"
FROM book
;

--(2) 마당서점에도서를출고하는출판사의총개수

SELECT COUNT (DISTINCT publisher)
FROM book
ORDER BY publisher
;

--(3) 모든 고객의이름, 주소

SELECT name, address
FROM customer
;

--(4) 2014년7월4일~7월7일사이에주문받은도서의주문번호

SELECT orderid
FROM orders
WHERE orderdate BETWEEN '2014-07-04' AND '2014-07-07'
;

--(5) 2014년7월4일~7월7일사이에주문받은도서를제외한도서의주문번호

SELECT orderid
FROM orders
WHERE orderdate NOT BETWEEN '2014-07-04' AND '2014-07-07'
;

--(6) 성이‘김’씨인고객의이름과주소

SELECT *
FROM customer 
WHERE name LIKE '김%'
;

--(7) 성이‘김’씨이고이름이‘아’로끝나는고객의이름과주소

SELECT name, address
FROM customer
WHERE name LIKE '김%아'
;
​