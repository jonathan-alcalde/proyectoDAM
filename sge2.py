# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#!/usr/bin/env python
#-*- coding: utf-8 -*-


#declaramos las variables base y altura para pedir las medidas del rectángulo
base = int(input("Introduce la base del rectangulo: " ))
altura = int(input("Teclea la altura del rectangulo: "))
#calculamos el perímetro
perimetro = (base * 2) + (altura * 2)
#calculamos el área
area = base * altura
print('El perimetro es: ',perimetro)
print('El area es: ', area)
