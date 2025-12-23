import java.util.List;
import java.util.Random;

public class Etudiant {

    private String name;
    private String lastname;
    private int nbNotes;
    private double[] grades;

    public Etudiant(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
        this.grades = new double[20];
        this.nbNotes = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void ajouterNote(double note) {
        if (nbNotes >= grades.length) {
            System.out.println("Error");
        } else {
            grades[nbNotes] = note;
            nbNotes++;

        }
    }

    public double calculerMoyenne() {
        if (nbNotes == 0) {
            return 0;}

        double somme = 0;

        for (int i = 0; i < nbNotes; i++) {
            somme += grades[i];
        }

        return somme / nbNotes;

    }

}


