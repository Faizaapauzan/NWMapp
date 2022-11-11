<?php
 session_start();
 // cek apakah yang mengakses halaman ini sudah login
 if($_SESSION['staff_position']=="" ){
  header("location:index.php?error");
 }

if(!isset($_SESSION['username']))
	{	
    header("location:index.php?error");
	}

    elseif($_SESSION['staff_position']== 'Admin')
	{

	}

        elseif($_SESSION['staff_position']== 'Manager')
	{
	}

  else
	{
			header("location:index.php?error");
	}

?>

<!DOCTYPE html>
<html>

<head>
    <meta name="keywords" content="" />
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin Report</title>
    <link rel = "icon" href = "https://i.ibb.co/ngKJ7c4/android-chrome-512x512.png" type = "image/x-icon">
    <link href="css/homepage.css" rel="stylesheet" />

    <link href="css/report.css" rel="stylesheet" />
    <!-- Datatable CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css"/>
    <!-- Script -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src='bootstrap/js/bootstrap.bundle.min.js' type='text/javascript'></script> 
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <!--Boxicons link -->
    <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
    <script src="https://kit.fontawesome.com/cd421cdcf3.js" crossorigin="anonymous"></script>

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700;900&family=Mukta:wght@300;400;600;700;800&family=Noto+Sans:wght@400;700&display=swap" rel="stylesheet">
</head>

		<style>


#auto {
  counter-reset: rowNumber;
}

#auto tr > td:first-child {
  counter-increment: rowNumber;
}

#auto tr td:first-child::before {
  content: counter(rowNumber);
  min-width: 1em;
  margin-right: 0.5em;
}

table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}




</style>



    <body>

  <div class="sidebar close" style="opacity: 5; line-height: 1; ">
    <div class="logo-details">
	    <img src="neo.png" height="65" width="75"></img>
      <span class="logo_name">NWM SYSTEM</span>
    </div>

    <div class="welcome" style="color: white; text-align: center; font-size:small;">Hi <?php echo $_SESSION["username"] ?>!</div>

    <ul class="nav-links">

      <li>
        <a href="jobregister.php">
          <i class='bx bx-registered' ></i>
          <span class="link_name">Register Job</span>
        </a>
        <ul class="sub-menu blank">
          <li><a class="link_name" href="jobregister.php">Register Job</a></li>
        </ul>
      </li>

       <li>
                <div class="iocn-link">
                    <a href="attendanceadmin.php">
                        <i class='bx bx-calendar-check' ></i>
                        <span class="link_name">Attendance</span>
                    </a>
                </div>
                <ul class="sub-menu blank">
                    <li><a class="link_name" href="attendanceadmin.php">Attendance</a></li>
                </ul>
            </li>

      <li>
        <div class="iocn-link">
          <a href="staff.php">
            <i class='bx bx-id-card' ></i>
            <span class="link_name">Staff</span>
          </a>
        </div>
        <ul class="sub-menu blank">
          <li><a class="link_name" href="staff.php">Staff</a></li>
        </ul>
      </li>

      <li>
        <a href="technicianlist.php">
          <i class='fa fa-users' ></i>
          <span class="link_name">Technician</span>
        </a>
        <ul class="sub-menu blank">
          <li><a class="link_name" href="technicianlist.php">Technician</a></li>
        </ul>
      </li>

      <li>
        <a href="customer.php">
          <i class='bx bx-user' ></i>
          <span class="link_name">Customers</span>
        </a>
        <ul class="sub-menu blank">
          <li><a class="link_name" href="customer.php">Customers</a></li>
        </ul>
      </li>

      <li>
        <div class="iocn-link">
          <a href="machine.php">
            <i class='fa fa-medium' ></i>
            <span class="link_name">Machine</span>
          </a>
        </div>
        <ul class="sub-menu blank">
          <li><a class="link_name" href="machine.php">Machine</a></li>
        </ul>
      </li>

      <li>
        <a href="accessories.php">
          <i class='bx bx-wrench' ></i>
          <span class="link_name">Accessories</span>
        </a>
        <ul class="sub-menu blank">
          <li><a class="link_name" href="accessories.php">Accessories</a></li>
        </ul>
      </li>

      <li>
        <a href="jobtype.php">
          <i class='bx bx-briefcase'></i>
          <span class="link_name">Job Type</span>
        </a>
        <ul class="sub-menu blank">
          <li><a class="link_name" href="jobtype.php">Job Type</a></li>
        </ul>
      </li>

      <li>
        <a href="jobcompleted.php">
          <i class='fa fa-check-square-o' ></i>
          <span class="link_name">Completed Job</span>
        </a>
        <ul class="sub-menu blank">
          <li><a class="link_name" href="jobcompleted.php">Compeleted Job</a></li>
        </ul>
      </li>

      <li>
        <a href="jobcanceled.php">
          <i class='fa fa-minus-square' ></i>
          <span class="link_name">Canceled Job</span>
        </a>
        <ul class="sub-menu blank">
          <li><a class="link_name" href="jobcanceled.php">Canceled Job</a></li>
        </ul>
      </li>
      
 <li>
                <a href="">
                    <i class='bx bxs-report' ></i>
                    <span class="link_name">Report</span>
                </a>
                <ul class="sub-menu blank">
                    <li><a class="link_name" href="adminreport.php">Admin Report</a></li>
                    <li><a class="link_name" href="report.php">Service Report</a></li>
                </ul>

               
            </li>

      <li>
        <a href="logout.php">
          <i class='bx bx-log-out' ></i>
          <span class="link_name">Logout</span>
        </a>
        <ul class="sub-menu blank">
          <li><a class="link_name" href="logout.php">Logout</a></li>
        </ul>
      </li>


  </div>


    <!--Home navigation-->
    <section class="home-section">
    <nav>
    <div class="home-content">
    <i class='bx bx-menu' ></i>
    <a><button style="background-color: #ffffff; color: black; font-size: 26px; padding: 29px -49px; margin-left: -17px; border: none; cursor: pointer; width: 100%;" class="btn-reset" onclick="document.location='Adminhomepage.php'" ondblclick="document.location='adminjoblisting.php'">Home</button></a>
    </div>
    </nav>  
	

