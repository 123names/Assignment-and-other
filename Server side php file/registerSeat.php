<?php
	$con = mysqli_connect("mysql9.000webhost.com","a3025937_123name","123test","a3025937_PARKLOG");
	
	$position = $_POST["position"];
	$available = $_POST["available"];
	$user = $_POST["user"];
	
	$response = array();
	$response["success"] = false;
	
	$check = mysqli_prepare($con,"select Available from seats where Position = ?");
	mysqli_stmt_bind_param($check,"s",$position);
	mysqli_stmt_execute($check);
	mysqli_stmt_store_result($check);
	mysqli_stmt_bind_result($check, $availableInDatabase);
	mysqli_stmt_fetch($check);
	
	if($availableInDatabase){
		$statement  = mysqli_prepare($con,"update seats set available = ?, TakenBy = ? where Position = ?");
		mysqli_stmt_bind_param($statement,"iss",$available,$user,$position);
		$result = mysqli_stmt_execute($statement);
		
		if($result){
			$statement2 = mysqli_prepare($con,"update account set seatTaken = ? where username = ?");
			mysqli_stmt_bind_param($statement2,"ss",$position,$user);
			$result2 = mysqli_stmt_execute($statement2);
			if($result2){
				$response["success"] = true;
			}
			else{
				$rollBackAvailable = 1;
				$rollBackUser = NULL;
				$statement3  = mysqli_prepare($con,"update seats set available = ?, TakenBy = ? where Position = ?");
				mysqli_stmt_bind_param($statement3,"iss",$rollBackAvailable,$rollBackUser,$position);
				$result3 = mysqli_stmt_execute($statement3);
				if($result3){
					$response["Error"] = "Database mismatch.";
				}
			}
		}
	}
	
	echo json_encode($response);
	
	mysqli_close($con);
?>