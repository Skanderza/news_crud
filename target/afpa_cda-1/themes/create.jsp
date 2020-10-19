<%@page contentType="text/html" pageEncoding="ISO-8859-15"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
        <title>JSP Page</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <!-- div de centrage -->
        <div>
            
            <!-- fichiers inclus -->
            <!-- POSSIBLE PASSAGE DE PARAMETRES TRAITES PAR LES FICHIERS INCLUS -->
            <jsp:include page="../haut.jsp"/>
            <jsp:include page="../navigation.jsp"/>
      
   
        
        <div id="main">
            <h3>Création</h3>
            <form action="themes" method="post" >
                
                <input type="hidden" name="action" value="${requestScope.action}"/>
                
                <div> 
                <p>Libellé</p>
                <p><input type="text" name="libelle" /></p>
                </div>
                
                <p class="submit"><input type="image" src="MEDIAS/GO.jpg" /></p>

              
            </form>

        </div>
        </div>   
    </body>
</html>
