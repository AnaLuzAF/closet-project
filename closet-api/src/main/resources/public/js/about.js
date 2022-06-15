function loadAbout() {
        var aboutStructure = $('#main');
        aboutStructure.empty();

       var about = `<div class="inicio">
                                    <h1><a href = "index.html">Online Closet</a></h1>
                                    <h2>Plan your <span>best outfits</span> ahead</h2>
                                   </div>
                        <div class = "contenedor-form">
                            <div class = "toggle">
                                <span> Log In/Create Account</span>
                            </div>
                            <div class="formulario">
                                <h2>Log In</h2>
                                <form action = "#" class = "form" id = "form">
                                    <input id = "users" type = "text" placeholder = "User" required>
                                    <input id = "password-view" type = "password" placeholder = "Password" required>
                                    <span>show</span>
                                    <input type="submit" class="submitBtn" onclick = "getUser()" value="Sign up">
                                    <p class = "warnings" id ="warnings"></p>
                                </form>

                            </div>

                            <div class="formulario" id="formulario">
                                <h2>Create your Account</h2>
                                <form action="#" class="form" id = "form">
                                    <input id = "user" type = "text" name = "name" placeholder = "User" required>

                                    <input id = "password-view-create" type ="password" placeholder = "Password" required>
                                    <span>show</span>

                                    <input id = "emailUser" type = "email" name = "emailUser" placeholder = "Email" required>

                                    <input type="submit" class="submitBtn" onclick = "insertUser()" value="Sign up">
                                </form>
                            </div>
                            <div class="reset-password">
                                <a href="#">I forgot my password</a>
                            </div>
                        </div>
                `;
        aboutStructure.append(about);


     $('.toggle').click(function(){
         $('.formulario').animate({
             height: "toggle",
             'padding-top': 'toggle',
             'padding-bottom': 'toggle',
             opacity: 'toggle'
         }, "slow");
     });

     document.querySelector('.contenedor-form .formulario span').addEventListener('click',
     e => {
        const passwordInput = document.querySelector('#password-view');
        if(e.target.classList.contains('show')){
        e.target.classList.remove('show');
        e.target.textContent ='hidden';
        passwordInput.type ='text';
        }else{
        e.target.classList.add('show');
        e.target.textContent ='show';
        passwordInput.type ='password';
        }
     });
     document.querySelector('.contenedor-form #formulario span').addEventListener('click',
          e => {
             const passwordInput = document.querySelector('#password-view-create');
             if(e.target.classList.contains('show')){
             e.target.classList.remove('show');
             e.target.textContent ='hidden';
             passwordInput.type ='text';
             }else{
             e.target.classList.add('show');
             e.target.textContent ='show';
             passwordInput.type ='password';
             }
          });


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