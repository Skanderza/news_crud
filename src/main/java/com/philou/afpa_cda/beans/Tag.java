package com.philou.afpa_cda.beans;

import java.io.Serializable;

/**
 *
 * @author philou
 */
public class Tag implements Serializable{
    
    private long idTag;
    private String libelle;
    
    public Tag(){
        //
    }

    /**
     * @return the idTag
     */
    public long getIdTag() {
        return idTag;
    }

    /**
     * @param idTag the idTag to set
     */
    public void setIdTag(long idTag) {
        this.idTag = idTag;
    }

    /**
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * @param libelle the libelle to set
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    /*
    @Override
      public boolean equals(Object obj) {
      return (obj instanceof Tag) && ((Tag)obj.getIdTag())==(idTag) && (Tag)obj.getLibelle().equals(libelle);
    }
*/
    
}
