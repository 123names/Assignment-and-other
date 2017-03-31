<?php
	$con = mysqli_connect("mysql9.000webhost.com","a3025937_123name","123test","a3025937_PARKLOG");
	
	$position = $_POST["position"];
	$available = $_POST["available"];
	$currentUser = $_POST["currentUser"];
	$response = array();
	$response["success"] = false;
	$user = NULL;
	
	$statement  = mysqli_prepare($con,"update seats set available = ? , TakenBy = ? where Position = ?");
	mysqli_stmt_bind_param($statement,"iss",$available,$user,$position);
	$result = mysqli_stmt_execute($statement);
	
	if($result){
		$statement2 = mysqli_prepare($con,"update account set seatTaken = ? where username = ?");
		mysqli_stmt_bind_param($statement2,"ss",$user,$currentUser);
		$result2 = mysqli_stmt_execute($statement2);
		if($result2){
			$response["success"] = true;
		}
		else{
			$response["Error"] = "Database mismatch.";
		}
	}
	echo json_encode($response);
	
	mysqli_close($con);
?>