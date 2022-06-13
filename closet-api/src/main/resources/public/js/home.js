function loadHome() {
    var homeStructure = $('#main');
    homeStructure.empty();

    var home = `<div id="fondoHome"><div class="inicio">
                        <h1>Online Closet</h1>
                        <h2>Plan your <span>best outfits</span> ahead</h2>
                </div>
                <div class = "contenedor-form" id="log">

                       <div class="formulario" id="logContainer">
                                <h2>Log In</h2>
                                <form action="#" class="form" id="form">
                                    <input id="userLog" type="text" placeholder="User" required>
                                    <input id="password-view" type="password" placeholder="Password" required>
                                    <input type = "submit" id = "submit" onclick = "getUser()" value = "Log In">
                                    <p class = "warnings" id ="warnings"></p>
                                </form>
                            </div>
                            <div class="reset-password">
                                <a href="#">I forgot my password</a>
                            </div>
                        </div>
                        <div class = "contenedor-form" id="create">
                            <div class="formulario" id="formulario">
                                <h2>Create your Account</h2>

                                <form action="#" class="form" id="form">

                                    <input id="user" type="text" name="name" placeholder="User" required>

                                    <input id= "password-view-create" type="password" placeholder="Password" required>

                                    <input id="email" type="email" name="email" placeholder="Email" required>

                                    <input type="submit" value="Register" id="register" onclick=insertUser()>
                                </form>
                            </div>
                    </div>
                `;

     homeStructure.append(home);
}

function getUser() {
           var nickname = $('#userLog').val();
           var password = $('#password-view').val();
           var parrafo = $('#warnings').val();

            $.get("/users/" + nickname + "?password=" + password, function(user) {

               var divLoader = document.getElementById("loader");
               var p = document.createElement("p");
               var text = document.createTextNode("welcome " + nickname);

               p.appendChild(text);
               divLoader.appendChild(p);

               showLoader();
            }
    );
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



    var user = {
        "nickname": $('#user').val(),
        "password": $('#password-view-create').val(),
        "email": $('#email').val()
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










