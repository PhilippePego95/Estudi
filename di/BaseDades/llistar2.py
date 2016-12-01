#! /usr/bin/env python
# -*- coding: utf-8 -*-

import sqlite3

conn = sqlite3.connect('Registre.db')

cursor=conn.execute("select * from registre");

print("conectant a la base de dades...")
lista0=[]
lista1=[]
lista2=[]
lista3=[]
lista4=[]
lista5=[]
u=0
print ("Id","Usuari","Contrasenya","Nom","Cognom","Direccio")
print("*******************************************************")
for row in cursor:	
	lista0.append(row[0])
	lista1.append(row[1])
	lista2.append(row[2])
	lista3.append(row[3])
	lista4.append(row[4])
	lista5.append(row[5])
	
	a=(lista0[u],lista1[u],lista2[u],lista3[u],lista4[u],lista5[u])	
	print (a)

	u=u+1



#for row in cursor:	
	

conn.commit()
conn.close()
