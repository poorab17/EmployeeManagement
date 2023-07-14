<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Sign Up Form by STS</title>
<style>
body {
  margin: 0;
  padding: 0;
  font-family: Arial, sans-serif;
}

.main {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f7e6ff;
}

.sign-in {
  background: rgba(255, 255, 255, 0.8);
  padding: 20px;
  border-radius: 10px;
  text-align: center;
}

.form-title {
  margin-top: 0;
}

.form-group {
  margin-bottom: 20px;
  text-align: center; /* Center align the form-group content */
}

label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
}

input[type="text"],
input[type="password"],
input[type="submit"] {
  width: 30%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  margin: 0 auto; /* Center align the text boxes */
  display: block;
}

.agree-term {
 display: inline-block; 
 vertical-align: middle;
  margin-right: 5px;
}

.form-button {
  text-align: center;
}

.socials {
  display: flex;
  justify-content: center;
  margin-top: 10px;
}

.socials li {
  list-style: none;
  margin: 0 5px;
  text-align: center
}

.socials li a {
  display: block;
  width: 30px;
  height: 30px;
  text-align: center;
  line-height: 30px;
  border: 1px solid #ccc;
  border-radius: 50%;
}



.signin-image img {
  max-width: 35%;
  height: auto;
}
</style>


</head>
<body>
<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
 


	<div class="main">

		<!-- Sing in  Form -->
		<section class="sign-in">
			<div class="container">
				<div class="signin-content">
					

					<div class="signin-form">
						<h2 class="form-title">Sign in</h2>
						<form method="post" action="login" class="register-form"
							id="login-form">
							<div class="form-group">
								<label for="username"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="name" id="name"
									placeholder="Your Name" required="required" />
							</div>
							<div class="form-group">
								<label for="password"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="password" id="password"
									placeholder="Password"  required="required" />
							</div>
							<div class="form-group">
								<input type="checkbox" name="remember-me" id="remember-me"
									class="agree-term"  />Remember me
									 <label for="remember-me"
									class="label-agree-term"><span><span></span></span>
								</label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signin" id="signin"
									class="form-submit" value="Log in" required="required"/>
							</div>
							
							<div class="signin-image">
						<figure>
						 <img src="https://images.unsplash.com/photo-1610465299993-e6675c9f9efa?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80" alt="sing up image">
						</figure>
						<a href="registration.jsp" class="signup-image-link">Create an
							account</a>
					
					</div>		
						</form>
						<div class="social-login">
							<span class="social-label">Or login with</span>
							 <ul class="socials">
                <li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
                <li><a href="#"><i class="fab fa-twitter"></i></a></li>
                <li><a href="#"><i class="fab fa-google"></i></a></li>
              </ul>
						</div>
					</div>
				</div>
			</div>
		</section>

	</div>
	
	<script>
   var status = '<%= request.getAttribute("status") %>';
  </script>
	
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
	
<script type="text/javascript">

var status = '<%= request.getAttribute("status") %>';


if(status == "failed")

{
	swal("sorry","Wrong Username or Password","error");
}

if(status == "invalidEmail")

{
	swal("sorry","Please Enter Username","error");
}

if(status == "invalidUpwd")

{
	swal("sorry","Please enter Password","error");
}

</script>


</body>
</html>
