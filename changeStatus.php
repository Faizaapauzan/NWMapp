<?php

include 'dbconnect.php';

$response = array('success' => false);

if(isset($_POST['job_status']) && $_POST['job_status']!='' || $_POST['job_status']==''
    &&
   isset($_POST['customer_name']) && $_POST['customer_name']!='' || $_POST['customer_name']==''
    &&
   isset($_POST['job_assign']) && $_POST['job_assign']!='' || $_POST['job_assign']==''
    &&
   isset($_POST['today_date']) && $_POST['today_date']!='' || $_POST['today_date']=='')

    {
        
        $sql = "UPDATE job_register SET 
                       job_status ='".addslashes($_POST['job_status'])."'
                      
                 WHERE customer_name='".addslashes($_POST['customer_name'])."'
                 AND job_assign='".addslashes($_POST['job_assign'])."'
                 AND today_date='".addslashes($_POST['today_date'])."'";
        
        if($conn->query($sql))
        {
            $response['success'] = true;
        }
    }

echo json_encode($response);

?>