<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div id="container">
	<div class="row">
		<div class="col-md-10 col-md-offset-1">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<b>Sale Cow List</b>
				</div>
				<div class="panel-body">
					<form:form action="search" method="post">
						<input type="text" name="searchName" />
						<input type="submit" value="search" class="btn btn-success" />


					</form:form>

					<!-- Add button to perform purchase -->
					<input type="button" value="Sale Cow"
						onclick="window.location.href='showSaleForm'" ,return
						false;
		class="btn btn-success" />
					<!-- add html table -->
					<table class="table table-striped">
						<tr>
							<th>Cow</th>
							<th>Tag No</th>
							<th>Sale Date</th>
							<th>Description</th>
							<th>Price</th>
							<th>Action</th>
						</tr>
						
						<c:forEach var="sale" items="${sales}">
							<!--  URL for update Link -->
							<c:url var="updateLink" value="/showSaleUpdateForm">
								<c:param name="saleId" value="${sale.id}" />
								<c:param name="cowId" value="${sale.getCows().get(0).id}" />
							</c:url>
							<!--  URL for Delete Link -->
							<c:url var="deleteLink" value="/deleteSale">
								<c:param name="saleId" value="${sale.id}" />
							</c:url>

							<tr>
								<td><img src="data:image/jpeg;base64,${sale.getCows().get(0).getLastPicture().base64imageFile}" width="150" height="100"></td>
								<td>${sale.getCows().get(0).cowTagNo}</td>
								
								<td>${sale.saleDate}</td>
								<td>${sale.description}</td>
								<td>${sale.salePrice}</td>
								<td><a href="${updateLink}" class="btn btn-success">Update</a>
									| <a href="${deleteLink}" class="btn btn-success"
									onclick="if(!(confirm('Are you sure you want to delete this Sale Transaction?'))) return false">Delete</a>
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





<%@ include file="common/footer.jspf" %>