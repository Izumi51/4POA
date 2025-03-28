import java.io.Serializable;

public class Cinema implements Serializable {

	private transient String filme; // filme passando na sala
	private int numeroSala; // numero da sala no cinema
	private int quantidadeCadeiras; // quantidade de cadeiras na sala
	private transient Double precoBase; // preco base para o ingresso na sala para o filme

	public Cinema(String filme, int numeroSala, int quantidadeCadeiras, Double precoBase) {
		super();
		this.filme = filme;
		this.numeroSala = numeroSala;
		this.quantidadeCadeiras = quantidadeCadeiras;
		this.precoBase = precoBase;
	}

	// GET
	public String getFilme() {
		return filme;
	}

	public Double getPrecoBase() {
		return precoBase;
	}

	public int getNumeroSala() {
		return numeroSala;
	}

	public int getQuantidadeCadeiras() {
		return quantidadeCadeiras;
	}

	// SET
	public void setFilme(String filme) {
		this.filme = filme;
	}

	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala;
	}

	public void setPrecoBase(Double precoBase) {
		this.precoBase = precoBase;
	}

	public void setQuantidadeCadeiras(int quantidadeCadeiras) {
		this.quantidadeCadeiras = quantidadeCadeiras;
	}

	// METHODS
	@Override
	public String toString() {
		return "SalaCinema [filme=" + filme + ", numeroSala=" + numeroSala +
				", quantidadeCadeiras=" + quantidadeCadeiras + ", precoBase=" + precoBase + "]";
	}
}

