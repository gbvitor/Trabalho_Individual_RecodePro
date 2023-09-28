package br.com.agenciaViagens.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	//Nome de Úsuario
		private static final String USERNAME = "root";
		//Senha do MySQL
		private static final String PASSWORD = "PASSWORD";
		//Dados do caminho, porta e nome da base de dados que será feita a conecção
		private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/FILE";
		
		/**
		 * @param username
		 * @param senha
		 * @return uma conecção com banco de dados
		 * @throws Exception
		 */
		
		public static Connection createConnectionToMySQL() throws Exception{
			Class.forName("com.mysql.cj.jdbc.Driver"); //faz com que a classe seja carregado pela JVM
			
			//cria uma conecção com banco de dados
			Connection connection = DriverManager.getConnection(URL_DATABASE, USERNAME, PASSWORD);
			return connection;
		}
		
		//Recupera uma conecção com banco de dados
		public static void main(String[] args) throws Exception{
			Connection con = createConnectionToMySQL();
			
			//Testa se a conecção é nula
			if(con != null){
				System.out.println("Conecção obtida com sucesso!" + con);
				
				con.close();
			}
		}
	}

