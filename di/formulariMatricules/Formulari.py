#! /usr/bin/env python
# -*- coding: UTF-8 -*-

import gi
gi.require_version('Gtk', '3.0')
from gi.repository import Gtk
import sqlite3


class Actua:
	def llistar(self):
		cursor.execute("SELECT * FROM usuari")
		fila=cursor.fetchone()

		store=Gtk.ListStore(str,str,str,int)
		treeview=builder.get_object("treeview1")

		for i in cursor.execute("SELECT * FROM usuari"):

		
			store.append(i)

		treeview.set_model(store)
		Act=Actua()
		Act.combonom()

	def llistarM(self):
		cursor.execute("SELECT * FROM matricula")
		fila=cursor.fetchone()

		lista=Gtk.ListStore(str,str,str,int)
		treeview=builder.get_object("matricula")

		for i in cursor.execute("SELECT * FROM matricula"):

			
			lista.append(i)

		matricula.set_model(lista)

	def llistarCentre(self):
		cursor.execute("SELECT * FROM institut")
		fila=cursor.fetchone()

		store1=Gtk.ListStore(str,str,str,int)
		treeview1=builder.get_object("treeview2")

		for i in cursor.execute("SELECT * FROM institut"):

			
			store1.append(i)

		treeview1.set_model(store1)
		Act=Actua()
		Act.combobo()
	def llistarEsp(self):
		cursor.execute("SELECT * FROM especialitat")
		fila=cursor.fetchone()

		store2=Gtk.ListStore(str,str,str,int)
		treeview2=builder.get_object("treeview3")

		for i in cursor.execute("SELECT * FROM especialitat"):

			

			store2.append(i)
			Act=Actua()

		treeview2.set_model(store2)
	def combobo(self):
		listaelementos=Gtk.ListStore(str)
		
		cursor.execute('SELECT nom FROM institut')
		for row in cursor:
			listaelementos.append(row)

		combo.set_model(listaelementos)
		render=Gtk.CellRendererText()
		combo.pack_start(render, True)
	def comboesp(self):
		model = combocent.get_model()
		activo = combocent.get_active()
		if activo >= 0:
			print(model[activo][0])
		cent=(model[activo][0])
		print(cent)
		listaelementos=Gtk.ListStore(str)
		a = "a"
		cursor.execute("SELECT nom FROM especialitat WHERE centre ='"+cent+"'")
		for row in cursor:
			listaelementos.append(row)

		comboesp.set_model(listaelementos)
		render=Gtk.CellRendererText()
		comboesp.pack_start(render, True)
	def combonom(self):
		listaelementos=Gtk.ListStore(str)
		
		cursor.execute('SELECT nom FROM usuari')
		for row in cursor:
			listaelementos.append(row)

		combonom.set_model(listaelementos)
		render=Gtk.CellRendererText()
		combonom.pack_start(render, True)
	def combocent(self):
		listaelementos=Gtk.ListStore(str)
		
		cursor.execute('SELECT nom FROM institut')
		for row in cursor:
			listaelementos.append(row)

		combocent.set_model(listaelementos)
		render=Gtk.CellRendererText()
		combocent.pack_start(render, True)

class comand:		
	
	def save(self,tabla):

		cursor.execute(tabla);
		conexion.commit()
		conexion.rollback()

def Uguardar(button):
	print("insertant usuari...")

	nomU=Unom.get_text()
	cogU=Ucog.get_text()
	dirU=Udir.get_text()
	dniU=Udni.get_text()

	p=comand()
	p.save("INSERT INTO usuari (nom,cognom,dir,dni)"+
		"VALUES ('"+nomU+"','"+cogU+"','"+dirU+"','"+dniU+"')")

	Act=Actua()
	Act.llistar()
def Iguardar(button):
	print("insertant centre...")

	nomI=Inom.get_text()
	dirI=Idir.get_text()
	llocI=Illoc.get_text()

	p=comand()
	p.save("INSERT INTO institut (nom,dir,poblacio)"+
		"VALUES ('"+nomI+"','"+dirI+"','"+llocI+"')")

	Act=Actua()
	Act.llistarCentre()

def Eguardar(button):	
	model = combo.get_model()
	activo = combo.get_active()
	if activo >= 0:
		print(model[activo][0])
		cent=(model[activo][0])
	print(cent)
	print("insertant especialitat...")

	nomE=Enom.get_text()
	desE=Edes.get_text()

	p=comand()
	p.save("INSERT INTO especialitat (nom,des,centre)"+
		"VALUES ('"+nomE+"','"+desE+"','"+cent+"')")

	Act=Actua()
	Act.llistarEsp()

