select (
    select distinct 
    salary as SencondHighestSalary
from 
    employee
order by 
    salary desc
limit 1 offset 1
) as SencondHighestSalary;