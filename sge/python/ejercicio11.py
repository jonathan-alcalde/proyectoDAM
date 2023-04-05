# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#!/usr/bin/env python
#-*- coding: utf-8 -*-

import math
def max_in_list(list):
    """
        Encuentra el número mayor de una lista
    """
    numeromayor = 0
    for i in list:
        if i > numeromayor:
            numeromayor = i

    return numeromayor




#se declara un array, un boolean y se pide un número por teclado
list = []
print ('¿Cuantos numeros se van a introducir?')
cant_numeros = int(input())
numero = 0
for i in range(cant_numeros):
            print("Escribe un número")
            numero = int(input())
            list.append(numero)
print(max_in_list(list))
