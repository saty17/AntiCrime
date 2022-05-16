<?php

  require 'connection.php';
  $address=$_POST['address'];
  $city=$_POST['city'];
  $pincode=$_POST['pincode'];
  $subject = $_POST['subject'];
  $complaint = $_POST['complaint'];
  $username = $_POST['username'];
  $status = $_POST['status'];

  
  $insertQuery="INSERT INTO complaintregister(CompAddress,CompCity,CompPincode,CompSubject,Complaint,UserName, Status) VALUES('$address','$city','$pincode','$subject','$complaint','$username', '$status')";
  $result=mysqli_query($con,$insertQuery);

  if($result){

  	$response['error']="200";
  	$response['message']="Register successful!";
  }
  else
  {
  	$response['error']="400";
  	$response['message']="Registeration failed!";
  }

  
  echo json_encode($response);

?>