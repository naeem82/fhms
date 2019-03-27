<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>


<div id="container">
	<div class="row">
		<div class="col-md-10 col-md-offset-1">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<b>Purchased Cow List</b>
				</div>
				<div class="panel-body">
					<form:form action="search" method="post">
						<input type="text" name="searchName" />
						<input type="submit" value="search" class="btn btn-success" />


					</form:form>

					<!-- Add button to perform purchase -->
					<security:authorize access="hasRole('ADMIN')">
					<input type="button" value="Purchase Cow"
						onclick="window.location.href='showPurchaseForm'" ,return
						false;
		class="btn btn-success" />
		</security:authorize>
					<!-- add html table -->
					<table class="table table-striped">
						<tr>
							<th>Cow</th>
							<th>Tag No</th>
							<th>Purchase Date</th>
							<th>Description</th>
							<th>Price</th>
							<th>Action</th>
						</tr>
						
						<c:forEach var="purchase" items="${purchases}">
							<!--  URL for update Link -->
							<c:url var="updateLink" value="/showPurchaseUpdateForm">
								<c:param name="purchaseId" value="${purchase.id}" />
								<c:param name="cowId" value="${purchase.getCows().get(0).id}" />
							</c:url>
							<!--  URL for Delete Link -->
							<c:url var="deleteLink" value="/deletePurchase">
								<c:param name="purchaseId" value="${purchase.id}" />
							</c:url>

							<tr>
								<td><img src="data:image/jpeg;base64,${purchase.getCows().get(0).getLastPicture().base64imageFile}" width="150" height="100"></td>
								<td>${purchase.getCows().get(0).cowTagNo}</td>
								
								<td>${purchase.purchaseDate}</td>
								<td>${purchase.description}</td>
								<td>${purchase.price}</td>
								<td>
								<security:authorize access="hasRole('ADMIN')">
								<a href="${updateLink}" class="btn btn-success">Update</a>
									| <a href="${deleteLink}" class="btn btn-success"
									onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
								</security:authorize>
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




<%@include file="common/footer.jspf" %>