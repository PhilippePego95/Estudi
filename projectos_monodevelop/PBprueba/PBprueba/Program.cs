using System;
using MySql.Data.MySqlClient;

namespace PBdprueba
{
	class MainClass
	{
		public static void Main (string[] args)
		{


			/*Console.WriteLine ("Probando acceso a dbPrueba");
			MySqlConnection mySqlConnection = new MySqlConnection 
				("Database=dbprueba; User Id=root; Password=sistemas");
			mySqlConnection.Open ();
			//operacioins
			Console.WriteLine("conectant...");
			mySqlConnection.Close ();*/

			Console.WriteLine ("Tria la opció que vols fer: " +
				"\n0.Eixir" +
				"\n1.Nou" +
				"\n2.Editar" +
				"\n3.Eliminar" +
				"\n4.Llistar");

			switch (Console.Read())
			{
			case '0': Console.Write("\n Eixint..");
				// Continuar lógica y extraer métodos //
				break;
			case '1': Console.Write("\n Creant..");
				// Continuar lógica y extraer métodos //
				break;
			case '2': Console.Write("\n Editant..");
				// Continuar lógica y extraer métodos //
				break;
			case '3': Console.Write("\n Eliminant..");
				// Continuar lógica y extraer métodos //
				break;
			case '4': Console.Write("\n Llistant..");
				// Continuar lógica y extraer métodos //
				break;
			} 
			Console.ReadKey();

		}

	}
}
