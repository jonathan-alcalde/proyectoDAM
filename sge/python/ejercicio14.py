# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#!/usr/bin/env python
#-*- coding: utf-8 -*-

def invertir(palabra):
    palabra_invertida = ""
    for i in palabra:
        palabra_invertida = i + palabra_invertida
    return palabra_invertida

palabra = input("Introduce la palabra a invertir\n")
print (invertir(palabra))
