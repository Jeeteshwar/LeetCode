# Write your MySQL query statement below
select distinct author_id as id from Views
where viewer_id >= 1 AND viewer_id = author_id  
ORDER BY id;

