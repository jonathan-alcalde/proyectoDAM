# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#!/usr/bin/env python
#-*- coding: utf-8 -*-


#pedimos todas las notas del alumno
print ("Teclea el promedio de las tres califiaciones parciales: ")
promedio_examenes = float(input())
print ("Teclea la nota del examen final: ")
examen_final = float(input())
print ("Teclea la calificacion de un trabajo final")
trabajo_final = float(input())
print ("Teclea la calificacion de actitud")
#calculamos el porcentaje de la nota
actitud = float(input())
nota_final = 0
promedio_examenes = promedio_examenes * 0.55
examen_final = examen_final * 0.30
trabajo_final = trabajo_final * 0.05
actitud = actitud * 0.1
#nota total
nota_final = promedio_examenes + trabajo_final + examen_final + actitud
print ('La nota final es ', nota_final)
