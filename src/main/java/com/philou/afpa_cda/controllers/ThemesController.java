package com.philou.afpa_cda.controllers;

import com.philou.afpa_cda.beans.Theme;
import com.philou.afpa_cda.dao.DaoTheme;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ThemesController", urlPatterns = {"/themes"})
public class ThemesController extends HttpServlet {
    
    private Connection cnx;
    private List<Theme> liste;
    private Theme theme;
    private DaoTheme dao;
    private final String SECTION = "SECTION-THEMES";
    
    
//------------------------------------------------------------------------------
//-- doGet(HttpServletRequest request, HttpServletResponse response)
//------------------------------------------------------------------------------
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Trace
        System.out.println("ThemesController::DOGET");
        
        // On attrape la connexion sql crée et mise dans une variable d'application dans EntranceServlet::init()
        cnx = (Connection)getServletContext().getAttribute("connexion");
        
        // Business
        dao = new DaoTheme(cnx); // // Un objet dao pour Theme
        liste = new ArrayList();
        theme = new Theme(); // Un objet Theme
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
                request.setAttribute("listeThemes", liste);
                view = "themes/liste.jsp";
            break;
            
            // action 1 (création)
            case "1":     
                view = "themes/create.jsp";
            break;
            
            // action 2 (modification)
            case "2":
                if(request.getParameter("id") != null) id = Long.parseLong(request.getParameter("id"));
                theme = dao.find(id);
                request.setAttribute("theme", theme);
                view = "themes/modify.jsp";
            break;
            
            // action 3 (suppression)
            case "3":
                if(request.getParameter("id") != null) id = Long.parseLong(request.getParameter("id"));
                theme = dao.find(id);
                request.setAttribute("theme", theme);
                view = "themes/delete.jsp";
            break;
            
        }
        
        // On forward la requète
        request.getRequestDispatcher(view).forward(request, response); 
        
    }

    
//------------------------------------------------------------------------------
//-- doPost(HttpServletRequest request, HttpServletResponse response)
//------------------------------------------------------------------------------
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Trace
        System.out.println("ThemesController::DOPOST");
        
        // On attrape la connexion sql crée et mise dans une variable d'application dans EntranceServlet::init()
        cnx = (Connection)getServletContext().getAttribute("connexion");
        
        // Business
        dao = new DaoTheme(cnx); // Un objet dao pour Theme
        liste = new ArrayList();
        theme = new Theme(); // Un objet Theme
        Long id = -1L; // Un id
        String view = ""; // La JSP finale
        
        // Gestion de l'action
        // Par défaut
        String action = "";
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
            
           // action 1 (création)
            case "1": 
                // On récupère les données du form
                if(request.getParameter("libelle") != null) theme.setLibelle(request.getParameter("libelle"));
                System.out.println("libelle" + theme.getLibelle());
                // On insère en BD
                dao.insert(theme);
                
                // On raffraichit la liste
                liste = dao.liste();
                request.setAttribute("listeThemes", liste);
                view = "themes/liste.jsp";
            break;
     
            // action 2 (modification)
            case "2":
                // On récupère les données du form
                if(request.getParameter("id") != null) theme.setIdTheme(Long.parseLong(request.getParameter("id")));
                if(request.getParameter("libelle") != null) theme.setLibelle(request.getParameter("libelle"));
                System.out.println("libelle" + theme.getLibelle());
                // On insère en BD
                dao.update(theme);
                
                // On raffraichit la liste
                liste = dao.liste();
                request.setAttribute("listeThemes", liste);
                view = "themes/liste.jsp";
            break;
            
            // action 3 (suppression)
            case "3":
                // On récupère les données du form
                if(request.getParameter("id") != null) 
                    dao.delete(Long.parseLong(request.getParameter("id")));
                // On raffraichit la liste
                liste = dao.liste();
                request.setAttribute("listeThemes", liste);
                // On forward
                view = "themes/liste.jsp";
            break;
            
        }
        
        // On forward la requète
        request.getRequestDispatcher(view).forward(request, response);         
 
    } // doPost END


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


// valeur pour les actions
// 0 ==> liste
// 1 ==> création
// 2 ==> modification
// 3 ==> suppression
