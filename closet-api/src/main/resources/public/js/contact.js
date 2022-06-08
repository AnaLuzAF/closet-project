function loadContact() {
    var contactStructure = $('#main');
    contactStructure.empty();

    var contact = `<div id="fondoHome"><div class="contact">
                           <form action="#" class="form-contact">
                               <div class="form-contact-container">
                                   <h2 class= "form-contact-title">Contact Us</h2>
                                   <input type= "text" id="subject" class="form-contact-input" placeholder="Name">
                                   <input type= "text" class="form-contact-input" placeholder="Surname">
                                   <input type= "text" class="form-contact-input" placeholder="Phone">
                                   <input type= "email" id="email" class="form-contact-input" placeholder="Email">
                                   <input type= "text" class="form-contact-input" placeholder="Subject">
                                   <textarea class="mensaje"  id="text" placeholder="Message:"></textarea>
                                   <input type= "submit" value= "Send" class="form-contact-input-send">
                               </div>
                           </form>
                       </div></div>`;

    contactStructure.append(contact);
}