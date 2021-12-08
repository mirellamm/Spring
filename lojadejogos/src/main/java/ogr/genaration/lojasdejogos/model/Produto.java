package ogr.genaration.lojasdejogos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Produto {
	@Entity 
	@Table (name="tb_produto")
	
	public class produto{
		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public String getValor() {
			return valor;
		}

		public void setValor(String valor) {
			this.valor = valor;
		}

		@Id 
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotBlank (message = "o nome é obrigatorio")
		private String nome; 
		
		@NotNull
		private String descricao;
		
		@NotNull
		private String valor; 
	}
	

}
