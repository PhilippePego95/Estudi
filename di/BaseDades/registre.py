#! /usr/bin/env python
# -*- coding: UTF-8 -*-
from gi.repository import Gtk
import sqlite3

def on_aceptar_clicked(button):
	us= Usuari.get_text() 
	con = Contrasenya.get_text()
	email=Correu.get_text()
	nom=Nom.get_text()
	cog=Cognom.get_text()
	dire=Direccio.get_text()

	lUsuari.set_text(us)
	lContrasenya.set_text(con)
	lCorreu.set_text(email)
	lNom.set_text(nom)
	lCognom.set_text(cog)
	lDireccio.set_text(dire)
	
	finestra2.show_all()

def on_aplicar_clicked(button):

	us= Usuari.get_text() 
	con = Contrasenya.get_text()
	email=Correu.get_text()
	nom=Nom.get_text()
	cog=Cognom.get_text()
	dire=Direccio.get_text()

	conn = sqlite3.connect('Registre.db')
	c=conn.cursor()
	print "Opened database successfully";

	c.execute("INSERT INTO registre (USER,PASSWORD,EMAIL,NAME,SUBNAME,ADDRESS)"+
		" VALUES ('"+us+"','"+con+"','"+email+"','"+nom+"','"+cog+"','"+dire+"')");

	conn.commit()
	conn.close()
	print "Records created successfully";
	
	finestra2 = builder.get_object("window2")
	finestra2.hide()

def on_cancel_clicked(button):
	finestra2 = builder.get_object("window2")
	finestra2.hide()
def on_veure_clicked(button):
	finestra3.show_all()
	
def on_reset_clicked(button):
	Usuari.set_text(" ")
	Contrasenya.set_text(" ")
	Correu.set_text(" ")
	Nom.set_text(" ")
	Cognom.set_text(" ")
	Direccio.set_text(" ")

builder = Gtk.Builder()			
builder.add_from_file("registre.glade")
handlers={
	"on_reset_clicked":on_reset_clicked,
	"on_aplicar_clicked":on_aplicar_clicked,
	"on_cancel_clicked":on_cancel_clicked,
	"on_aceptar_clicked":on_aceptar_clicked,
	"on_veure_clicked":on_veure_clicked,
	"gtk_main_quit" : Gtk.main_quit,	
}


builder.connect_signals(handlers)
Usuari=builder.get_object("Usuari")
Contrasenya=builder.get_object("Contrasenya")
Correu=builder.get_object("Correu")
Nom=builder.get_object("Nom")
Cognom=builder.get_object("Cognom")
Direccio=builder.get_object("Direccio")

lUsuari=builder.get_object("lUsuari")
lContrasenya=builder.get_object("lContrasenya")
lCorreu=builder.get_object("lCorreu")
lNom=builder.get_object("lNom")
lCognom=builder.get_object("lCognom")
lDireccio=builder.get_object("lDireccio")

finestra2 = builder.get_object("window2")
finestra3 = builder.get_object("window3")
finestra3 = TreeViewFilterWindow()

finestra = builder.get_object("window1")
finestra.show_all()

Gtk.main()
