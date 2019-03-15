<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>



<div id="container">
	<div class="row">
		<div class="col-md-8 col-md-offset-1">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<b>Cow Pictures List</b>
				</div>
				<div class="panel-body">
					

					
					<!-- add html table -->
					<table class="table table-striped">
						<%int count=0,index=3; %>
						
						<c:forEach var="cowPicture" items="${cowPictures}">
						
						
						<c:url var="deleteLink" value="/deleteCowPicture">
						<c:param name="pictureId"  value="${cowPicture.id }"></c:param>
						<c:param name="cowId"  value="${cowId }"></c:param>
						</c:url>
							
							<%++count;%>
							<% if ((count+index)%3==1 ){ %>
									<tr>
									<%} %>
							
								
								<td align="center"><img alt="img"
									src="data:image/jpeg;base64,${cowPicture.base64imageFile}"
									width="250" height="250" /><br><a href="${deleteLink}"  class="btn btn-warning"
									 onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a></td>
									<% if (count%3==0){ %>
									</tr>
									<%} %>
								

						</c:forEach>

					</table>



				</div>
			</div>
		</div>
	</div>
</div>
</div>



<%@ include file="common/footer.jspf"%>