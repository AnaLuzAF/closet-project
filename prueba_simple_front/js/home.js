function loadHome() {
    var homeStructure = $('#main');
    homeStructure.empty();

    var home = `<div class="inicio">
                    <h1><a href="index.html">Online Closet</a></h1>
                    <h2>Plan your <span>best outfits</span> ahead</h2>
                    <br>
                    <h2>Formulario inicio</h2>
                </div>
              <div class = "formulario">
                <form method= "post">
                    <label for="nickname">Nickname</label>
                    <input type= "text" name = "nickname" id= "nickname" placeholder= "nickname" required>
                    <label for="email">Email</label>
                    <input type= "text" name = "email" id= "email" placeholder= "email" required>
                    <label for="password">Password</label>
                    <input type= "password" name = "password" id= "password" placeholder= "password" required>
                    <input type= "submit" name = "enviar" id= "enviar" placeholder= "enviar" required>
                </form>

              </div>
                `;
     homeStructure.append(home);
}