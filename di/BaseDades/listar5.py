#!/usr/bin/python
# -*- coding: utf-8 -*-

from gi.repository import Gtk
from gi.repository import Pango
import sys
import sqlite3

columns = ["ID","Usuari","Contrasenya","Nom","Cognom","Direccio"]

phonebook = [["1","Jurg12","qwqwq","Jurg", "Billeter", "555-0123"],
             ["2","Johannes12","qwqwq","Johannes", "Schmid", "555-1234"],
             ["3","Julita2","qwqwq","Julita", "Inca", "555-2345"],
             ["4","Javier42","qwqwq","Javier", "Jardon", "555-3456"],
             ["5","Jason5","qwqwq","Jason", "Clinton", "555-4567"],
             ["6","RandomJ2","qwqwq","Random J.", "Hacker", "555-5678"]]


class MyWindow(Gtk.ApplicationWindow):

    def __init__(self, app):
        Gtk.Window.__init__(self, title="Llistat d'usuaris", application=app)
        self.set_default_size(250, 100)
        self.set_border_width(10)

        # the data in the model (three strings for each row, one for each
        # column)
        listmodel = Gtk.ListStore(str, str, str, str, str,str)
        # append the values in the model
        for i in range(len(phonebook)):
            listmodel.append(phonebook[i])

        # a treeview to see the data stored in the model
        view = Gtk.TreeView(model=listmodel)
        # for each column
        for i in range(len(columns)):
            # cellrenderer to render the text
            cell = Gtk.CellRendererText()
            # the text in the first column should be in boldface
            if i == 0:
                cell.props.weight_set = True
                cell.props.weight = Pango.Weight.BOLD
            # the column is created
            col = Gtk.TreeViewColumn(columns[i], cell, text=i)
            # and it is appended to the treeview
            view.append_column(col)

        # metode per a seleccionar un element de la llista
      #  view.get_selection().connect("changed", self.on_changed)

        self.label = Gtk.Label()
        self.label.set_text("")

        grid = Gtk.Grid()
        grid.attach(view, 0, 0, 1, 1)
        grid.attach(self.label, 0, 1, 1, 1)

        self.add(grid)

        #metode per selecionar un element i monstrar-lo en un label
    #def on_changed(self, selection):
     #   (model, iter) = selection.get_selected()
     #   self.label.set_text("\n %s %s %s" %
     #                       (model[iter][0],  model[iter][1], model[iter][2]))
      #  return True


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