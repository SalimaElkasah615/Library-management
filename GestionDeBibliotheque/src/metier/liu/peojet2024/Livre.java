package metier.liu.peojet2024;

public class Livre {
	/*********************
	 * donnees
	 *********************/
	private int ISBN ;
	private String titre ;
	private int IdAuteur ;
	
	/*********************
	 * constructeurs
	 *********************/
	public Livre(int iSBN, String titre, int idAuteur) {
		super();
		ISBN = iSBN;
		this.titre = titre;
		IdAuteur = idAuteur;
	}
	public Livre() {
		
	}
	
	/*********************
	 * getters et setters
	 *********************/
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getIdAuteur() {
		return IdAuteur;
	}
	public void setIdAuteur(int idAuteur) {
		IdAuteur = idAuteur;
	}
	/*********************
	 * affichage
	 *********************/
	@Override
	public String toString() {
		return "Livre [ISBN=" + ISBN + ", titre=" + titre + ", IdAuteur=" + IdAuteur + "]";
	}
	
	
	
}
