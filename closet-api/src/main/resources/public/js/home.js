function loadHome() {
    var homeStructure = $('#main');
    homeStructure.empty();

    var home = `<div class="inicio">
                    <h1><a href="index.html">Online Closet</a></h1>
                    <h2>Plan your <span>best outfits</span> ahead</h2>
                    <br>
                    <h2>Formulario inicio</h2>
                </div>`;

     homeStructure.append(home);
}