<div class="jobTypeList">
<h1>Admin Report</h1>
<body>

    <div class="board" style="background-color:#ffffff;padding-top: 20px;padding-bottom: 20px;">
    <div class="status" style="margin: 20px;font-weight: bold;">
    <h3>Worker Assignment</h3>
    </div>

    <div class="CodeDropdown" style="margin-right: 20px;margin-left: 21px;">
    <label for="date" class="details" style="padding-right: 20px;">Date</label>
    <input type="date" style="height: 36px; width: 301px;" id="date" value="<?php echo $date = date('d-m-Y'); ?>">
    <button class="btn-biru" style="width: auto;">Submit</button>
    <button class="btn-biru" style="width: auto;" class="printreport" data-id='<?php echo $row['jobregister_id']; ?>'>Print</button>
    </div>

    <div class="remarks-job" style="margin-top: 27px; margin: 20px;">
    <b>Remark - Total Workers:</b>
    <div class="job-update" style="margin-top: 20px; margin: 20px;">
    <table id="auto" style="width:100%">

        <thead style="height: 42px;">
            <th></th>
            <th style="width: 9%;">Leader</th>
            <th style="width: 12%;">Assistant</th>
            <th style="width: 15%;">Place</th>
            <th style="width: 27%;">Machine</th>
            <th style="width: 7%;">Departure</th>
            <th style="width: 7%;">Arrival</th>
            <th style="width: 7%;">Leaving</th>
            <th style="width: 9%;">Work Time</th>
            <th style="width: 9%;">Travel Time</th>
        </thead>

            <?php
                include_once 'dbconnect.php';

                $query = mysqli_query($conn, "SELECT * FROM job_register LEFT JOIN assistants ON job_register.jobregister_id=assistants.jobregister_id WHERE job_register.DateAssign='$date'");

                if ($query){
                  // output data of each row
                  while ($row = mysqli_fetch_array($query)) {

                  $technician_departure =$row['technician_departure'];
                  $technician_arrival =$row['technician_arrival'];
                  $technician_leaving =$row['technician_leaving'];
                  $departure = substr($technician_departure,11);
                  $arrival = substr($technician_arrival,11); 
                  $leaving = substr($technician_leaving,11);

                  if (!function_exists('difftime'))   {
                    function difftime($techniciandeparture, $technicianarrival)  {
                        $dif=array();
                        $first = strtotime($techniciandeparture);
                        $second = strtotime($technicianarrival);
                        $TravelTime = abs($first - $second);

                        $dif['s'] = floor($TravelTime);
                        $dif['m'] = floor($TravelTime/(60) % 60 ); //minute
                        $dif['h'] = floor($TravelTime/(60*60)); //hour
                        
                        return $dif;
                    }
                }

                if (!function_exists('difftime2'))   {
                  function difftime2($technicianarrival, $technicianleaving)  {
                      $dif2=array();
                      $first = strtotime($technicianarrival);
                      $second = strtotime($technicianleaving);
                      $WorkTime = abs($first - $second);

                      $dif['s'] = floor($WorkTime);
                      $dif['m'] = floor($WorkTime/(60) % 60 ); //minute
                      $dif['h'] = floor($WorkTime/(60*60)); //hour
                      
                      return $dif2;
                  }
              }
            ?>

        <tbody>
            <td style="text-align: center;"></td>
            <td><?php echo $row["job_assign"]; ?></td>
            <td><textarea style="border:none;" class="infoarea" id="textarea-container"><?php echo $row["username"]; ?></textarea></td>
            <td><?php echo $row["customer_name"]; ?></td>
            <td><?php echo $row["machine_type"]; ?> - <?php echo $row["job_name"]; ?></td>
            <td style="text-align: center;"><?php echo "$departure" ?></td>
            <td style="text-align: center;"><?php echo "$arrival" ?></td>
            <td style="text-align: center;"><?php echo "$leaving" ?></td>
            <td style="text-align: center;"><?php echo difftime($arrival, $leaving)['h']?>   hours <?php echo difftime($arrival, $leaving)['m']?>  minutes</td>
            <td style="text-align: center;"><?php echo difftime($departure, $arrival)['h']?>   hours <?php echo difftime($departure, $arrival)['m']?>  minutes</td>
            
        </tbody>
        <?php } } ?>

    </table>
       </div>
    </div>
       <script type="text/javascript">
