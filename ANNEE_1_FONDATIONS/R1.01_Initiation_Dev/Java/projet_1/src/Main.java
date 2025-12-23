//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Promo maPromo = new Promo("BUT1");

        Etudiant toto = new Etudiant("Toto", "Dupont");
        toto.ajouterNote(10);
        toto.ajouterNote(12);
        maPromo.ajouterEtudiant(toto);

        Etudiant titi = new Etudiant("Titi", "Dubois");
        titi.ajouterNote(15);
        titi.ajouterNote(20);
        maPromo.ajouterEtudiant(titi);

        System.out.println(maPromo.calculerMoyennePromo());


        System.out.println("Le Major de la promo est : " + maPromo.getMajor().getName());
        }
    }
