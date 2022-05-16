<?php

  require 'connection.php';
  $username=$_POST['username'];
  $email=$_POST['email'];
  $password=md5($_POST['password']);
  $aadhar_no = $_POST['aadhar_no'];
  $phone_no = $_POST['phone_no'];



  $checkUser="SELECT * from regtable WHERE Email='$email'";
  $checkQuery=mysqli_query($con,$checkUser);

  if(mysqli_num_rows($checkQuery)>0){

  	 $response['error']="403";
  	$response['message']="User exist";
  }
  else
  {
     $insertQuery="INSERT INTO regtable(UserName,Email,Password,Aadhar_no,Phone_no) VALUES('$username','$email','$password','$aadhar_no','$phone_no')";
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



  }

  
  echo json_encode($response);

?>