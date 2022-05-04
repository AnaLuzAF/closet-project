$.delete = function(url, callback){
  return $.ajax({
    url: url,
    type: 'DELETE',
    complete: callback,
    contentType: "application/json"
  });
}

function showMembers() {

}
