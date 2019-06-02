
package us.projeten3couches.domaine;


public class Personne 
{
    private String Nom, Prenom, Sexe;
    private int Age;
    
    public Personne(String Nom,String Prenom,String Sexe,int Age)
    {
        //this.Id=Id;
        this.Nom=Nom;
        this.Prenom=Prenom;
        this.Sexe=Sexe;
        this.Age=Age;
    }
    public Personne(){}
    
    //Accesseurs
  

    public String getNom() 
    {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getSexe() {
        return Sexe;
    }

    public int getAge() {
        return Age;
    }
     
    
    //Mutateurs

   

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public void setSexe(String Sexe) {
        this.Sexe = Sexe;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }
   
    
}
