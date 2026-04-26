select (
    Select distinct salary
    from Employee 
    ORDER BY salary desc 
    LIMIT 1 OFFSET 1

) as SecondHighestSalary ;