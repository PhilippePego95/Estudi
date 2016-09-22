using System;
using MySql.Data.MySqlClient;
using System.Data;

namespace PBdprueba
{

	class MainClass
	{
		public static void Main (string[] args)
		{

			IDbConnection dbConnection = new MySqlConnection ("Database=dbprueba; User Id=root; Password=sistemas");
			dbConnection.Open ();
			dbConnection.CreateCommand ();
			IDbCommand dbCommand= dbConnection.CreateCommand();
			IDataParameter parameterName = dbCommand.CreateParameter();
			IDataParameter parameterID = dbCommand.CreateParameter();





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
					dbCommand.CommandText = "insert into categoria (nombre) values (@nombre)";

					parameterName.ParameterName = "nombre";
					Console.WriteLine("Disme el nom ");
					String nom = Console.ReadLine();
					parameterName.Value = nom;
					dbCommand.Parameters.Add (parameterName);
					dbCommand.ExecuteNonQuery ();				


					break;
				case '2': Console.Write("\n Editant..");

					dbCommand.CommandText="Update categoria set nombre =@nombre where id=@id";

					Console.WriteLine("Disme el id ");
					String id = Console.ReadLine();
					parameterID.ParameterName = "id";
					parameterID.Value = id;
					dbCommand.Parameters.Add (parameterID);

					parameterName.ParameterName = "nombre";
					Console.WriteLine("Disme el nom ");
					String names = Console.ReadLine();
					parameterName.Value = names;
					dbCommand.Parameters.Add (parameterName);

					dbCommand.ExecuteNonQuery ();


					break;
				case '3': Console.Write("\n Eliminant..");

					dbCommand.CommandText = "delete from categoria where id = @id";

					parameterID.ParameterName = "id";
					Console.WriteLine("Disme el id ");
					String ids = Console.ReadLine();
					parameterID.Value = ids;
					dbCommand.Parameters.Add (parameterID);
					dbCommand.ExecuteNonQuery ();

					break;
				case '4': Console.WriteLine("\n Llistant..");



					dbCommand.CommandText="Select * From categoria";
					IDataReader dr =dbCommand.ExecuteReader();

					while(dr.Read()){

						Console.Write(dr["id"]);
						Console.WriteLine(dr["nombre"]);

					}dr.Close();	

					break;
				} 
				Console.ReadKey();
			}while (bandera==true);

			dbConnection.Close ();

		}
	}
}