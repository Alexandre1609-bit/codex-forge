import sqlite3


def ajouter_etudiant(nom, prenom):
    with sqlite3.connect("ecole.db") as connection:
        cur = connection.cursor() 
        cur.execute("INSERT INTO etudiant(nom, prenom) VALUES (?, ?)",(nom, prenom))
        connection.commit() 
       
        

def afficher_etudiant():
    with sqlite3.connect("ecole.db") as connection:
        cur = connection.cursor()
        cur.execute("SELECT e.prenom, n.resultat, n.matiere FROM etudiant as e LEFT JOIN note AS n ON e.id = etudiant_id")
        etudiants = cur.fetchall()
        for etudiant in etudiants:
            prenom, note, matiere = etudiant
            if note is None:
                print(f"L'étudiant {prenom} n'a pas encore de note")
            else:
                print(f"L'étudiant {prenom} a obtenu la note de {note} en {matiere}")


def ajouter_note(etudiant_id, matiere, resultat):
    with sqlite3.connect("ecole.db") as connection:
        cur = connection.cursor()
        #NE PAS OUBLIER CETTE LIGNE POUR LA LIAISON PK FK 
        cur.execute("PRAGMA foreign_keys = ON")
        
        try:
            cur.execute("INSERT INTO note (matiere, resultat, etudiant_id) VALUES (?, ?, ?)", 
                        (matiere, resultat, etudiant_id))
            connection.commit()
            print("Note ajoutée avec succès.")
            
        except sqlite3.IntegrityError:
            print(f"Erreur : L'étudiant ID {etudiant_id} n'existe pas !")

def delete_etudiant():
    with sqlite3.connect("ecole.db") as connect:
        cur = connect.cursor()

        cur.execute("""
            DELETE FROM 
                    etudiant
                WHERE
                    prenom = 'test'   
        """)

if __name__ == "__main__":
    afficher_etudiant()

    