package dao.liu.projet2024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bdd.liu.projet2024.*;
import metier.liu.peojet2024.*;


public class AuteurDao implements Dao<Auteur> {
		private Connection conn= null;
		
		public AuteurDao() {
			try {
				conn = DBConnection.getInstance().getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	//methode get
		public Auteur get(long id) {
			Auteur auteur = null;
			String requet = "SELECT * FROM auteur WHERE IdAuteur = " + (int) id;
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				ResultSet rs = pstm.executeQuery(requet);
				if (rs.next()) {
					int IdAuteur = rs.getInt("IdAuteur");
					String nom = rs.getString("nom");
					//String adresse = rs.getString("adresse");//
					String region = rs.getString("region");
					auteur = new Auteur(IdAuteur, nom, region);
					System.out.println(auteur.toString());
					System.out.println();
				}
				else throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... element introuvable");
				e.printStackTrace();
			}
			return auteur;	
		}
		
	//get all
		public List<Auteur> getAll() {
			// TODO Auto-generated method stub
			Auteur auteur = null;
			ArrayList<Auteur> arrayList = new ArrayList<>();
			String requet = "SELECT * FROM auteur";
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				ResultSet rs = pstm.executeQuery(requet);
				if (rs.next())
					do {
						int IdAuteur = rs.getInt("IdAuteur");
						String nom = rs.getString("nom");
						//String adresse = rs.getString("adresse");//
						String region = rs.getString("region");
						auteur = new Auteur(IdAuteur, nom, region);
						arrayList.add(auteur);
						System.out.println(auteur.toString());
					} while (rs.next());
				else throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... elements introuvables");
				e.printStackTrace();
			}
			return arrayList;
		}
		@Override
		public void save(Auteur t) {
			String requet = "INSERT INTO auteur(IdAuteur, nom, region) VALUES('"+t.getIdAuteur()+"', '"+t.getNom()+"', ', '"+t.getRegion()+"')";
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				int rs = pstm.executeUpdate(requet);
				if (rs>0)
					System.out.println("\tAuteur enregistre !\n");
				else
					throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... enregistrement echoue");
				e.printStackTrace();
			}
		}
		//update
		@Override
		public void update(Auteur t, String[] params) {
			String requet = "UPDATE auteur SET nom='"+params[0]+"', "
							//+ "adresse='"+params[1]+"' "//
							+ "region='"+params[1]+"' "
							+ "WHERE IdAuteur = " + (int) t.getIdAuteur();
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				int rs = pstm.executeUpdate(requet);
				if (rs>0)
					System.out.println("\tAuteur modifie !\n");
				else throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... modification echouee");
				e.printStackTrace();
			}
		}
	//
		public void delete(Auteur t) {
			String requet = "DELETE FROM auteur WHERE numero = " + (int) t.getIdAuteur();
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				int rs = pstm.executeUpdate(requet);
				if (rs>0)
					System.out.println("\tAuteur supprime !\n");
				else throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... suppression echouee");
				e.printStackTrace();
			}
		}
	//
			public static void main(String[] args) {
				System.out.println("Test de methode select by id");
				new AuteurDao().get(10);// get by id
				//System.out.println("Test de methode insertion");
				//new AuteurDao().save(new Auteur(12, "salima", "LY", "Mauritanie"));;// insert
				System.out.println("Test de methode select * all ");
				new AuteurDao().getAll();// get qll
				// update
				// delete
		}
			public void createAuteur(Auteur auteur) {
				// TODO Auto-generated method stub
				
			}
	}


