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

<style>
.error {
	color: red
}
</style>


<div class="container">

	<div class="panel panel-primary">
		<div class="panel-heading">Add Cow Form</div>
		<div class="panel-body col-md-11">
			<div class="row">
				<div class="col-md-8">


					<form:form action="addCow" method="post"
						enctype="multipart/form-data" class="form-horizontal"
						modelAttribute="cowAndPictureDTO">

						<form:input type="hidden" path="id" />
						<form:input type="hidden" path="picId" />


						<div class="form-group">
							<label class="control-label col-sm-3" for="cowTagNo">Cow
								ID:</label>
							<div class="col-sm-4">
								<form:input type="text" path="cowTagNo" class="form-control"
									id="cowTagNo" placeholder="Enter ID Number" required="required" />
								<form:errors path="cowTagNo" cssClass="error" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3" for="gender">Cow
								Type:</label>
							<div class="col-sm-4">
								<form:select path="cowType" class="form-control" id="cowType"
									required="required">
									<option value="">Select</option>
									<option value="born"
										<c:if test="${cowAndPictureDTO.cowType=='born'}">selected="selected"</c:if>>Born</option>
									<option value="purchased"
										<c:if test="${cowAndPictureDTO.cowType=='purchased'}">selected="selected"</c:if>>Purchased</option>

								</form:select>
								<form:errors path="cowType" cssClass="error" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-sm-3" for="color">Color:</label>
							<div class="col-sm-6">
								<form:input type="text" path="color" class="form-control"
									id="color" placeholder="Enter color" required="required"
									pattern="[a-zA-Z]+" title="Please Enter Color Name" />
								<form:errors path="color" cssClass="error" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-sm-3" for="gender">Gender:</label>
							<div class="col-sm-4">
								<form:select path="gender" class="form-control" id="gender"
									required="required">
									<option value="">Select</option>
									<option value="male"
										<c:if test="${cowAndPictureDTO.gender=='male'}"> selected="selected"  </c:if>>Male</option>
									<option value="female"
										<c:if test="${cowAndPictureDTO.gender=='female'}"> selected="selected"  </c:if>>Female</option>
								</form:select>
								<form:errors path="gender" cssClass="error" />
							</div>
						</div>
						<div class="form-group" id="radioButton">
							<label class="control-label col-sm-3" for="age"></label>
							<div class="col-sm-4">
							Age(In years)	<input type="radio" name="ageSelection" value="ageInYear" required
							<c:if test="${cowAndPictureDTO.id!=0 && cowAndPictureDTO.age>0}">checked					
							
							</c:if>
							
							/ > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								D.O.B <input type="radio" name="ageSelection" value="dob"  
								<c:if test="${cowAndPictureDTO.id!=0  && cowAndPictureDTO.age==0}">checked					
							
							</c:if>
								
								/>
							</div>
						</div>
						<div class="form-group" id="age1">
							<label class="control-label col-sm-3" for="age">Age:</label>
							<div class="col-sm-4">
								<form:input type="number" min="0" max="20" step="1" path="age"
									class="form-control" id="age" 
									required="required" />
								<form:errors path="age" cssClass="error" />
							</div>
						</div>
						<div class="form-group" id="dob1">
							<label class="control-label col-sm-3" for="dob">DOB:</label>

							<div class="col-sm-4">

								<form:input type="date" path="dob" class="form-control" id="dob"
									required="required" />
								<form:errors path="dob" cssClass="error" />
							</div>
						</div>
						<!-- -------------------------------------------------------------------------------------------------- -->
						<div class="form-group">
							<label class="control-label col-sm-3" for="cowImage">Select
								Picture:</label>
							<div class="col-sm-6">
								<c:choose>
									<c:when test="${cowAndPictureDTO.base64ImageFile!=null}">
										<form:input type="file" path="file" class="form-control"
											id="cowImage" onchange="readURL(this);" />


									</c:when>
									<c:otherwise>
										<form:input type="file" path="file" class="form-control"
											id="cowImage" onchange="readURL(this);" required="required" />

									</c:otherwise>
								</c:choose>

								<form:errors path="file" cssClass="error" />
							</div>
						</div>


						<!-- -------------------------------------------------------------------------------------------------- -->
						<div class="form-group">
							<label class="control-label col-sm-3" for="description">Description:</label>
							<div class="col-sm-6">
								<form:textarea type="text" path="description"
									class="form-control" id="description" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-2">
								<button type="submit" class="btn btn-default">Submit</button>
							</div>
							<div class="col-sm-offset-0 col-sm-2">
								<form:button type="reset" class="btn btn-default">Reset</form:button>
							</div>
						</div>
					</form:form>









				</div>
				<div class="col-md-4" align="left">

					<!-- <img id="cow" src="#" alt="" /> -->
					<c:choose>
						<c:when test="${cowAndPictureDTO.base64ImageFile!=null }">
							<img id="cow" alt="img"
								src="data:image/jpeg;base64,${cowAndPictureDTO.base64ImageFile}"
								width="250" height="250" />

						</c:when>
						<c:otherwise>
							<img id="cow" src="#" alt="" />

						</c:otherwise>
					</c:choose>
				</div>
			</div>

		</div>



	</div>

</div>





<%@ include file="common/footer.jspf"%>

<script type="text/javascript">
$( document ).ready(function() {
	var currentValue = $("input[name='ageSelection']:checked").val(); // Get the radio checked value
	 
    if(currentValue=='ageInYear'){
  
  //	 $("dob").removeAttr("required");
  	  $( "#age" ).prop( "disabled", false );
  	  $( "#dob" ).prop( "disabled", true );
    }
    if(currentValue=='dob'){
  	$( "#dob" ).prop( "disabled", false );
  	$( "#age" ).prop( "disabled", true );
  	
  }
});

$(document).on('click', '[type="radio"]', function() {
    var currentValue = $(this).val(); // Get the radio checked value
 
      if(currentValue=='ageInYear'){
    
    //	 $("dob").removeAttr("required");
    	  $( "#age" ).prop( "disabled", false );
    	  $( "#dob" ).prop( "disabled", true );
      }
    else{
    	$( "#dob" ).prop( "disabled", false );
    	$( "#age" ).prop( "disabled", true );
    	
    }
    	
});

</script>