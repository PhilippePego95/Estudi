#!/usr/bin/python
# -*- coding: utf-8 -*-

from gi.repository import Gtk
from gi.repository import Pango
import sys
import sqlite3

columns = ["ID",
           "Usuari",
           "Pasword",
           "Nom",
           "Cognom",
           "Direccio"]

conn = sqlite3.connect('Registre.db')
print "Opened database successfully";


class MyWindow(Gtk.ApplicationWindow):
	def __init__(self, app):
		Gtk.Window.__init__(self, title="Llistat d'usuaris", application=app)
        self.set_default_size(250, 100)
        self.set_border_width(10)
		
		listmodel = Gtk.ListStore(str, str, str,str, str, str)
		for row in cursor:	
			listmodel.append(row[0])
			listmodel.append(row[1])
			listmodel.append(row[2])
			listmodel.append(row[3])
			listmodel.append(row[4])
			listmodel.append(row[5])
			
		view = Gtk.TreeView(model=listmodel)
		for i in range(len(columns)):
			cell = Gtk.CellRendererText()
			if i == 0:
	        
	        	cell.props.weight_set = True
	        	cell.props.weight = Pango.Weight.BOLD

	        col = Gtk.TreeViewColumn(columns[i], cell, text=i)
	        view.append_column(col) 
        view.get_selection().connect("changed", self.on_changed)
		self.label = Gtk.Label()
        self.label.set_text("")
		grid = Gtk.Grid()
        grid.attach(view, 0, 0, 1, 1)
        grid.attach(self.label, 0, 1, 1, 1)
        self.add(grid)
def on_changed(self, selection):
        # get the model and the iterator that points at the data in the model
        (model, iter) = selection.get_selected()
        # set the label to a new value depending on the selection
        self.label.set_text("\n %s %s %s" %
                            (model[iter][0],  model[iter][1], model[iter][2], model[iter][3], model[iter][4], model[iter][5]))
        return True


class MyApplication(Gtk.Application):

    def __init__(self):
        Gtk.Application.__init__(self)

    def do_activate(self):
        win = MyWindow(self)
        win.show_all()

    def do_startup(self):
        Gtk.Application.do_startup(self)

app = MyApplication()
exit_status = app.run(sys.argv)
sys.exit(exit_status)






