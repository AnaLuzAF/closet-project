$.delete = function(url, callback){
  return $.ajax({
    url: url,
    type: 'DELETE',
    complete: callback,
    contentType: "application/json"
  });
}

function printBooks() {
    $.get("/books", function(books, status) {
        var booksDiv = $('#main');
        booksDiv.empty();
        booksDiv.append("<ol>")
        var header = $("<thead class='table-dark'>").append("<tr><th>Portada</th><th>ISBN</th><th>Título</th><th>Autor</th><th>Año publicación</th><th>Acciones</th></tr>")
        var body = $("<tbody>")
        for (book of books) {
            body.append(bookRow(book));
        }
        booksDiv.append($("<table class='table'>").append(header).append(body));
        booksDiv.append($("<button>",{
            class:'btn btn-dark',
           onclick: 'addBookDialog()'
        }).text("Añadir"));
    });
}

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

function createBook() {
    var book = {
        "isbn": $("#isbn").val(),
        "author": $("#author").val(),
        "title": $("#title").val(),
        year: $("#year").val()
    };
    $.post(
        {
            url:"/books",
            data: JSON.stringify(book),
            contentType: 'application/json; charset=utf-8'
        }
    ).done(
        function(nothing, status) {
              upload($("#isbn").val());
        }
    );
}

function bookRow(book) {
    return $("<tr>")
        .append($("<td>").append($("<img>",
            {
                src: "/images/"+book.isbn+".jpeg",
                width: 40,
                height: 40
            })))
        .append($("<td>").text(book.isbn))
        .append($("<td>").text(book.title))
        .append($("<td>").text(book.author))
        .append($("<td>").text(book.year))
        .append($("<td>")
                    .append(pencilIcon("modifyBook('"+ book.isbn +"')"))
                    .append(trashIcon("deleteBook('"+book.isbn+"')"))
        );
}

function loadBook(isbn){
 $.get("/books/"+isbn, function(book, status) {
        var mainDiv = $('#main');
        mainDiv.empty();
        mainDiv.append(
             $("<article>")
             .append($("<h2>").text(book.title))
             .append($("<p>").text(book.author))
        );
    });
}

function deleteBook(isbn) {
    let text = "¿Estás seguro de que deseas eliminar el libro?";
    if (confirm(text) == true) {
        $.delete("/books/"+isbn, function(data, textStatus) {
            if(data.status == 200) {
                printBooks();
            } else if(data.status == 404) {
                alert("No se ha encontrado el libro " + isbn);
            } else {
                alert("Error al eliminar el libro. Error: " + data.status);
            }
        });

    }
}

function upload(isbn) {
    var fd = new FormData();
    // Selecciono el input cuyo id es image
    var input = $('#image')[0];
    fd.append( 'image', input.files[0] );

    $.ajax({
         url: '/books/'+isbn+"/image",
         data: fd,
         processData: false,
         contentType: false,
         type: 'POST',
         success: function(data){
             alert(data);
        }
    });
}