# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#!/usr/bin/env python
#-*- coding: utf-8 -*-


#se declara la funcion sum que consistirá en un bucle for que se repetirá por cada número que haya en el array
#la funcion devuelve el total de todos los números del array
def sum(numeros):
    """
    Suma un conjunto de valores numericos
    """
    total = 0
    for numero in numeros:
        total = numero + total
    return total    
#se declara la funcion multip que consistirá en un bucle for que se repetirá por cada número que haya en el array
#la funcion devuelve el producto de todos los números del array
def multip(numeros):
    """
    Multiplica un conjunto de valores numericos
    """
    producto = 1
    for numero in numeros:
        producto = numero * producto
    return producto    
#se declara el array y el usuario decide la longitud de este
list = []
print ('¿Cuantos numeros se van a introducir?')
cant_numeros = int(input())
numero = 0
for i in range(cant_numeros):
            print("Escribe un número")
            numero = int(input())
            list.append(numero)

#se muestra el resultado
print('la suma de los numeros de la lista es', sum(list))
print('la multiplicacion de los numeros de la lista es', multip(list))
