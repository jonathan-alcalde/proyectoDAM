# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#!/usr/bin/env python
#-*- coding: utf-8 -*-

print("Teclea los minutos:")
minutos_total = float(input())
#calculamos primero las horas como número entero para no obtener los decimales
horas=int(minutos_total/60)
#repetimos el cálculo pero esta vez mostrando los décimales
horas_total = float(minutos_total/60)
#calculamos los minutos restando el resultado de las dos horas para extraer los decimales
minutos = float(horas_total-horas)
minutos= int(minutos*60)
print (minutos_total, "son ",horas, "horas y ",minutos, "minutos")
