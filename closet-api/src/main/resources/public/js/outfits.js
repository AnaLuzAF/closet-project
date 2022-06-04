function loadOutfits(){
    var outfitStructure = $('#main');
    outfitStructure.empty();

    var outfits = `<div class="outfit">
                    <script> window.onload = printOutfits(1)</script>
                    <div class=types-outfit>
                       <ul>
                          <li><a onclick="printOutfits(1)">All</a></li>
                          <li><a onclick="printCategoryOutfits(1, 'sport')">Sport</a></li>
                          <li><a onclick="printCategoryOutfits(1, 'classy')">Classy</a></li>
                          <li><a onclick="printCategoryOutfits(1, 'casual')">Casual</a></li>

                       </ul>
                    </div>
                        <div class="outfits" id= "outfits">

                            </div>
                        </div>
                    </div>


                </div>`;

     outfitStructure.append(outfits);
}

function printCategoryOutfits(userId,category) {
    $.get("/users/" +userId+ "/outfits?category=" + category, function(outfits) {
        var outfitsDiv = $('#outfits');
        outfitsDiv.empty();

        for (outfit of outfits) {
            outfitsDiv.append(outfitDiv(outfit));
        }
  });
  }

function printOutfits(userId) {
    $.get("/users/" +userId+ "/outfits", function(outfits) {
        var outfitsDiv = $('#outfits');
        outfitsDiv.empty();

        for (outfit of outfits) {
            outfitsDiv.append(outfitDiv(outfit));
        }
  });
  }


function outfitDiv(outfit) {
    
    var outfitStructure = `<div class='outfit-div'>
<div class="outfit-items" id="outfitTop"><img src= '' alt= "imgprueba" class=''></div>
<div class="outfit-items" id="outfitBottom"><img src= '' alt= "imgprueba" class=''></div>
<div class="outfit-items" id="outfitShoes"><img src= '' alt= "imgprueba" class=''></div>`;
    
    return $("<div class='outfit-div'>").append(outfitStructure);
        //.append($("<h1>").text(outfit.id));
}