def Mguardar(button):	
	model = comboesp.get_model()
	activo = comboesp.get_active()
	if activo >= 0:
		print(model[activo][0])
		esp=(model[activo][0])

	model1 = combonom.get_model()
	activo = combonom.get_active()
	if activo >= 0:
		print(model1[activo][0])
		nom=(model1[activo][0])

	model2 = combocent.get_model()
	activo = combocent.get_active()
	if activo >= 0:
		print(model2[activo][0])
		cent=(model2[activo][0])		
	print(nom,esp,cent)
	print("insertant especialitat...")



	p=comand()
	p.save("INSERT INTO matricula (usuari,institut,especialitat)"+
		"VALUES ('"+nom+"','"+cent+"','"+esp+"')")

	
	Act=Actua()
	Act.llistarM()
def Uborrar(button):
	print("borrant...")
	dni=Udni.get_text()
	
	p=comand()
	p.save("DELETE FROM usuari where dni='"+dni+"'")

	Act=Actua()
	Act.llistar()

def Iborrar(button):
	print("borrant...")
	Iid=idd.get_text()
	
	p=comand()
	p.save("DELETE FROM institut where id='"+Iid+"'")

	
	idd.set_text("")

	Act=Actua()
	Act.llistarCentre()

def Eborrar(button):
	print("borrant...")
	ed=Eid.get_text()
	
	p=comand()
	p.save("DELETE FROM especialitat where id='"+ed+"'")

	
	Eid.set_text("")
	Act=Actua()
	Act.llistarEsp()

def Mborrar(button):
	
	m=Mid.get_text()
	
	p=comand()
	p.save("DELETE FROM matricula where id='"+m+"'")

	
	Mid.set_text("")
	print("borrant...")

	Act=Actua()
	Act.llistarM()	

def Uedit(button):
	print("editant...")
	nomU=Unom.get_text()
	cogU=Ucog.get_text()
	dirU=Udir.get_text()
	dniU=Udni.get_text()
	
	p=comand()
	p.save("UPDATE usuari SET nom='"+nomU+"',cognom='"+cogU+"',dir='"+dirU+"',dni='"+dniU+"'"+
	"WHERE dni='"+dniU+"'");
	
	Act=Actua()
	Act.llistar()

def Iedit(button):
	print("editant centre...")
	nomI=Inom.get_text()
	llocI=Illoc.get_text()
	diI=Idir.get_text()
	idI=idd.get_text()
	
	p=comand()
	p.save("UPDATE institut SET nom='"+nomI+"',dir='"+diI+"',poblacio='"+llocI+"',id='"+idI+"'"+
	"WHERE id='"+idI+"'");
	
	Act=Actua()
	Act.llistarCentre()

def Eedit(button):
	print("editant especialitat...")
	model = combo.get_model()
	activo = combo.get_active()
	if activo >= 0:
		print(model[activo][0])
		cent=(model[activo][0])
	print(cent)
	print("insertant especialitat...")

	nomE=Enom.get_text()
	desE=Edes.get_text()
	ed=Eid.get_text()
	p=comand()
	p.save("UPDATE especialitat SET nom='"+nomE+"',des='"+desE+"',centre='"+cent+"',id='"+ed+"'"+
	"WHERE id='"+ed+"'");
	
	Act=Actua()
	Act.llistarEsp()
def Medit(button):
	model = comboesp.get_model()
	activo = comboesp.get_active()
	if activo >= 0:
		print(model[activo][0])
		esp=(model[activo][0])

	model1 = combonom.get_model()
	activo = combonom.get_active()
	if activo >= 0:
		print(model1[activo][0])
		nom=(model1[activo][0])

	model2 = combocent.get_model()
	
	activo = combocent.get_active()
	if activo >= 0:
		print(model2[activo][0])
		cent=(model2[activo][0])		
	print(nom,esp,cent)
	print("insertant especialitat...")
	mid=Mid.get_text()
	p=comand()
	p.save("UPDATE matricula SET usuari='"+nom+"',institut='"+cent+"',especialitat='"+esp+"',id='"+mid+"'"+
	"WHERE id='"+mid+"'");


	Act=Actua()
	Act.llistarM()

