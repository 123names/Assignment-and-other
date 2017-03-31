<?php
	$con = mysqli_connect("mysql9.000webhost.com","a3025937_123name","123test","a3025937_PARKLOG");
	
	$username = $_POST["username"];
	$password = $_POST["password"];	
	
	$statement = mysqli_prepare($con,"select * from account where username = ? AND password = ?");
	mysqli_stmt_bind_param($statement,"ss",$username,$password);
	mysqli_stmt_execute($statement);
	
	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement, $name,$username,$password,$seatTaken,$level);
	
	$response = array();
	$response["success"] = false;
	
	while(mysqli_stmt_fetch($statement)){
		$response["success"] = true;
		$response["name"] = $name;
		$response["username"] = $username;
		$response["password"] = $password;
		$response["seatTaken"] =$seatTaken;
		$response{"accountLevel"} = $level;
	}
	echo json_encode($response);
	
	//mysqli_stmt_close($statement);
	mysqli_close($con);
?>