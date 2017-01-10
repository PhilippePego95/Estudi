#!/usr/bin/python

import sqlite3

conn = sqlite3.connect('FormulariBD')
print ("Opened database successfully");

cursor=conn.execute("select * from institut");
for row in cursor:
   print (".................")
   print ("id = ", row[3])
   print ("nom = ", row[0])
   print ("direccio = ", row[1])
   print ("poblacio = ", row[2])

   
  
conn.commit()
print ("Records created successfully");
conn.close()
