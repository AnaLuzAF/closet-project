function loadOutfits(){
    var outfitStructure = $('#main');
    outfitStructure.empty();

    var outfits = `<div class="outfit">

                    <div class=types-outfit>
                       <ul>
                          <li><a onclick="printOutfits(1)">All</a></li>
                          <li><a onclick="printOutfits()">Sport</a></li>
                          <li><a onclick="printOutfits()">Classy</a></li>
                          <li><a onclick="printOutfits()">Casual</a></li>
                       </ul>
                    </div>
                        <div class="outfits" id= "outfits">

                    </div>
                </div>`;

     outfitStructure.append(outfits);
}

/*printOutfits por cada outfit añade un div dentro del blanco meta uno verde todos y un item, mapper tambien el controller y el dao investigar el ejemplo para las imagenes*/
function printOutfits(userId) {
    $.get("/users/" +userId+ "/outfits", function(outfits) {
        var outfitsDiv = $('#outfits');
        outfitsDiv.empty();

        for (outfit of outfits) {
            outfitsDiv.append(outfitDiv(outfit));
        }
  });
  }


  function printOutfitsCategories(userId,category) {
      $.get("/users/"+userId+ "/outfits/" + category, function(userId,category) {
          var categoriesDiv = $('#category');
           categoriesDiv.empty();


          for (categories of category) {
               categoriesDiv.append(categoriesDiv(categories));
          }
    });
}

function outfitDiv(outfit) {
    return $("<div class='outfit-div'>")
        .append($("<h1>").text(outfit.id));
}