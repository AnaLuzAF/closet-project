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
               <div class="outfit-box" id="outfit-box-top"></div>
               <div class="outfit-box" id="outfit-box-bottom">item</div>
               <div class="outfit-box" id="outfit-box-shoes">item</div>
           </div>
       </div>
       `;

     wardrobeStructure.append(form);
}


function printItems(userId, itemType) {
    $.get("/users/" + userId + "/items?item_type=" + itemType, function(items) {
        var itemsDiv = $('#items');
        itemsDiv.empty();

        itemsDiv.append("<div class='item-box'><h1 class='add-icon' onclick=insertItem(" + userId + "," + "'" + itemType + "'" + ")>Add item</h1><input type='file' id='image' name='image'></div>");

        for (item of items) {
            itemsDiv.append(itemDiv(item));
        }
  });
}

function itemDiv(item) {
    var itemString=JSON.stringify(item);
    return $("<div class='item-box' onclick= 'outfitBoxItem(" + itemString + ")'>")
        .append($("<img src= '/images/" + item.id + ".jpg' alt= " + item.id + " class='clothes'>"));
}

function outfitBoxItem(itemString){
    var top=$("#outfit-box-top");
    var bottom=$("#outfit-box-bottom");
    var shoes=$("#outfit-box-shoes");

    if(itemString.itemType=="top"){
        top.empty();
        top.append($("<img src='/images/"+ itemString.id + ".jpg' alt= 'topImg' class='clothes'>"));
    }else if(itemString.itemType=="bottom"){
        bottom.empty();
        bottom.append($("<img src='/images/"+ itemString.id + ".jpg' alt= 'bottomImg' class='clothes'>"));
    }else{
        shoes.empty();
        shoes.append($("<img src='/images/"+ itemString.id + ".jpg' alt= 'shoesImg' class='clothes'>"));
    }
}


function insertItem(userId, itemType) {
    var item = {
            "user_id": userId,
            "item_type": itemType
        };

        postItem("/users/" + userId + "/items", item);
}

function postItem(url, item) {

    $.post(
        {
            url: url,
            data: JSON.stringify(item),
            contentType: 'application/json; charset=utf-8',
            success: function (itemId) {
                if(itemId != null) {

                    upload(item.user_id, itemId, item.item_type);

                } else {
                    alert("There's been a problem trying to insert your item")
                }
            }
        }
    ).done(
    );
 }




function upload(userId, itemId, itemType) {

    var fd = new FormData();

    var input = $('#image')[0];
    fd.append( 'image', input.files[0] );

    $.ajax({
         url: "/users/" + userId + "/items/" + itemId + "/image",
         data: fd,
         processData: false,
         contentType: false,
         type: 'POST',
         success: function(data){
             printItems(userId, itemType);
        }
    });
}
