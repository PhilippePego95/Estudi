using System;
using Gtk;

public partial class MainWindow: Gtk.Window
{
	public MainWindow () : base (Gtk.WindowType.Toplevel){
		Build ();
	}

	protected void OnDeleteEvent (object sender, DeleteEventArgs a)	{
		Application.Quit ();
		a.RetVal = true;
	

	Button btn = new Button();
	for (int i = 0; i < 10; i++){

		btn = new Button();
		btn.Name = "myButton" + i.ToString();
			Frame.Add (btn);

		}
	}
}
