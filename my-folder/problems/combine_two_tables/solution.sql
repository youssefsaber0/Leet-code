# Write your MySQL query statement below
select firstName, lastName, city, state from Person as p Left Join Address as a on (a.personId = p.personId);