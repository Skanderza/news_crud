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

            <jsp:include page="../haut.jsp"/>
            <jsp:include page="../navigation.jsp"/>
      
   
        
        <div id="main">
            <h3>Suppression</h3>
            
            <form action="tags" method="post" >
                
                <input type="hidden" name="action" value="${requestScope.action}"/>
                <input type="hidden" name="id" value="${requestScope.tag.idTag}"/>
                
                <div>
                    <p>Voulez-vous vraiment supprimer le tag <em>${requestScope.tag.libelle}</em> ?</p>
                </div>
                
                <div>
                    <p class="submit"><input type="image" src="MEDIAS/GO.jpg" /> <a href="tags"><img src="MEDIAS/ICO_DELETE.png"/></a></p>
                </div>

            </form>

        </div>
 
        </div>
        
        
    </body>
</html>


