package models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Vol implements Crud<Vol> {
	
	private int idVol;
	private int duree;
	private Date dateHeureDepart;
	private Date dateHeureArrivee;
	private int idAvion;
	private int idPisteDepart;
	private int idPisteArrivee;
	
	public Vol() {
		super();
	}
	public Vol(int idVol, int duree, Date dateHeureDepart, Date dateHeureArrivee, int idAvion, int idPisteDepart,
			int idPisteArrivee) {
		super();
		this.idVol = idVol;
		this.duree = duree;
		this.dateHeureDepart = dateHeureDepart;
		this.dateHeureArrivee = dateHeureArrivee;
		this.idAvion = idAvion;
		this.idPisteDepart = idPisteDepart;
		this.idPisteArrivee = idPisteArrivee;
	}
	public int getIdVol() {
		return idVol;
	}
	public void setIdVol(int idVol) {
		this.idVol = idVol;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public Date getDateHeureDepart() {
		return dateHeureDepart;
	}
	public void setDateHeureDepart(Date dateHeureDepart) {
		this.dateHeureDepart = dateHeureDepart;
	}
	public Date getDateHeureArrivee() {
		return dateHeureArrivee;
	}
	public void setDateHeureArrivee(Date dateHeureArrivee) {
		this.dateHeureArrivee = dateHeureArrivee;
	}
	public int getIdAvion() {
		return idAvion;
	}
	public void setIdAvion(int idAvion) {
		this.idAvion = idAvion;
	}
	public int getIdPisteDepart() {
		return idPisteDepart;
	}
	public void setIdPisteDepart(int idPisteDepart) {
		this.idPisteDepart = idPisteDepart;
	}
	public int getIdPisteArrivee() {
		return idPisteArrivee;
	}
	public void setIdPisteArrivee(int idPisteArrivee) {
		this.idPisteArrivee = idPisteArrivee;
	}
	@Override
	public void insert() {

		String query = "INSERT INTO vol (duree, date_heure_depart, date_heure_arrivee, id_avion, id_piste_depart, id_piste_arrivee) VALUES(?, ?, ?, ?, ?, ?)";
		
		try(PreparedStatement p = DbConnect.getConnector().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			
			// Binding sur requête préparée
			p.setInt(1, this.duree);
			p.setDate(2, this.dateHeureDepart);
			p.setDate(3, this.dateHeureArrivee);
			p.setInt(4, this.idAvion);
			p.setInt(5, this.idPisteDepart);
			p.setInt(6, this.idPisteArrivee);
			
			p.executeUpdate();
			ResultSet result = p.getGeneratedKeys();
			while(result.next())
				this.idVol = result.getInt(1);
			
			DbConnect.getConnector().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public ArrayList<Vol> selectAll() {

		ArrayList<Vol> vols = new ArrayList<Vol>();
		
		String query = "SELECT id_vol, duree, date_heure_depart, date_heure_arrivee, id_avion, id_piste_depart, id_piste_arrivee FROM vol;";
		
		try(PreparedStatement p = DbConnect.getConnector().prepareStatement(query)) {
			
			// Binding sur requête préparée
			p.setInt(1, this.idVol);
			
			ResultSet result = p.executeQuery();
			
			while(result.next()) {
				
				this.setIdVol(result.getInt("id_vol"));
				this.setDuree(result.getInt("duree"));
				this.setDateHeureDepart(result.getDate("date_heure_depart"));
				this.setDateHeureArrivee(result.getDate("date_heure_arrivee"));
				this.setIdAvion(result.getInt("id_avion"));
				this.setIdPisteDepart(result.getInt("id_piste_depart"));
				this.setIdPisteArrivee(result.getInt("id_piste_arrivee"));
				
			}
			
			DbConnect.getConnector().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vols;
	}
	
	@Override
	public Vol select() {
		
		String query = "SELECT id_vol, duree, date_heure_depart, date_heure_arrivee, id_avion, id_piste_depart, id_piste_arrivee FROM vol WHERE id_vol = ?;";
		
		try(PreparedStatement p = DbConnect.getConnector().prepareStatement(query)) {
			
			// Binding sur requête préparée
			p.setInt(1, this.idVol);
			
			ResultSet result = p.executeQuery();
			
			while(result.next()) {
				
				this.setIdVol(result.getInt("id_vol"));
				this.setDuree(result.getInt("duree"));
				this.setDateHeureDepart(result.getDate("date_heure_depart"));
				this.setDateHeureArrivee(result.getDate("date_heure_arrivee"));
				this.setIdAvion(result.getInt("id_avion"));
				this.setIdPisteDepart(result.getInt("id_piste_depart"));
				this.setIdPisteArrivee(result.getInt("id_piste_arrivee"));
				
			}
			
			DbConnect.getConnector().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return this;
		
	}
	@Override
	public void update() {

		String query = "UPDATE vol SET duree = ?, date_heure_depart = ?, date_heure_arrivee = ?, id_avion = ?, id_piste_depart = ?, id_piste_arrivee = ? WHERE id_vol = ? ";
		
		try(PreparedStatement p = DbConnect.getConnector().prepareStatement(query)) {
			
			// Binding sur requête préparée
			p.setInt(1, this.duree);
			p.setDate(2, this.dateHeureDepart);
			p.setDate(3, this.dateHeureArrivee);
			p.setInt(4, this.idAvion);
			p.setInt(5, this.idPisteDepart);
			p.setInt(6, this.idPisteArrivee);
			p.setInt(7, this.idVol);
			
			p.executeUpdate();
			
			DbConnect.getConnector().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void delete() {

		String query = "DELETE FROM vols WHERE id_vol = ? ;";
		
		try(PreparedStatement p = DbConnect.getConnector().prepareStatement(query)) {
			
			p.setInt(1, this.idVol);
			
			p.executeUpdate();
			
			DbConnect.getConnector().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
