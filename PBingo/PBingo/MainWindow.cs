using System;
using Gtk;
using System.Diagnostics;
using System.Collections.Generic;

public partial class MainWindow: Gtk.Window
{	
	public MainWindow (): base (Gtk.WindowType.Toplevel)
	{
		Build ();

		Random random = new Random ();

		List<Button> buttons = new List<Button> ();

		Table table = new Table (10, 10, true);

		//Opcion 1
		for (uint index = 0; index<110; index++) {

			Button button = new Button ();
			button.Label = (index+1).ToString();
			button.Visible = true;
			uint fila = index / 10;
			uint colum = index % 10;

			table.Attach (button, colum, colum+1, fila, fila+1);
			buttons.Add (button);
		}

		table.Visible = true;
		vbox1.Add (table);


		button1.Clicked += delegate {
			int indexAleatorio = random.Next(buttons.Count);
			Button button = buttons[indexAleatorio];
			button.ModifyBg(StateType.Normal, new Gdk.Color(0,200,0));
			buttons.RemoveAt(indexAleatorio);
			indexAleatorio++;
			Process.Start("espeak", "-v es "+button.Label);
			label2.Text=button.Label.ToString();
			button1.Sensitive = buttons.Count>0;
		};


	}

	protected void OnDeleteEvent (object sender, DeleteEventArgs a)
	{
		Application.Quit ();
		a.RetVal = true;
	}
}
