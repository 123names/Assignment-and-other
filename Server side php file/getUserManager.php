<?php
	$con = mysqli_connect("mysql9.000webhost.com","a3025937_123name","123test","a3025937_PARKLOG");
	
	$statement  ="select * from account";
	$result = mysqli_query($con, $statement);
	
	$response = array();
	$response["success"] = false;
	
	$count = mysqli_num_rows($result);
	
	if ($count > 0) {
		while($row = mysqli_fetch_assoc($result)) {
			$response[] = $row;
			//echo "position: " . $row["Position"]. " - available: " . $row["Available"]."<br>";
		}
		$response["success"] = true;
		$response{"count"} = $count;
	}
	else{
		$response{"count"} = 0;
	}
	
	echo json_encode($response);
	mysqli_close($con);
?>