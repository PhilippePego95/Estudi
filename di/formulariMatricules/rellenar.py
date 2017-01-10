#!/usr/bin/python

import sqlite3

conn = sqlite3.connect('FormulariBD')
print ("Opened database successfully");

cursor=conn.execute("INSERT INTO institut (nom,dir,poblacio)"+
		"VALUES ('IES SERPIS','Serpis 17','Valencia')");
conn.commit()

  
print ("Records created successfully");
conn.close()
