# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#!/usr/bin/env python
#-*- coding: utf-8 -*-

#Se declara la variable nombre que pide que se introduzca un dato mediante teclado
nombre = input("Escribe tu nombre ")
#Se comprueba si se ha introduce un dato
if nombre == " ":
    print("No escribiste nada ")
else:
    print("Hola, " + nombre)
