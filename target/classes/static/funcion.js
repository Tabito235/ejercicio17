
function like(imagen) {
  fetch('/api/likes/' + imagen, { method: 'POST' })
    .then(response => response.json())
    .then(data => actualizarContadores(data));
}

function actualizarContadores(data) {
  document.getElementById("like1").innerText = data.likeImagen1;
  document.getElementById("like2").innerText = data.likeImagen2;
  document.getElementById("like3").innerText = data.likeImagen3;
}

setInterval(() => {
  fetch('/api/likes')
    .then(response => response.json())
    .then(data => actualizarContadores(data));
}, 5000);
