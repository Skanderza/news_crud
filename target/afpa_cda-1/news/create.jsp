<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <form action="news" method="post" >
                <input type="hidden" name="action" value="${requestScope.action}"/>
                
                <div> 
                <p>Titre</p>
                <p><input type="text" name="titre" /></p>
                </div>
                
                <div> 
                <p>Content</p>
                <p><textarea name="content" cols="60" rows="10"></textarea></p>
                </div>
                
                <div> 
                <p>Thème</p>
                <p>
                    <select name="theme">
                        <option value="-1">Please select a Theme</option>
                        <c:forEach var="theme" items="${requestScope.allThemes}">
                            <option value="${theme.idTheme}">${theme.libelle}</option>
                        </c:forEach>
                    </select></p>
                </div>
                
                <p class="submit"><input type="image" src="MEDIAS/GO.jpg" /></p>


              
            </form>

        </div>
        </div>   
    </body>
</html>
