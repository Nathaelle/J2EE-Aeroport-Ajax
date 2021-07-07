package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Aeroport implements Crud<Aeroport> {

	private int idAeroport;
	private String nom;
	private String adresse;
	private String adresseGps;
	private int maxNbAvions;
	private int maxAccueil;
	
	public Aeroport() {
		super();
	}
	
	public Aeroport(int idAeroport, String nom, String adresse, String adresseGps, int maxNbAvions, int maxAccueil) {
		super();
		this.idAeroport = idAeroport;
		this.nom = nom;
		this.adresse = adresse;
		this.adresseGps = adresseGps;
		this.maxNbAvions = maxNbAvions;
		this.maxAccueil = maxAccueil;
	}

	public int getIdAeroport() {
		return idAeroport;
	}

	public void setIdAeroport(int idAeroport) {
		this.idAeroport = idAeroport;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getAdresseGps() {
		return adresseGps;
	}

	public void setAdresseGps(String adresseGps) {
		this.adresseGps = adresseGps;
	}

	public int getMaxNbAvions() {
		return maxNbAvions;
	}

	public void setMaxNbAvions(int maxNbAvions) {
		this.maxNbAvions = maxNbAvions;
	}

	public int getMaxAccueil() {
		return maxAccueil;
	}

	public void setMaxAccueil(int maxAccueil) {
		this.maxAccueil = maxAccueil;
	}

	@Override
	public void insert() {
		
		String query = "INSERT INTO aeroport (nom, adresse, adresse_gps, max_nb_avions, max_accueil) VALUES(?, ?, ?, ?, ?);";
		
		try(PreparedStatement p = DbConnect.getConnector().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			
			// Binding sur requête préparée
			p.setString(1, this.nom);
			p.setString(2, this.adresse);
			p.setString(3, this.adresseGps);
			p.setInt(4, this.maxNbAvions);
			p.setInt(5, this.maxAccueil);
			
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
	public ArrayList<Aeroport> selectAll() {
		ArrayList<Aeroport> aeroports = new ArrayList<Aeroport>();

		String query = "SELECT id_aeroport, nom, adresse, adresse_gps, max_nb_avions, max_accueil FROM aeroport;";

		try(PreparedStatement p = DbConnect.getConnector().prepareStatement(query)) {
			
			ResultSet result = p.executeQuery();
			
			while(result.next()) {
				
				Aeroport a = new Aeroport();
				a.setIdAeroport(result.getInt("id_aeroport"));
				a.setNom(result.getString("nom"));
				a.setAdresse(result.getString("adresse"));
				a.setAdresseGps(result.getString("adresse_gps"));
				a.setMaxNbAvions(result.getInt("max_nb_avions"));
				a.setMaxAccueil(result.getInt("max_accueil"));
				
				aeroports.add(a);
			}
			
			DbConnect.getConnector().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aeroports;
	}

	@Override
	public Aeroport select() {
		
		String query = "SELECT id_aeroport, nom, adresse, adresse_gps, max_nb_avions, max_accueil FROM aeroport WHERE id_aeroport = ?;";
		
		try(PreparedStatement p = DbConnect.getConnector().prepareStatement(query)) {
			
			// Binding sur requête préparée
			p.setInt(1, this.idAeroport);
			
			ResultSet result = p.executeQuery();
			
			while(result.next()) {
				
				this.setIdAeroport(result.getInt("id_aeroport"));
				this.setNom(result.getString("nom"));
				this.setAdresse(result.getString("adresse"));
				this.setAdresseGps(result.getString("adresse_gps"));
				this.setMaxNbAvions(result.getInt("max_nb_avions"));
				this.setMaxAccueil(result.getInt("max_accueil"));
				
			}
			
			DbConnect.getConnector().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return this;
	}

	@Override
	public void update() {

		String query = "UPDATE aeroport SET nom = ?, adresse = ?, adresse_gps = ?, max_nb_avions = ?, max_accueil = ? WHERE id_aeroport = ? ";
		
		try(PreparedStatement p = DbConnect.getConnector().prepareStatement(query)) {
			
			// Binding sur requête préparée
			p.setString(1, this.nom);
			p.setString(2, this.adresse);
			p.setString(3, this.adresseGps);
			p.setInt(4, this.maxNbAvions);
			p.setInt(5, this.maxAccueil);
			p.setInt(6, this.idAeroport);
			
			p.executeUpdate();
			
			DbConnect.getConnector().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void delete() {

		String query = "DELETE FROM aeroport WHERE id_aeroport = ? ;";
		
		try(PreparedStatement p = DbConnect.getConnector().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			
			p.setInt(1, this.idAeroport);
			
			p.executeUpdate();
			
			DbConnect.getConnector().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
