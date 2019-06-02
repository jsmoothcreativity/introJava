
package us.projeten3couches.DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import us.projeten3couches.domaine.Personne;


public class PersonneDAL extends Connexion
{
  private static Connection con=null;
  private static Statement st=null;
  private static ResultSet rs;
  private static PreparedStatement pr=null;
  
  public PersonneDAL(){}
  
  public static int savePersonne(Personne pers)
  {
      int verifye = 0;
        try 
        {
           Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            verifye=st.executeUpdate("insert into tblPersonne values('" + pers.getNom() + "','" + pers.getPrenom() + "','" + pers.getSexe() + "','" + pers.getAge() + "')");

        } catch (Exception ex) 
        {
            System.out.println("SQLException:" + ex.getMessage());
        } 
        finally 
        {
            try 
            {
                con.close();
            }
            catch (Exception e) 
            {
            }
        }
        return verifye;
  }
  
   public static Object[][] listerPersonne() 
    {
        
        boolean r = false;
        Object[][] listPersonne=null;
        try
        {
            con = DriverManager.getConnection(chaine);
            pr=con.prepareStatement("select * from tblPersonne");
            rs=pr.executeQuery();
           int nb=0,i=0;
           while(rs.next())
           {
               nb++;
           }
          //Reposition du curseur dans le premier enregistrement
           rs.beforeFirst();
           listPersonne=new Object[nb][4];
           while(rs.next())
           {
               listPersonne[i][0]=rs.getObject("Nom");
               listPersonne[i][1]=rs.getObject("Prenom");
               listPersonne[i][2]=rs.getObject("Sexe");
               listPersonne[i][3]=rs.getObject("Age");
               i++;
           }
           
        }
        catch(SQLException ex)
        {
             JOptionPane.showMessageDialog(null, "Enregistrement non effectué!"+ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);   
        }
        finally
        {
            try {
                if(con != null)
                {
                con.close();
                }
            } catch (SQLException ex) 
            {
                Logger.getLogger(PersonneDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       return listPersonne;
    }
   
   public static int deletePersonne(String nom)
  {
      int verifye = 0;
        try 
        {
           Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            verifye=st.executeUpdate("DELETE FROM tblPersonne WHERE Nom='"+nom+"'");

        } catch (Exception ex) 
        {
            System.out.println("SQLException:" + ex.getMessage());
        } 
        finally 
        {
            try 
            {
                con.close();
            }
            catch (Exception e) 
            {
            }
        }
        return verifye;
  }

}
