package metier.liu.peojet2024;

public class Telephone {

	private int numero ;
	private String type ;
	private int IdAuteur ;
	
	public Telephone(int numero, String type, int idAuteur) {
		super();
		this.numero = numero;
		this.type = type;
		IdAuteur = idAuteur;
	}
	public Telephone() {

	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getIdAuteur() {
		return IdAuteur;
	}
	public void setIdAuteur(int idAuteur) {
		IdAuteur = idAuteur;
	}
	@Override
	public String toString() {
		return "Telephone [numero=" + numero + ", type=" + type + ", IdAuteur=" + IdAuteur + "]";
	}
	
	
}
