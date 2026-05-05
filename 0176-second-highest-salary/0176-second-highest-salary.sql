SELECT MAX(salary) as SecondHighestSalary
FROM Employee
where salary < (select MAX(salary)
from Employee);