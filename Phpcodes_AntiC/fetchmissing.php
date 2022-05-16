<?php

	require "connection.php";
	
	$missingList="SELECT* FROM missingregister";
	$result=mysqli_query($con,$missingList);

	if(mysqli_num_rows($result)>0){
		
		while($row=$result->fetch_assoc()){
			
			$response['missingList'][]=$row;
			$response['error']="200";
		}
	}
	else{
		
		$response['missingList']="400";
		$response['users']=(object)[];
	}
	
	echo json_encode($response);

?>