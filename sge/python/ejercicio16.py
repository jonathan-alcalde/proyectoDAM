# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#!/usr/bin/env python
#-*- coding: utf-8 -*-

def elemento_comun(lista_1,lista_2):
    for v1 in lista_1:
        for v2 in lista_2:
            if v1 == v2:
                return True


lista_1 = []
lista_2 = []
print ('¿Cuantos numeros se van a introducir?')
cant_numeros = int(input())
numero = 0
for i in range(cant_numeros):
            print("Escribe un número")
            numero = int(input())
            lista_1.append(numero)
print ('¿Cuantos numeros se van a introducir?')
cant_numeros = int(input())
numero = 0
for i in range(cant_numeros):
            print("Escribe un número")
            numero = int(input())
            lista_2.append(numero)   
print(elemento_comun(lista_1,lista_2))
