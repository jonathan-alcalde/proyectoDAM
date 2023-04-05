# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#!/usr/bin/env python
#-*- coding: utf-8 -*-

n = int(input("Ingrese un número entero positivo impar"))

sim = "*"

for x in range(1, n+1, 2):
    print("{:^33}".format(x * sim))
for j in range(n-2,1, -2):
    print("{:^33}".format(j * sim))
print("{:^33}".format("*"))
