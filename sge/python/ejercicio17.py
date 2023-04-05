# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#!/usr/bin/env python
#-*- coding: utf-8 -*-

n=int(input('Introduce el numero de filas'))
for i in range(n+1):
    espacios=n-i
    print(' '*i+'*'*espacios)
