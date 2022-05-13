function loadWardrobe() {
    var wardrobeStructure = $('#main');
    wardrobeStructure.empty();

    var form = `<div class="item-container">

           <script> window.onload = printItems(1, 'top')</script>

           <div class="types">
               <ul>
                  <li><a onclick="printItems(1, 'top')">Top</a></li>
                  <li><a onclick="printItems(1, 'bottom')">Bottom</a></li>
                  <li><a onclick="printItems(1, 'shoes')">Shoes</a></li>
               </ul>
           </div>
           <div class="items" id="items">

           </div>
       </div>

       <div class="outfit-container">
           
           <div class= "outfit-menu">
               
               <div class="dropdown">
                  <button class="dropbtn">Choose category...</button>
                  <div class="dropdown-content">
                    <a href="#">Sport</a>
                    <a href="#">Classy</a>
                    <a href="#">Casual</a>
                  </div>
                </div>
               
                  <div class="saveButton"><a onclick="postOutfit()">Save</a></div>
               
           </div>    
           
           <div class="outfit-parts">
               <div class="outfit-box">item</div>
               <div class="outfit-box">item</div>
               <div class="outfit-box">item</div>
           </div>
       </div>
       `;

     wardrobeStructure.append(form);
}


function printItems(userId, itemType) {
    $.get("/users/" + userId + "/items?item_type=" + itemType, function(items) {
        var itemsDiv = $('#items');
        itemsDiv.empty();

        itemsDiv.append("<div class='item-box' onclick=insertItem(" + userId + "," + "'" + itemType + "'" + ")><h1 class='add-icon'>+</h1></div>");

        for (item of items) {
            itemsDiv.append(itemDiv(item));
        }
  });
}

function itemDiv(item) {
    return $("<div class='item-box'>")
        .append($("<h1>").text(item.id));
}

function insertItem(userId, itemType) {
    var item = {
            "user_id": userId,
            "item_type": itemType
        };

        postItem("/users/" + userId + "/items", item);

        /*if() {
                printItems(userId, itemType);
        }
*/
          /*
        $.post(
            {
                url:"/users/" + userId + "/items",
                data: JSON.stringify(item),
                contentType: 'application/json; charset=utf-8'
            }
        ).done(
            printItems(userId, itemType)

        );
        */
}

function postItem(url, item) {
    $.post(
        {
            url: url,
            data: JSON.stringify(item),
            contentType: 'application/json; charset=utf-8',
            success: function (data) {
                if(data == true) {
                printItems(item.user_id, item.item_type);
                } else {
                    alert("There's been a problem trying to insert your item")
                }
            }
        }
    ).done(
    );
 }

