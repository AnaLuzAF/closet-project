function loadHome() {
    var homeStructure = $('#main');
    homeStructure.empty();

    var home = `   <div class="inicio">
                                       <p>Bienvenido a tu Armario Online donde podrás crear tus Outfits en un sólo click</p>
                                <a href="mailto:analuzaviles@gmail.com" id="trucazo"></a>
                                   </div>
                        <div class="contenedor-form">
                            <div class="toggle">
                                <span> Crear Cuenta</span>
                            </div>

                            <div class="formulario">
                                <h2>Iniciar Sesión</h2>
                                <form action="#">
                                    <input type="text" placeholder="Usuario" required>
                                    <input type="password" placeholder="Contraseña" required>
                                    <input type="submit" value="Iniciar Sesión">
                                </form>
                            </div>

                            <div class="formulario">
                                <h2>Crea tu Cuenta</h2>
                                <form action="" class="form" id="form">
                                    <input type="text" name="name" placeholder="Usuario" required>

                                    <input type="password" placeholder="Contraseña" required>

                                    <input type="email" name="correoUser" placeholder="Correo Electronico" required>

                                    <input type="submit" value="Registrarse">
                                </form>
                            </div>
                            <div class="reset-password">
                                <a href="#">Olvidé mi Contraseña</a>
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

}

