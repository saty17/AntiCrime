<?php

	require "connection.php";
	
	$complaintList="SELECT* FROM complaintregister";
	$result=mysqli_query($con,$complaintList);
	
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
	
	echo json_encode($response);

?>