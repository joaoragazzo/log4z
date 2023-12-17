var map = L.map('map', {
    crs: L.CRS.Simple,
    center: [-128, 128],
    zoom: 1,
    maxBounds: [[-256, 0], [0, 256]],
    maxBoundsViscosity: 1.0
});


// Configurações do tile layer mantidas iguais
L.tileLayer('http://localhost:8080/images/chernarus/{z}/{x}/{y}.jpeg', {
    maxZoom: 7,
    minZoom: 1,
    noWrap: true,
    attribution: '&copy; <a href="http://www.log4z.com/">Log4Z</a>',
    bounds: [[-256, 0], [0, 256]]
}).addTo(map);