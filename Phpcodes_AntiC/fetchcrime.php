<?php

	require "connection.php";
	
	$crimeList="SELECT* FROM crimeregister";
	$result=mysqli_query($con,$crimeList);
	
	if(mysqli_num_rows($result)>0){
		
		while($row=$result->fetch_assoc()){
			
			$response['crimeList'][]=$row;
			$response['error']="200";
		}
	}
	else{
		
		$response['crimeList']="400";
		$response['users']=(object)[];
	}
	
	echo json_encode($response);

?>