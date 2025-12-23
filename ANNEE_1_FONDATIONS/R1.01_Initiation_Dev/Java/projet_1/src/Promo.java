public class Promo {
    private String nomPromo;
    private Etudiant[] listeEtudiants; // Le tableau
    private int nbEtudiants; // Le compteur (comme nbNotes)

    public Promo(String nomPromo) {
        this.nomPromo = nomPromo;
        this.listeEtudiants = new Etudiant[30];
        this.nbEtudiants = 0;
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        if (nbEtudiants >= listeEtudiants.length) {
            System.out.println("Error");
        } else {
            listeEtudiants[nbEtudiants] = etudiant;
            nbEtudiants ++;
        }
    }

    public double calculerMoyennePromo() {
        if (nbEtudiants  == 0) {
            return 0;
        }
        double somme = 0;
        for (int i = 0; i < nbEtudiants; i++) {
            somme += listeEtudiants[i].calculerMoyenne();
        }
        return somme / nbEtudiants;

    }

    public Etudiant getMajor() {

        if (nbEtudiants == 0) {
            return  null;
        }
        Etudiant leMeilleur = listeEtudiants[0];
        for (int i = 1; i < nbEtudiants; i++) {
            double moyenneEtu =  listeEtudiants[i].calculerMoyenne();
            if (moyenneEtu > leMeilleur.calculerMoyenne()) {
                System.out.println("Nouveau champion !" + listeEtudiants[i]);
                leMeilleur = listeEtudiants[i];
            }
        }
        return leMeilleur;
    }
}