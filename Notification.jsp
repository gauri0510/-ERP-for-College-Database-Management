<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>collegeManagement</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,400i,600,700|Raleway:300,400,400i,500,500i,700,800,900" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: eBusiness - v4.7.0
  * Template URL: https://bootstrapmade.com/ebusiness-bootstrap-corporate-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
  <style>
.button {
  background-color:#282852;
  border: none;
  color: white;
  padding: 8px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 3px 2px;
  cursor: pointer;
}
</style>
</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top d-flex align-items-center">
    <div class="container d-flex justify-content-between">

      <div class="logo">
        <h1><a href="index.html"><span>College</span>Management</a></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
      </div>

      <nav id="navbar" class="navbar">
        <ul>
          <li><a class="nav-link scrollto active" href="adminHome.jsp">back</a></li>
          <!-- <li><a class="nav-link scrollto" href="stuNotification.jsp"class="img-fluid"><img src="assets/img/bg.png" alt="" >View Student Notification</a></li>
          <li><a class="nav-link scrollto" href="facNotification.jsp" class="img-fluid"><img src="assets/img/bg.png" alt="">View faculty Notification</a></li> -->
          <!-- <li><a class="nav-link scrollto" href="home.jsp">Logout</a></li> <li class="dropdown"> -->
          <a style="color:white;"><img src="assets/img/user.png" alt=""  class="rounded-circle"><%response.setContentType("text/html");  
				 HttpSession sessio=request.getSession(true);  
	               if(session!=null){  
	               String email=(String)session.getAttribute("email");  
	                out.print(" "+email+""); }   %></a>
	                <ul><li class="dropdown"><a class="nav-link scrollto" href="home.jsp" style="color:black;">Logout</a></li></ul>
          <!-- <li><a class="nav-link scrollto" href="#team">Team</a></li>
          <li><a href="blog.html">Blog</a></li> -->
          <!-- <li class="dropdown"><a href="#"><span>Drop Down</span> <i class="bi bi-chevron-down"></i></a>
            <ul>
              <li><a href="#">Drop Down 1</a></li>
              <li class="dropdown"><a href="#"><span>Deep Drop Down</span> <i class="bi bi-chevron-right"></i></a>
                <ul>
                  <li><a href="#">Deep Drop Down 1</a></li>
                  <li><a href="#">Deep Drop Down 2</a></li>
                  <li><a href="#">Deep Drop Down 3</a></li>
                  <li><a href="#">Deep Drop Down 4</a></li>
                  <li><a href="#">Deep Drop Down 5</a></li>
                </ul>
              </li> -->
              <!-- <li><a href="#">Drop Down 2</a></li>
              <li><a href="#">Drop Down 3</a></li>
              <li><a href="#">Drop Down 4</a></li>
            </ul>
          </li> -->
         <!--  <li><a class="nav-link scrollto" href="#contact">Contact</a></li> -->
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

    </div>
  </header><!-- End Header -->

  <!-- ======= hero Section ======= -->
  <section id="hero">
    <div class="hero-container">
      <div id="heroCarousel" class="carousel slide carousel-fade" data-bs-ride="carousel" data-bs-interval="5000">

      <!--   <ol id="hero-carousel-indicators" class="carousel-indicators"></ol> -->

        <div class="carousel-inner" role="listbox">
<br><br><br><br>
          <div class="carousel-item active" style="background-image:url(assets/img/notification.jpg)">
            <div class="carousel-container">
              <div class="container">
               <!--  <h2 class="animate__animated animate__fadeInDown">The Best Business Information </h2>
                <p class="animate__animated animate__fadeInUp">We're In The Business Of Helping You Start Your Business</p> -->
                <a href="#about" class="btn-get-started scrollto animate__animated animate__fadeInUp"> Notice added</a>
              </div>
            </div>
          </div> 

          <!-- <div class="carousel-item" style="background-image: url(assets/img/hero-carousel/2.jpg)">
            <div class="carousel-container">
              <div class="container">
                <h2 class="animate__animated animate__fadeInDown">At vero eos et accusamus</h2>
                <p class="animate__animated animate__fadeInUp">Helping Business Security & Peace of Mind for Your Family</p>
                <a href="#about" class="btn-get-started scrollto animate__animated animate__fadeInUp">Get Started</a>
              </div>
            </div>
          </div> -->

         <!--  <div class="carousel-item" style="background-image: url(assets/img/hero-carousel/3.jpg)">
            <div class="carousel-container">
              <div class="container">
                <h2 class="animate__animated animate__fadeInDown">Temporibus autem quibusdam</h2>
                <p class="animate__animated animate__fadeInUp">Beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem</p>
                <a href="#about" class="btn-get-started scrollto animate__animated animate__fadeInUp">Get Started</a>
              </div>
            </div>
          </div> -->

        </div>

       <!--  <a class="carousel-control-prev" href="#heroCarousel" role="button" data-bs-slide="prev">
          <span class="carousel-control-prev-icon bi bi-chevron-left" aria-hidden="true"></span>
        </a> -->

        <!-- <a class="carousel-control-next" href="#heroCarousel" role="button" data-bs-slide="next">
          <span class="carousel-control-next-icon bi bi-chevron-right" aria-hidden="true"></span>
        </a> -->
<!--  <a href="#about" class="btn-get-started scrollto animate__animated animate__fadeInUp">Get Started</a> -->
      </div>
      </div>
  
  </section><!-- End Hero Section -->

  <main id="main">

    <!--  ======= About Section ======= -->
    <div id="about" class="about-area area-padding">
      <div class="container">
        <div class="row">
        
        <div class="container">

        <div class="row justify-content-center">
        
            <div class="text-center">
              <div class="col-xl-6 col-lg-5 pt-5 pt-lg-5" >
           
            <div class="text-center">
            <div class="icon-box" data-aos="fade-up">
             <h4 style="color:#282852">Attach Notice Here!!!</h4><br>
                 <form action="NoticeServlet" method="post" enctype="multipart/form-data">
           
          <label>  <input type="file" name="file" class="form-control" id="file"  placeholder="Enter course Id" required><br>
           <button class="button"  name="submit"  type="submit" value="submit">Submit</button></label>
											
           <!--  <input type="text" name="name" class="form-control" id="name"  placeholder="Enter course Name" required><br>
            <input type="text" name="year" class="form-control" id="year"  placeholder="Enter course year started" required><br> -->
            
                
                    
                   
                   
			
			</form> 
			</div>
			</div>
			</div>
			</div>
			
            </div>
          </div>
        </div>
                      
</div>
</div>
</main>
  <div id="preloader"></div>
  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

</body>

</html>