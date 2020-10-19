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
            <jsp:include page="../haut.jsp"/>
            <jsp:include page="../navigation.jsp"/>
      
   
        
        <div id="main">
            <h3>Liste</h3>
            <p class="nouvel-item"><a href="themes?action=1"><img src="MEDIAS/ICO_NEW.png" width="100" /></a></p>
            <table>
            <caption>list des thèmes</caption>
            <tr>
                <th>Libellé</th>
                <th></th>
                <th></th>
            </tr>

        <c:forEach var="theme" items="${requestScope.listeThemes}">
            
            <tr>
                <td>${theme.libelle}</td>
                <td><a href="themes?id=${theme.idTheme}&action=2"><img src="MEDIAS/ICO_MODIFY.png" width="100" /></a></td>
                <td><a href="themes?id=${theme.idTheme}&action=3"><img src="MEDIAS/ICO_DELETE.png" width="100" /></a></td>
            </tr>
            
        </c:forEach>
            
        </table>
        </div>
 
        </div>
               
    </body>
</html>
