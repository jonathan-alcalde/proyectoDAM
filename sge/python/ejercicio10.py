# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#!/usr/bin/env python
#-*- coding: utf-8 -*-
def max_de_tres(primer_numero, segundo_numero,tercer_numero):
    numeromayor = 0
    numeros = []
    numeros.append(primer_numero)
    numeros.append(segundo_numero)
    numeros.append(tercer_numero)
    for n in numeros:
        if n > numeromayor:
            numeromayor = n
    return numeromayor


#se piden 3 números
print ('Teclea el primer numero ')
primer_numero = int(input())
print("Teclea un segundo numero")
segundo_numero = int(input())
print ('Teclea un tercer numero')
tercer_numero = int(input())
#se muestra el mayor de los 3 números
print ("El numero mas alto es ",max_de_tres(primer_numero,segundo_numero,tercer_numero))
