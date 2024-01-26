package dao.liu.projet2024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bdd.liu.projet2024.DBConnection;
import metier.liu.peojet2024.Associer;

public class AssocierDao implements Dao<Associer> {
		
		private Connection conn= null;
		
		public AssocierDao() {
			try {
				conn = DBConnection.getInstance().getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	//methode get
		public Associer get(long id) {
			Associer associer = null;
			String requet = "SELECT * FROM associer WHERE IdBibliotheque = " + (int) id;
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				ResultSet rs = pstm.executeQuery(requet);
				if (rs.next()) {
					int IdBibliotheque = rs.getInt("IdBibliotheque");
					int IdAuteur = rs.getInt("IdAuteur");
					associer = new Associer(IdBibliotheque,IdAuteur);
					System.out.println(associer.toString());
					System.out.println();
				}
				else throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... element introuvable");
				e.printStackTrace();
			}
			return associer;	
		}
		
	//get all
		public List<Associer> getAll() {
			// TODO Auto-generated method stub
			Associer associer = null;
			ArrayList<Associer> arrayList = new ArrayList<>();
			String requet = "SELECT * FROM associer";
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				ResultSet rs = pstm.executeQuery(requet);
				if (rs.next())
					do {
						int IdBibliotheque = rs.getInt("IdBibliotheque");
						int IdAuteur = rs.getInt("IdAuteur");
						associer = new Associer(IdBibliotheque,IdAuteur);
						arrayList.add(associer);
						System.out.println(associer.toString());
					} while (rs.next());
				else throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... elements introuvables");
				e.printStackTrace();
			}
			return arrayList;
		}
		@Override
		public void save(Associer t) {
			String requet = "INSERT INTO associer(IdBibliotheque, IdAuteur) VALUES('"+t.getIdBibliotheque()+"','"+t.getIdAuteur()+"')";
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				int rs = pstm.executeUpdate(requet);
				if (rs>0)
					System.out.println("\tassocier enregistre !\n");
				else
					throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... enregistrement echoue");
				e.printStackTrace();
			}
		}
		@Override
		public void update(Associer t, String[] params) {
			String requet = "UPDATE associer SET IdAuteur='"+params[0]+"', "
							+ "WHERE IdBibliotheque = " + (int) t.getIdBibliotheque();
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				int rs = pstm.executeUpdate(requet);
				if (rs>0)
					System.out.println("\tassocier modifie !\n");
				else throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... modification echouee");
				e.printStackTrace();
			}
		}
	//
		public void delete(Associer t) {
			String requet = "DELETE FROM associer WHERE IdBibliotheque = " + (int) t.getIdBibliotheque();
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				int rs = pstm.executeUpdate(requet);
				if (rs>0)
					System.out.println("\tassocier supprime !\n");
				else throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... suppression echouee");
				e.printStackTrace();
			}
		}
	//
			public static void main(String[] args) {
				System.out.println("Test de methode select by id");
				new AssocierDao().get(1);// get by id
				//System.out.println("Test de methode insertion");
				//new AssocierDao().save(new Associer(1213007,12 ));;// insert
				System.out.println("Test de methode select * all ");
				new AssocierDao().getAll();// get all
				// update
				// delete
		}
			public void createAssocier(Associer associer) {
				// TODO Auto-generated method stub
				
			}
			public List<Associer> getAllAssociations() {
				// TODO Auto-generated method stub
				return null;
			}
	}
