
function init(){
    // Add submit event to form for new and edit
    $("#login-form").on('button', function() {
        console.log("Submitting");
    });
}




function validateForm() {
  var username = document.getElementById("username").value;
  var password = document.getElementById("password").value;

  // Predefined login and password values for different users
  var users = {
    manager: "1111",
    receptionist: "1111"
  };

  if (username in users && password === users[username]) {
//    alert("Access allowed");

    // Redirect to the appropriate web page
    if (username === "manager") {
      window.location.href = "manager.html";
    } else if (username === "receptionist") {
      window.location.href = "receptionist.html";
    }
  } else {
    alert("Wrong login or password");
  }
}
