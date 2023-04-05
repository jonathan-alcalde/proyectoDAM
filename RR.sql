select * 
from empleados
where codemples like 'CAM%';

select c.* from c.camarero, e.empleados
where c.encargardo = 'CAM01' or c.encargado = 'CAM02';
select * 
from camarero
where superior is in (
	select codigo from empleado
	where apellido is equal "garcia" and (nombre = "JOSE" or nombre = "ROSA"))

select e.codemple , e.nombre, e.apellido, c.turno
from empleado e, camarero c
where e.codemple = c.codemple
and turno like 'TARDE';

select e.* , c.*
from empleado e, cocineros c
where e.codemple = c.codemple
and c.especialidad like 'PESCADOS'

