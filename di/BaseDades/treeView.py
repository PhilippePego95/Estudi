#! /usr/bin/env python
# -*- coding: UTF-8 -*-
import gi
gi.require_version('Gtk', '3.0')
from gi.repository import Gtk


lista=[]
lista=Gtk.ListStore(str,int)
lista.append(["Negro",12])
lista.append(["Verde",11])
lista.append(["Blanco",13])

render=Gtk.CellRendererText()
      columna1=Gtk.TreeViewColumn("Colores",render,text=0)
      columna2=Gtk.TreeViewColumn("Precios",render,text=1)

self.vista.set_model(lista)
self.vista.append_column(columna1)
self.vista.append_column(columna2)
self.vista.show()

#def on_boton_clicked(self, widget, data=None):
#	(model,iter)=self.vista.get_selection().get_selected()
#	if iter != None:
#		print list(model[iter])

builder = Gtk.Builder()			
builder.add_from_file("treeView.glade")
handlers={
	"gtk_main_quit" : Gtk.main_quit,	
}
builder.connect_signals(handlers)

vista=builder.get_object("vista")
finestra=builder.get_object("window")

finestra.show_all()

Gtk.main()


