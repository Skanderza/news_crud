package com.philou.afpa_cda.dao;

import com.philou.afpa_cda.beans.Tag;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DaoTag implements Dao<Tag>{
    
    
    private Connection cnx;
    

    //--------------------------------------
    // Constructeur
    public DaoTag(Connection cnx) {
        this.cnx = cnx;
    }
    
    
//-----------------------------------------------------------------------------
// liste()
//-----------------------------------------------------------------------------
    @Override
    public List<Tag> liste() {
        
        List<Tag> liste = new ArrayList();
        
        String sql = "SELECT * FROM tags";
        
        // Avec les 'try-with-ressources'
        // Les classes qui implantent l'interface autoCloseable sont acceptées comme ressources
        try(
            PreparedStatement ps = cnx.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ){
	
	while(rs.next()) {
		Tag obj = new Tag();
                obj.setIdTag(rs.getLong("id_tag")); // nom de la colonne
                obj.setLibelle(rs.getString("libelle"));				
		liste.add(obj);		
	}
	
        } catch (SQLException e) {
        System.out.println(e.getMessage());
        }
        
        return liste;

    }

//-----------------------------------------------------------------------------
// insert(Tag obj)
//-----------------------------------------------------------------------------
    @Override
    public boolean insert(Tag obj) {

        String sql = "INSERT INTO tags (libelle) VALUES (?)";

        try(PreparedStatement ps = cnx.prepareStatement(sql);){

        ps.setString(1, obj.getLibelle());

        int i = ps.executeUpdate();
        
        if(i == 1) {
                return true;
        }
        }
        catch (SQLException e) {
        System.out.println(e.getMessage());
        }
	
    return false;
    

    }

    @Override
    public Tag find(Long id) {
        
        Tag obj = new Tag();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM tags WHERE id_tag=?";

        try{
            ps = cnx.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while(rs.next()) {
                obj.setIdTag(rs.getLong("id_tag"));
                obj.setLibelle(rs.getString("libelle"));
            }		
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if(ps != null | rs != null) {
            try {
                ps.close();
                rs.close();
            }
            catch(SQLException e) {
            System.out.println(e.getMessage());	                        
            }
            }
        }
    return obj;
        
    }

    @Override
    public boolean update(Tag obj) {
        
        String sql = "UPDATE tags SET libelle=? WHERE id_tag=?";

        try(PreparedStatement ps = cnx.prepareStatement(sql);){

        ps.setString(1, obj.getLibelle());
        ps.setLong(2, (obj.getIdTag()));

        int i = ps.executeUpdate();

        if(i >= 1) {
                return true;
        }		

        } catch (SQLException e) {
        // TODO Auto-generated catch block
        System.out.println(e.getMessage());
        }

    return false;
    }

    @Override
    public void delete(Long id) {
        
        String sql = "DELETE FROM tags WHERE id_tag=?";

        try(PreparedStatement ps = cnx.prepareStatement(sql);)
        {

        ps.setLong(1, id);
        ps.executeUpdate();

        } 
        catch (SQLException e) {
        System.out.println(e.getMessage());
    }
        
    }
    
    

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
