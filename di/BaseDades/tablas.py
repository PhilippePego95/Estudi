import gi
gi.require_version('Gtk', '3.0')
from gi.repository import Gtk
import sqlite3

#http://python-gtk-3-tutorial.readthedocs.io/en/latest/treeview.html
#list of tuples for each software, containing the software name, initial release, and main programming languages used
software_list = [("Firefox", 2002,  "C++"),
                 ("Eclipse", 2004, "Java" ),
                 ("Pitivi", 2004, "Python"),
                 ("Netbeans", 1996, "Java"),
                 ("Chrome", 2008, "C++"),
                 ("Filezilla", 2001, "C++"),
                 ("Bazaar", 2005, "Python"),
                 ("Git", 2005, "C"),
                 ("Linux Kernel", 1991, "C"),
                 ("GCC", 1987, "C"),
                 ("Frostwire", 2004, "Java")]

class TreeViewFilterWindow(Gtk.Window):

    def __init__(self):
        conn = sqlite3.connect('Registre.db')
        cursor=conn.execute("select * from registre");

        Gtk.Window.__init__(self, title="Treeview Filter Demo")
        self.set_border_width(10)

        #Setting up the self.grid in which the elements are to be positionned
        self.grid = Gtk.Grid()
        self.grid.set_column_homogeneous(True)
        self.grid.set_row_homogeneous(True)
        self.add(self.grid)

        #Creating the ListStore model
        cursor=conn.execute("select * from registre");
        for row in cursor:
           print "ID = ", row[0]
           print "USER = ", row[1]
           print "PASSWORD = ", row[2]
           print "EMAIL = ", row[3]
           print "NAME = ", row[4]
           print "SUBNAME = ", row[5]
           print "ADRESS = ", row[6], "\n"
        
        #********************************


        self.liststore = Gtk.ListStore(int, str, str, str, str, str)
        for row in cursor:            
            self.liststore.append(row[0], row[1], row[2], row[3], row[4], row[5], row[6])
        self.current_filter_language = None
        conn.commit()
        print "Records created successfully";
        conn.close()
        #Creating the filter, feeding it with the liststore model
        self.language_filter = self.liststore.filter_new()
        #setting the filter function, note that we're not using the
        self.language_filter.set_visible_func(self.language_filter_func)

        #creating the treeview, making it use the filter as a model, and adding the columns
        self.treeview = Gtk.TreeView.new_with_model(self.language_filter)
        for i, column_title in enumerate(["Id","Usuari", "Contrasenya", "Nom","Cognom","Direccio"]):
            renderer = Gtk.CellRendererText()
            column = Gtk.TreeViewColumn(column_title, renderer, text=i)
            self.treeview.append_column(column)

        #creating buttons to filter by programming language, and setting up their events
       # self.buttons = list()
       # for prog_language in ["Java", "C", "C++", "Python", "None"]:
           # button = Gtk.Button(prog_language)
           # self.buttons.append(button)
          #  button.connect("clicked", self.on_selection_button_clicked)

        #setting up the layout, putting the treeview in a scrollwindow, and the buttons in a row
        self.scrollable_treelist = Gtk.ScrolledWindow()
        self.scrollable_treelist.set_vexpand(True)
        self.grid.attach(self.scrollable_treelist, 0, 0, 8, 10)
      #  self.grid.attach_next_to(self.buttons[0], self.scrollable_treelist, Gtk.PositionType.BOTTOM, 1, 1)
       # for i, button in enumerate(self.buttons[1:]):
       #     self.grid.attach_next_to(button, self.buttons[i], Gtk.PositionType.RIGHT, 1, 1)
        self.scrollable_treelist.add(self.treeview)

        self.show_all()

    def language_filter_func(self, model, iter, data):
        """Tests if the language in the row is the one in the filter"""
        if self.current_filter_language is None or self.current_filter_language == "None":
            return True
        else:
            return model[iter][2] == self.current_filter_language

    def on_selection_button_clicked(self, widget):
        """Called on any of the button clicks"""
        #we set the current language filter to the button's label
        self.current_filter_language = widget.get_label()
        print("%s language selected!" % self.current_filter_language)
        #we update the filter, which updates in turn the view
        self.language_filter.refilter()


win = TreeViewFilterWindow()
win.connect("delete-event", Gtk.main_quit)
win.show_all()
Gtk.main()