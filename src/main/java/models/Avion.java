package models;

public class Avion {

	private int idAvion;
	private String modele;
	private String capacite;
	private String autonomie;
	
	public Avion() {
		super();
	}
	
	public Avion(int idAvion, String modele, String capacite, String autonomie) {
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

	public String getCapacite() {
		return capacite;
	}

	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}

	public String getAutonomie() {
		return autonomie;
	}

	public void setAutonomie(String autonomie) {
		this.autonomie = autonomie;
	}
	
	
	
}
