<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- rajouter taglibs -->
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- rajouter bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css" />

<title>Insert title here</title>
</head>
<body>
<div class="container">
		<h2>Formulaire Test</h2>
		<form action="ServletPersonne">
			<!-- dans l'action il faut mettre la destination de notre Servlet où on veut aller    -->
			<div class="form-group">
			
				<br><input type="hidden" name="id" value="${id}"><br>
				<!-- on rajoute un champ caché -->
				Nom:<br> <input type="text" name="lastname" value="${lastname }"required><br> <!--on ramene les infos avec ces parametres-->
				Prénom:<br> <input type="text" name="firstname" value="${firstname }"required><br>
				Age:<br> <input type="text" name="age" value="${age }"required><br>
				Login:<br><input type="text" name="login" value="${login}" required></br>
				Mot de passe:<br><input type="password" name="password" value="${password}" required></br>
				
				Adresse : </br> <select name="idAdresse">                
				<optgroup>                   
				 <option value ="0">---</option>                    
				 <c:if test="${! empty adresses}">                    
				 <c:forEach items="${adresses}" var="a">                        
				 <option value="${a.idAdresse}"><c:out value="${a.nomRue}"></c:out></option>                    
				 </c:forEach>
				</c:if>                
				</optgroup>               
				</select>
			</div>
			<input type="submit" name="ajouter" value="Ajouter">
			<input type="submit" name="modifier" value="Modifier">
			
				<tr>
			
			           
			</optgroup></select>
		</form>

	</div>
	</body>
<div class = "container">
<h2>Liste des personnes en bdd</h2>
<table class="table table-striped">
	<thead>
		<tr>
			<th>id</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Age</th>
			<th>Login</th>
			<th>mdp</th>
			<th>Supprimer</th>
			<th>Modifier</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${! empty personnes}"><!-- si c'est pas vide ça doit marcher, ça doit etre rempli-->
			<c:forEach items="${personnes}" var="x">
				<tr>
					<td><c:out value="${x.id}"/></td>
					<td><c:out value="${x.nom}"/></td>
					<td><c:out value="${x.prenom}"/></td>
					<td><c:out value="${x.age}"/></td>
					<td><c:out value="${x.connexion.login}"/></td><!-- rajouter connexion.login, pour faire référence à la classe connexion qui a un lien avec personnes  -->
					<td><c:out value="${x.connexion.mdp}"/></td>
					<td><a href = "SupprimerPersonne?id=${x.id }">Supprimer</a></td>
					<td><a href = "ModifierPersonne?id=${x.id }">Modifier</a></td>
				</tr>
			</c:forEach>
			</c:if>
	</tbody>
</body>
</html>