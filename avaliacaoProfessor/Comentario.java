package avaliacaoProfessor;

public class Comentario {
	private String conteudo, id_comentario, id;
	Comentario(){};
	Comentario(String id_comentario, String conteudo, String id){
		this.id_comentario = id_comentario;
		this.conteudo = conteudo;
		this.id = id;
	}
	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getId_comentario() {
		return id_comentario;
	}

	public void setId_comentario(String id_comentario) {
		this.id_comentario = id_comentario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
