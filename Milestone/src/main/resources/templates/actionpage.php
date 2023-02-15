<?php
    if(!empty($_POST["send"]))
    {
        $Name = $_POST["Name"];
        $Email = $_POST["Email"];
        $Message = $_POST["Message"];
        $toEmail = $_POST["jevonkl@gmail.com"];

        $mailHeaders = "Name: " . $Name . "\r\n Email: " . $Email . "\r\n Message: " . $Message . "\r\n";

        if(mail($toEmail, $Name, $mailHeaders)){
            $Message = "Your Email has been sent";
        }

    }
?>