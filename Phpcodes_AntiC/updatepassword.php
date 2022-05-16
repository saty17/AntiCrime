<?php  

	require 'connection.php';
	$email=$_POST['email'];
	$current=md5($_POST['current']);
	$new=md5($_POST['new']);
	

	$checkuser="SELECT * FROM regtable WHERE Email='$email' and Password='$current'";
	
	$result=mysqli_query($con,$checkuser);


	if(mysqli_num_rows($result)>0){

		$updatePass=mysqli_query($con,"UPDATE regtable SET Password='$new' WHERE Email='$email'");

		if(mysqli_num_rows($result)>0){

			$response['error']="200";
			$response['message']="password update success";


		}
		else{

			$response['error']="400";
			$response['message']="password not updated";

		}



	}
	else{

		$response['error']="400";
		$response['message']="current password not correct";

	}

	echo json_encode($response);

?>