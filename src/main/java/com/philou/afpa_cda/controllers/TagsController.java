package com.philou.afpa_cda.controllers;

import com.philou.afpa_cda.beans.Tag;
import com.philou.afpa_cda.dao.DaoTag;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "TagController", urlPatterns = {"/tags"})
public class TagsController extends HttpServlet {
    
    
    private Connection cnx;
    private List<Tag> liste;
    private Tag tag;
    private DaoTag dao;
    private final String SECTION = "SECTION-TAGS";

    
    
//----------------------------------------------------------------------------
// doGet(HttpServletRequest request, HttpServletResponse response)
//----------------------------------------------------------------------------
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Trace
        System.out.println("TagsController::DOGET");
    
        // On attrape la connexion sql crée et mise dans une variable d'application dans EntranceServlet::init()
        cnx = (Connection)getServletContext().getAttribute("connexion");
        
        // Business
        liste = new ArrayList();
        dao = new DaoTag(cnx); // Un objet DaoTag
        tag = new Tag(); // Un objet Tag
        Long id = -1L; // Un id
        String view = ""; // La JSP finale
        
        // Gestion de l'action
        // Par défaut
        String action = "0";
        // Présence param http action ?
        if(request.getParameter("action") != null){
            // On écrase l'action par défaut
            action = request.getParameter("action");      
        }
        // On stocke l'action dans un attribut de requète (lisible par la page web)
        request.setAttribute("action", action);
        
        // Gestion de la section
        // On stocke la section dans un attribut de requète (lisible par la page web)
        request.setAttribute("section", SECTION);

        // Which action ?
        switch(action){
            
            // action 0 (liste)
            case "0":
                liste = dao.liste();
                // On crée un attribut de requète 
                request.setAttribute("listeTags", liste);
                view = "tags/liste.jsp";
            break;
            
            // action 1 (création)
            case "1":     
                view = "tags/create.jsp";
            break;
            
            // action 2 (modification)
            case "2":
                if(request.getParameter("id") != null) id = Long.parseLong(request.getParameter("id"));
                tag = dao.find(id);
                request.setAttribute("tag", tag);
                view = "tags/modify.jsp";
            break;
            
            // action 3 (suppression)
            case "3":
                if(request.getParameter("id") != null) id = Long.parseLong(request.getParameter("id"));
                tag = dao.find(id);
                request.setAttribute("tag", tag);
                view = "tags/delete.jsp";
            break;
            
        }
        
        // On forward la requète
        request.getRequestDispatcher(view).forward(request, response); 

    }

    
    
//----------------------------------------------------------------------------
// doPost(HttpServletRequest request, HttpServletResponse response)
//----------------------------------------------------------------------------
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Trace
        System.out.println("TagsController::DOPOST");
        
       // On attrape la connexion sql crée et mise dans une variable d'application dans EntranceServlet::init()
        cnx = (Connection)getServletContext().getAttribute("connexion");
        
        // Business
        liste = new ArrayList();
        dao = new DaoTag(cnx); // Un objet DaoTag
        tag = new Tag(); // Un objet Tag
        Long id = -1L; // Un id
        String view = ""; // La JSP finale
        
        // Gestion de l'action
        // Par défaut
        String action = "0";
        // Présence param http action ?
        if(request.getParameter("action") != null){
            // On écrase l'action par défaut
            action = request.getParameter("action");      
        }
        // On stocke l'action dans un attribut de requète (lisible par la page web)
        request.setAttribute("action", action);
        
        // Gestion de la section
        // On stocke la section dans un attribut de requète (lisible par la page web)
        request.setAttribute("section", SECTION);
     
        // Which action ?
        switch(action){
            
                case "1": 
                // On récupère les données du form
                if(request.getParameter("libelle") != null) tag.setLibelle(request.getParameter("libelle"));
                // On insère en BD
                dao.insert(tag);
                
                // On raffraichit la liste
                liste = dao.liste();
                request.setAttribute("listeTags", liste);
                view = "tags/liste.jsp";
            break;
            
            // action 2 (modification)
            case "2":
                // On récupère les données du form
                if(request.getParameter("id") != null) tag.setIdTag(Long.parseLong(request.getParameter("id")));
                if(request.getParameter("libelle") != null) tag.setLibelle(request.getParameter("libelle"));
          
                // On insère en BD
                dao.update(tag);
                
                // On raffraichit la liste
                liste = dao.liste();
                request.setAttribute("listeTags", liste);
                view = "tags/liste.jsp";
            break;
            
                        // action 3 (suppression)
            case "3":
                // On récupère les données du form
                if(request.getParameter("id") != null) 
                    dao.delete(Long.parseLong(request.getParameter("id")));
                // On raffraichit la liste
                liste = dao.liste();
                request.setAttribute("listeTags", liste);
                // On forward
                view = "tags/liste.jsp";
            break;
     }
        
        // On forward la requète
        request.getRequestDispatcher(view).forward(request, response); 

    }

    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
