package ma.fstt.business;

import java.util.List;

import jakarta.ejb.Remote;
import ma.fstt.entities.Etudiant;

@Remote
public interface IEtudiantRemote {
	public Long addEtudiant(Etudiant e) ;
	public List<Etudiant> listEtudiants() ;
	public Etudiant update(Etudiant e) ;
	public void delete(int id) ;
	public void supprimer(Etudiant e) ;
	public Etudiant findById(Long id) ;
}
