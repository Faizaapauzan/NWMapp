<?php
include 'dbconnect.php';

    if(isset($_POST['update']))
    {   
        $jobregister_id = $_POST['jobregister_id'];
        
    $job_priority = $_POST['job_priority'];
    $job_order_number = $_POST['job_order_number'];
    $job_name = $_POST['job_name'];
    $job_status   = $_POST['job_status'];
    $job_description  = $_POST['job_description'];
    $requested_date = $_POST['requested_date'];
    $delivery_date = $_POST['delivery_date'];
    $customer_name = $_POST['customer_name'];
    $customer_grade = $_POST['customer_grade'];
    $customer_address  = $_POST['customer_address'];
    $customer_PIC = $_POST['customer_PIC'];
    $customer_phone = $_POST['customer_phone'];
    $machine_name = $_POST['machine_name'];
    $machine_type = $_POST['machine_type'];
    $machine_brand = $_POST['machine_brand'];


        $query = "UPDATE job_register SET job_priority='$job_priority', job_order_number='$job_order_number', job_name='$job_name', job_status='$job_status', job_description='$job_description', requested_date='$requested_date', delivery_date='$delivery_date', customer_name='$customer_name', customer_grade='$customer_grade', customer_address='$customer_address', customer_PIC='$customer_PIC', customer_phone='$customer_phone', machine_name='$machine_name', machine_type='$machine_type', machine_brand='$machine_brand' WHERE jobregister_id='$jobregister_id'  ";
        $query_run = mysqli_query($conn, $query);

        if($query_run)
        {
            echo '<script> alert("Data Updated"); </script>';
            header("Location:Adminhomepage.php");
        }
        else
        {
            echo '<script> alert("Data Not Updated"); </script>';
        }
    }
?>