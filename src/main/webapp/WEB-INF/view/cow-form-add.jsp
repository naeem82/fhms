<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<script>
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#cow')
                .attr('src', e.target.result)
                .width(250)
                .height(250);
        };

        reader.readAsDataURL(input.files[0]);
    }
}
</script>



<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-primary">
				<div class="panel-heading">Add Cow Form</div>
				<div class="panel-body col-md-12">
				<div class="row">
				<div  class="col-md-8">
				

					<form:form action="addCow" method="post"
						enctype="multipart/form-data" class="form-horizontal" modelAttribute="cowAndPictureDTO">




						<div class="form-group">
							<label class="control-label col-sm-2" for="cowTagNo">Cow
								ID:</label>
							<div class="col-sm-6">
								<form:input type="text" path="cowTagNo" class="form-control" 
									id="cowTagNo" placeholder="Enter ID Number" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="color">Color:</label>
							<div class="col-sm-6">
								<form:input type="text" path="color" class="form-control" id="color"
									placeholder="Enter color" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-sm-2" for="gender">Gender:</label>
							<div class="col-sm-2">
								<form:select path="gender" class="form-control" id="gender">
									<option value="select">Select</option>
									<option value="male">Male</option>
									<option value="female">Female</option>
								</form:select>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-2" for="age">Age:</label>
							<div class="col-sm-2">
								<form:input type="text" path="age" class="form-control" id="age"
									placeholder="Enter age" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="dob">DOB:</label>
							<div class="col-sm-4">
							
								<form:input type="date" path="dob" class="form-control" id="dob"   />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="cowImage">Select Picture:</label>
							<div class="col-sm-6">
								<form:input type="file" path="file" class="form-control" id="cowImage"  onchange="readURL(this);" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-2" for="description">Description:</label>
							<div class="col-sm-6">
								<form:input type="text" path="description" class="form-control" id="description" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">Submit</button>
							</div>
						</div>
					</form:form>









				</div>
				<div class="col-md-4">
			
				<img id="cow" src="#" alt=""  />
				</div>
				</div>
				
				</div>
				
			</div>
		</div>

	</div>

</div>

















<%@ include file="common/footer.jspf"%>