import gtk
import sqlite3

class  ListViewTestApp:
    def __init__(self):
        builder = gtk.Builder()
        builder.add_from_file('listview_test.glade')
        builder.connect_signals(self)

        self.model = builder.get_object('list_items')
        self.list = builder.get_object('items_view')

        column = gtk.TreeViewColumn('column0', gtk.CellRendererText(), text=0)   
        column.set_clickable(True)   
        column.set_resizable(True)   
        self.list.append_column(column)

        column = gtk.TreeViewColumn('column1', gtk.CellRendererText(), text=0)   
        column.set_clickable(True)   
        column.set_resizable(True)   
        self.list.append_column(column)

        column = gtk.TreeViewColumn('column3', gtk.CellRendererText(), text=0)   
        column.set_clickable(True)   
        column.set_resizable(True)   
        self.list.append_column(column)

        self.create_database()
        self.load_list_items()

        window = builder.get_object('main_window')
        window.show_all()

    def create_database(self):
        self.engine = sqlite3.connect(':memory:')
        self.engine.execute('create table test_table ' + \
            '(id INTEGER NOT NULL PRIMARY KEY, test_field0 VARCHAR(30), test_field1 VARCHAR(30))');
        self.add_new_line('test0', 'test000');
        self.add_new_line('test1', 'test111');

    def load_list_items(self):
        self.model.clear()        
        result = self.engine.execute('select * from test_table');
        for row in result: 
            self.model.append([row[1], row[2]])

    def add_new_line(self, test0, test1):
        query = 'INSERT INTO test_table (test_field0, test_field1) VALUES ("{0}", "{1}")'\
            .format(test0, test1)
        self.engine.execute(query)

    def on_load_button_clicked(self, widget):
        self.load_list_items()

    def on_add_line_button_clicked(self, widget):
        id = len(self.model)
        self.add_new_line('new_item{0}'.format(id), 'new__item{0}'.format(id));
        self.load_list_items()

if __name__ == "__main__":
    ListViewTestApp()
    gtk.main()