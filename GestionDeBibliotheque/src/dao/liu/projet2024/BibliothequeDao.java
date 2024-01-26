package dao.liu.projet2024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bdd.liu.projet2024.*;
import metier.liu.peojet2024.*;


public class BibliothequeDao implements Dao<Bibliotheque> {


		private Connection conn = null;

		public BibliothequeDao() {
			try {
				conn = DBConnection.getInstance().getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
///////////////////////////////GET////////////////////////
		@Override
		public Bibliotheque get(long id) {
			Bibliotheque bibliotheque = null;
			String requet = "SELECT * FROM Bibliotheque WHERE IdBibliotheque = " + (int) id;
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				ResultSet rs = pstm.executeQuery(requet);
				if (rs.next()) {
					int IdBibliotheque = rs.getInt("IdBibliotheque");
					String emplacement = rs.getString("emplacement");
					
					bibliotheque = new Bibliotheque(IdBibliotheque, emplacement);
					System.out.println(bibliotheque.toString());
					System.out.println();
				}
				else throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... element introuvable");
				e.printStackTrace();
			}
			return bibliotheque;	
		}
		
/////////////////////////////////////////////////////////////////////
		
		
/////////////GET ALL/////////////////////////////////////////////////
		
		@Override
		public List<Bibliotheque> getAll() {
			// TODO Auto-generated method stub
			Bibliotheque bibliotheque = null;
			ArrayList<Bibliotheque> arrayList = new ArrayList<>();
			String requet = "SELECT * FROM bibliotheque";
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				ResultSet rs = pstm.executeQuery(requet);
				if (rs.next())
					do {
						int IdBibliotheque = rs.getInt("IdBibliotheque");
						String emplacement = rs.getString("emplacement");
						bibliotheque = new Bibliotheque(IdBibliotheque, emplacement);
						arrayList.add(bibliotheque);
						System.out.println(bibliotheque.toString());
					} while (rs.next());
				else throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... elements introuvables");
				e.printStackTrace();
			}
			return arrayList;
		}
		
/////////////////////////////////////////////////////////////////////////	

		
///////////////////////////SAVE////////////////////////////////////////
		
		public void save(Bibliotheque bibliotheque) {
			String requet = "INSERT INTO Bibliotheque(IdBibliotheque, emplacement) VALUES('"
		+ bibliotheque.getIdBibliotheque()
					+ "', '" + bibliotheque.getEmplacement() + "')";
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				int rs = pstm.executeUpdate(requet);
				if (rs > 0)
					System.out.println("\tBibliotheque enregistre !\n");
				else
					throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... enregistrement echoue");
				e.printStackTrace();
			}

		}
		
////////////////////////////////////////////////////////////////////
		
		
//////////////////////////UPDATE//////////////////////////////////////
		
		@Override
		public void update(Bibliotheque bibliotheque, String[] params) {
			String requet = "UPDATE Bibliotheque SET " + "emplacement='" + params[0] + "' " + "WHERE IdBibliotheque = "
					+ bibliotheque.getIdBibliotheque() + ";";
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				int rs = pstm.executeUpdate(requet);
				if (rs > 0)
					System.out.println("\tBibliotheque modifie !\n");
				else
					throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... modification echouee");
				e.printStackTrace();
			}

		}
	
		
		//ubdate
		

/////////////////////////////////////////////////////////////////////////	
		

///////////////////////////////DELETE/////////////////////////////////////
		
		@Override
		public void delete(Bibliotheque bibliotheque) {
			String requet = "DELETE FROM Bibliotheque WHERE IdBibliotheque = " + bibliotheque.getIdBibliotheque() + "";
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				int rs = pstm.executeUpdate(requet);
				if (rs > 0)
					System.out.println("\tBibliotheque supprime !\n");
				else
					throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... suppression echouee");
				e.printStackTrace();
			}

		}
		
		
		//delete
		
		
/////////////////////////////////////////////////////////////////		

//////////////////////test/////////////////////////////////
		
		//test main
		public static void main(String[] args) {
			System.out.println("Test de methode select by id");
			new BibliothequeDao().get(2);// get by id
			System.out.println("Test de methode insertion");
			new BibliothequeDao().save(new Bibliotheque( 13, "mr"));
			System.out.println("Test de methode update");
			System.out.println("Test de methode select * all ");
			new BibliothequeDao().getAll();
			String[] params= {"Ndb"};
			new BibliothequeDao().update(new BibliothequeDao().get(13), params);
			System.out.println("Test de methode delete");
			System.out.println("Test de methode select * all ");
			new BibliothequeDao().getAll();
			new BibliothequeDao().delete(new BibliothequeDao().get(13));
			System.out.println("Test de methode select * all ");
			new BibliothequeDao().getAll();
		

		}
		
	
}

