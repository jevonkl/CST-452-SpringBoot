// Script for side navigation
function w3_open() {
  var x = document.getElementById("mySidebar");
  x.style.width = "300px";
  x.style.paddingTop = "10%";
  x.style.display = "block";
}

// Close side navigation
function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
}

// Used to toggle the menu on smaller screens when clicking on the menu button
function openNav() {
  var x = document.getElementById("navDemo");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else { 
    x.className = x.className.replace(" w3-show", "");
  }
}

//for Email
function SendEmail() 
{
	var params = {
		from_name : document.getElementById("name").value,
		email_id : document.getElementById("email").value,
		message : document.getElementById("msg").value
	}
	emailjs.send("service_zjnnxcs", "template_nwyg59d", params).then(function(res){
		alert("Email Sent " + res.status);
	})
			
}

//chart in modal
window.onload = function() {

var chart = new CanvasJS.Chart("chartContainer", {
	theme: "dark2", 
	animationEnabled: true,
	title: {
		text: "Programs used in Project"
	},
	data: [{
		type: "pie",
		startAngle: 25,
		toolTipContent: "<b>{label}</b>: {y}%",
		indexLabelFontSize: 16,
		indexLabel: "{label} - {y}%",
		dataPoints: [
			{ y: 43.00, label: "Java" },
			{ y: 27.00, label: "JavaScript" },
			{ y: 20.00, label: "HTML" },
			{ y: 10.00, label: "MAMP" }
		]
	}]
});
chart.render();

}