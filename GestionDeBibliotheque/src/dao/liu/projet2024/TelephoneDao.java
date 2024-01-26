package dao.liu.projet2024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bdd.liu.projet2024.DBConnection;

import metier.liu.peojet2024.Telephone;

public class TelephoneDao implements Dao<Telephone> {
		
		private Connection conn= null;
		
		public TelephoneDao() {
			try {
				conn = DBConnection.getInstance().getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	//methode get
		public Telephone get(long id) {
			Telephone telephone = null;
			String requet = "SELECT * FROM telephone WHERE numero = " + (int) id;
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				ResultSet rs = pstm.executeQuery(requet);
				if (rs.next()) {
					int numero = rs.getInt("numero");
					String type = rs.getString("type");
					int IdAuteur = rs.getInt("IdAuteur");
					telephone = new Telephone(numero, type, IdAuteur);
					System.out.println(telephone.toString());
					System.out.println();
				}
				else throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... element introuvable");
				e.printStackTrace();
			}
			return telephone;	
		}
		
	//get all
		public List<Telephone> getAll() {
			// TODO Auto-generated method stub
			Telephone telephone = null;
			ArrayList<Telephone> arrayList = new ArrayList<>();
			String requet = "SELECT * FROM telephone";
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				ResultSet rs = pstm.executeQuery(requet);
				if (rs.next())
					do {
						int numero = rs.getInt("numero");
						String type = rs.getString("type");
						int IdAuteur = rs.getInt("IdAuteur");
						telephone = new Telephone(numero, type, IdAuteur);
						arrayList.add(telephone);
						System.out.println(telephone.toString());
					} while (rs.next());
				else throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... elements introuvables");
				e.printStackTrace();
			}
			return arrayList;
		}
		@Override
		public void save(Telephone t) {
			String requet = "INSERT INTO telephone(numero, type, IdAuteur) VALUES('"+t.getNumero()+"', '"+t.getType()+"', '"+t.getIdAuteur()+"')";
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				int rs = pstm.executeUpdate(requet);
				if (rs>0)
					System.out.println("\ttelephone enregistre !\n");
				else
					throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... enregistrement echoue");
				e.printStackTrace();
			}
		}
		@Override
		public void update(Telephone t, String[] params) {
			String requet = "UPDATE telephone SET type='"+params[0]+"', "
							+ "IdAuteur='"+params[1]+"' "
							+ "WHERE numero = " + (int) t.getNumero();
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				int rs = pstm.executeUpdate(requet);
				if (rs>0)
					System.out.println("\tTelephone modifie !\n");
				else throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... modification echouee");
				e.printStackTrace();
			}
		}
	//
		public void delete(Telephone t) {
			String requet = "DELETE FROM telephone WHERE numero = " + (int) t.getNumero();
			System.out.println(requet);
			try {
				Statement pstm = conn.createStatement();
				int rs = pstm.executeUpdate(requet);
				if (rs>0)
					System.out.println("\ttelephone supprime !\n");
				else throw new SQLException();
			} catch (SQLException e) {
				System.out.println("Erreur SQL... suppression echouee");
				e.printStackTrace();
			}
		}
	//
			public static void main(String[] args) {
				System.out.println("Test de methode select by id");
				new TelephoneDao().get(101010);// get by id
				//System.out.println("Test de methode insertion");
				//new TelephoneDao().save(new Telephone(1213007, "Fixe",12 ));;// insert
				System.out.println("Test de methode select * all ");
				new TelephoneDao().getAll();// get all
				// update
				// delete
		}
	}
