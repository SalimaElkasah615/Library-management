package metier.liu.peojet2024;

public class Associer {
	
private int IdBibliotheque ;
private int IdAuteur ;

public Associer(int idBibliotheque, int idAuteur) {
	super();
	IdBibliotheque = idBibliotheque;
	IdAuteur = idAuteur;
}
//////
public Associer() {
	// TODO Auto-generated constructor stub
}
///
public int getIdBibliotheque() {
	return IdBibliotheque;
}
public void setIdBibliotheque(int idBibliotheque) {
	IdBibliotheque = idBibliotheque;
}
public int getIdAuteur() {
	return IdAuteur;
}
public void setIdAuteur(int idAuteur) {
	IdAuteur = idAuteur;
}
@Override
public String toString() {
	return "Associer [IdBibliotheque=" + IdBibliotheque + ", IdAuteur=" + IdAuteur + "]";
}


}
