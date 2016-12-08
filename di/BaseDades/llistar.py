#!/usr/bin/python

import sqlite3

conn = sqlite3.connect('Registre.db')
print "Opened database successfully";

cursor=conn.execute("select * from registre");
for row in cursor:
   print "ID = ", row[0]
   print "USER = ", row[1]
   print "PASSWORD = ", row[2]
   print "EMAIL = ", row[3]
   print "NAME = ", row[4]
   print "SUBNAME = ", row[5]
   print "ADRESS = ", row[6], "\n"
   print "Registre = ", row[0], row[1], row[2], row[3], row[4], row[5], row[6], "\n"
conn.commit()
print "Records created successfully";
conn.close()