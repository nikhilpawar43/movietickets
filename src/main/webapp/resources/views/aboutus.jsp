<h3>
	{{message}}
</h3>
	
<p>
	<input type="text" ng-model="username" />
</p>

<button ng-click="getUser()">Get user</button>

<div>
	<table>
		<tr>
			<td>First name</td>
			<td>{{user.firstName}}</td>
		</tr>
	</table>
</div>

<div>
	<!-- <select ng-model = "users[itemToSelect]" ng-options="user.firstName for user in users" > -->
	<select ng-model = "option.user" ng-options="user.id as user.firstName for user in users" >
	</select>
</div>
