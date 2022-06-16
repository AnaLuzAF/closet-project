function loadHome() {
    var homeStructure = $('#main');
    homeStructure.empty();

    var home = `
    <div id="fondoHome"><div class="inicio">
                        <h1>Online Closet</h1>
                        <h2>Plan your <span>best outfits</span> ahead</h2>
                </div>
                <div id="formularios-container-all">
                        <div class = "form-container-general" id="container-login-general">

                             <div class="login-form">
                                <form class="form">
                                   <h1 class="title">Log In</h1>

                                    <div class="inputContainer">
                                     <input id="userLog" type="text" class="input" placeholder="user">
                                     </div>
                                    <div class="inputContainer">
                                        <input id="password-view" type="password" class="input" placeholder="password">
                                    </div>

                                 <div id="submit" onclick=login()><a>Log in</a></div>
                                </form>

                                <div class="reset-password">
                                    <a href="#">I forgot my password</a>
                                 </div>
                             </div>

                         </div>

                         <div class = "form-container-general" id="container-register-general">
                            <div class="signupform">
                                <form class="form">
                                  <h1 class="title">Create your Account</h1>

                                    <div class="inputContainer">
                                     <input  id="user" type="text" class="input" placeholder="nickname">
                                       </div>

                                  <div class="inputContainer">
                                    <input id="password-view-create" type="password" class="input" placeholder="password">
                                  </div>

                                  <div class="inputContainer">
                                    <input id="email" type="text" class="input" placeholder="email">
                                  </div>

                                 <div id="register" onclick=insertUser()><a>Register</a></div>
                                </form>
                              </div>
                         </div>
                   </div>
                `;

     homeStructure.append(home);
}

function login() {

            var nickname = $('#userLog').val();
            var password = $('#password-view').val()

            if(nickname == null || nickname == "") {
                alert("User can't be empty or null ");
            }
            if(password == null || password == "") {
                 alert("Password can't be empty or null ");
            }

            $.get("/users/" + nickname + "?password=" + password, function(user) {

               var divLoader = document.getElementById("loader");
               var p = document.createElement("p");
               var text = document.createTextNode("welcome " + nickname);

               p.appendChild(text);
               divLoader.appendChild(p);

               showLoader();

               alert("You have logged in");
             }
    ).fail(function() {
        alert("User not found");
    });
}

function showLoader () {
         $('#main').hide();
         $(document).ready(function() {
            $('.loader').show();
            setTimeout(function() {
            location.reload();
             },2000);
         });
}


function insertUser() {

    var nickname = $('#user').val();
    var password = $('#password-view-create').val()
    var email = $('#email').val();

    if(nickname == null || nickname == "") {
        alert("User can't be empty or null ");
    }
    if(password == null || password == "") {
         alert("Password can't be empty or null ");
    }
    if(email == null || email == "") {
         alert("Email can't be empty or null ");
    }

    var user = {
        "nickname": nickname,
        "password": password,
        "email": email
    };

    postUser("/users", user);
}

function postUser(url, user) {

    $.ajax({
        type : "POST",
        url: url,
        data: JSON.stringify(user),
        contentType: 'application/json; charset=utf-8',
       success: function (response) {
           alert("Account created");
       },
       statusCode: {
           409: function() {
               alert("Username already exist");
           }
       },
       error: function (e) {
           alert("Error processing request");
       }
       });
}










