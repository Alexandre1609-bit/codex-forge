import sqlite3


def init_db():

    with sqlite3.connect("ecole.db") as connection:

        cur = connection.cursor()
        cur.execute("PRAGMA foreign_keys = ON")


        cur.execute("""
            CREATE TABLE IF NOT EXISTS etudiant (
                nom TEXT NOT NULL,
                prenom TEXT NOT NULL,
                id INTEGER PRIMARY KEY AUTOINCREMENT)            
        """)

        cur.execute("""
            CREATE TABLE IF NOT EXISTS note (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                resultat REAL CHECK(resultat BETWEEN 0 AND 20),
                matiere TEXT NOT NULL,
                etudiant_id INTEGER NOT NULL,
                FOREIGN KEY (etudiant_id) REFERENCES etudiant(id) ON DELETE CASCADE)
        """)

        print("Bdd initialisée avec succès !")

if __name__ == "__main__":
    init_db()