package ogr.genaration.lojasdejogos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity // cria tabela 
@Table(name="tb_categoria") //  dar o nome para tabela
public class Categoria {
	@Id //chave primaria
	@GeneratedValue (strategy = GenerationType.IDENTITY)// Informa que a estrategia é o mesmo que id ++  
private Long id;
	
	@NotBlank (message = "o nome é obrigatorio")// Not blank está avisando que não pode deixar o espaço em branco e o nome é obrigatorio
private String nome;
	
	@NotNull // Esta dizendo que o valor não pode ser nulo
private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
}
