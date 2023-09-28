package main;
import br.com.agenciaViagens.dao.CadastroDestinoDAO;
import br.com.agenciaViagens.model.CadastroDestino;


public class Main {
public static void main(String[] args) {
		
		CadastroDestinoDAO cadastDestDAO = new CadastroDestinoDAO();
		
		//cria um novo contato e salva no banco de dados
		CadastroDestino cadDes = new CadastroDestino();
		cadDes.setEmail("email@exemplo.com.br");
		cadDes.setNome("vitor");
		
		cadastDestDAO.save(cadDes);
		
		for(CadastroDestino c: cadastDestDAO.getCadastroDestino()) {
			System.out.println("ID: " + c.getId());
			System.out.println("Email: " + c.getEmail());
			System.out.println("Nome: " + c.getNome());
		
			
		}
}
}
