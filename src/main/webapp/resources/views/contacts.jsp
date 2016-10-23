<h3>
	{{message}}
</h3>

<table class="table">
	<tr>
		<th>First name</th>
		<th>Last name</th>
		<th>Phone</th>
		<th>Operations</th>
	</tr>
	
	<tr class="row1">
		<td class="firstname">Nikhil</td>
		<td class="lastname">Pawar</td>
		<td class="phone">1122334455</td>
		<td>
			<a class="btn btn-default glyphicon glyphicon-pencil editButton" ng-click="editAttendee($event)"></a>
			<a class="btn btn-default glyphicon glyphicon-ok" ng-click="saveChanges($event)"></a>
		</td>
	</tr>
	
	<tr>
		<td>Bibha</td>
		<td>Yadav</td>
		<td>0123456789</td>
		<td>
			<a class="btn btn-default glyphicon glyphicon-pencil"></a>
			<a class="btn btn-default glyphicon glyphicon-ok"></a>
		</td>
	</tr>
	
</table>

<div>
	The input state: {{firstnameForm.firstname.$valid}}
</div>

