app.controller('paymentDetailsController', function($scope, $routeParams) {
	
	$scope.secureToken = $routeParams.secureToken;
	$scope.secureTokenId = $routeParams.secureTokenId;

	var loc = 'https://pilot-payflowlink.paypal.com?SECURETOKEN=' + $scope.secureToken + '&SECURETOKENID=' + $scope.secureTokenId;
	
	$('#paymentDetails').attr('src', loc);
	
	var setLoc = $('#paymentDetails').attr('src');
	console.log('The iframe src is: ' + setLoc);
});