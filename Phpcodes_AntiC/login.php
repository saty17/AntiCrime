<?php

  require 'connection.php';

  $email=$_POST['email'];
  $password=md5($_POST['password']);

  $checkUser="SELECT * FROM regtable WHERE Email='$email'";

  $result=mysqli_query($con,$checkUser);



  if(mysqli_num_rows($result)>0){ 

    $checkUserquery="SELECT Id, UserName, Email FROM regtable WHERE Email='$email' and Password='$password'";
    $resultant=mysqli_query($con,$checkUserquery);

    if(mysqli_num_rows($resultant)>0){

      while($row=$resultant->fetch_assoc())
      
      $response['user']=$row;
      $response['error']="200";
      $response['message']="login success";
    }
    else{
      $response['user']=(object)[];
      $response['error']="400";
      $response['message']="Wrong credentials";

    }
   
    
  }
  else{

    $response['user']=(object)[];
    $response['error']="400";
  	$response['message']="user does not exist";


  }

  echo json_encode($response);
    
?>