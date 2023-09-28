package br.com.agenciaViagens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agenciaViagens.factory.ConnectionFactory;
import br.com.agenciaViagens.model.Cliente;

public class ClienteDAO {
	public void save(Cliente cliente) {
		/*
		 * Isso é um sql comum as ? são os parametros que vamos adicionar
		 * na base de dados.
		 */
			String sql = "INSERT INTO cliente(email,senha,nome)" + "VALUES(?,?,?)";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try{
				//tenta criar uma conecção com banco de dados
				conn = ConnectionFactory.createConnectionToMySQL();
				
				//cria uma PreparedStatement, classe usada para execultar a query
				pstm = conn.prepareStatement(sql);
				
				//adiciona o valor do primeiro parâmetro do sql
				pstm.setString(1, cliente.getEmail());
				//adiciona o valor do segundo parâmetro do sql
				pstm.setInt(2, cliente.getSenha());
				//adiciona o valor do terceiro parâmetro do sql
				pstm.setString(3, cliente.getNome());;
				
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
			
			
			public void removeByEmail(String email) {
				
				String sql = "DELETE FROM cliente WHERE email = ?";
					
					Connection conn = null;
					PreparedStatement pstm = null;
					
					try{
						conn = ConnectionFactory.createConnectionToMySQL();

						pstm = conn.prepareStatement(sql);
						
						pstm.setString(1, email);
						
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
			
			
			public void update(Cliente cliente) {
		/*
		 * Isso é um sql comum as ? são os parametros que vamos adicionar
		 * na base de dados.
		 */
			String sql = "UPDATE cliente SET email = ?, senha = ?, nome = ?" +
		 "WHERE email = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try{
				//tenta criar uma conecção com banco de dados
				conn = ConnectionFactory.createConnectionToMySQL();
				
				//cria uma PreparedStatement, classe usada para execultar a query
				pstm = conn.prepareStatement(sql);
				
				//adiciona o valor do primeiro parâmetro do sql
				pstm.setString(1, cliente.getEmail());
				//adiciona o valor do segundo parâmetro do sql
				pstm.setInt(2, cliente.getSenha());
				//adiciona o valor do terceiro parâmetro do sql
				pstm.setString(3, cliente.getNome());
				
				pstm.setString(4, cliente.getEmail());
				
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
			
			
			public List<Cliente> getCliente() {
				/*
				 * Isso é um sql comum as ? são os parametros que vamos adicionar
				 * na base de dados.
				 */
					String sql = "SELECT * FROM cliente";
					
					List<Cliente> clientes = new ArrayList<Cliente>();
					
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
							
							Cliente cliente = new Cliente();
							
						//recupera a email do banco de dados e atribui ele ao objeto
						cliente.setEmail(rset.getString("email"));
						//recupera o senha do banco de dados e atribui ele ao objeto
						cliente.setSenha(rset.getInt("senha"));
						//recupera o nome do banco de dados e atribui ele ao objeto
						cliente.setNome(rset.getString("nome"));
						
						//adiciona o contato recuperado a lista de contatos
						clientes.add(cliente);
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
					return clientes;
					}
		}

