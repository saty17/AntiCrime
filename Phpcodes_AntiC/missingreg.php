<?php


    require 'connection.php';
  $name=$_POST['name'];
  $age=$_POST['age'];
  $lastseen=$_POST['lastseen'];
  $details = $_POST['details'];
  
  $encodedImage = $_POST['EN_IMAGE'];
  $username = $_POST['username'];
  $status = $_POST['status'];


								// $title = $_POST['title'];
								//$username=$_POST['username'];

	$imagetitle = "myImage";
	$imagelocation = "images/$name.jpg";
	//$username = $_POST['username'];

	$sqlQuery = "INSERT INTO missingregister(Name,Age,LastSeen,Details,ImageTitle,ImageLocation,UserName, Status) VALUES ('$name','$age','$lastseen','$details','$imagetitle', '$imagelocation','$username', '$status')";

	if(mysqli_query($con, $sqlQuery)){

		file_put_contents($imagelocation, base64_decode($encodedImage));

		//$result["status"] = TRUE;
		//$result["remarks"] = "Image Uploaded Successfully";
		$response['error']="200";
  		$response['message']="Register successful!";

	}else{

		//$result["status"] = FALSE;
		//$result["remarks"] = "Image Uploading Failed";
		$response['error']="200";
  		$response['message']="Register Failed!";

	}

	mysqli_close($con);

	print(json_encode($response));

?>