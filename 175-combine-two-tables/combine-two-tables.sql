# MAJHA NOTES
# we want All people from Person table + addr info if it exits # else show NULL ----> LEFT JOIN
# Both tables share:  Person.personId = Address.personId

SELECT 
    p.firstName,
    p.lastName,
    a.city,
    a.state
FROM Person p
LEFT JOIN Address a
ON p.personId = a.personId;    