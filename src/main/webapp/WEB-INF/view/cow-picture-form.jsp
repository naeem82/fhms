<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div class="row">
		<div class="col-md-10">
			<div class="panel panel-primary">
				<div class="panel-heading">Add Cow Picture Form</div>
				<div class="panel-body">

					<form:form action="addCowPicture" method="post"
						enctype="multipart/form-data" class="form-horizontal"
						modelAttribute="fileBucket">




						<div class="form-group">
							<label class="control-label col-sm-2" for="fileName">File:</label>
							<div class="col-sm-10">
								<input type="file" name="file" class="form-control"
									id="fileName" placeholder="Select File">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="description">Description:</label>
							<div class="col-sm-10">
								<input type="text" name="description" class="form-control"
									id="description" placeholder="Enter Description">
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">Submit</button>
							</div>
						</div>








					</form:form>

				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>