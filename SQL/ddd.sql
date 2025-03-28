-- LeetCode 185. Department Top Three Salaries
WITH RankedGrades AS (
    SELECT
        name, 
        salary,
        `departmentId`,
        DENSE_RANK() OVER (PARTITION BY departmentId ORDER BY salary DESC) as rank_num
    FROM
        Employee
)
SELECT
	d.name as Department,
    r.name as Employee,
    salary
FROM
    RankedGrades as r, Department as d 
WHERE
    rank_num <= 3
    and r.departmentId = d.id
ORDER BY
    departmentId,
    salary DESC;