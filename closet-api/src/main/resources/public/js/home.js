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
                                <form action="#">
                                    <input type="text" placeholder="User" required>
                                    <input id="password-view" type="password" placeholder="Password" required>
                                    <span>show</span>
                                    <input type="submit" value="Log In">
                                </form>
                            </div>

                            <div class="formulario" id="formulario">
                                <h2>Create your Account</h2>
                                <form action="" class="form" id="form">
                                    <input type="text" name="name" placeholder="User" required>

                                    <input id= "password-view-create" type="password" placeholder="Password" required>
                                    <span>show</span>

                                    <input type="email" name="emailUser" placeholder="Email" required>

                                    <input type="submit" value="Check In">
                                </form>
                            </div>
                            <div class="reset-password">
                                <a href="#">I forgot my password</a>
                            </div>
                        </div>

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

}

