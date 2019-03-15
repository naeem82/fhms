<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<script>
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#cow').attr('src', e.target.result).width(250).height(250);
			};

			reader.readAsDataURL(input.files[0]);
		}
	}
</script>


<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-primary">
				<div class="panel-heading">Add Cow Picture Form</div>
				<div class="panel-body">
				  <div class="row">
				  <div class="col-md-6">
					<form:form action="addCowPicture" method="post"
						enctype="multipart/form-data" class="form-horizontal"
						modelAttribute="fileBucket">
						<form:hidden path="cowId"/>



						<div class="form-group">
							<label class="control-label col-sm-2" for="fileName">File:</label>
							<div class="col-sm-10">
								<input type="file" name="file" class="form-control"
									id="fileName" placeholder="Select File" onchange="readURL(this);">
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
				  <div class="col-md-6">
				   <img id="cow" src="#" alt="" />
				  <img alt="img" src="data:image/jpeg;base64,${fileBucket.base64ImageFile}"  width="250" height="250"/>
				 
				  </div>
				  </div>

				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>