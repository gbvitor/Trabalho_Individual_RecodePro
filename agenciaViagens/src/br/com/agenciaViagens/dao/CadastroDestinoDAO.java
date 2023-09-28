package br.com.agenciaViagens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agenciaViagens.factory.ConnectionFactory;
import br.com.agenciaViagens.model.CadastroDestino;

public class CadastroDestinoDAO {
	public void save(CadastroDestino cdest) {
		/*
		 * Isso é um sql comum as ? são os parametros que vamos adicionar
		 * na base de dados.
		 */
			String sql = "INSERT INTO cadastrodestino(id,email,nome,CEPOrigem,CEPDestino,valorPassagem)" + 
		 "VALUES(?,?,?,?,?,?)";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try{
				//tenta criar uma conecção com banco de dados
				conn = ConnectionFactory.createConnectionToMySQL();
				
				//cria uma PreparedStatement, classe usada para execultar a query
				pstm = conn.prepareStatement(sql);
				
				//adiciona o valor do primeiro parâmetro do sql
				pstm.setInt(1, cdest.getId());
				//adiciona o valor do segundo parâmetro do sql
				pstm.setString(2, cdest.getEmail());
				//adiciona o valor do terceiro parâmetro do sql
				pstm.setString(3, cdest.getNome());
				//adiciona o valor do quarto parâmetro do sql
				pstm.setInt(4, cdest.getCEPOrigem());
				//adiciona o valor do quinto parâmetro do sql
				pstm.setInt(5, cdest.getCEPDestino());
				//adiciona o valor do sexto parâmetro do sql
				pstm.setDouble(6, cdest.getValorPassagem());
				
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
			
			
			public void removeById(String id) {
				
				String sql = "DELETE FROM cadastrodestino WHERE id = ?";
					
					Connection conn = null;
					PreparedStatement pstm = null;
					
					try{
						conn = ConnectionFactory.createConnectionToMySQL();

						pstm = conn.prepareStatement(sql);
						
						pstm.setString(1, id);
						
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
			
			
			public void update(CadastroDestino cdest) {
		/*
		 * Isso é um sql comum as ? são os parametros que vamos adicionar
		 * na base de dados.
		 */
			String sql = "UPDATE cadastrodestino SET id = ?, email = ?, nome = ?, CEPOrigem = ?, CEPDestino = ?, valorPassagem = ?" +
		 "WHERE id = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try{
				//tenta criar uma conecção com banco de dados
				conn = ConnectionFactory.createConnectionToMySQL();
				
				//cria uma PreparedStatement, classe usada para execultar a query
				pstm = conn.prepareStatement(sql);
				
				//adiciona o valor do primeiro parâmetro do sql
				pstm.setInt(1, cdest.getId());
				//adiciona o valor do segundo parâmetro do sql
				pstm.setString(2, cdest.getEmail());
				//adiciona o valor do terceiro parâmetro do sql
				pstm.setString(3, cdest.getNome());
				//adiciona o valor do quarto parâmetro do sql
				pstm.setInt(4, cdest.getCEPOrigem());
				//adiciona o valor do quinto parâmetro do sql
				pstm.setInt(5, cdest.getCEPDestino());
				//adiciona o valor do sexto parâmetro do sql
				pstm.setDouble(5, cdest.getValorPassagem());
				//adiciona o valor do setimo parâmetro do sql
				pstm.setInt(7, cdest.getId());
				
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
			
			
			public List<CadastroDestino> getCadastroDestino() {
				/*
				 * Isso é um sql comum as ? são os parametros que vamos adicionar
				 * na base de dados.
				 */
					String sql = "SELECT * FROM cadastrodestino";
					
					List<CadastroDestino> cadasdestinos = new ArrayList<CadastroDestino>();
					
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
							
							CadastroDestino cadasdestino = new CadastroDestino();
							
							
						//recupera o senha do banco de dados e atribui ele ao objeto
						cadasdestino.setId(rset.getInt("id"));
						//recupera a email do banco de dados e atribui ele ao objeto
						cadasdestino.setEmail(rset.getString("email"));
						//recupera o nome do banco de dados e atribui ele ao objeto
						cadasdestino.setNome(rset.getString("nome"));
						//recupera o nome do banco de dados e atribui ele ao objeto
						cadasdestino.setCEPOrigem(rset.getInt("CEPOrigem"));
						//recupera o nome do banco de dados e atribui ele ao objeto
						cadasdestino.setCEPDestino(rset.getInt("CEPDestino"));
						//recupera o nome do banco de dados e atribui ele ao objeto
						cadasdestino.setValorPassagem(rset.getDouble("valorPassagem"));
						
						//adiciona o contato recuperado a lista de contatos
						cadasdestinos.add(cadasdestino);
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
					return cadasdestinos;
					}
		}