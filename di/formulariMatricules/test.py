from gi.repository import Gtk
from os.path import abspath, dirname, join

WHERE_AM_I = abspath(dirname(__file__))

class MyApp(object):

    def __init__(self):
        # Build GUI
        self.builder = Gtk.Builder()
        self.glade_file = join(WHERE_AM_I, 'test.glade')
        self.builder.add_from_file(self.glade_file)

        # Get objects
        go = self.builder.get_object
        self.window = go('window')
        self.myliststore = go('myliststore')
        self.mycombobox = go('mycombobox')

        # Initialize interface
        colors = [
            ['#8C1700', 'Redish'],
            ['#008C24', 'Greenish'],
            ['#6B6BEE', 'Blueish'],

        ]
        for c in colors:
            self.myliststore.append(c)
        self.mycombobox.set_active(0)

        # Connect signals
        self.builder.connect_signals(self)

        # Everything is ready
        self.window.show()

    def main_quit(self, widget):
        Gtk.main_quit()

    def combobox_changed(self, widget, data=None):
        model = widget.get_model()
        active = widget.get_active()
        if active >= 0:
            code = model[active][0]
            print('The code of the selected color is {}'.format(code))
        else:
            print('No color selected')

if __name__ == '__main__':
    try:
        gui = MyApp()
        Gtk.main()
    except KeyboardInterrupt:
        pass
