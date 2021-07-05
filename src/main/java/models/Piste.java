package models;

public class Piste {

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
	
	
}
