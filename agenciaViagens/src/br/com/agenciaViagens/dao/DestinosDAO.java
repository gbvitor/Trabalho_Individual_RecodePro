package br.com.agenciaViagens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agenciaViagens.factory.ConnectionFactory;
import br.com.agenciaViagens.model.Destinos;

public class DestinosDAO {
	
	public void save(Destinos destinos) {
	/*
	 * Isso é um sql comum as ? são os parametros que vamos adicionar
	 * na base de dados.
	 */
		String sql = "INSERT INTO cliente(CEPDestino,nomeDestino,valorPassagem)" + "VALUES(?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try{
			//tenta criar uma conecção com banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//cria uma PreparedStatement, classe usada para execultar a query
			pstm = conn.prepareStatement(sql);
			
			//adiciona o valor do primeiro parâmetro do sql
			pstm.setInt(1, destinos.getCEPDestino());
			//adiciona o valor do segundo parâmetro do sql
			pstm.setString(2, destinos.getNomeDestino());
			//adiciona o valor do terceiro parâmetro do sql
			pstm.setDouble(3, destinos.getValorPassagem());;
			
			//executa a sql para iserção de dados
			pstm.execute();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			//fecha as conecções
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		}
		
		
		public void removeByCEP(String CEPDestino) {
			
			String sql = "DELETE FROM destinos WHERE CEPDestino = ?";
				
				Connection conn = null;
				PreparedStatement pstm = null;
				
				try{
					conn = ConnectionFactory.createConnectionToMySQL();

					pstm = conn.prepareStatement(sql);
					
					pstm.setString(1, CEPDestino);
					
					pstm.execute();
					
				}catch(Exception e){
					//Todo auto genered catch block
					e.printStackTrace();
				}finally {
					
					try {
						if(pstm != null) {
							pstm.close();
						}
						if(conn != null) {
							conn.close();
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				}
		
		
		public void update(Destinos destinos) {
	/*
	 * Isso é um sql comum as ? são os parametros que vamos adicionar
	 * na base de dados.
	 */
		String sql = "UPDATE destinos SET nomeDestino = ?, CEPDestino = ?, valorPassagem = ?" +
	 "WHERE CEPDestino = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try{
			//tenta criar uma conecção com banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//cria uma PreparedStatement, classe usada para execultar a query
			pstm = conn.prepareStatement(sql);
			
			//adiciona o valor do primeiro parâmetro do sql
			pstm.setString(1, destinos.getNomeDestino());
			//adiciona o valor do segundo parâmetro do sql
			pstm.setInt(2, destinos.getCEPDestino());
			//adiciona o valor do terceiro parâmetro do sql
			pstm.setDouble(3, destinos.getValorPassagem());
			
			pstm.setInt(4, destinos.getCEPDestino());
			
			//executa a sql para iserção de dados
			pstm.execute();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			//fecha as conecções
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		}
		
		
		public List<Destinos> getdestinos() {
			/*
			 * Isso é um sql comum as ? são os parametros que vamos adicionar
			 * na base de dados.
			 */
				String sql = "SELECT * FROM destinos";
				
				List<Destinos> destinos = new ArrayList<Destinos>();
				
				Connection conn = null;
				PreparedStatement pstm = null;
				//Classe que vai recuperar os dados do banco de dados
				ResultSet rset = null;
				
				try{
					//tenta criar uma conecção com banco de dados
					conn = ConnectionFactory.createConnectionToMySQL();
					
					//cria uma PreparedStatement, classe usada para execultar a query
					pstm = conn.prepareStatement(sql);
					
					rset = pstm.executeQuery();
					
					
					//Enquanto existir dados no banco de dados faça
					while(rset.next()){
						
						Destinos destino = new Destinos();
						
					//recupera a email do banco de dados e atribui ele ao objeto
					destino.setNomeDestino(rset.getString("nomeDestino"));
					//recupera o senha do banco de dados e atribui ele ao objeto
					destino.setCEPDestino(rset.getInt("CEPDestino"));
					//recupera o nome do banco de dados e atribui ele ao objeto
					destino.setValorPassagem(rset.getDouble("valorPassagem"));
					
					//adiciona o contato recuperado a lista de contatos
					destinos.add(destino);
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}finally {
					//fecha as conecções
					try {
						if(rset != null) {
							rset.close();
						}
						if(pstm != null) {
							pstm.close();
						}
						if(conn != null) {
							conn.close();
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				return destinos;
				}
	}