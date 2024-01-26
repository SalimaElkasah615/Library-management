package dao.liu.projet2024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import bdd.liu.projet2024.*;
import metier.liu.peojet2024.*;

public class LivreDao implements Dao<Livre> {
	
		private Connection conn= null;
		
		public LivreDao() {
			try {
				conn = DBConnection.getInstance().getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	//methode get
		public Livre get(long id) {
			Livre livre = null;
			String requet = "SELECT * FROM livre WHERE ISBN = " + (int) id;
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				ResultSet rs = pstm.executeQuery(requet);
				if (rs.next()) {
					int ISBN = rs.getInt("ISBN");
					String titre = rs.getString("titre");
					int IdAuteur = rs.getInt("IdAuteur");
					livre = new Livre(ISBN, titre, IdAuteur);
					System.out.println(livre.toString());
					System.out.println();
				}
				else throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... element introuvable");
				e.printStackTrace();
			}
			return livre;	
		}
		
	//get all
		public List<Livre> getAll() {
			// TODO Auto-generated method stub
			Livre livre = null;
			ArrayList<Livre> arrayList = new ArrayList<>();
			String requet = "SELECT * FROM livre";
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				ResultSet rs = pstm.executeQuery(requet);
				if (rs.next())
					do {
						int ISBN = rs.getInt("ISBN");
						String titre = rs.getString("titre");
						int IdAuteur = rs.getInt("IdAuteur");
						livre = new Livre(ISBN, titre, IdAuteur);
						arrayList.add(livre);
						System.out.println(livre.toString());
					} while (rs.next());
				else throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... elements introuvables");
				e.printStackTrace();
			}
			return arrayList;
		}
		@Override
		public void save(Livre t) {
			String requet = "INSERT INTO livre(ISBN, titre, IdAuteur) VALUES('"+t.getISBN()+"', '"+t.getTitre()+"', '"+t.getIdAuteur()+"')";
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				int rs = pstm.executeUpdate(requet);
				if (rs>0)
					System.out.println("\tlivre enregistre !\n");
				else
					throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... enregistrement echoue");
				e.printStackTrace();
			}
		}
		@Override
		public void update(Livre t, String[] params) {
			String requet = "UPDATE livre SET titre='"+params[0]+"', "
							+ "IdAuteur='"+params[1]+"' "
							+ "WHERE ISBN = " + (int) t.getISBN();
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				int rs = pstm.executeUpdate(requet);
				if (rs>0)
					System.out.println("\tLivre modifie !\n");
				else throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... modification echouee");
				e.printStackTrace();
			}
		}
	//
		public void delete(Livre t) {
			String requet = "DELETE FROM livre WHERE ISBN = " + (int) t.getISBN();
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				int rs = pstm.executeUpdate(requet);
				if (rs>0)
					System.out.println("\tLivre supprime !\n");
				else throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... suppression echouee");
				e.printStackTrace();
			}
		}
	//
			public static void main(String[] args) {
				System.out.println("Test de methode select by id");
				new LivreDao().get(987654);// get by id
				//System.out.println("Test de methode insertion");
				//new LivreDao().save(new Livre(12, "IT",13 ));;// insert
				System.out.println("Test de methode select * all ");
				new LivreDao().getAll();// get all
				// update
				// delete
		}
	}
