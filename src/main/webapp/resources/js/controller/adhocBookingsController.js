app.controller('adhocBookingsController', function($scope, $http, $window) {
	
	$scope.title = 'Welcome to adhoc bookings page';
	
	$scope.bookingTraining = function() {
		
		$http({
			
				url : '/movietickets/bookingTraining',
				method : 'GET',
				params : {
					'location' : $scope.location,
					'program' : $scope.program,
					'course' : $scope.course,
					'trainingSession' : $scope.session
				}
		}).success(function(data) {
			
			if (data['RESULT'] === '0') {
				console.log("The secure token id is: " + data['SECURETOKENID']);
				console.log("The secure token is: " + data['SECURETOKEN']);
				console.log("The result code is: " + data['RESULT']);
				console.log("The response message is: " + data['RESPMSG']);
				
				$window.location.href = '/movietickets/#/paymentDetails/' + data['SECURETOKEN'] + "/" + data['SECURETOKENID'];
				
			} else if (data['RESULT'] != '0') {
				console.log(data['error']);
				$window.location.href = '/movietickets/#/paymenterror';
			}
		}).error(function(data) {
			console.log("This is an error: " + data);
		});
		
	}
		
});