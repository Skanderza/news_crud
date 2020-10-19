package com.philou.afpa_cda.beans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author philou
 */
public class News implements Serializable{
    
    private long idNews;
    private String titre;
    private String content;
    private LocalDateTime  dateCreation; // java 8
    private Theme theme; // one to many
    private List<Tag>  listeTags; // many to many

    public News() {
        listeTags = new ArrayList();
        theme = new Theme();
    }

    
    ///////////////////////////////////////////////////////////
    // getters / setters
    ///////////////////////////////////////////////////////////
    
    /**
     * @return the idNews
     */
    public long getIdNews() {
        return idNews;
    }

    /**
     * @param idNews the idNews to set
     */
    public void setIdNews(long idNews) {
        this.idNews = idNews;
    }

    /**
     * @return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre the titre to set
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }



    /**
     * @return the theme
     */
    public Theme getTheme() {
        return theme;
    }

    /**
     * @param theme the theme to set
     */
    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    /**
     * @return the listeTags
     */
    public List<Tag> getListeTags() {
        return listeTags;
    }

    /**
     * @param listeTags the listeTags to set
     */
    public void setListeTags(List<Tag> listeTags) {
        this.listeTags = listeTags;
    }

    @Override
    public String toString() {
        return "News{" + "idNews=" + idNews + ", titre=" + titre + ", content=" + content + ", dateCreation=" + dateCreation + ", theme=" + theme + ", listeTags=" + listeTags + '}';
    }
    
    
    
    
    
}
