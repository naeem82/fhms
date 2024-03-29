<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<style>
.error {
	color: red;
}
</style>


<div id="container">
	<div class="row">
		<div class="col-md-10 col-md-offset-1">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<b>Purchase Cow</b>
				</div>
				<div class="panel-body">



					<form:form action="performPurchase" method="post"
						enctype="multipart/form-data" class="form-horizontal"
						modelAttribute="purchaseDTO">

						<form:hidden path="purchaseId" />

						<form:hidden path="customerId" />

						<fieldset class="scheduler-border">
							<legend class="scheduler-border"> Cow</legend>
							<div class="form-group">
								<label class="control-label col-sm-2" for="cow ID">Select
									Cow:</label>
								<div class="col-sm-3">
									<form:select path="cowId" class="form-control" id="cow">
										<form:option value="" label="Select One" />
										<form:options items="${cows}" itemValue="id"
											itemLabel="cowTagNo" />
									</form:select>
									<form:errors path="cowId" cssClass="error"></form:errors>
								</div>
							</div>
						</fieldset>
						<fieldset class="scheduler-border">
							<legend class="scheduler-border">Customer Information</legend>
							<div class="form-group">
								<label class="control-label col-sm-2" for="nic">NIC:</label>
								<div class="col-sm-6">
									<form:input type="text" path="nic" class="form-control"
										id="nic" placeholder="Enter NIC" />
									<form:errors path="nic" cssClass="error"></form:errors>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="firstName">First
									Name:</label>
								<div class="col-sm-6">
									<form:input type="text" path="firstName" class="form-control"
										id="firstName" placeholder="Enter First Name" />
									<form:errors path="firstName" cssClass="error"></form:errors>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="lastName">Last
									Name:</label>
								<div class="col-sm-6">
									<form:input type="text" path="lastName" class="form-control"
										id="lastName" placeholder="Enter Last Name" />
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
						</fieldset>
						<fieldset class="scheduler-border">
							<legend class="scheduler-border">Sale Information</legend>
							<div class="form-group">
								<label class="control-label col-sm-2" for="purchaseDate">Purchase
									Date:</label>
								<div class="col-sm-4">
								<form:input type="date" path="purchaseDate"
												class="form-control" id="purchaseDate" />
									

									<form:errors path="purchaseDate" cssClass="error"></form:errors>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="price">Price:</label>
								<div class="col-sm-6">
									<form:input type="text" path="price" class="form-control"
										id="price" placeholder="Enter Purchase Price" />
									<form:errors path="price" cssClass="error"></form:errors>
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
						</fieldset>
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