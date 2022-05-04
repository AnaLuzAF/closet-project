function addBookDialog() {
    var booksDiv = $('#main');
    booksDiv.empty();

    var form = `<div>
                  <div >
                    <div >
                      <div >
                        <h5 >Añadir libro</h5>
                      </div>
                      <div >
                        <label for="isbn">ISBN</label>

                        <input type="text" id="isbn" name="isbn" required>
                        <br>
                        <label for="title">Título</label>
                        <input type="text" id="title" name="title" required>
                        <br>
                        <label for="author">Autor</label>
                        <input type="text" id="author" name="author" required>
                        <br>
                        <label for="year">Año de publicación</label>
                        <input type="text" id="year" name="year" required>
                        <br>
                        <label for="image">Portada</label>
                        <input type="file" id="image" name="image">
                      </div>
                      <div >
                        <button type="button" class="btn btn-secondary-dark" >Cancelar</button>
                        <button type="button" class="btn btn-dark" onclick="createBook()">Añadir</button>
                      </div>
                    </div>
                  </div>
                </div>`;

     booksDiv.append(form);
}