def Uselec(button):
	print("selecionant...")
	treeview=builder.get_object("treeview1")
	#VAMOS A GUARDAR LO SELECCIONADO DEL TREEVIEW EN UNA VARIABLE
	selection=treeview.get_selection()
	#DECIMOS QUE EL MODELO Y LA POSICION SE GUARDEN 
	model,treeiter=selection.get_selected()
	#MIENTRAS HAYA ALGO SELECCIONADO, PASAMOS LOS PARAMETROS
	if treeiter != None:
		Unom.set_text(model[treeiter][0])
		Ucog.set_text(model[treeiter][1])
		Udir.set_text(model[treeiter][2])
		#convertir un in a str
		d=model[treeiter][3]
		dni=str(d)
		Udni.set_text(dni)
		#comprovació de la operació -> print (dni, type(dni))
		
def Iselec(button):
	print("selecionant centre...")
	treeview1=builder.get_object("treeview2")
	#VAMOS A GUARDAR LO SELECCIONADO DEL TREEVIEW EN UNA VARIABLE
	selection=treeview1.get_selection()
	#DECIMOS QUE EL MODELO Y LA POSICION SE GUARDEN 
	model,treeiter=selection.get_selected()
	#MIENTRAS HAYA ALGO SELECCIONADO, PASAMOS LOS PARAMETROS
	if treeiter != None:
		Inom.set_text(model[treeiter][0])
		Idir.set_text(model[treeiter][1])
		Illoc.set_text(model[treeiter][2])
		#convertir un in a str
		i=model[treeiter][3]
		ids=str(i)
		idd.set_text(ids)
		#comprovació de la operació -> print (dni, type(dni))
def Esel(button):
	print("selecionant centre...")
	treeview2=builder.get_object("treeview3")
	#VAMOS A GUARDAR LO SELECCIONADO DEL TREEVIEW EN UNA VARIABLE
	selection=treeview2.get_selection()
	#DECIMOS QUE EL MODELO Y LA POSICION SE GUARDEN 
	model,treeiter=selection.get_selected()
	#MIENTRAS HAYA ALGO SELECCIONADO, PASAMOS LOS PARAMETROS
	if treeiter != None:
		Enom.set_text(model[treeiter][0])
		Edes.set_text(model[treeiter][1])
		#convertir un in a str
		e=model[treeiter][3]
		eds=str(e)
		Eid.set_text(eds)
		#comprovació de la operació -> print (dni, type(dni))
def Msel(button):
	print("selecionant matricula...")
	matricula=builder.get_object("matricula")
	#VAMOS A GUARDAR LO SELECCIONADO DEL TREEVIEW EN UNA VARIABLE
	selection=matricula.get_selection()
	#DECIMOS QUE EL MODELO Y LA POSICION SE GUARDEN 
	model,treeiter=selection.get_selected()
	#MIENTRAS HAYA ALGO SELECCIONADO, PASAMOS LOS PARAMETROS
	if treeiter != None:
		#convertir un in a str
		m=model[treeiter][3]
		mid=str(m)
		Mid.set_text(mid)
		#comprovació de la operació -> print (dni, type(dni))

def Unetejar(button):
	Unom.set_text("")
	Ucog.set_text("")
	Udir.set_text("")
	Udni.set_text("")
	print("borrant camps...")

def Inetejar(button):
	Inom.set_text("")
	Idir.set_text("")
	Illoc.set_text("")
	idd.set_text("")
	print("borrant camps...")
def Enetejar(button):
	Enom.set_text("")
	Edes.set_text("")	
	Eid.set_text("")
	print("borrant camps...")

def Mnetejar(button):		
	Mid.set_text("")
	print("borrant camps...")
def buscar(button):
	Act=Actua()
	Act.comboesp()

#Conexio base dades
conexion=sqlite3.connect("FormulariBD")
cursor=conexion.cursor()

builder = Gtk.Builder()			
builder.add_from_file("FormulariGlade.glade")
combo=builder.get_object("centres")
combocent=builder.get_object("combocent")
comboesp=builder.get_object("comboesp")
combonom=builder.get_object("combonom")


handlers={
	"Eguardar":Eguardar,
	"Iguardar":Iguardar,
	"Uguardar":Uguardar,
	"Mguardar":Mguardar,

	"Iborrar":Iborrar,
	"Uborrar":Uborrar,
	"Eborrar":Eborrar,
	"Mborrar":Mborrar,


	"Iedit":Iedit,
	"Uedit":Uedit,
	"Eedit":Eedit,
	"Medit":Medit,

	"Iselec":Iselec,
	"Uselec":Uselec,
	"Esel":Esel,
	"Msel":Msel,

	"Inetejar":Inetejar,
	"Unetejar":Unetejar,
	"Enetejar":Enetejar,
	"Mnetejar":Mnetejar,

	"buscar":buscar,

	"gtk_main_quit" : Gtk.main_quit,	
}




