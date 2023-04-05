# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#!/usr/bin/env python
#-*- coding: utf-8 -*-

def contar_cadena(cadena):
    contador = 0
    for i in cadena:
        contador = contador + 1
    return contador
print ('Introduce una cadena de carateres')
cadena = input()
print (cadena ,  ' tiene ', contar_cadena(cadena) , ' caracteres')
