<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.aricent.pojo_classes.EmpBday"%>
<!DOCTYPE html>
<html lang="en">
<head>

<title>EMS-Super Admin</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Lato'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Ubuntu:700'
	rel='stylesheet' type='text/css'>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="javascript/EmployeeManage.js"></script>
<script src="javascript/LocationsManage.js"></script>


<script src="javascript/AddSubAdmin.js"></script>
<script src="javascript/DeleteSubAdmin.js"></script>



<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>  -->
<script src="SuperAdminTeamManagementJS.js"></script>



</head>
<style>
.white, .white a {
  color: #fff;
}
h1 {
	font-size: 6.2vw;
	font-family: 'Ubuntu', Helvetica, Arial, sans-serif !important;
	padding: 0px;
	display: inline
}

h2 {
	font-size: 5.5vw;
	font-family: 'Ubuntu', Helvetica, Arial, sans-serif !important;
	padding: 0px;
	display: inline
}

p.p1 {
	font-size: 4.5vw;
	font-family: 'Ubuntu', Helvetica, Arial, sans-serif !important;
	padding: 0px;
	display: inline
}

p.p2 {
	font-size: 1.5vw;
	font-family: 'Ubuntu', Helvetica, Arial, sans-serif !important;
	padding: 0px;
	display: inline
}

li {
	font-size: 1.2vw;
	font-family: 'Lato Hairline Light';
}

th,td {
	font-family: 'Lato Hairline Light';
	padding: 10px;
}

.btn {
	padding: 5px 5px;
}

.btn-success {
	color: #fff;
	background-color: #286090;
	border-color: #286090;
}

.btn-success:hover {
	color: #fff;
	background-color: #286090;
	border-color: #286090;
}

.btn-danger {
	color: #fff;
	background-color: red;
	border-color: red;
}

.btn-danger:hover {
	color: #fff;
	background-color: red;
	border-color: red;
}

.modal-header,h4,.close {
	background-color: #084B8A;
	color: white !important;
	text-align: center;
	font-size: 30px;
}

.modal-footer {
	background-color: #f9f9f9;
}

.modal-content {
	max-height: 750px;
	overflow: auto;
}

.modal-dialog {
	overflow-y: initial !important
}

input.img {
	border-radius: 10px;
	background-color: #084B8A;
	margin-right: 60px;
}

.img-responsive {
	display: block;
	max-width: 100%;
	width: 100%;
	height: 100%;
}

fieldset {
	display: none;
	width: 70%;
	padding: 10px;
	margin-top: 50px;
	margin-bottom: 50px;
	border-radius: 5px;
	box-shadow: 3px 3px 25px 1px gray;
}

#first {
	display: block;
	width: 70%;
	padding: 20px;
	margin-top: 50px;
	border-radius: 5px;
	box-shadow: 3px 3px 25px 1px gray;
}

.sign-in-facebook {
	background-image: url('facebook.png');
	background-size: cover;
	background-position: -9px -7px;
	background-repeat: no-repeat;
	background-size: 39px 43px;
	padding-left: 18px;
	color: #000;
}

.sign-in-facebook:hover {
	background-image: url('facebook.png');
	background-size: cover;
	background-position: -9px -7px;
	background-repeat: no-repeat;
	background-size: 39px 43px;
	padding-left: 18px;
	color: #000;
}

.sign-in-twitter {
	background-image: url('twitter.png');
	background-size: cover;
	background-position: -4px -5px;
	background-repeat: no-repeat;
	background-size: 39px 43px;
	padding-left: 18px;
	color: #000;
}

.sign-in-twitter:hover {
	background-image: url('twitter.png');
	background-size: cover;
	background-position: -4px -5px;
	background-repeat: no-repeat;
	background-size: 39px 43px;
	padding-left: 18px;
	color: #000;
}

.sign-in-linkedin {
	background-image: url('linkedin.png');
	background-size: cover;
	background-position: -4px -5px;
	background-repeat: no-repeat;
	background-size: 39px 43px;
	padding-left: 18px;
	color: #000;
}

.sign-in-linkedin:hover {
	background-image: url('linkedin.png');
	background-size: cover;
	background-position: -4px -5px;
	background-repeat: no-repeat;
	background-size: 39px 43px;
	padding-left: 18px;
	color: #000;
}

body {
	background: url(background_blur.jpg) no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}

