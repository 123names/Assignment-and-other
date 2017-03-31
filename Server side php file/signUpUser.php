<?php
	$con = mysqli_connect("mysql9.000webhost.com","a3025937_123name","123test","a3025937_PARKLOG");
	
	$name = $_POST["name"];
	$username = $_POST["username"];
	$password = $_POST["password"];
	$seatTaken = NULL;
	$response = array();
	
	$check = mysqli_prepare($con,"select * from account where username = ?");
	mysqli_stmt_bind_param($check,"s",$username);
	mysqli_stmt_execute($check);
	
	mysqli_stmt_store_result($check);
	$row_count = mysqli_stmt_num_rows($check);
	
	if($row_count == 1){
		$response["exist"] = true;
		$response["success"] = false;
	}
	else{
		$statement  = mysqli_prepare($con,"INSERT INTO account (name,username,password) VALUES (?,?,?)");
		mysqli_stmt_bind_param($statement,"sss",$name,$username,$password);
		$result = mysqli_stmt_execute($statement);
		if($result){
			$response["success"] = true;
		}
		else{
			$response["success"] = false;
		}
	}
	echo json_encode($response);
	
	//mysqli_stmt_close($statement);
	mysqli_close($con);
?>