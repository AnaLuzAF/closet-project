function loadWardrobe() {
    var wardrobeStructure = $('#main');
    wardrobeStructure.empty();

    var form = `<div class="item-container">
           
           <div class=types>
               <ul>
                  <li><a onclick="getTops()">Top</a></li>
                  <li><a onclick="getBottoms()">Bottom</a></li>
                  <li><a onclick="getShoes()">Shoes</a></li>
               </ul>
           </div>
           <div class="items">

               <div class="item-box">+</div>

           </div>
       </div>
       
       <div class="outfit-container">
           <div class="outfit-parts">
               <div class="outfit-box">item</div>
               <div class="outfit-box">item</div>
               <div class="outfit-box">item</div>
           </div>
       </div>
       `;

     wardrobeStructure.append(form);
}


function printItems() {
    $.get("/users/{user_id}/items/{item_type}", function(items, itemType) {
        var itemsDiv = $('.items');
        itemsDiv.empty();
    
        
        for (item of items) {
            itemsDiv.append(itemDiv(item));
        }
  });
}

function itemDiv(item) {
    return $("<div class='outfit-box'>")
        .append($("<h1>").text(item.id))
}

