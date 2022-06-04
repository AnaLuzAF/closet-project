function loadOutfits() {
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

function printCategoryOutfits(userId, category) {
    $.get("/users/" + userId + "/outfits?category=" + category, function(outfits) {
        var outfitsDiv = $('#outfits');

        for (outfit of outfits) {
            outfitsDiv.append(outfitDiv(outfit));
            addImages(outfit);
        }
    });
}

function printOutfits(userId) {
    $.get("/users/" + userId + "/outfits", function(outfits) {
        var outfitsDiv = $('#outfits');
        outfitsDiv.empty();

        for (outfit of outfits) {
            outfitsDiv.append(outfitDiv(outfit));
            addImages(outfit);
        }
    });
}


function outfitDiv(outfit) {

    var outfitStructure = `
        <div class="outfit-items" id="outfitTop"></div>
        <div class="outfit-items" id="outfitBottom"></div>
        <div class="outfit-items" id="outfitShoes"></div>
`;

    return $("<div class='outfit-div'>").append(outfitStructure).attr('id', outfit.id);
}

function addImages(outfit) {

    var outfitDiv = $('#' + outfit.id);

    var topItem = outfitDiv.find('#outfitTop');
    topItem.append($("<img src= '/images/" + outfit.top + ".jpg' alt= " + outfit.id + " class=''>"));

    var bottomItem = outfitDiv.find('#outfitBottom');
    bottomItem.append($("<img src= '/images/" + outfit.bottom + ".jpg' alt= " + outfit.id + " class=''>"));

    var shoesItem = outfitDiv.find('#outfitShoes');
    shoesItem.append($("<img src= '/images/" + outfit.shoes + ".jpg' alt= " + outfit.id + " class=''>"));
}