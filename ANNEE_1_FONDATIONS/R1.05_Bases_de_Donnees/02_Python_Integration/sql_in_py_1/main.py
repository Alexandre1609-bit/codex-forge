import sqlite3

def ajouter_etudiant(nom, prenom):
    with sqlite3.connect("ecole.db") as connection:
        cur = connection.cursor()

        cur.execute("INSERT INTO etudiant(nom, prenom) VALUES (?, ?)",(nom, prenom))
        connection.commit() 

           

if __name__ == "__main__":
    ajouter_etudiant("Alex", "test")
       