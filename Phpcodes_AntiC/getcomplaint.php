<?php

	require "connection.php";
	
	$receivedUser = $_POST["userN"];
	
	$sqlQuery = "SELECT * FROM complaintregister WHERE UserName = '$receivedUser'";
	
	$result = mysqli_query($con,$sqlQuery);
	
	
	
	if(mysqli_num_rows($result)>0){
		
		while($row=$result->fetch_assoc()){
			
			$response['complaintList'][]=$row;
			$response['error']="200";
		}
	}
	else{
		
		$response['complaintList']="400";
		$response['users']=(object)[];
	}
	
	mysqli_close($con);
	
	print(json_encode($response));

?>