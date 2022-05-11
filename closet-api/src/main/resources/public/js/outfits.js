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