$(
function () { // Setup drop down menu //$('.dropdown-toggle ').dropdown
	(); // Fix input element click problem $('.dropdown input,.dropdown
	label ').click (function(e) {e .stopPropagation();
	
}
);
}
);
</style>
<body>
	<%@ page session="false"%>
	<%
		response.setHeader("Cache-Control",
				"no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0);
		HttpSession sess = request.getSession(false);
		if (sess == null
				|| (!sess.getAttribute("userTypeId").toString().equals("1")))
			response.sendRedirect("Home.html");
	%>
	<nav class="navbar navbar-fixed">
		<div class="container-fluid">
			<button type="button" style="background-color: white;"
				class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar" style="background-color: black;"></span> <span
					class="icon-bar" style="background-color: black;"></span> <span
					class="icon-bar" style="background-color: black;"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="Home.html"><font color="black"><b>Home</b></font></a></li>
					<li><a href="About_us.html"><font color="black"><b>About
									us</b></font></a></li>
					<li><a href="Contact_us.html"><font color="black"><b>Contact
									us</b></font></a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="LogoutServlet?page=Home.html"><font color="black"><b>Logout</b></font></a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div align="center">
		<fieldset id="first">
			<div class="container-fluid" align="center">
				<h1>
					<font color="black">Dashboard</font>
				</h1>
			</div>
			<div class="container-fluid table-responsive" align="center">
				<table>
					<tr>
						<td style="padding: 40px;">
							<div class="container-fluid">
								<button type="submit" class="btn btn-default"
									data-dismiss="modal">
									<img src="Location.jpg" id="myBtn1" />
								</button>
							</div>
						</td>
						<td style="padding: 40px;">
							<div class="container-fluid">
								<button type="submit" class="btn btn-default"
									data-dismiss="modal">
									<img src="Sub_Admin.png" id="myBtn2" />
								</button>

							</div>
						</td>
						<td style="padding: 40px;">
							<div class="container-fluid">
								<button type="submit" class="btn btn-default"
									data-dismiss="modal">
									<img src="Employee.png" id="myBtn3" />
								</button>



								<!-- Modal content FOR EMPLOYEE MANAGEMENT PART ONE-->
								<div class="modal fade" id="myModal3">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header" style="padding: 35px 50px;">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4>
													<span class="glyphicon glyphicon-user"></span> Employee
												</h4>
											</div>
											<div class="modal-body" style="padding: 40px 50px;">
												<form>
													<div class="form-group">
														<label for="usrname">Employee Id</label> <input
															type="text" class="form-control" id="emp_id"
															placeholder="Enter Employee Id" required>
													</div>
													<button type="submit" class="btn btn-success btn-block"
														value="add" id="myBtn3a">Add/Update Employee</button>
												</form>
											</div>

										</div>
									</div>
								</div>

							</div> <!-- Modal For LOCATION MANAGEMENT -->
							<div class="modal fade" id="myModallocation">
								<div class="modal-dialog modal-lg">
									<div class="modal-content">
										<div class="modal-header" style="padding: 35px 50px;">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4>
												<span class="glyphicon glyphicon-map-marker"></span>
												Locations
											</h4>
										</div>
										<div class="modal-body" style="padding: 40px 50px;">
											<form>
												<div class="form-group">
													<table>
														<tr>
															<td style="padding: 5px;"><font color="black"><b>Country
																		: </b></font></td>
															<td style="padding: 5px;"><select name="country"
																id="country">
																	<option value="Afganistan">Afghanistan</option>
																	<option value="Albania">Albania</option>
																	<option value="Algeria">Algeria</option>
																	<option value="American Samoa">American Samoa</option>
																	<option value="Andorra">Andorra</option>
																	<option value="Angola">Angola</option>
																	<option value="Anguilla">Anguilla</option>
																	<option value="Antigua &amp; Barbuda">Antigua
																		&amp; Barbuda</option>
																	<option value="Argentina">Argentina</option>
																	<option value="Armenia">Armenia</option>
																	<option value="Aruba">Aruba</option>
																	<option value="Australia">Australia</option>
																	<option value="Austria">Austria</option>
																	<option value="Azerbaijan">Azerbaijan</option>
																	<option value="Bahamas">Bahamas</option>
																	<option value="Bahrain">Bahrain</option>
																	<option value="Bangladesh">Bangladesh</option>
																	<option value="Barbados">Barbados</option>
																	<option value="Belarus">Belarus</option>
																	<option value="Belgium">Belgium</option>
																	<option value="Belize">Belize</option>
																	<option value="Benin">Benin</option>
																	<option value="Bermuda">Bermuda</option>
																	<option value="Bhutan">Bhutan</option>
																	<option value="Bolivia">Bolivia</option>
																	<option value="Bonaire">Bonaire</option>
																	<option value="Bosnia &amp; Herzegovina">Bosnia
																		&amp; Herzegovina</option>
																	<option value="Botswana">Botswana</option>
																	<option value="Brazil">Brazil</option>
																	<option value="British Indian Ocean Ter">British
																		Indian Ocean Ter</option>
																	<option value="Brunei">Brunei</option>
																	<option value="Bulgaria">Bulgaria</option>
																	<option value="Burkina Faso">Burkina Faso</option>
																	<option value="Burundi">Burundi</option>
																	<option value="Cambodia">Cambodia</option>
																	<option value="Cameroon">Cameroon</option>
																	<option value="Canada">Canada</option>
																	<option value="Canary Islands">Canary Islands</option>
																	<option value="Cape Verde">Cape Verde</option>
																	<option value="Cayman Islands">Cayman Islands</option>
																	<option value="Central African Republic">Central
																		African Republic</option>
																	<option value="Chad">Chad</option>
																	<option value="Channel Islands">Channel
																		Islands</option>
																	<option value="Chile">Chile</option>
																	<option value="China">China</option>
																	<option value="Christmas Island">Christmas
																		Island</option>
																	<option value="Cocos Island">Cocos Island</option>
																	<option value="Colombia">Colombia</option>
																	<option value="Comoros">Comoros</option>
																	<option value="Congo">Congo</option>
																	<option value="Cook Islands">Cook Islands</option>
																	<option value="Costa Rica">Costa Rica</option>
																	<option value="Cote DIvoire">Cote D'Ivoire</option>
																	<option value="Croatia">Croatia</option>
																	<option value="Cuba">Cuba</option>
																	<option value="Curaco">Curacao</option>
																	<option value="Cyprus">Cyprus</option>
																	<option value="Czech Republic">Czech Republic</option>
																	<option value="Denmark">Denmark</option>
																	<option value="Djibouti">Djibouti</option>
																	<option value="Dominica">Dominica</option>
																	<option value="Dominican Republic">Dominican
																		Republic</option>
																	<option value="East Timor">East Timor</option>
																	<option value="Ecuador">Ecuador</option>
																	<option value="Egypt">Egypt</option>
																	<option value="El Salvador">El Salvador</option>
																	<option value="Equatorial Guinea">Equatorial
																		Guinea</option>
																	<option value="Eritrea">Eritrea</option>
																	<option value="Estonia">Estonia</option>
																	<option value="Ethiopia">Ethiopia</option>
																	<option value="Falkland Islands">Falkland
																		Islands</option>
																	<option value="Faroe Islands">Faroe Islands</option>
																	<option value="Fiji">Fiji</option>
																	<option value="Finland">Finland</option>
																	<option value="France">France</option>
																	<option value="French Guiana">French Guiana</option>
																	<option value="French Polynesia">French
																		Polynesia</option>
																	<option value="French Southern Ter">French
																		Southern Ter</option>
																	<option value="Gabon">Gabon</option>
																	<option value="Gambia">Gambia</option>
																	<option value="Georgia">Georgia</option>
																	<option value="Germany">Germany</option>
																	<option value="Ghana">Ghana</option>
																	<option value="Gibraltar">Gibraltar</option>
																	<option value="Great Britain">Great Britain</option>
																	<option value="Greece">Greece</option>
																	<option value="Greenland">Greenland</option>
																	<option value="Grenada">Grenada</option>
																	<option value="Guadeloupe">Guadeloupe</option>
																	<option value="Guam">Guam</option>
																	<option value="Guatemala">Guatemala</option>
																	<option value="Guinea">Guinea</option>
																	<option value="Guyana">Guyana</option>
																	<option value="Haiti">Haiti</option>
																	<option value="Hawaii">Hawaii</option>
																	<option value="Honduras">Honduras</option>
																	<option value="Hong Kong">Hong Kong</option>
																	<option value="Hungary">Hungary</option>
																	<option value="Iceland">Iceland</option>
																	<option value="India" selected="selected">India</option>
																	<option value="Indonesia">Indonesia</option>
																	<option value="Iran">Iran</option>
																	<option value="Iraq">Iraq</option>
																	<option value="Ireland">Ireland</option>
																	<option value="Isle of Man">Isle of Man</option>
																	<option value="Israel">Israel</option>
																	<option value="Italy">Italy</option>
																	<option value="Jamaica">Jamaica</option>
																	<option value="Japan">Japan</option>
																	<option value="Jordan">Jordan</option>
																	<option value="Kazakhstan">Kazakhstan</option>
																	<option value="Kenya">Kenya</option>
																	<option value="Kiribati">Kiribati</option>
																	<option value="Korea North">Korea North</option>
																	<option value="Korea Sout">Korea South</option>
																	<option value="Kuwait">Kuwait</option>
																	<option value="Kyrgyzstan">Kyrgyzstan</option>
																	<option value="Laos">Laos</option>
																	<option value="Latvia">Latvia</option>
																	<option value="Lebanon">Lebanon</option>
																	<option value="Lesotho">Lesotho</option>
																	<option value="Liberia">Liberia</option>
																	<option value="Libya">Libya</option>
																	<option value="Liechtenstein">Liechtenstein</option>
																	<option value="Lithuania">Lithuania</option>
																	<option value="Luxembourg">Luxembourg</option>
																	<option value="Macau">Macau</option>
																	<option value="Macedonia">Macedonia</option>
																	<option value="Madagascar">Madagascar</option>
																	<option value="Malaysia">Malaysia</option>
																	<option value="Malawi">Malawi</option>
																	<option value="Maldives">Maldives</option>
																	<option value="Mali">Mali</option>
																	<option value="Malta">Malta</option>
																	<option value="Marshall Islands">Marshall
																		Islands</option>
																	<option value="Martinique">Martinique</option>
																	<option value="Mauritania">Mauritania</option>
																	<option value="Mauritius">Mauritius</option>
																	<option value="Mayotte">Mayotte</option>
																	<option value="Mexico">Mexico</option>
																	<option value="Midway Islands">Midway Islands</option>
																	<option value="Moldova">Moldova</option>
																	<option value="Monaco">Monaco</option>
																	<option value="Mongolia">Mongolia</option>
																	<option value="Montserrat">Montserrat</option>
																	<option value="Morocco">Morocco</option>
																	<option value="Mozambique">Mozambique</option>
																	<option value="Myanmar">Myanmar</option>
																	<option value="Nambia">Nambia</option>
																	<option value="Nauru">Nauru</option>
																	<option value="Nepal">Nepal</option>
																	<option value="Netherland Antilles">Netherland
																		Antilles</option>
																	<option value="Netherlands">Netherlands
																		(Holland, Europe)</option>
																	<option value="Nevis">Nevis</option>
																	<option value="New Caledonia">New Caledonia</option>
																	<option value="New Zealand">New Zealand</option>
																	<option value="Nicaragua">Nicaragua</option>
																	<option value="Niger">Niger</option>
																	<option value="Nigeria">Nigeria</option>
																	<option value="Niue">Niue</option>
																	<option value="Norfolk Island">Norfolk Island</option>
																	<option value="Norway">Norway</option>
																	<option value="Oman">Oman</option>
																	<option value="Pakistan">Pakistan</option>
																	<option value="Palau Island">Palau Island</option>
																	<option value="Palestine">Palestine</option>
																	<option value="Panama">Panama</option>
																	<option value="Papua New Guinea">Papua New
																		Guinea</option>
																	<option value="Paraguay">Paraguay</option>
																	<option value="Peru">Peru</option>
																	<option value="Phillipines">Philippines</option>
																	<option value="Pitcairn Island">Pitcairn
																		Island</option>
																	<option value="Poland">Poland</option>
																	<option value="Portugal">Portugal</option>
																	<option value="Puerto Rico">Puerto Rico</option>
																	<option value="Qatar">Qatar</option>
																	<option value="Republic of Montenegro">Republic
																		of Montenegro</option>
																	<option value="Republic of Serbia">Republic of
																		Serbia</option>
																	<option value="Reunion">Reunion</option>
																	<option value="Romania">Romania</option>
																	<option value="Russia">Russia</option>
																	<option value="Rwanda">Rwanda</option>
																	<option value="St Barthelemy">St Barthelemy</option>
																	<option value="St Eustatius">St Eustatius</option>
																	<option value="St Helena">St Helena</option>
																	<option value="St Kitts-Nevis">St Kitts-Nevis</option>
																	<option value="St Lucia">St Lucia</option>
																	<option value="St Maarten">St Maarten</option>
																	<option value="St Pierre &amp; Miquelon">St
																		Pierre &amp; Miquelon</option>
																	<option value="St Vincent &amp; Grenadines">St
																		Vincent &amp; Grenadines</option>
																	<option value="Saipan">Saipan</option>
																	<option value="Samoa">Samoa</option>
																	<option value="Samoa American">Samoa American</option>
																	<option value="San Marino">San Marino</option>
																	<option value="Sao Tome &amp; Principe">Sao
																		Tome &amp; Principe</option>
																	<option value="Saudi Arabia">Saudi Arabia</option>
																	<option value="Senegal">Senegal</option>
																	<option value="Serbia">Serbia</option>
																	<option value="Seychelles">Seychelles</option>
																	<option value="Sierra Leone">Sierra Leone</option>
																	<option value="Singapore">Singapore</option>
																	<option value="Slovakia">Slovakia</option>
																	<option value="Slovenia">Slovenia</option>
																	<option value="Solomon Islands">Solomon
																		Islands</option>
																	<option value="Somalia">Somalia</option>
																	<option value="South Africa">South Africa</option>
																	<option value="Spain">Spain</option>
																	<option value="Sri Lanka">Sri Lanka</option>
																	<option value="Sudan">Sudan</option>
																	<option value="Suriname">Suriname</option>
																	<option value="Swaziland">Swaziland</option>
																	<option value="Sweden">Sweden</option>
																	<option value="Switzerland">Switzerland</option>
																	<option value="Syria">Syria</option>
																	<option value="Tahiti">Tahiti</option>
																	<option value="Taiwan">Taiwan</option>
																	<option value="Tajikistan">Tajikistan</option>
																	<option value="Tanzania">Tanzania</option>
																	<option value="Thailand">Thailand</option>
																	<option value="Togo">Togo</option>
																	<option value="Tokelau">Tokelau</option>
																	<option value="Tonga">Tonga</option>
																	<option value="Trinidad &amp; Tobago">Trinidad
																		&amp; Tobago</option>
																	<option value="Tunisia">Tunisia</option>
																	<option value="Turkey">Turkey</option>
																	<option value="Turkmenistan">Turkmenistan</option>
																	<option value="Turks &amp; Caicos Is">Turks
																		&amp; Caicos Is</option>
																	<option value="Tuvalu">Tuvalu</option>
																	<option value="Uganda">Uganda</option>
																	<option value="Ukraine">Ukraine</option>
																	<option value="United Arab Erimates">United
																		Arab Emirates</option>
																	<option value="United Kingdom">United Kingdom</option>
																	<option value="United States of America">United
																		States of America</option>
																	<option value="Uraguay">Uruguay</option>
																	<option value="Uzbekistan">Uzbekistan</option>
																	<option value="Vanuatu">Vanuatu</option>
																	<option value="Vatican City State">Vatican
																		City State</option>
																	<option value="Venezuela">Venezuela</option>
																	<option value="Vietnam">Vietnam</option>
																	<option value="Virgin Islands (Brit)">Virgin
																		Islands (Brit)</option>
																	<option value="Virgin Islands (USA)">Virgin
																		Islands (USA)</option>
																	<option value="Wake Island">Wake Island</option>
																	<option value="Wallis &amp; Futana Is">Wallis
																		&amp; Futana Is</option>
																	<option value="Yemen">Yemen</option>
																	<option value="Zaire">Zaire</option>
																	<option value="Zambia">Zambia</option>
																	<option value="Zimbabwe">Zimbabwe</option>
															</select></td>
														</tr>
														<tr>
															<td style="padding: 5px;"><font color="black"><b>City
																		: </b></font></td>
															<td style="padding: 5px;"><input type="text"
																name="city" id="city" required></td>
														</tr>
														<tr>
															<td style="padding: 5px;"><font color="black"><b>Office
																		Address : </b></font></td>
															<td style="padding: 5px;"><textarea name="address"
																	id="address" cols="50" rows="5" required></textarea></td>
														</tr>
														<tr>
															<td style="padding: 5px;"><font color="black"><b>Timezone
																		: </b></font></td>
															<td style="padding: 5px;"><select name="timezone"
																id="timezone">
																	<option value="GMT-12:00">(GMT -12:00)
																		Eniwetok, Kwajalein</option>
																	<option value="GMT-11:00">(GMT -11:00) Midway
																		Island, Samoa</option>
																	<option value="GMT-10:00">(GMT -10:00) Hawaii</option>
																	<option value="GMT-9:00">(GMT -9:00) Alaska</option>
																	<option value="GMT-8:00">(GMT -8:00) Pacific
																		Time (US &amp; Canada)</option>
																	<option value="GMT-7:00">(GMT -7:00) Mountain
																		Time (US &amp; Canada)</option>
																	<option value="GMT-6:00">(GMT -6:00) Central
																		Time (US &amp; Canada), Mexico City</option>
																	<option value="GMT-5:00">(GMT -5:00) Eastern
																		Time (US &amp; Canada), Bogota, Lima</option>
																	<option value="GMT-4:30">(GMT -4:30) Caracas</option>
																	<option value="GMT-4:00">(GMT -4:00) Atlantic
																		Time (Canada), La Paz, Santiago</option>
																	<option value="GMT-3:30">(GMT -3:30)
																		Newfoundland</option>
																	<option value="GMT-3:00">(GMT -3:00) Brazil,
																		Buenos Aires, Georgetown</option>
																	<option value="GMT-2:00">(GMT -2:00)
																		Mid-Atlantic</option>
																	<option value="GMT-1:00">(GMT -1:00 hour)
																		Azores, Cape Verde Islands</option>
																	<option value="GMT+0:00">(GMT) Western Europe
																		Time, London, Lisbon, Casablanca, Greenwich</option>
																	<option value="GMT+1:00">(GMT +1:00 hour)
																		Brussels, Copenhagen, Madrid, Paris</option>
																	<option value="GMT+2:00">(GMT +2:00)
																		Kaliningrad, South Africa, Cairo</option>
																	<option value="GMT+3:00">(GMT +3:00) Baghdad,
																		Riyadh, Moscow, St. Petersburg</option>
																	<option value="GMT+3:30">(GMT +3:30) Tehran</option>
																	<option value="GMT+4:00">(GMT +4:00) Abu
																		Dhabi, Muscat, Yerevan, Baku, Tbilisi</option>
																	<option value="GMT+4:30">(GMT +4:30) Kabul</option>
																	<option value="GMT+5:00">(GMT +5:00)
																		Ekaterinburg, Islamabad, Karachi, Tashkent</option>
																	<option value="GMT+5:30" selected="selected">(GMT
																		+5:30) Mumbai, Kolkata, Chennai, New Delhi</option>
																	<option value="GMT+5:45">(GMT +5:45) Kathmandu</option>
																	<option value="GMT+6:00">(GMT +6:00) Almaty,
																		Dhaka, Colombo</option>
																	<option value="GMT+6:30">(GMT +6:30) Yangon,
																		Cocos Islands</option>
																	<option value="GMT+7:00">(GMT +7:00) Bangkok,
																		Hanoi, Jakarta</option>
																	<option value="GMT+8:00">(GMT +8:00) Beijing,
																		Perth, Singapore, Hong Kong</option>
																	<option value="GMT+9:00">(GMT +9:00) Tokyo,
																		Seoul, Osaka, Sapporo, Yakutsk</option>
																	<option value="GMT+9:30">(GMT +9:30) Adelaide,
																		Darwin</option>
																	<option value="GMT+10:00">(GMT +10:00) Eastern
																		Australia, Guam, Vladivostok</option>
																	<option value="GMT+11:00">(GMT +11:00)
																		Magadan, Solomon Islands, New Caledonia</option>
																	<option value="GMT+12:00">(GMT +12:00)
																		Auckland, Wellington, Fiji, Kamchatka</option>
															</select></td>
														</tr>
													</table>
												</div>
												<button type="button" class="btn btn-success btn-block"
													value="add" id="myBtn1a">Add Location</button>
											</form>
											<hr>
											<select id="deleteLocation"></select>
											<button type="button" class="btn btn-danger" value="add" id="myBtn1b">Delete Location </button>
											
										</div>

									</div>
								</div>
							</div> <!-- Modal for Sub-Admin Management -->

							<div class="modal fade" id="myModal2">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header" style="padding: 35px 50px;">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4>
												<span class="glyphicon glyphicon-plus-sign"></span>
												Sub-Admin
											</h4>
										</div>
										<div class="modal-body" style="padding: 40px 50px;">
											<form>
												<div class="form-group">
													<table>

														<tr>
															<td style="padding: 20px;"><label for="usrname">Employee
																	Id</label></td>
															<td style="padding: 20px;"><input type="text"
																id="employee_id"></td>
														</tr>
														<tr>
															<td style="padding: 20px;"><label
																for="Office Address">Office Address</label></td>
															<td style="padding: 20px;">
																<!-- Insert the Office Address list here --> <select
																id="office_add_modal2" multiple="multiple">
															</select>


															</td>
														</tr>
													</table>

												</div>
											</form>
											<button type="button" class="btn btn-success btn-block"
												value="add" id="addSubAdmin">Add Sub-Admin</button>
											<br />
											<button type="button" class="btn btn-success btn-block"
												value="show" id="myBtn2b">Show Sub-Admin List</button>
										</div>

									</div>


								</div>

							</div>
							<div class="modal fade" id="myModal3a">
								<div class="modal-dialog modal-lg">


									<!-- Modal content FOR EMPLOYEE PART 2-->
									<div class="modal-content">
										<div class="modal-header" style="padding: 35px 50px;">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4>
												<span class="glyphicon glyphicon-user"></span>Add Employee
											</h4>
										</div>
										<div class="modal-body" style="padding: 40px 50px;">
											<form id="modal_modify_emp">
												<div class="container-fluid" align="right"
													style="float: right">
													<button type="button" class="btn btn-danger" value="add"
														id="myBtn3b">Delete Employee</button>
													<br />
												</div>
												<table>
													<tr>
														<td style="padding: 5px;"><font color="black"><b>Employee-Id
																	:</b></font></td>
														<td style="padding: 5px;"><input type="text"
															id="emp_id_fixed" name="emp_id"></td>
													</tr>
													<tr>
														<td style="padding: 5px;"><font color="black"><b>First
																	Name :</b></font></td>
														<td style="padding: 5px;"><input type="text"
															id="emp_fname" name="emp_fname" required></td>
													</tr>
													<tr>
														<td style="padding: 5px;"><font color="black"><b>Last
																	Name : </b></font></td>
														<td style="padding: 5px;"><input type="text"
															id="emp_lname" name="emp_lname" required></td>
													</tr>
													<tr>
														<td style="padding: 5px;"><font color="black"><b>Birthday
																	: </b></font></td>
														<td style="padding: 5px;"><input type="date"
															id="emp_bday" name="emp_bday" required></td>
													</tr>
													<tr>
														<td style="padding: 5px;"><font color="black"><b>Start
																	of Work : </b></font></td>
														<td style="padding: 5px;"><input type="date"
															id="emp_wannv" name="emp_wannv" required></td>
													</tr>
													<tr>
														<td style="padding: 5px;"><font color="black"><b>Address
																	: </b></font></td>
														<td style="padding: 5px;"><select id="emp_location"
															name="emp_location"></select></td>
													</tr>
													<tr>
														<td style="padding: 5px;"><font color="black"><b>Email-id
																	:</b></font></td>
														<td style="padding: 5px;"><input type="email"
															id="emp_mail" name="emp_mail" required></td>
													</tr>
													<tr>
														<td style="padding: 5px;"><font color="black"><b>Telephone
																	:</b></font></td>
														<td style="padding: 5px;"><input type="tel"
															id="emp_tel" name="emp_tel" required></td>
													</tr>
												</table>
												<br />
												<button type="button" class="btn btn-success btn-block"
													id="modify_emp_button" value="add">Add Employee</button>
											</form>
										</div>

									</div>

								</div>

							</div> <!-- Modal for Sub-Admin Part Two -->
							<div class="modal fade" id="myModal2b">
								<div class="modal-dialog modal-lg">
									<div class="modal-content">
										<div class="modal-header" style="padding: 35px 50px;">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4>
												<span class="glyphicon glyphicon-plus-sign"></span>Sub-Admin
												List
											</h4>
										</div>
										<div class="modal-body" style="padding: 40px 50px;">
											<table id="showSubAdmin">
												<tr>
													<th style="padding: 20px">Employee Id</th>
													<th style="padding: 20px">Employee First Name</th>
													<th style="padding: 20px">Employee Last Name</th>
													<th style="padding: 20px">Employee Office Address</th>
													<th style="padding: 20px"></th>
												</tr>

											</table>

											<button type="submit" class="btn btn-success btn-block"
												id="Sclose" value="" data-dismiss="modal">Close</button>


										</div>

									</div>
								</div>
							</div> <!-- Modal for Sub-Admin Part Two -->
							<div class="modal fade" id="myModal2b">
								<div class="modal-dialog modal-lg">
									<div class="modal-content">
										<div class="modal-header" style="padding: 35px 50px;">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4>
												<span class="glyphicon glyphicon-plus-sign"></span>Sub-Admin
												List
											</h4>
										</div>
										<div class="modal-body" style="padding: 40px 50px;">
											<table>
												<tr>
													<td></td>
													<td><button type="button" class="btn btn-danger"
															value="add" id="">Delete</button></td>
												</tr>
												<tr>
													<td></td>
													<td><button type="button" class="btn btn-danger"
															value="add" id="">Delete</button></td>
												</tr>
												<tr>
													<td></td>
													<td><button type="button" class="btn btn-danger"
															value="add" id="">Delete</button></td>
												</tr>
											</table>

											<button type="submit" class="btn btn-success btn-block"
												id="Sclose" value="" data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div>

						</td>
					</tr>
					<tr>
						<td style="padding: 40px;">
							<div class="container-fluid">
								<button type="submit" class="btn btn-default"
									data-dismiss="modal">
									<img src="Team.jpg" id="viewTeam" />
								</button>

								<!-- Modal for Team Module-->
								<div class="modal fade" id="myModal4">
									<div class="modal-dialog modal-lg">
										<div class="modal-content">
											<div class="modal-header" style="padding: 35px 50px;">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4>
													<span class="glyphicon glyphicon-globe"></span> Team
												</h4>
											</div>
											<div class="modal-body" style="padding: 40px 50px;">
												<div class="container-fluid" align="center">

													<h3>Manage Team</h3>
													<table>
														<tr>
															<td><select class="teamList" id="teamList1"></select></td>
															<td><button type="button" class="btn btn-danger"
																	id="deleteTeam" value="Delete Team">Delete
																	Team</button></td>
															<td><button type="button" class="btn btn-success"
																	id="updateTeam" value="Update Team">Update
																	Team</button></td>
														</tr>
													</table>
													<table>
														<tr>
															<td><textarea id="addTeamDescription" cols="50"
																	rows="5">Team Description here</textarea></td>
															<td><button type="button" class="btn btn-success"
																	id="addTeam" value="Add Team">Add Team</button></td>
														</tr>
													</table>
													<h3>Manage Team Members</h3>
													<table>
														<tr>
															<td><select class="teamList" id="teamList2"></select></td>
															<td><button type="button" class="btn btn-success"
																	id="viewMembers" value="View Members">View
																	Members</button></td>
														</tr>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>

								<!-- Modal for Team Part Two-->
								<div class="modal fade" id="myModal4a">
									<div class="modal-dialog modal-lg">
										<div class="modal-content">
											<div class="modal-header" style="padding: 35px 50px;">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4>
													<span class="glyphicon glyphicon-globe"></span> Update Team
												</h4>
											</div>
											<div class="modal-body" style="padding: 40px 50px;">
												<div class="container-fluid" align="center">

													<div id="updateTeamDiv">
														<textarea id="updateTeamDescription" cols="50" rows="5">New Description here</textarea>
														<br />
														<button type="button" id="updateConfirmTeam"
															class="btn btn-success btn-block" value="Update Team">Update
															Team</button>
													</div>

												</div>
											</div>
										</div>
									</div>
								</div>

								<!-- Modal for Team Part Three-->
								<div class="modal fade" id="myModal4b">
									<div class="modal-dialog modal-lg">
										<div class="modal-content">
											<div class="modal-header" style="padding: 35px 50px;">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4>
													<span class="glyphicon glyphicon-globe"></span> Team
													Members
												</h4>
											</div>
											<div class="modal-body" style="padding: 40px 50px;">
												<div class="container-fluid" align="center">

													<div id="employeeDiv">
														<table>
															<tr>
																<td><label>Enter employee id</label></td>
																<td><input type="text" id="addEmployeeId"></td>
																<td><button type="button" class="btn btn-success"
																		id="addMember" value="Add Member">Add Member</button>
																</td>
															</tr>
														</table>
														<table id="myTable" border="1">
															<tr>
																<th>Employee Id</th>
																<th>Employee First Name</th>
																<th>Employee Last Name</th>
																<th>Delete</th>
															</tr>
														</table>
													</div>

												</div>
											</div>
										</div>
									</div>
								</div>

							</div>
						</td>
						<td style="padding: 40px;">
							<div class="container-fluid">
								<button type="submit" class="btn btn-default"
									data-dismiss="modal">
									<img src="Message.png" id="myBtn5" />
								</button>

								<!-- Modal for Message Module-->
								<div class="modal fade" id="myModal5">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header" style="padding: 35px 50px;">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4>
													<span class="glyphicon glyphicon-comment"></span> Messages
												</h4>
											</div>
											<div class="modal-body" style="padding: 40px 50px;">
												<button type="button" class="btn btn-success btn-block"
													id="myBtn5a" value="" data-dismiss="modal">Birthday
													Messages</button>
												<br />
												<button type="button" class="btn btn-success btn-block"
													id="myBtn5b" value="" data-dismiss="modal">Anniversary
													Messages</button>
											</div>
										</div>
									</div>
								</div>

								<!-- Modal for Message Part Two-->
								<div class="modal fade" id="myModal5a">
									<div class="modal-dialog modal-lg">
										<div class="modal-content">
											<div class="modal-header" style="padding: 35px 50px;">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h5>
													<span class="glyphicon glyphicon-comment"></span> Birthday
													Messages
												</h5>
											</div>
											<div class="modal-body" style="padding: 40px 50px;">
												<div class="container-fluid" align="center">
													<table>
														<tr>
															<td><textarea name="BMessage" id="birthday_text"
																	rows="5" cols="50"
																	placeholder="Enter Birthday Message here"></textarea></td>
															<td>
																<button type="button" class="btn btn-success"
																	id="add_msg_birthday" value="">Add Message</button>
															</td>
														</tr>
													</table>


													<h3>
														<b>Birthday Message List</b>
													</h3>
													<table id="messages_birthday">
													</table>
												</div>

											</div>
										</div>
									</div>
								</div>
							</div> <!-- Modal for Message Part Three-->
							<div class="modal fade" id="myModal5b">
								<div class="modal-dialog modal-lg">
									<div class="modal-content">
										<div class="modal-header" style="padding: 35px 50px;">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<font><span class="glyphicon glyphicon-comment"></span>
												Anniversary Messages</font>
										</div>
										<div class="modal-body" style="padding: 40px 50px;">
											<div class="container-fluid" align="center">
												<table>
													<tr>
														<td><textarea name="AMessage" id="anniversary_text"
																rows="5" cols="50"
																placeholder="Enter Anniversary Message herte"></textarea></td>
														<td>
															<button type="button" class="btn btn-success"
																id="add_msg_anniversary" value="">Add Message</button>
														</td>
													</tr>
												</table>

												<h3>
													<b>Anniversary Message List</b>
												</h3>

												<table id='messages_anniversary'>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>

						</td>
						<td style="padding: 40px;">
							<div class="container-fluid">
								<button type="submit" class="btn btn-default"
									data-dismiss="modal">
									<img src="Event.jpg" id="myBtn6" />
								</button>
								<div class="modal fade" id="myModal6">
									<div class="modal-dialog modal-lg">

										<!-- Modal for Event module -->
										<div class="modal-content">
											<div class="modal-header" style="padding: 35px 50px;">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4>
													<span class="glyphicon glyphicon-gift"></span> Upcoming
													Events
												</h4>
											</div>
											<div class="modal-body" style="padding: 40px 50px;">
												<div class="container-fluid" align="center">

													<form action="BdayDisplay" method="post">
														<table>
															<tr>
																<td style="padding: 30px"><font color="black"><b>Select
																			Birth-day Month: </b></font></td>
																<td style="padding: 30px"><select name="month"
																	id="bdaymonth">
																		<option value="-1">Select Month</option>
																		<option value="1">January</option>
																		<option value="2">February</option>
																		<option value="3">March</option>
																		<option value="4">April</option>
																		<option value="5">May</option>
																		<option value="6">June</option>
																		<option value="7">July</option>
																		<option value="8">August</option>
																		<option value="9">September</option>
																		<option value="10">October</option>
																		<option value="11">November</option>
																		<option value="12">December</option>
																</select></td>
																<td style="padding: 30px">
																	<div class="container-fluid">
																		<button type="button" class="btn btn-default"
																			id="myBtn6a" value="Show BTable" data-dismiss="modal">Show
																			Birthday</button>
																	</div>

																</td>
															</tr>
														</table>
													</form>

													<form action="AnniversaryDisplay" method="post">
														<table>

															<tr>
																<td style="padding: 20px"><font color="black"><b>Select
																			Anniversary-day Month: </b></font></td>
																<td style="padding: 20px"><select name="month"
																	id="anniversarymonth">
																		<option value="-1">Select Month</option>
																		<option value="1">January</option>
																		<option value="2">February</option>
																		<option value="3">March</option>
																		<option value="4">April</option>
																		<option value="5">May</option>
																		<option value="6">June</option>
																		<option value="7">July</option>
																		<option value="8">August</option>
																		<option value="9">September</option>
																		<option value="10">October</option>
																		<option value="11">November</option>
																		<option value="12">December</option>
																</select></td>
																<td style="padding: 30px">
																	<div class="container-fluid">
																		<button type="button" class="btn btn-default"
																			id="myBtn6b" value="Show ATable" data-dismiss="modal">Show
																			Anniversary</button>
																		<div class="modal fade" id="bdayModal">
																			<div class="modal-dialog"></div>
																		</div>
																	</div>
																</td>
															</tr>

														</table>
													</form>
												</div>
											</div>

										</div>
									</div>
								</div>

								<!-- Modal for Event Part Two -->

								<div class="modal fade" id="myModal6a">
									<div class="modal-dialog modal-lg">
										<div class="modal-content">
											<div class="modal-header" style="padding: 35px 50px;">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4>
													<span class="glyphicon glyphicon-gift"></span> Upcoming
													Birthdays
												</h4>
											</div>
											<div class="modal-body" style="padding: 40px 50px;">

												<table id="myBTable">
													<tr>
														<th style="padding: 20px">Employee Id</th>
														<th style="padding: 20px">Employee First Name</th>
														<th style="padding: 20px">Employee Last Name</th>
														<th style="padding: 20px">Employee Birth Date</th>
														<th style="padding: 20px">Employee Office Address</th>

													</tr>
												</table>

												<button type="submit" class="btn btn-success btn-block"
													id="bclose" value="Show Table" data-dismiss="modal">Close</button>
											</div>
										</div>
									</div>
								</div>

								<!-- Modal for Event Part Three -->

								<div class="modal fade" id="myModal6b">
									<div class="modal-dialog modal-lg">
										<div class="modal-content">
											<div class="modal-header" style="padding: 35px 50px;">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4>
													<span class="glyphicon glyphicon-gift"></span> Upcoming
													Anniversaries
												</h4>
											</div>
											<div class="modal-body" style="padding: 40px 50px;">

												<table id="myATable">
													<tr>
														<th style="padding: 20px">Employee Id</th>
														<th style="padding: 20px">Employee First Name</th>
														<th style="padding: 20px">Employee Last Name</th>
														<th style="padding: 20px">Employee Anniversary Date</th>
														<th style="padding: 20px">Employee Office Address</th>

													</tr>
												</table>


												<button type="submit" class="btn btn-success btn-block"
													id="aclose" value="Show Table" data-dismiss="modal">Close</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</fieldset>
	</div>
	<div class="footer navbar-fixed-bottom">
		<footer>
			<nav class="navbar-left"
						style="margin-left: 20px; margin-right: 30px; margin-bottom: 10px">
						<span class="glyphicon glyphicon-copyright-mark white">
							<font color="white">Copyrights reserved by Aricent</font>
						</span>
			</nav>
			<nav class="navbar-right"
				style="margin-left: -20px; margin-right: 30px; margin-bottom: 10px">
				<p class="p2" style="margin-right: 10px">
					<font color="white"><b><i>Follow us on</i></b></font>
				</p>
				<input onclick="location.href='http://facebook.com';" type="button"
					class="btn btn-default sign-in-facebook" class="img-responsive"
					style="margin-top: 2px; margin-bottom: 2px; margin-right: 10px">
				<input onclick="location.href='http://twitter.com';" type="button"
					class="btn btn-default sign-in-twitter" class="img-responsive"
					style="margin-top: 2px; margin-bottom: 2px; margin-right: 10px">
				<input onclick="location.href='http://linkedin.com';" type="button"
					class="btn btn-default sign-in-linkedin" class="img-responsive"
					style="margin-top: 2px; margin-bottom: 2px; margin-right: 10px">
			</nav>
		</footer>
	</div>
	<script>
		$(document).ready(function() {
			$("#myBtn2").click(function() {
				getLocations('office_add_modal2');
				$("#myModal2").modal();
			});
		});
		$(document).ready(function() {
			$("#myBtn2b").click(function() {
				$("#myModal2").modal('toggle');
				$("#myModal2b").modal('toggle');
			});
		});
		$(document).ready(function() {
			$("#Sclose").click(function() {
				$("#myModal2b").modal('toggle');
				$("#myModal2").modal('toggle');
			});
		});
		$(document).ready(function() {
			$("#bclose").click(function() {
				$("#myModal6a").modal('toggle');
				$("#myModal6").modal('toggle');
			});
		});
		$(document).ready(function() {
			$("#aclose").click(function() {
				$("#myModal6b").modal('toggle');
				$("#myModal6").modal('toggle');
			});
		});
		$(document).ready(function() {
			$("#myBtn3").click(function() {
				$("#myModal3").modal();
			});
		});
		$(document).ready(function() {
			$("#myBtn3a").click(function() {
				findEmployee();
				getLocations('emp_location');
				document.getElementById("emp_id").value = null;
				$('#myModal3').modal('toggle');
				$("#myModal3a").modal('toggle');
			});
		});
		$(document).ready(function() {
			$("#modify_emp_button").click(function() {
				modifyEmployee();
				$("#myModal3a").modal('toggle');
			});
		});
		$(document).ready(function() {
			$("#myBtn1").click(function() {
				getLocations('deleteLocation');
				$("#myModallocation").modal();
			});
		});
		$(document).ready(function() {
			$("#myBtn1a").click(function() {
				addLocation();
				$("#myModallocation").modal('toggle');
			});
		});
		$(document).ready(function() {
			$("#viewTeam").click(function() {
				$("#myModal4").modal();
			});
		});
		$(document).ready(function() {
			$("#updateTeam").click(function() {
				$("#myModal4").modal('toggle');
				$("#myModal4a").modal('toggle');
			});
		});
		$(document).ready(function() {
			$("#viewMembers").click(function() {
				$("#myModal4").modal('toggle');
				$("#myModal4b").modal('toggle');
			});
		});
		$(document).ready(function() {
			$("#myBtn5").click(function() {
				$("#myModal5").modal();
			});
		});
		$(document).ready(function() {
			$("#myBtn5a").click(function() {
				$("#myModal5").modal('toggle');
				getMessage('messages_birthday');
				$("#myModal5a").modal('toggle');
			});
		});
		$(document).ready(function() {
			$("#myBtn5b").click(function() {
				$("#myModal5").modal('toggle');
				getMessage('messages_anniversary');
				$("#myModal5b").modal('toggle');
			});
		});
		$(document).ready(function() {
			$("#myBtn6").click(function() {
				$("#myModal6").modal();
			});
		});
		$(document).ready(function() {
			$("#myBtn6a").click(function() {
				$("#myModal6").modal('toggle');
				$("#myModal6a").modal('toggle');
			});
		});
		$(document).ready(function() {
			$("#myBtn6b").click(function() {
				$("#myModal6").modal('toggle');
				$("#myModal6b").modal('toggle');
			});
		});
		$(document).ready(function() {
			$("#myBtn3b").click(function() {
				deleteEmployee();
				$("#myModal3a").modal('toggle');
			});
		});

		//Adding birthday
		$(document).ready(function() {
			$("#add_msg_birthday").click(function() {
				modifyMessage('messages_birthday');
			});
		});
		//Adding anniversary
		$(document).ready(function() {
			$("#add_msg_anniversary").click(function() {
				modifyMessage('messages_anniversary');
			});
		});
		//Delete Location 
		$(document).ready(function() {
			$("#myBtn1b").click(function() {
				deleteLocation();
			});
		});

		$(document)
				.ready(
						function() {
							//$("#myTable").hide();
							$("#myBtn6b")
									.click(
											function() {
												$("#myATable").find("tr:gt(0)").remove();
												var month = $(
														'#anniversarymonth')
														.find(":selected")
														.val();
												$("#myModal6b").append(month);
												$
														.post(
																"AnniversaryDisplay",
																{
																	month : month
																},
																function(data,
																		status) {
																	$(data)
																			.find(
																					'EMPLOYEE')
																			.each(
																					function() {
																						var employeeId = $(
																								this)
																								.find(
																										'EMP_ID')
																								.text();
																						var firstName = $(
																								this)
																								.find(
																										'FIRST_NAME')
																								.text();
																						var lastName = $(
																								this)
																								.find(
																										'LAST_NAME')
																								.text();
																						var anniversaryDate = $(
																								this)
																								.find(
																										'ANNIVERSARY_DATE')
																								.text();
																						var officeAddress = $(
																								this)
																								.find(
																										'OFFICE_ADDRESS')
																								.text();
																						$(
																								'#myATable')
																								.append(
																										'<tr><td style="padding:20px">'
																												+ employeeId
																												+ '</td><td style="padding:20px">'
																												+ firstName
																												+ '</td><td style="padding:20px">'
																												+ lastName
																												+ '</td><td style="padding:20px">'
																												+ anniversaryDate
																												+ '</td><td style="padding:20px">'
																												+ officeAddress
																												+ '</td></tr>');
																						$(
																								"#myATable")
																								.show();
																					})
																			.fail(
																					function() {
																						alert("nothing found");
																					});
																}, 'xml');

											});
						});
		$(document)
				.ready(
						function() {
							//$("#myTable").hide();
							$("#myBtn6a")
									.click(
											function() {
												$("#myBTable").find("tr:gt(0)").remove();
												var month = $('#bdaymonth')
														.find(":selected")
														.val();
												$
														.post(
																"BdayDisplay",
																{
																	month : month
																},
																function(data,
																		status) {
																	$(data)
																			.find(
																					'EMPLOYEE')
																			.each(
																					function() {
																						var employeeId = $(
																								this)
																								.find(
																										'EMP_ID')
																								.text();
																						var firstName = $(
																								this)
																								.find(
																										'FIRST_NAME')
																								.text();
																						var lastName = $(
																								this)
																								.find(
																										'LAST_NAME')
																								.text();
																						var birthDate = $(
																								this)
																								.find(
																										'BIRTH_DATE')
																								.text();
																						var officeAddress = $(
																								this)
																								.find(
																										'OFFICE_ADDRESS')
																								.text();

																						$(
																								'#myBTable')
																								.append(
																										'<tr><td style="padding:10px">'
																												+ employeeId
																												+ '</td><td style="padding:10px">'
																												+ firstName
																												+ '</td><td style="padding:10px">'
																												+ lastName
																												+ '</td><td style="padding:10px">'
																												+ birthDate
																												+ '</td><td style="padding:10px">'
																												+ officeAddress
																												+ '</td></tr>');
																						$(
																								"#myBTable")
																								.show();
																					})
																			.fail(
																					function() {
																						alert("nothing found");
																					});
																}, 'xml');

											});
						});
	</script>

</body>
</html>