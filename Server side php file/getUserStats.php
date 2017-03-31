<?php
	$con = mysqli_connect("mysql9.000webhost.com","a3025937_123name","123test","a3025937_PARKLOG");
	
	$username = $_POST["username"];
	
	$statement = mysqli_prepare($con,"select seatTaken from account where username = ?");
	mysqli_stmt_bind_param($statement,"s",$username);
	mysqli_stmt_execute($statement);
	
	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement,$seatTaken);
	
	$response = array();
	$response["success"] = false;
	
	while(mysqli_stmt_fetch($statement)){
		$response["success"] = true;
		$response["seatTaken"] =$seatTaken;
	}
	echo json_encode($response);
	
	//mysqli_stmt_close($statement);
	mysqli_close($con);
?>