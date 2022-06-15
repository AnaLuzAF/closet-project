    function loadHome() {
        var homeStructure = $('#main');
        homeStructure.empty();

       var home = `<div id="fondoHome">
                        <div class="inicio">

                                    <h1><a href = "index.html">Online Closet</a></h1>
                                    <h2>Plan your <span>best outfits</span> ahead</h2>
                                   </div>
                        <div class = "form-container-general" id="container-login-general">

                             <div class="login-form">
                                <form action="" class="form">
                                   <h1 class="title">Log In</h1>

                                    <div class="inputContainer">
                                     <input id="userLog" type="text" class="input" placeholder="user">
                                     </div>
                                    <div class="inputContainer">
                                        <input id="password-view" type="password" class="input" placeholder="password">
                                    </div>

                                    <input type="submit" class="submitBtn" onclick = "getUser()" value="Sign up">
                                </form>

                                <div class="reset-password">
                                    <a href="#">I forgot my password</a>
                                 </div>
                             </div>

                         </div>

                         <div class = "form-container-general" id="container-register-general">
                            <div class="signupform">
                                <form action="" class="form">
                                  <h1 class="title">Sign up</h1>

                                    <div class="inputContainer">
                                     <input  id="user" type="text" class="input" placeholder="nickname">
                                       </div>


                                  <div class="inputContainer">
                                    <input id="email" type="text" class="input" placeholder="email">
                                  </div>


                                  <div class="inputContainer">
                                    <input id="password-view-create" type="password" class="input" placeholder="password">
                                  </div>
                                  <input type="submit" class="submitBtn" onclick = "insertUser()" value="Sign up">
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










