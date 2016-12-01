#!/usr/bin/python

import sqlite3

conn = sqlite3.connect('Registre.db')
print "Opened database successfully";

conn.execute('''CREATE TABLE registre
       (ID INTEGER PRIMARY KEY AUTOINCREMENT,
       USER           TEXT    NOT NULL,
       PASSWORD		  TEXT    NOT NULL,
       EMAIL		  TEXT    NOT NULL,
       NAME		  	TEXT    NOT NULL,
       SUBNAME		  TEXT    NOT NULL,
       ADDRESS        TEXT    NOT NULL);''')
print "Table created successfully";

conn.close()