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
    return $("<div class='outfit-div'>")
        .append($("<h1>").text(outfit.id));
}