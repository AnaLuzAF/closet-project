function loadWardrobe() {
    var wardrobeStructure = $('#main');
    wardrobeStructure.empty();

    var form = `  <div class="item-container">
           
           <div class=types>
               <ul>
                  <li><a onclick="getTops()">Top</a></li>
                  <li><a onclick="getBottoms()">Bottom</a></li>
                  <li><a onclick="getShoes()">Shoes</a></li>
               </ul>
           </div>
           <div class="items">
               <div class="item-box">item</div>
               <div class="item-box">item</div>
               <div class="item-box">item</div>
               <div class="item-box">item</div>
               <div class="item-box">item</div>
               <div class="item-box">item</div>
               <div class="item-box">item</div>
               <div class="item-box">item</div>
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
