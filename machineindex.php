<?php

include 'dbconnect.php';

$response = array('success' => false);

if(isset($_POST['type_id']) && $_POST['type_id']!='' || $_POST['type_id']==''
   &&
   isset($_POST['serialnumber']) && $_POST['serialnumber']!='' || $_POST['serialnumber']==''
    &&
   isset($_POST['machine_code']) && $_POST['machine_code']!='' || $_POST['machine_code']==''
    &&
   isset($_POST['machine_name']) && $_POST['machine_name']!='' || $_POST['machine_name']==''
    &&
   isset($_POST['customer_name']) && $_POST['customer_name']!='' || $_POST['customer_name']==''
    &&
	  isset($_POST['customer_id']) && $_POST['customer_id']!='' || $_POST['customer_id']==''
    &&
   isset($_POST['purchase_date']) && $_POST['purchase_date']!='' || $_POST['purchase_date']==''
    &&
    isset($_POST['machine_description']) && $_POST['machine_description']!='' || $_POST['machine_description']==''
    &&
   isset($_POST['machinelistcreated_by']) && $_POST['machinelistcreated_by']!='' || $_POST['machinelistcreated_by']==''
    &&
   isset($_POST['machinelistlastmodify_by']) && $_POST['machinelistlastmodify_by']!='' || $_POST['machinelistlastmodify_by']=='')

    {
        
        $sql = "INSERT INTO machine_list (type_id, serialnumber, machine_code, machine_name, customer_name, customer_id, purchase_date, machine_description, machinelistcreated_by, machinelistlastmodify_by) 
                       
                       VALUES ( '".addslashes($_POST['type_id'])."',
					    		'".addslashes($_POST['serialnumber'])."',
								 '".addslashes($_POST['machine_code'])."',
                               '".addslashes($_POST['machine_name'])."',
                               '".addslashes($_POST['customer_name'])."',  
							     '".addslashes($_POST['customer_id'])."',                           
                               '".addslashes($_POST['purchase_date'])."',
							    '".addslashes($_POST['machine_description'])."',
                               '".addslashes($_POST['machinelistcreated_by'])."',
                               '".addslashes($_POST['machinelistlastmodify_by'])."')";
        
        if($conn->query($sql))
        {
            $response['success'] = true;
        }
    }

echo json_encode($response);

?>