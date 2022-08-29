package avaliacaoProfessor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sistemaDeCadastro.Usuario;

public class Crud {
	private Connection conexao = FabricaConexao.getConexao();
	
	public void inserirComentario(String nome, String conteudo) throws SQLException {
		String sql2 = "SELECT id FROM professores WHERE  nome = '" + nome + "'; ";
		Statement stmt2 = conexao.createStatement();
		ResultSet resultado = stmt2.executeQuery(sql2);
		while(resultado.next()) {
			if(resultado.getString("id") != null) {
				String sql1 = "INSERT INTO comentario "
						+ "(conteudo, id)"
						+ " VALUES (?,?);";
				PreparedStatement stmt1 = conexao.prepareStatement(sql1);
				stmt1.setString(1, conteudo);
				stmt1.setString(2, resultado.getString("id"));
				stmt1.execute();
			}else {throw new RuntimeException("Nome de professor inválido");}
		}
	}
	public List<Comentario> mostrarComentario(String nome) throws SQLException {
		String sql2 = "SELECT id FROM professores WHERE  nome = '" + nome + "'; ";
		Statement stmt2 = conexao.createStatement();
		ResultSet resultado = stmt2.executeQuery(sql2);
		List<Comentario> comentarios = new ArrayList<>();
		while(resultado.next()) {
			if(resultado.getString("id") != null) {
				String sql3 = "SELECT * FROM comentario WHERE  id = '" + resultado.getString("id") + "'; ";
				Statement stmt3 = conexao.createStatement();
				ResultSet resultado2 = stmt3.executeQuery(sql3);
				while(resultado2.next()) {
					String id_comentario = resultado2.getString("id_comentario");
					String conteudo = resultado2.getString("conteudo");
					String id = resultado.getString("id");
					comentarios.add(new Comentario(id_comentario, conteudo, id));
				}
			}else {throw new RuntimeException("Nome de professor inválido");}
		}
		return comentarios;
	}
	public void removerComentario(String conteudo) throws SQLException {
		String sql = "DELETE FROM comentario WHERE conteudo  = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, conteudo);
		stmt.execute();
	}	
	public List<Professor> mostrarProfessores() throws SQLException {
		String sql = "SELECT * FROM professores;";
		Statement stmt = conexao.createStatement();
		ResultSet resultado = stmt.executeQuery(sql);
		List<Professor> professor = new ArrayList<>();
		while(resultado.next()) {
			String id = resultado.getString("id");
			String nome = resultado.getString("nome");
			professor.add(new Professor(id, nome));
		}
		return professor;
	}
}
