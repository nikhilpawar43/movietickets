<h3>{{title}}</h3>

<div>
	<table class="table">
		<tr>
			<td>Location</td>
			<td><input type="text" name="location" ng-model="location" class="form-control" /> </td>
		</tr>
		<tr>
			<td>Program</td>
			<td><input type="text" name="program" ng-model="program" class="form-control" /> </td>
		</tr>
		<tr>
			<td>Course</td>
			<td><input type="text" name="course" ng-model="course" class="form-control" /> </td>
		</tr>
		<tr>
			<td>Training session</td>
			<td><input type="text" name="session" ng-model="session" class="form-control" /> </td>
		</tr>
		<tr>
			<td>
				<button class="btn btn-warning">Cancel</button>
			</td>
			<td>
				<button class="btn btn-primary" ng-click="bookingTraining()">Book now</button>
			</td>
		</tr>
	</table>
</div>