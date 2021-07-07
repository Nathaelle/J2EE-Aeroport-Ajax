package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Piste implements Crud<Piste> {

	private int idPiste;
	private float longueur;
	private float largeur;
	private String orientation;
	private int idAeroport;
	
	public Piste() {
		super();
	}
	
	public Piste(int idPiste, float longueur, float largeur, String orientation, int idAeroport) {
		super();
		this.idPiste = idPiste;
		this.longueur = longueur;
		this.largeur = largeur;
		this.orientation = orientation;
		this.idAeroport = idAeroport;
	}

	public int getIdPiste() {
		return idPiste;
	}

	public void setIdPiste(int idPiste) {
		this.idPiste = idPiste;
	}

	public float getLongueur() {
		return longueur;
	}

	public void setLongueur(float longueur) {
		this.longueur = longueur;
	}

	public float getLargeur() {
		return largeur;
	}

	public void setLargeur(float largeur) {
		this.largeur = largeur;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public int getIdAeroport() {
		return idAeroport;
	}

	public void setIdAeroport(int idAeroport) {
		this.idAeroport = idAeroport;
	}

	@Override
	public void insert() {

		String query = "INSERT INTO piste (longueur, largeur, orientation, id_aeroport) VALUES(?, ?, ?, ?);";
		
		try(PreparedStatement p = DbConnect.getConnector().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			
			// Binding sur requête préparée
			p.setFloat(1, this.longueur);
			p.setFloat(2, this.largeur);
			p.setString(3, this.orientation);
			p.setInt(4, this.idAeroport);
			
			p.executeUpdate();
			ResultSet result = p.getGeneratedKeys();
			while(result.next())
				this.idAeroport = result.getInt(1);
			
			DbConnect.getConnector().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Piste> selectAll() {
		
		ArrayList<Piste> pistes = new ArrayList<Piste>();

		String query = "SELECT id_piste, longueur, largeur, orientation, id_aeroport FROM piste;";

		try(PreparedStatement p = DbConnect.getConnector().prepareStatement(query)) {
			
			ResultSet result = p.executeQuery();
			
			while(result.next()) {
				
				Piste piste = new Piste();
				piste.setIdPiste(result.getInt("id_piste"));
				piste.setLongueur(result.getFloat("longueur"));
				piste.setLargeur(result.getFloat("largeur"));
				piste.setOrientation(result.getString("orientation"));
				piste.setIdAeroport(result.getInt("id_aeroport"));
				
				pistes.add(piste);
			}
			
			DbConnect.getConnector().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pistes;
	}

	@Override
	public Piste select() {

		String query = "SELECT id_piste, longueur, largeur, orientation, id_aeroport FROM piste WHERE id_piste = ?;";
		
		try(PreparedStatement p = DbConnect.getConnector().prepareStatement(query)) {
			
			// Binding sur requête préparée
			p.setInt(1, this.idAeroport);
			
			ResultSet result = p.executeQuery();
			
			while(result.next()) {
				
				this.setIdPiste(result.getInt("id_piste"));
				this.setLongueur(result.getFloat("longueur"));
				this.setLargeur(result.getFloat("largeur"));
				this.setOrientation(result.getString("orientation"));
				this.setIdAeroport(result.getInt("id_aeroport"));
				
			}
			
			DbConnect.getConnector().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return this;
	}

	@Override
	public void update() {

		String query = "UPDATE piste SET longueur = ?, largeur = ?, orientation = ?, idAeroport = ? WHERE id_piste = ? ";
		
		try(PreparedStatement p = DbConnect.getConnector().prepareStatement(query)) {
			
			// Binding sur requête préparée
			p.setFloat(1, this.longueur);
			p.setFloat(2, this.largeur);
			p.setString(3, this.orientation);
			p.setInt(4, this.idAeroport);
			p.setInt(5, this.idPiste);
			
			p.executeUpdate();
			
			DbConnect.getConnector().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete() {
		
		String query = "DELETE FROM piste WHERE id_piste = ? ;";
		
		try(PreparedStatement p = DbConnect.getConnector().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			
			p.setInt(1, this.idPiste);
			
			p.executeUpdate();
			
			DbConnect.getConnector().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
