
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
<div class="panel panel-primary">
<div class="panel-heading"> Home Page</div>
<div class="panel-body">



</div>

<h3>WELCOME To Farm House Management System</h3>
User Name :<security:authentication property="principal.username"/><br>
Role(s):<security:authentication property="principal.authorities"/>
</div>




</div>

<%@ include file="common/footer.jspf" %>

</body>

</html>