CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      SELECT DISTINCT(salary)
      from(
        select salary, DENSE_RANK() OVER(ORDER BY salary desc) as dr
        from Employee) ranked
        where dr =N
     

  );
END