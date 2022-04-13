<?php session_start(); ?>


<!DOCTYPE html>

<html lang=”en”>

<head>

    <meta name="keywords" content="" />
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel = "icon" href = "https://i.ibb.co/ngKJ7c4/android-chrome-512x512.png" type = "image/x-icon">
	<link href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' rel='stylesheet'>
    <title>NWM Technician Page</title>
	
    <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>	
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" ></script>  
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/tab.css"/>
	<link href="css/ajax.css"rel="stylesheet" />


</head>
<body>

 <?php
//include connection file 
include_once("dbconnect.php");

  if (isset($_POST['jobregister_id'])) {
      $jobregister_id =$_POST['jobregister_id'];

      $sql = "SELECT * FROM `servicereport` WHERE jobregister_id ='$jobregister_id'";
      $queryRecords = mysqli_query($conn, $sql) or die("Error to fetch Accessories data");
  }
  
?>
 
      <?php foreach($queryRecords as $res) :?>
      
    <form method="POST" action="">
    <input type="hidden" id="jobregister_id" name="jobregister_id" value="<?php echo $res['jobregister_id'] ?>">
    <input type="hidden" id="servicereport_id" name="servicereport_id" value="<?php echo $res['servicereport_id'] ?>">
 
 
	<label for="reportdate">View Report</label>
  <div class="input-group">
  <input type="date" class="form-control" id="srvcreportdate" name="srvcreportdate" value="<?php echo $res['srvcreportdate'] ?>">
  

  <div class="input-group-append">

  
  </form>

  	<form id="view_form" method="post">
    <button class="userinfo btn btn-success" type="button" data-id='<?php echo $res['servicereport_id']; ?>'>VIEW</button>
</form>
  </div>

	  <?php endforeach;?>


<!-- FOR VIEW SERVICE REPORT-->	
	    <script type='text/javascript'>
        $(document).ready(function(){
        $('.userinfo').click(function(){
        var servicereport_id = $(this).data('id');
        $.ajax({
            url: 'servicereport.php',
            type: 'post',
            data: {servicereport_id: servicereport_id},
            success: function(data){
            var win = window.open('servicereport.php');
            win.document.write(data);
                        }
                    });
                });
            });
    </script>



	

<?php
        include 'dbconnect.php';
        if (isset($_POST['jobregister_id'])) {
          $jobregister_id =$_POST['jobregister_id'];
          $query = "SELECT * FROM job_register WHERE jobregister_id ='$jobregister_id'";
          // $query = "SELECT * FROM job_register INNER JOIN servicereport ON job_register.jobregister_id = servicereport.jobregister_id";
          $query_run = mysqli_query($conn, $query);
          if ($query_run) {
            while ($row = mysqli_fetch_array($query_run)) {
    ?>


<!-- FOR SUBMIT SERVICE REPORT DATE -->

<form method="POST" action="servicereportdate.php">
    <input type="hidden" id="jobregister_id" name="jobregister_id" value="<?php echo $row['jobregister_id'] ?>">
 
	<label for="reportdate">Service Report Date:</label>
<div class="input-group">
  <input type="date" class="form-control" id="srvcreportdate" name="srvcreportdate">


  <div class="input-group-append">
    <button class="btn btn-primary" type="submit" value="Submit" name="submit-date">SUBMIT</button>

</form>
            </div>

    <?php
    }
  }
}
?>


<!-- FOR UPLOAD SERVICE REPORT -->
 
<form id="uploadreport-form" method="POST" action="uploadservicereport.php" enctype="multipart/form-data">
    
<?php
    include 'dbconnect.php';
    
    if (isset($_POST['servicereport_id'])) {
        
        $servicereport_id =$_POST['servicereport_id'];
        
        $query = "SELECT * FROM servicereport WHERE servicereport_id ='$servicereport_id'";
        
        $query_run = mysqli_query($conn, $query);
            if ($query_run) {
                while ($row = mysqli_fetch_array($query_run)) {
?>


        <input type="text" id="servicereport_id" name="servicereport_id" value="<?php echo $row['servicereport_id'] ?>">

<?php
            }
        }
        }
?>

<br>

<label for="reportdate">Upload Report:</label>
<div class="input-group">
  <div class="custom-file">
    <input type="file" class="custom-file-input" name="files[]" multiple>
    <label class="custom-file-label" for="inputGroupFile04">Choose file</label>
  </div>
  <div class="input-group-append">
    <button class="btn btn-primary" name="update-report" value="Update" type="submit">UPDATE</button>
  </div>
</div>
    </form> 

<br>


<form id="view_upload" method="">




<?php
include_once 'dbconnect.php';

// fetch files
$sql = "SELECT * FROM servicereport WHERE jobregister_id ='$jobregister_id'";
$result = mysqli_query($conn, $sql);
?>


<section>

                        <!-- Responsive table -->
                        <div class="table-responsive">
                            <table class="table m-0">
                                <thead>
                                    <tr>
                                        <th scope="col">File Name</th>
                                        <th scope="col">Download</th>
                                        <th scope="col">Action</th>
                                        <th scope="col">Upload</th>
                                    </tr>
                                </thead>
                                <tbody>
                <?php
                
                while($row = mysqli_fetch_array($result)) { ?>
                <tr>
                  
                    <td><?php echo $row['file_name']; ?></td>
                    <td><a href="servicereport/<?php echo $row['file_name']; ?>" download>Download</td>
					<td><span class='deletes'  style="color:red;" data-id='<?php echo $row["servicereport_id"]; ?>'>Delete</span></td>
          <td></td>
                </tr>
                <?php } ?>
	

                                </tbody>
                            </table>

                        </div>
 <script>
  $(document).ready(function(){

 // Delete 
 $('.deletes').click(function(){
   var el = this;
  
   // Delete id
   var deletesid = $(this).data('id');
 
   var confirmalert = confirm("Are you sure?");
   if (confirmalert == true) {
      // AJAX Request
      $.ajax({
        url: 'servicereportdelete.php',
        type: 'POST',
        data: { servicereport_id:deletesid },
        success: function(response){

          if(response == 1){
	    // Remove row from HTML Table
	    $(el).closest('tr').css('background','tomato');
	    $(el).closest('tr').fadeOut(800,function(){
	       $(this).remove();
	    });
          }else{
	    alert('Invalid ID.');
          }

        }
      });
   }

 });

});

</script>
                    </div>
					<br>
</section>


</body>
</html>