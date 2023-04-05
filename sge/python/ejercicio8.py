# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#!/usr/bin/env python
#-*- coding: utf-8 -*-


#se piden dos números por teclado
print("Teclea un numero: ")
primer_numero = int(input())
print("Tecle un segundo numero")
segundo_numero = int(input())
#se declaran la variables que contendrán la suma de los números pares y el contados de los números pares
total_numeros = 0
suma_pares = 0
total_pares = 0

#bucles for
if primer_numero > segundo_numero:
    for i in range(segundo_numero, primer_numero):
        print(i)
        total_numeros = total_numeros + 1
        if i % 2 == 0:
            suma_pares = suma_pares + i
            total_pares = total_pares + 1
else:
    for i in range(primer_numero,segundo_numero ):
        print(i)
        total_numeros = total_numeros + 1
        if i % 2 == 0:
            suma_pares = suma_pares + i
            total_pares = total_pares + 1
print ('Entre los dos numeros hay ',total_numeros, 'numeros')
print ('La cantidad de numeros pares es',total_pares)
print ('El total de los pares es:',suma_pares)
