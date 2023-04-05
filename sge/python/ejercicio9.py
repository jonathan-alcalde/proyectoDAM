# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#!/usr/bin/env python
#-*- coding: utf-8 -*-

#funcion para buscar el número mayor
def numero_mayor(primer_numero, segundo_numero):
    numeromayor = 0
    if primer_numero > segundo_numero:
        numeromayor = primer_numero
    else:
        numeromayor = segundo_numero

    return numeromayor


print('Teclea el primer numero')
primer_numero = int(input())
print("Teclea un segundo numero")
segundo_numero = int(input())
# se muestra el número mayor
print("El numero mas alto es ", numero_mayor(primer_numero, segundo_numero))

