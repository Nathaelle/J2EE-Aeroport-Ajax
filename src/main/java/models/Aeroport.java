package models;

public class Aeroport {

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
	
	
}
