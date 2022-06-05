function loadHome() {
    var homeStructure = $('#main');
    homeStructure.empty();

    var home = `<div class="inicio">
                                    <h1><a href="index.html">Online Closet</a></h1>
                                    <h2>Plan your <span>best outfits</span> ahead</h2>
                                   </div>
                        <div class="contenedor-form">
                            <div class="toggle">
                                <span> Log In/Create Account</span>
                            </div>

                            <div class="formulario">
                                <h2>Log In</h2>
                                <form action="#" class="form" id="form">
                                    <input id="user" type="text" placeholder="User" required>
                                    <input id="password-view" type="password" placeholder="Password" required>
                                    <span>show</span>
                                    <input type="submit" id="submit" onclick="validar()" value="Log In">
                                    <p class="warnings" id="warnings"></p>

                                </form>
                            </div>

                            <div class="formulario" id="formulario">
                                <h2>Create your Account</h2>
                                <form onsubmit="sendMail(); reset(); return=false;" action="#" class="form" id="form">
                                    <input id="user" type="text" name="name" placeholder="User" required>

                                    <input id= "password-view-create" type="password" placeholder="Password" required>
                                    <span>show</span>

                                    <input id="emailUser" type="email" name="emailUser" placeholder="Email" required>

                                    <input type="submit" value="Check In">
                                </form>

                            </div>
                            <div class="reset-password">
                                <a href="#">I forgot my password</a>
                            </div>
                        </div>
                        <script src="https://smtpjs.com/v3/smtp.js"></script>
                `;



     homeStructure.append(home);
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
        e.target.textContent='hidden';
        passwordInput.type='text';
        }else{
        e.target.classList.add('show');
        e.target.textContent='show';
        passwordInput.type='password';
        }
     });
     document.querySelector('.contenedor-form #formulario span').addEventListener('click',
          e => {
             const passwordInput = document.querySelector('#password-view-create');
             if(e.target.classList.contains('show')){
             e.target.classList.remove('show');
             e.target.textContent='hidden';
             passwordInput.type='text';
             }else{
             e.target.classList.add('show');
             e.target.textContent='show';
             passwordInput.type='password';
             }
          });

          //Validar usuarios
}
function validar(){
 //Escuchar un evento al hacer click en submit

                var name = $('#user').val();
                var password = $('#password-view-create').val();
                var emailUser = $('#emailUser').val();
                var parrafo = $('#warnings').val();

                /*CONEXION A LA BASE DE DATOS PARA COMPROBAR LOS NICKNAME DE LOS USUARIOS Y COMPROBAR SI EXISTE EL USUARIO QUE SE LOGEA, RUTAS CORRECTAS PERO NO FUNCIONA
                alert("DELANTE");
                   $.get('/users/'+name.value,function(users){
                    alert("DENTRO");
                    function comprobarNickName(user,name){
                        var userString=JSON.stringify(user);
                    } });
                    if(name.value==users.nickname){
                    */
                   if(name != "" && password != ""){
                            parrafo.innerHTML = "";


                           $('#main').hide();
                           $(document).ready(function() {
                               $('.loader').show();
                               setTimeout(function() {
                                   location.reload();

                               },2000);

                           });
                   }else{
                     parrafo.innerHTML = "Debe rellenar todos los campos";
                   }

}




