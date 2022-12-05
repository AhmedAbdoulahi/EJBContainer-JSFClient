package ma.fstt.business;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ma.fstt.entities.Etudiant;

//pour que sa soit un ejb session il faut utiliser la notation @Stateless
@Stateless
public class EtudiantImpl implements IEtudiantRemote,IEtudiantLocal {
	//injection d'entity manager pour la sauvegarde des donnees 
	@PersistenceContext(unitName="Etudiant")
	private EntityManager em ;

	@Override
	public Long addEtudiant(Etudiant e) {
		// TODO Auto-generated method stub
		em.persist(e);
		return e.getId_etudiant() ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> listEtudiants() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select e from Etudiant e ") ;
		return req.getResultList() ;
	}

	@Override
	public Etudiant update(Etudiant e) {
		// TODO Auto-generated method stub
		em.persist(e);
		return e ;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		//on chercher d'abord par la methode find et on utilise la methose remove sur l'objet
		Etudiant e = em.find(Etudiant.class, id) ;
		//les exceptions surveillees au cas ou l'etudiant n'existe pas dans notre base de donnees
		if(e==null) throw new RuntimeException("Etudiant inexistant") ;
		em.remove(e);
	}

	@Override
	public Etudiant findById(Long id) {
		// TODO Auto-generated method stub
		Etudiant e = em.find(Etudiant.class, id) ;
		if(e==null) throw new RuntimeException("Etudiant inexistant") ;
		return e ;
	}

	@Override
	public void supprimer(Etudiant e) {
		// TODO Auto-generated method stub
		em.remove(e);
	}

}
