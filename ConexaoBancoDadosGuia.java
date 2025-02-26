/**
 * Guia para criação de conexao ao banco de dados
 * @author Matheus Rocha Silva
 * @since 26/02/2003
 */

/**
 * Antes de mais nada, lembre de importar os pacotes de SQL, os quais serão mostrados abaixo
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Driver;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoBancoDadosGuia {
	Connection conexao; //Instanciar variavel do tipo Connection o qual será usado para executar a conexao com o banco
	PreparedStatement pst; // Variavel para realizar as ações de consulta 
	ResultSet rs; //Variavel usada para executar as consultas 
	
	
	
	
	// ABAIXO TERA O METODO DE CONEXAO COM O BANCO DE DADOS
	public void conectarBanco() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // URL de Driver para realizar conexao com o Banco de Dados
			conexao = DriverManager.getConnection("jdbc:mysql:localhost//Insira o nome do banco de dados", "root", "senha_do_seu_MySQL");
		}catch(SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * Abaixo será mostrado os metodos CRUD
	 * Criar (CREATE)
	 * Ler (READ)
	 * Atualizar (UPDATE)
	 * Deletar (DELETE)
	 * 
	 */
	
	
	/**
		 *  Aqui havera o metodo para inserir os dados
		 *  Geralmentec com todos os metodos é necessario usar o try..catch
		 *  assim como foi feito no metodo de conexao com o banco de dados
		 */
	
	public void inserirDados() {
		
		try {
			// Assim como no banco de dados, você insere uma declação usada lá
			pst = conexao.prepareStatement("INSERT INTO SUA_TABELA(atributo1, atributo2, atributo3....) VALUES(?, ?, ?, ....)"); // OS ? REPRESENTAM A QUANTIDADE DE ATRIBUTOS E OS VALORES QUE VOCE MESMO IRA DECIDIR
			pst.setString(1, "atributo1");
			pst.setString(2, "atributo2");
			pst.setString(3, "atributo3");
			pst.executeUpdate(); // Ao final essa ultima declaração Executa tudo o que foi feito
			
			
			//DETALHES: pst.set deve mudar de acord com o tipo de variavel usado, por exemplo, pst.setInt, pst.setString e assim por diante
			// Os numeros antes dos atributos representam eles mesmo, ou seja, uma sequencia de variaveis que serão aletaradas			
		}catch(SQLException ex) {
			
			ex.printStackTrace();
		}	
	}
	
	
	/**
	 * Nota-se que o processo deesses metodos repetem bastante, pois de certa forma são iguais mesmo
	 * o que muda de certa forma é o comando usado do SQL e a sequencia de atributos que serão alterados
	 */
	
	public void atualizarDados() {
			
		try {
			pst = conexao.prepareStatement("UPDATE SUA_TABELA SET atributo1 = ?, atributo2 = ? atributo3 = ? WHERE ID = ?"); // AQUI MUDOU O COMANDO SQL PARA ATUALIZAR NOTE COMO SEGUE O MESMO PRINCIPIO
			pst.setString(1, "atributo1");
			pst.setString(2, "atributo2");
			pst.setString(3, "atributo3");
			pst.setInt(3, "ID"); // AQUI NESSE CASO ASSIM COMO NO METODO DELETAR, UTILIZA O ID
			
			pst.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		}

	
	
	/**
	 * Metodo para deletar dados
	 */
	public void deletarDados() {
		try {
			pst = conexao.prepareStatement("DELETE FROM SUA_TABELA WHERE ID = ?");					 
			pst.setInt(0, "ID"); // NO CASO DO DELETE É BEM MAIS SIMPLES, POIS UTILIZA APENAS OS ID
			pst.executeUpdate();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

	/**
	 * Por fim o metodo para selecionar tudo de determinada tabela
	 */
	
	public void puxarTodosOsDados() {
		
		try {
			pst = conexao.prepareStatement("SELECT * FROM SUA_TABELA");
			rs = pst.executeQuery(); // AQUI O DIFERENTE É QUE O RS RECEBE O RESULTADO E O PST EXECUTA A CONSULTA SENDO USADO COM executeQuery()
			
			while(rs.next()) {
				/**
				 * Objeto_da_classe.setAtributo1(resultSet.getTipo_Prmitivo("atributo1"));
				 * Objeto_da_classe.setAtributo2(resultSet.getTipo("atributo2"));
				 * Objeto_da_classe.setAtributo3(resultSet.getTipo("atributo3"));
				 * Objeto_da_classe.setAtributo4(resultSet.getTipo("atributo4"));
				 * ........
				 */
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	
}
