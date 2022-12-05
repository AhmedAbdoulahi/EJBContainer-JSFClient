package ma.fstt.entities;

import ma.fstt.business.EtudiantImpl;
import ma.fstt.business.IEtudiantLocal;

public class Test {

	public static void main(String[] args) {
		EtudiantImpl e = new EtudiantImpl();
		Etudiant etudiant = new Etudiant("", "", "", "", "") ;
		e.addEtudiant(etudiant);
	}

}
