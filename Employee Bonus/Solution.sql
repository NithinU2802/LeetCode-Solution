select e.name,b.bonus from employee e Left JOIN bonus b on b.empid=e.empid where ifNULL(b.bonus,0)<1000;