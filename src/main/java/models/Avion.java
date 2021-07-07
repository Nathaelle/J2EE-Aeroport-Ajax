package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Avion implements Crud<Avion> {

	private int idAvion;
	private String modele;
	private int capacite;
	private int autonomie;
	
	public Avion() {
		super();
	}
	
	public Avion(int idAvion, String modele, int capacite, int autonomie) {
		super();
		this.idAvion = idAvion;
		this.modele = modele;
		this.capacite = capacite;
		this.autonomie = autonomie;
	}

	public int getIdAvion() {
		return idAvion;
	}

	public void setIdAvion(int idAvion) {
		this.idAvion = idAvion;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public int getAutonomie() {
		return autonomie;
	}

	public void setAutonomie(int autonomie) {
		this.autonomie = autonomie;
	}

	@Override
	public void insert() {

		String query = "INSERT INTO avion (modele, capacite, autonomie) VALUES(?, ?, ?);";
		
		try(PreparedStatement p = DbConnect.getConnector().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			
			// Binding sur requête préparée
			p.setString(1, this.modele);
			p.setInt(2, this.capacite);
			p.setInt(3, this.autonomie);
			
			p.executeUpdate();
			ResultSet result = p.getGeneratedKeys();
			while(result.next())
				this.idAvion = result.getInt(1);
			
			DbConnect.getConnector().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Avion> selectAll() {
		
		ArrayList<Avion> avions = new ArrayList<Avion>();
		
		String query = "SELECT id_avion, modele, capacite, autonomie FROM avion;";

		try(PreparedStatement p = DbConnect.getConnector().prepareStatement(query)) {
			
			ResultSet result = p.executeQuery();
			
			while(result.next()) {
				
				Avion a = new Avion();
				a.setIdAvion(result.getInt("id_avion"));
				a.setModele(result.getString("modele"));
				a.setCapacite(result.getInt("capacite"));
				a.setAutonomie(result.getInt("autonomie"));
				
				avions.add(a);
			}
			
			DbConnect.getConnector().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return avions;
		
	}

	@Override
	public Avion select() {

		String query = "SELECT id_avion, modele, capacite, autonomie FROM avion WHERE id_avion = ?;";

		try(PreparedStatement p = DbConnect.getConnector().prepareStatement(query)) {
			
			p.setInt(1, this.idAvion);
			
			ResultSet result = p.executeQuery();
			
			while(result.next()) {
				
				this.setIdAvion(result.getInt("id_avion"));
				this.setModele(result.getString("modele"));
				this.setCapacite(result.getInt("capacite"));
				this.setAutonomie(result.getInt("autonomie"));
			}
			
			DbConnect.getConnector().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this;
	}

	@Override
	public void update() {
		
		String query = "UPDATE avion SET modele = ?, capacite = ?, autonomie = ? WHERE id_avion = ? ";
		
		try(PreparedStatement p = DbConnect.getConnector().prepareStatement(query)) {
			
			// Binding sur requête préparée
			p.setString(1, this.modele);
			p.setInt(2, this.capacite);
			p.setInt(3, this.autonomie);
			p.setInt(4, this.idAvion);
			
			p.executeUpdate();
			
			DbConnect.getConnector().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete() {
		
		String query = "DELETE FROM avion WHERE id_avion = ? ;";
		
		try(PreparedStatement p = DbConnect.getConnector().prepareStatement(query)) {
			
			p.setInt(1, this.idAvion);
			
			p.executeUpdate();
			
			DbConnect.getConnector().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
