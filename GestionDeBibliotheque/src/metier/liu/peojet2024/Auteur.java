package metier.liu.peojet2024;

public class Auteur {

	private int IdAuteur ;
	private String nom ;
	//private String adresse ;//
	private String region ;
	
	public Auteur(int idAuteur, String nom, String region) {
		super();
		IdAuteur = idAuteur;
		this.nom = nom;
		//this.adresse = adresse;//
		this.region = region;
	}

	public int getIdAuteur() {
		return IdAuteur;
	}

	public void setIdAuteur(int idAuteur) {
		IdAuteur = idAuteur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	//public String getAdresse() {
		//return adresse;
	//}

	//public void setAdresse(String adresse) {
		//this.adresse = adresse;
	//}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Auteur [IdAuteur=" + IdAuteur + ", nom=" + nom + ", region=" + region + "]";
	}

	
	
	
}
