<?php

    include 'dbconnect.php';

    $sql = ("SELECT srvcreportnumber FROM `servicereport`");
    $res = mysqli_query($conn,$sql);
    $last_id = 0;
    while($row = mysqli_fetch_array($res))
    {
        $last_id = $last_id+1;
    }
    $next_id = str_pad ($last_id+1,3,0, STR_PAD_LEFT);
    date_default_timezone_set("Asia/Kuala_Lumpur");
    $m=date('m');
    $y=date('y');

    $srvcreportnumber = "S".$y.$m."-".$next_id;
    
    echo $srvcreportnumber;


    if (isset($_POST['$srvcreportnumber'])) {

        $servicereport_id = $_POST['servicereport_id'];
        $srvcreportnumber = $_POST['srvcreportnumber'];

        $sql = "UPDATE servicereport SET srvcreportnumber ='$srvcreportnumber' WHERE servicereport_id='$servicereport_id'";
        $query_run = mysqli_query($conn, $sql);
    }

?>


