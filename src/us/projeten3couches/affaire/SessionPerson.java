
package us.projeten3couches.affaire;

import java.util.logging.Level;
import java.util.logging.Logger;
import us.projeten3couches.DAL.PersonneDAL;
import us.projeten3couches.domaine.Personne;


public class SessionPerson 
{
 Personne pers;    
 
 public SessionPerson(){}
    public String NomPersone()
    {
        return this.pers.getNom();
    }
    
    public String PrenomPersonne()
    {
        return this.pers.getPrenom();
    }
    public String SexePersonne()
    {
        return this.pers.getSexe();
    }
    public int AgePersonne()
    {
        return this.pers.getAge();
    }
    
    
    public int savePers(String nom,String prenom,String sexe,int age)
    {
        this.pers=new Personne(nom,prenom,sexe,age);
        return PersonneDAL.savePersonne(pers);
    }
    
    public Object[][] listePersonne() 
    {
         Object[][] listPers=null;
         
            try 
            {
                listPers=PersonneDAL.listerPersonne();
            } 
            catch (Exception ex) 
            {
                Logger.getLogger(SessionPerson.class.getName()).log(Level.INFO, null, ex);
            }
         
         
         return listPers; 
    }
    
     public int deletePers(String nom)
    {
        return PersonneDAL.deletePersonne(nom);
    }
}
