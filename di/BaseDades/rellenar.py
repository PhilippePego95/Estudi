#!/usr/bin/python

import sqlite3

conn = sqlite3.connect('registre.db')
print "Opened database successfully";

conn.execute("INSERT INTO registre (ID,USER,PASSWORD,EMAIL,NAME,SUBNAME,ADDRESS) VALUES (2, 'Jaume96', 'qwerty1234', 'jaume@gmail.com','Jaume','sanjuan','sant antoni 69' )");

conn.commit()
print "Records created successfully";
conn.close()