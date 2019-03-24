<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<style>
.error {
	color: red;
}
</style>
<div id="container">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<b>Sale Cow</b>
				</div>
				<div class="panel-body">



					<form:form action="performSale" method="post"
						enctype="multipart/form-data" class="form-horizontal"
						modelAttribute="saleDTO">

						<form:hidden path="saleId" />
						<form:hidden path="customerId" />


						<div class="form-group">
							<label class="control-label col-sm-2" for="cow ID">Select
								Cow:</label>
							<div class="col-sm-3">
								<form:select path="cowId" class="form-control" id="cow"
									required="required">
									<form:option value="" label="Select One" />
									<form:options items="${saleAbleCows}" itemValue="id"
										itemLabel="cowTagNo" />
								</form:select>
								<form:errors path="cowId" cssClass="error" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-sm-2" for="nic">NIC:</label>
							<div class="col-sm-6">
								<form:input type="text" path="nic" class="form-control" id="nic"
									placeholder="Enter NIC" required="required" />
								<form:errors path="nic" cssClass="error"></form:errors>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="firstName">First
								Name:</label>
							<div class="col-sm-6">
								<form:input type="text" path="firstName" class="form-control"
									id="firstName" placeholder="Enter First Name"
									required="required" pattern="[a-zA-Z]+" title="Please Enter Correct Name"/>
								<form:errors path="firstName" cssClass="error"></form:errors>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2" for="lastName">Last
								Name:</label>
							<div class="col-sm-6">
								<form:input type="text" path="lastName" class="form-control"
									id="lastName" placeholder="Enter Last Name" required="required"
									pattern="[a-zA-Z]+"  title="Please Enter Correct Name"/>
								<form:errors path="lastName" cssClass="error"></form:errors>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2" for="address">Address:</label>
							<div class="col-sm-6">
								<form:textarea path="address" class="form-control" id="address"
									placeholder="Enter Address" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="saleDate">Sale
								Date:</label>
							<div class="col-sm-4">

								<form:input type="date" path="saleDate" class="form-control"
									id="saleDate" required="required" />
								<form:errors path="saleDate" cssClass="error"></form:errors>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="salePrice">Sale
								Price:</label>
							<div class="col-sm-6">
								<form:input type="text" path="salePrice" class="form-control"
									id="salePrice" placeholder="Enter Sale Price"
									required="required" />
								<form:errors path="salePrice" cssClass="error"></form:errors>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2" for="description">Description:</label>
							<div class="col-sm-6">

								<form:textarea path="description" class="form-control"
									id="description"
									placeholder="Enter Purchase related Description if any" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<div class="container">
									<div class="row">
										<div class="col-sm-1">
											<button type="submit" class="btn btn-default">Submit</button>
										</div>

										<div class="col-sm-1">
											<form:button type="reset" class="btn btn-default"> Reset</form:button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</form:form>

				</div>
			</div>
		</div>
	</div>
</div>






<%@ include file="common/footer.jspf"%>