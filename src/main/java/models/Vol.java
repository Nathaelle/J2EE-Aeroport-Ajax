package models;

import java.sql.Date;

public class Vol {
	
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
	
	
}
