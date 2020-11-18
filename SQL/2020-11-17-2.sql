-- 마당서점 : join sub query

SELECT * FROM book;
SELECT * FROM customer;
SELECT * FROM orders;

--(5) 박지성이구매한도서의출판사수

SELECT DISTINCT o.bookid
FROM customer c, orders o
WHERE c.custid = o.custid
AND c.name='박지성'
;

SELECT COUNT(DISTINCT publisher)
FROM book
WHERE bookid IN (SELECT DISTINCT o.bookid
                 FROM customer c, orders o
                 WHERE c.custid = o.custid
AND c.name='박지성')
;

-- 조인을 이용한 해결
SELECT COUNT (DISTINCT b.publisher)
FROM customer c, book b, orders o
WHERE o.custid = c.custid AND o.bookid = b.bookid
AND c.name='박지성'
;

--(6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이

SELECT b.bookname, b.price, b.price-o.saleprice
FROM customer c, book b, orders o
WHERE c.custid = o.custid AND b.bookid = o.bookid
AND c.name='박지성'
;


-- 서브쿼리로 표현
SELECT custid FROM customer WHERE name='박지성';

SELECT *
FROM book b, orders o
WHERE b.bookid = o.bookid
AND o.custid = (SELECT custid FROM customer WHERE name='박지성')
;
​

--(7) 박지성이 구매하지 않은 도서의 이름

--  박지성이 구매한 도서의 id
SELECT bookid
FROM orders
WHERE custid = (SELECT custid FROM customer WHERE name='박지성')
;

SELECT * 
FROM book
WHERE bookid NOT IN (SELECT bookid
                     FROM orders
                     WHERE custid = (SELECT custid FROM customer WHERE name='박지성')
);​

-- 조인
SELECT DISTINCT b.bookname
FROM customer c, book b, orders o
WHERE c.custid = o.custid AND b.bookid = o.bookid
AND c.name !='박지성'
;

SELECT *
FROM orders o, book b
WHERE o.bookid(+)=b.bookid
AND o.custid!=(SELECT custid FROM customer WHERE name='박지성')
;

--(8) 주문하지않은고객의이름(부속질의사용)
SELECT DISTINCT custid FROM orders;

-- 구매 고객 리스트 + NOT
SELECT name
FROM customer 
WHERE custid NOT IN (SELECT DISTINCT custid FROM orders)
;

-- 조인을 이용한 문제 해결
SELECT *
FROM customer c, orders o
WHERE o.custid(+)=c.custid 
AND o.orderid IS NULL
;

--(9) 주문금액의총액과주문의평균금액
SELECT SUM(saleprice), AVG(saleprice)
FROM orders
;

--(10) 고객의이름과고객별구매액
SELECT c.name, SUM(saleprice)
FROM customer c, orders o
WHERE c.custid=o.custid
GROUP BY c.name
;

--(11) 고객의이름과고객이구매한도서목록
SELECT name, bookname
FROM customer c, book b, orders o
WHERE c.custid = o.custid AND b.bookid = o.bookid
;

--(12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의차이가가장많은주문

SELECT MAX(b.price-o.saleprice)
FROM book b, orders o
WHERE b.bookid = o.bookid
;


--(13) 도서의 판매액 평균 보다 자신의 구매액 평균이 더 높은 고객의 이름

-- 판매액평균
SELECT AVG(saleprice) FROM orders;

-- 자신의 구매액 평균
SELECT c.name, AVG(saleprice)
FROM customer c, orders o
WHERE c.custid = o.custid
GROUP BY c.name
HAVING AVG(saleprice) > (SELECT AVG(saleprice) FROM orders)
;


--(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름

-- 박지성이 구매한 도서의 출판사
SELECT DISTINCT b.publisher
FROM customer c, book b, orders o
WHERE c.custid = o.custid AND b.bookid = o.bookid 
AND c.name ='박지성'
;

SELECT *
FROM customer c, book b, orders o
WHERE c.custid = o.custid AND b.bookid = o.bookid 
AND b.publisher IN (SELECT DISTINCT b.publisher
                    FROM customer c, book b, orders o
                    WHERE c.custid = o.custid AND b.bookid = o.bookid 
                    AND c.name ='박지성')
                    AND c.name !='박지성'
;

--(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름

SELECT c.name, COUNT(DISTINCT b.publisher)
FROM customer c, book b, orders o
WHERE c.custid=o.custid AND b.bookid=o.bookid
GROUP BY c.name
HAVING COUNT(DISTINCT b.publisher) > 1
;