builder.connect_signals(handlers)
#camps del usuari
Unom=builder.get_object("Unom")
Ucog=builder.get_object("Ucog")
Udir=builder.get_object("Udir")
Udni=builder.get_object("Udni")

Enom=builder.get_object("Enom")
Edes=builder.get_object("Edes")
Eid=builder.get_object("Eid")

Inom=builder.get_object("Inom")
Illoc=builder.get_object("Illoc")
Idir=builder.get_object("Idir")
idd=builder.get_object("idd")
Mid=builder.get_object("Mid")
finestra = builder.get_object("window1")
finestra.show_all()

#mostrar dades usuari
cursor.execute("SELECT * FROM usuari")
fila=cursor.fetchone()

store=Gtk.ListStore(str,str,str,int)
treeview=builder.get_object("treeview1")

store1=Gtk.ListStore(str,str,str,int)
treeview1=builder.get_object("treeview2")

store2=Gtk.ListStore(str,str,str,int)
treeview2=builder.get_object("treeview3")

lista=Gtk.ListStore(str,str,str,int)
matricula=builder.get_object("matricula")
#treeview del usuari
for i in cursor.execute ("SELECT * FROM matricula"):
	lista.append(i)

	render=Gtk.CellRendererText()
	ccolumna1=Gtk.TreeViewColumn("Usuari",render,text=0)
	ccolumna2=Gtk.TreeViewColumn("Centre",render,text=1)
	ccolumna3=Gtk.TreeViewColumn("Especialitat",render,text=2)
	ccolumna4=Gtk.TreeViewColumn("ID",render,text=3)

for i in cursor.execute("SELECT * FROM usuari"):


	
	store.append(i)
            
	#CREO LAS COLUMNAS
	render=Gtk.CellRendererText()
	columna1=Gtk.TreeViewColumn("Nom",render,text=0)
	columna2=Gtk.TreeViewColumn("Cognom",render,text=1)
	columna3=Gtk.TreeViewColumn("Direcció",render,text=2)
	columna4=Gtk.TreeViewColumn("DNI",render,text=3)

#treeview del institut
for i in cursor.execute("SELECT * FROM institut"):
	
	store1.append(i)
            
	#CREO LAS COLUMNAS
	render=Gtk.CellRendererText()
	col1=Gtk.TreeViewColumn("Nom",render,text=0)
	col2=Gtk.TreeViewColumn("Direcció",render,text=1)
	col3=Gtk.TreeViewColumn("Població",render,text=2)
	col4=Gtk.TreeViewColumn("ID",render,text=3)


for i in cursor.execute("SELECT * FROM especialitat"):		
	
	store2.append(i)
            
	#CREO LAS COLUMNAS
	render=Gtk.CellRendererText()
	coll1=Gtk.TreeViewColumn("Nom",render,text=0)
	coll2=Gtk.TreeViewColumn("Descripció",render,text=1)
	coll3=Gtk.TreeViewColumn("Centre",render,text=2)
	coll4=Gtk.TreeViewColumn("ID",render,text=3)


#rellenar un combobox amb una consulta 
listaelementos=Gtk.ListStore(str)

Act=Actua()
Act.combobo()
Act.combocent()
Act.combonom()

#Asignem la llista i les columnes als TreeView
treeview.set_model(store)
treeview.append_column(columna1)
treeview.append_column(columna2)
treeview.append_column(columna3)
treeview.append_column(columna4)

treeview1.set_model(store1)
treeview1.append_column(col1)
treeview1.append_column(col2)
treeview1.append_column(col3)
treeview1.append_column(col4)

treeview2.set_model(store2)
treeview2.append_column(coll1)
treeview2.append_column(coll2)
treeview2.append_column(coll3)
treeview2.append_column(coll4)

matricula.set_model(lista)

matricula.append_column(ccolumna1)
matricula.append_column(ccolumna2)
matricula.append_column(ccolumna3)
matricula.append_column(ccolumna4)



#MOSTRAM ELS TREEVIEW
treeview.show()
treeview1.show()
treeview2.show()
matricula.show()




Gtk.main()