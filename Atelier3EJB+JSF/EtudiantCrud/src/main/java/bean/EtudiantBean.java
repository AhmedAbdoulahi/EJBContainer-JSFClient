package bean;


import java.util.List;

import javax.faces.bean.ManagedBean;

import jakarta.ejb.EJB;
import ma.fstt.business.EtudiantImpl;
import ma.fstt.entities.Etudiant;

@ManagedBean(name = "EtudiantBean")
public class EtudiantBean {
	@EJB
	EtudiantImpl metier;
	
	private int id_Etudiant ;
	private String nom;
	private String prenom;
	private String cne;
	private String adresse;
	private String niveau;

	private Etudiant etudiant;
	// ajouter un etudiant
	public String addEtudiant(EtudiantBean etudiantBean) {
		Etudiant etudiant = new Etudiant(etudiantBean.nom, etudiantBean.prenom,etudiantBean.cne, etudiantBean.adresse, etudiantBean.niveau);
		metier.addEtudiant(etudiant);
		return "listEtudiants.xhtml?faces-redirect=true";
	}
	//supprimer etudiant
	public String supprimer(EtudiantBean etudiantBean) {
		Etudiant etudiant = new Etudiant(etudiantBean.nom, etudiantBean.prenom,etudiantBean.cne, etudiantBean.adresse, etudiantBean.niveau);
		metier.supprimer(etudiant);
		return "listEtudiants.xhtml?faces-redirect=true" ;
	}
	//lister les etudiants
	public List<Etudiant> lister() {
		return metier.listEtudiants() ;
	}
	
	//mettre a jour un etudiant
	public String update(EtudiantBean etudiantBean) {
		
		return "listEtudiants.xhtml?faces-redirect=true" ;
	}
	

	public int getId_Etudiant() {
		return id_Etudiant;
	}

	public void setId_Etudiant(int id_Etudiant) {
		this.id_Etudiant = id_Etudiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	
}
