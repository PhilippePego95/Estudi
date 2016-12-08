#!/usr/bin/python

import sqlite3

conn = sqlite3.connect('Registre.db')
print ("Opened database successfully")
llista=[]
i=0
cursor=conn.execute("select * from registre");
for row in cursor:
    opc=i
    llista+str(opc).append(row[0])
    llista + str(opc).append(row[1])
    llista + str(opc).append(row[2])
    llista + str(opc).append(row[3])
    llista + str(opc).append(row[4])
    llista + str(opc).append(row[5])
    i+=1
for row in cursor:
    opc=i
    print(llista+str(opc))
    i+=1
conn.commit()

conn.close()