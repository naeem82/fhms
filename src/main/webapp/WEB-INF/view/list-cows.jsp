<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>


<div id="container">
	<div class="row">
		<div class="col-md-10 col-md-offset-1">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<b>Cow List</b>
				</div>
				<div class="panel-body">
					<form:form action="" method="post">
						<input type="text" name="searchName" />
						<input type="submit" value="search" class="btn btn-success" />


					</form:form>

					<!-- Add button to add Customer -->

					<input type="button" value="Add Cow"
						onclick="window.location.href='${pageContext.request.contextPath}/showCowAddForm'"
						,return false;
		class="btn btn-success" />
					<!-- add html table -->
					<table class="table table-striped">
						<tr>

							<th>Cow</th>
							<th>Color</th>
							<th>Actual Age</th>
							<th>Age</th>
							<th>Gender</th>
							<th>DOB</th>
							<th>Action</th>
						</tr>
						<%
							int count = 0;
						%>
						<c:forEach var="cow" items="${cows}">
							<!--  URL for update Link -->
							<c:url var="updateLink" value="/showCowUpdateForm">
								<c:param name="cowId" value="${cow.id}" />
							</c:url>
							<!--  URL for Delete Link -->
							<c:url var="deleteLink" value="/deleteCow">
								<c:param name="cowId" value="${cow.id}" />
							</c:url>

							<tr>

								<td><img
									src="data:image/jpeg;base64,${cow.getLastPicture().base64imageFile}"
									width="100" height="100" class="cImage" /></td>
								<td>${cow.color}</td>
								<td>${cow.getDobInYear()}</td>
								<td>${cow.age}</td>
								<td>${cow.gender}</td>
								<td>${cow.dob}</td>
								<td><security:authorize access="hasRole('ADMIN')">
										<a href="${updateLink}" class="btn btn-success">Update</a>
									| <a href="${deleteLink}" class="btn btn-success"
											onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
									</security:authorize></td>

							</tr>

						</c:forEach>

					</table>

					<ul class="pagination pagination-sm">
						<c:forEach begin="1" end="${totalPages}" varStatus="loop">
							<li class="page-item"><a class="page-link"
								href="${pageContext.request.contextPath}/showCows/${loop.index}">${loop.index}</a></li>
						</c:forEach>
					</ul>

				</div>
			</div>
		</div>
	</div>
</div>


<%@include file="common/footer.jspf"%>
<script>
	$('.cImage').hover(function() {
		$(this).css({
			width : "250",
			height : "250"
		});
	}).mouseleave(function() {
		$(this).css({
			width : "100",
			height : "100"
		});
	});
</script>
