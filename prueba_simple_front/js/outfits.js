function loadOutfits(){
    var outfitStructure = $('#main');
    outfitStructure.empty();

    var outfits = `<div class="outfit">

                    <div class=types-outfit>
                       <ul>
                          <li><a onclick="all()">All</a></li>
                          <li><a onclick="sport()">Sport</a></li>
                          <li><a onclick="classy()">Classy</a></li>
                          <li><a onclick="casual()">Casual</a></li>
                       </ul>
                    </div>
                        <div class="outfits">
                            <div class="outfit-div"></div>
                            <div class="outfit-div"></div>
                            <div class="outfit-div"></div>
                            <div class="outfit-div"></div>
                            <div class="outfit-div"></div>
                            <div class="outfit-div"></div>
                            <div class="outfit-div"></div>
                            <div class="outfit-div"></div>
                            <div class="outfit-div"></div>


                    </div>
                </div>`;

     outfitStructure.append(outfits);
}

function printOutfits() {
    $.get("/users/{user_id}/outfits", function(outfits) {
        var outfitsDiv = $('.outfits');
        outfitsDiv.empty();

        for (outfit of outfits) {
            outfitsDiv.append(outfitsDiv(outfit));
        }
  });
  }


  function printOutfitsCategories() {
      $.get("/users/{user_id}/outfits/{category}", function(userId,category) {
          var categoriesDiv = $('.category');
           categoriesDiv.empty();


          for (categories of category) {
               categoriesDiv.append(categoriesDiv(categories));
          }
    });
}