package metier.liu.peojet2024;

public class Bibliotheque {
	private int IdBibliotheque;
	private String emplacement;
	
	public Bibliotheque(int idBibliotheque, String emplacement) {
		super();
		IdBibliotheque = idBibliotheque;
		this.emplacement = emplacement;
	}

	public int getIdBibliotheque() {
		return IdBibliotheque;
	}

	public void setIdBibliotheque(int idBibliotheque) {
		IdBibliotheque = idBibliotheque;
	}

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	@Override
	public String toString() {
		return "Bibliotheque [IdBibliotheque=" + IdBibliotheque + ", emplacement=" + emplacement + "]";
	}
	
	
}
