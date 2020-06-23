function upDate(picture) {
    var src = picture.getAttribute( "src" );
    var alt = picture.getAttribute( "alt" );
    document.getElementById('image').style.backgroundImage = "url('" + src + "')";
    document.getElementById('image').innerHTML = alt;
}
function unDo() {
    var undo = document.getElementById('image');
    undo.style.backgroundImage = "url('')";
    document.getElementById('image').innerHTML = "Hover over an image and display the image here";
}
