<?php
	$con = mysqli_connect("mysql9.000webhost.com","a3025937_123name","123test","a3025937_PARKLOG");
	
	$level = $_POST["level"];
	$position = $_POST["Position"];
	$response = array();
	$response["success"] = false;
	
	$statement  = mysqli_prepare($con,"update seats set Special = ? where Position = ?");
	mysqli_stmt_bind_param($statement,"is",$level,$position);
	$result = mysqli_stmt_execute($statement);
	
	if($result){
		$response["success"] = true;
	}
	echo json_encode($response);

	mysqli_close($con);
?>