var $textArea = $("#textarea-container");

// Re-size to fit initial content.
resizeTextArea($textArea);

// Remove this binding if you don't want to re-size on typing.
$textArea.off("keyup.textarea").on("keyup.textarea", function() {
    resizeTextArea($(this));
});

// function resizeTextArea($element) {
//     $element.height($element[0].scrollHeight);
// }
</script>
<div class="remarks-worker" style="margin: 20px;padding-top: 70px;">
   <b> Remark - Workers Attendance</b>

    <div class="staff-update" style="margin-top: 50px; margin: 20px;">
    <table id="auto" style="width:100%">
        <thead style="height: 42px;">
            <th style="width: 3%;"></th>
            <th style="width: 20%;">Leader</th>
            <th style="width: 20%;">Assistant</th>
            <th style="width: 10%">Clock In</th>
            <th style="width: 10%;">Clock Out</th>
            <th style="width: 10%;">Rest Out</th>
            <th style="width: 10%;">Rest In</th>
        </thead>

        
            <?php
                include_once 'dbconnect.php';

                $sql = "SELECT * FROM tech_update WHERE techupdate_date='$date'";
                $result = mysqli_query($conn, $sql);

                if (mysqli_num_rows($result) > 0) {
                  // output data of each row
                while($row = mysqli_fetch_assoc($result)) {
            ?>

        <tbody>
            <td style="text-align: center;"></td>
            <td><?php echo $row["tech_leader"]; ?></td>
            <td><?php echo $row["username"]; ?></td>
            <td style="text-align: center;"><?php echo $row["tech_clockin"]; ?></td>
            <td style="text-align: center;"><?php echo $row["tech_clockout"]; ?></td>
            <td style="text-align: center;"><?php echo $row["tech_out"]; ?></td>
            <td style="text-align: center;"><?php echo $row["technician_in"]; ?></td>
        </tbody>
        <?php } } ?>
    </table>
        </div>
    </div>

    </div>

        <!-- FOR NEW SERVICE REPORT-->	
    <script type='text/javascript'>
        $(document).ready(function(){
        $('.printreport').click(function(){
        var jobregister_id = $(this).data('id');

        $.ajax({
            url: 'reportadmin.php',
            type: 'post',
            data: {jobregister_id:jobregister_id},
            success: function(data){
            var win = window.open('reportadmin.php');
            win.document.write(data);
                        }
                    });
                });
            });
    </script>
    <!-- FOR NEW SERVICE REPORT-->	
    
  <script>
  let arrow = document.querySelectorAll(".arrow");
  for (var i = 0; i < arrow.length; i++) {
    arrow[i].addEventListener("click", (e)=>{
   let arrowParent = e.target.parentElement.parentElement;//selecting main parent of arrow
   arrowParent.classList.toggle("showMenu");
    });
  }
  let sidebar = document.querySelector(".sidebar");
  let sidebarBtn = document.querySelector(".bx-menu");
  console.log(sidebarBtn);
  sidebarBtn.addEventListener("click", ()=>{
    sidebar.classList.toggle("close");
  });
  </script>

</body>
</html>