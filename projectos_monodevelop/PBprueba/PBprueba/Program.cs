using System;
using MySql.Data.MySqlClient;

namespace PBdprueba
{
	class MainClass
	{
		public static void Main (string[] args){
			String sql =("Database=dbprueba; User Id=root; Password=sistemas");


		/*	Console.WriteLine ("Probando acceso a dbPrueba");
			MySqlConnection mySqlConnection = new MySqlConnection 
				("Database=dbprueba; User Id=root; Password=sistemas");
			mySqlConnection.Open ();
			//operacioins
			Console.WriteLine("conectant...");
			mySqlConnection.Close ();*/
			Boolean bandera=true;
			do{
			Console.WriteLine ("Tria la opció que vols fer: " +
				"\n0.Eixir" +
				"\n1.Nou" +
				"\n2.Editar" +
				"\n3.Eliminar" +
				"\n4.Llistar");

			switch (Console.Read())
			{
			case '0': Console.Write("\n Eixint..");
					bandera=false;
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


					Console.WriteLine("Quin id vols mostrar");

					int id = Console.Read();
					Console.Write("El numero és "+id);

					using(MySqlConnection cn = new MySqlConnection(sql)){
						cn.Open();
						MySqlCommand cmd =new MySqlCommand("Select * From categoria",cn);
						MySqlDataReader dr =cmd.ExecuteReader();
						if(dr.Read()){
							
							Console.WriteLine(Convert.ToString(dr[id]));
						//	Console.WriteLine(Convert.ToString(dr["nombre"]));

						}
						cn.Close();
					}
					/*	
					//Console.WriteLine (Probando acceso a dbPrueba");
					MySqlConnection mySqlConnection = new MySqlConnection 
						("Database=dbprueba; User Id=root; Password=sistemas");

					MySqlCommand cmd= new MySqlCommand();
					MySqlDataReader reader;

					cmd.CommandText= "Select * FROM categoria";
					cmd.CommandType= System.Data.CommandType.Text;
					cmd.Connection = mySqlConnection;
					reader = cmd.ExecuteReader();
					//Console.WriteLine("conectant...");
					mySqlConnection.Close ();*/

				break;
			} 
			Console.ReadKey();
			}while (bandera==true);

		}
	}
		
}