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
            <jsp:include page="../haut.jsp"/>
            <jsp:include page="../navigation.jsp"/>
      
   
        
        <div id="main">
            <h3>Liste</h3>
            <p class="nouvel-item"><a href="news?action=1"><img src="MEDIAS/ICO_NEW.png" width="100" /></a></p>
            <table>
            <caption>liste des news</caption>
            <tr>
                <th>Thème</th>
                <th>Titre</th>
                <th>Crée le</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>

        <c:forEach var="news" items="${requestScope.listeNews}">
            
            <tr>
                <td>${news.theme.libelle}</td>
                <td>${news.titre}</td>
                <td>${news.dateCreation}</td>
                <td class="special_cell"><a href="news?id=${news.idNews}&action=4"><img src="MEDIAS/tags.jpg"  /></a></td>
                <td><a href="news?id=${news.idNews}&action=2"><img src="MEDIAS/ICO_MODIFY.png"  /></a></td>
                <td><a href="news?id=${news.idNews}&action=3"><img src="MEDIAS/ICO_DELETE.png"  /></a></td>
                <td></td>
            </tr>
            
        </c:forEach>
            
        </table>
        </div>
        
            
            
        </div>
        
        
    </body>
</html>

