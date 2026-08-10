# Write your MySQL query statement below


-- SELECT 
-- DISTINCT()
-- FROM (SELECT SUBJECT_ID,DEP_ID FROM TEACHER);
-- JOIN TEACHER t2
-- on t1.teacher_id= t2.teacher_id;



SELECT teacher_id , -- working with this
COUNT(DISTINCT subject_id) as cnt -- aggerate function to cound the distinct
FROM Teacher -- from table Teacher
GROUP BY teacher_id; -- at last we need to work by teacher_id
