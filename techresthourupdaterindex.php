<?php

include 'dbconnect.php';

$response = array('success' => false);

if(isset($_POST['tech_out']) && $_POST['tech_out']!='' || $_POST['tech_out']==''
    &&
   isset($_POST['technician_in']) && $_POST['technician_in']!='' || $_POST['technician_in']==''
    &&
   isset($_POST['techupdate_id']) && $_POST['techupdate_id']!='' || $_POST['techupdate_id']=='')

    {
        
        $sql = "UPDATE tech_update SET
                       tech_out ='".addslashes($_POST['tech_out'])."',
                       technician_in ='".addslashes($_POST['technician_in'])."'
                WHERE  techupdate_id  ='".addslashes($_POST['techupdate_id'])."' ";
        
        if($conn->query($sql))
        {
            $response['success'] = true;
        }
    }

echo json_encode($response);

?>