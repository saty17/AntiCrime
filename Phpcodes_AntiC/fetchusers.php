<?php

	require "connection.php";
	
	$users="SELECT Id, UserName, Email FROM regtable";
	$result=mysqli_query($con,$users);
	
	if(mysqli_num_rows($result)>0){
		
		while($row=$result->fetch_assoc()){
			
			$response['users'][]=$row;
			$response['error']="200";
		}
	}
	else{
		
		$response['error']="400";
		$response['users']=(object)[];
	}
	
	echo json_encode($response);

?>