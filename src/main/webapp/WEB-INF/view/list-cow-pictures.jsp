<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div id="container">
	<div class="row">
		<div class="col-md-8 col-md-offset-1">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<b>Cow Pictures List</b>
				</div>
				<div class="panel-body">
					<form:form action="search" method="post">
						<input type="text" name="searchName" />
						<input type="submit" value="search" class="btn btn-success" />


					</form:form>

					
					<!-- add html table -->
					<table class="table table-striped">
						<tr>
							<th>NO</th>
							<th>Picture</th>
							<th>Tag NO</th>
							<th>Gender</th>
							<th>DOB</th>
							<th>Action</th>
						</tr>
						<%
							int count = 0;
						%>
						<c:forEach var="cow" items="${cows}">
							<!--  URL for Add Link -->
							<c:url var="addPictureLink" value="/showCowPictureForm">
								<c:param name="cowId" value="${cow.id}" />
							</c:url>
							<!--  URL for View Link -->
							<c:url var="viewPictureLink" value="/viewSingleCowPictures">
								<c:param name="cowId" value="${cow.id}" />
							</c:url>

							<tr>
							
								<td><%=++count%></td>
								<td><img alt="img"
									src="data:image/jpeg;base64,${cow.getLastPicture().base64imageFile}"
									width="100" height="100" /></td>
								<td>${cow.cowTagNo}</td>
								<td>${cow.gender}</td>
								<td>${cow.dob}</td>
								<td><a href="${addPictureLink}" class="btn btn-success">Add Picture</a>
									| <a href="${viewPictureLink}" class="btn btn-success">View Pictures</a>
								</td>

							</tr>

						</c:forEach>

					</table>



				</div>
			</div>
		</div>
	</div>
</div>
</div>

<%@ include file="common/footer.jspf"%>