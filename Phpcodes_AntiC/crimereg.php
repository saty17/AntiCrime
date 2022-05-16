<?php


    require 'connection.php';
  $crimestreet=$_POST['crimestreet'];
  $crimecity=$_POST['crimecity'];
  $crimepincode=$_POST['crimepincode'];
  $crimedetails = $_POST['crimedetails'];


  $encodedImage = $_POST['EN_IMAGE'];

	$imagetitle = "myImage";
	//$imagetitle = $encodedImage;
	$imagelocation = "crimeimages/$crimestreet.jpg";
	$username = $_POST['username'];
	$status = $_POST['status'];

	$sqlQuery = "INSERT INTO crimeregister(CrimeStreet,CrimeCity,CrimePincode,CrimeDetails,ImageTitle,ImageLocation,UserName, Status) VALUES ('$crimestreet','$crimecity',' $crimepincode','$crimedetails','$imagetitle', '$imagelocation','$username', '$status')";

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