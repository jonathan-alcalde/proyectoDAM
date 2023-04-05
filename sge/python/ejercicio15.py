# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#!/usr/bin/env python
#-*- coding: utf-8 -*-

def es_palindromo(palabra):
    palabra = palabra.lower()
    palabra = palabra.replace(' ', '')
    longitud = len(palabra)
    if longitud % 2 == 0:
        izquierda = palabra[:longitud // 2]
        derecha = palabra[longitud // 2:]
    else:
        izquierda = palabra[:longitud // 2]
        derecha = palabra[longitud // 2 + 1:]
    
    return izquierda == derecha[::-1]


palabra = input("Introduce la palabra a invertir\n")
print(es_palindromo(palabra))
