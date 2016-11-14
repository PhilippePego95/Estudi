using System;
using Gtk;

namespace TreeView {
	class MainClass	{
		public static void Main (string[] args)	{
			Application.Init ();
			MainWindow win = new MainWindow ();
			win.Show ();
			Application.Run ();

			for (int i = 1; i <= 5; i++) {
				Console.WriteLine(i);
			}
		}
	}
}
