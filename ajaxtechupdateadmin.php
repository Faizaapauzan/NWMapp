<?php
    session_start();
    $storeDate = date("d-m-Y");
    $_SESSION['storeDate'] = $storeDate;
?>

<!DOCTYPE html>
<head>
<link href="css/ajaxtechupdate.css"rel="stylesheet" />
</head>

<body>
    
      <!-- To open ajax -->
      <?php
          include 'dbconnect.php';
          if (isset($_POST['jobregister_id'])) {
            $jobregister_id =$_POST['jobregister_id'];
            $query = "SELECT * FROM job_register WHERE jobregister_id ='$jobregister_id'";
            $query_run = mysqli_query($conn, $query);
            if ($query_run) {
              while ($row = mysqli_fetch_array($query_run)) {
      ?>

      <input type="hidden" name="jobregister_id" value="<?php echo $row['jobregister_id'] ?>">

      <?php } } } ?>
      
      <!-- To update travel time and rest hour -->
      <?php
          include 'dbconnect.php';
          if (isset($_POST['jobregister_id'])) {
            $jobregister_id =$_POST['jobregister_id'];
            $query = "SELECT * FROM job_register WHERE jobregister_id ='$jobregister_id'";
            $query_run = mysqli_query($conn, $query);
            if ($query_run) {
              while ($row = mysqli_fetch_array($query_run)) {
      ?>
    
    <form id="formStatus" action="" method="post" style="margin-left: 20px;">
  
    <!-- Departure Time -->
    <div class="input-box-departure">
      <label for="">Departure Time</label>
      <div class="technician-time">
        <input type="text" class="technician_departure" id="Departure" name="technician_departure" value="<?php echo $row['technician_departure']?>">
        <input type="hidden" name="job_status" value="Doing">
        <input type="button" id="status" value="Departure" onclick="doSomething();">
        
          <script type="text/javascript">
              function doSomething()
                  {
                    $.ajax({url:"departureTime.php", success:function(result)
                      {
                        $("#Departure").val(result);
                      }
                    })
                  }
          </script>
          
          <!-- Change job status to doing -->
          <script>
              $(document).ready(function () {
                $('#status').click(function () {
                  var data = $('#formStatus').serialize() + '&status=status';
                  $.ajax({
                    url: 'changeStatus.php',
                    type: 'post',
                    data: data,
                    success: function(response)
                    {
                      var res = JSON.parse(response);
                      console.log(res);
                    }
                  });
                });
                });
          </script>

      </div>
    </div>
    
    <!-- Time at site -->
    <div class="input-box-arrival">
      <label for="">Time at site</label>
      <div class="technician-time">
        <input type="text" class="technician_arrival" name="technician_arrival" id="arrival" value="<?php echo $row['technician_arrival']?>">
        <input type="button" value="Arrival" onclick="test2()">
        
          <script type="text/javascript">
              function test2()
                  {
                    $.ajax({url:"departureTime.php", success:function(result)
                      {
                        $("#arrival").val(result);
                      }
                    })
                  }
          </script>

      </div>
    </div>
      
    <!-- Return Time -->
    <div class="input-box-leaving">
      <label for="">Return time</label>
      <div class="technician-time">
        <input type="text" class="technician_leaving" name="technician_leaving" id="leaving" value="<?php echo $row['technician_leaving']?>">
        <input type="button" value="Leaving" onclick="test3()">
        
          <script type="text/javascript">
              function test3()
                  {
                    $.ajax({url:"departureTime.php", success:function(result)
                      {
                        $("#leaving").val(result);
                      }
                    })
                  }
          </script>
                
      </div>
    </div>
    
    <div class="input-box-out">
      <label for="">Rest Hour</label>
      
      <!-- Rest Hour Out -->
      <div class="out-time" style="display: flex; align-items: baseline;">
      <input type="hidden" name="techupdate_date" id="techupdate_date" value="<?php echo $_SESSION["storeDate"] ?>">
      <input type="hidden" name="job_assign" value="<?php echo $row['job_assign'] ?>">
      <input type="hidden" name="today_date" value="<?php echo  $_SESSION['storeDate'] ?>">
      <input type="text" class="technician_leaving" name="tech_out" id="tech_out" value="<?= $row['tech_out']; ?>">
      <input style="background-color: #1a0845; color: white; width: 216px;" type="button" value="OUT" onclick="tech_outs()">
          
        <script type="text/javascript">
            function tech_outs()
                {
                  $.ajax({url:"techresthourtime.php", success:function(result)
                    {
                      $("#tech_out").val(result);
                    }
                  })
                }
        </script>
      
      </div>
      
        <?php
            date_default_timezone_set("Asia/Kuala_Lumpur");
            $RestTime = date('g:i A');
            $_SESSION['resttime'] = $RestTime; 
        ?>

      <!-- Rest Hour In -->
      <div class="in-time" style="display: flex; align-items: baseline;">
      <input type="hidden" name="tech_in" value="<?php echo $_SESSION["resttime"] ?>">
      <input type="text" class="technician_leaving" name="technician_in" id="tech_in" value="<?= $row['technician_in']; ?>">
      <input style="background-color: #1a0845; color: white; width: 216px;" type="button" value="IN" onclick="tech_ins();">
    
        <script type="text/javascript">
            function tech_ins()
                {
                  $.ajax({url:"techresthourtime.php", success:function(result)
                    {
                      $("#tech_in").val(result);
                    }
                  })
                }
        </script>
    
      </div>
    </div>
    
    <p class="control"><b id="techupdateAdmin"></b></p>
    <div class="updateBtn">
      <input style="height: 36px; margin-left: 20px; margin-right: 43px; font-size: 15px;" type="button" id="update_time" onclick="techresthourAdmin()" name="update_time" value="Update" />
    </div>
    </form>
        
        <script>
            $(document).ready(function () {
              $('#update_time').click(function () {
                var data = $('#formStatus').serialize() + '&update_time=update_time';
                $.ajax({
                  url: 'jobupdate.php',
                  type: 'post',
                  data: data,
                  success: function(response)
                  {
                    var res = JSON.parse(response);
                    console.log(res);
                    if(res.success == true)
                    $('#techupdateAdmin').html('<span style="color: green">Update Saved!</span>');
                    else
                    $('#techupdateAdmin').html('<span style="color: red">Data Cannot Be Saved</span>');
                  }
                });
              });
            });
        </script>
        
        <script type="text/javascript">
            function techresthourAdmin()
                {
                  var tech_out = $('input[name=tech_out]').val();
                  var technician_in = $('input[name=technician_in]').val();
                  var tech_leader = $('input[name=job_assign]').val();
                  var techupdate_date = $('input[name=techupdate_date]').val();
                  
                  if(tech_out!='' || tech_out=='',
                technician_in!='' || technician_in=='',
                  tech_leader!='' || tech_leader=='',
              techupdate_date!='' || techupdate_date=='')
              
              {
                var formData = {tech_out:tech_out,
                           technician_in:technician_in,
                             tech_leader:tech_leader,
                         techupdate_date:techupdate_date};
                         
                         $.ajax({
                                  url: "techupdateAdmin.php",
                                  type: 'POST',
                                  data: formData,
                                  success: function(response)
                                  {
                                    var res = JSON.parse(response);
                                    console.log(res);
                                  }
                                });
                              }
                            } 
        </script>
        
      <?php } } } ?>

</body>
</html>