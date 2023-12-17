class Marker {
    constructor(map, [x, y], information, date, iconUrl) {
        this.x = x;
        this.y = y;
        this.iconUrl = iconUrl;
        this.information = information;
        this.date = date;
        this.map = map;
        this.isActive = false;

        this.marker = null;
    }

    enable() {

        if (!this.isActive){
            var greenIcon = new L.Icon({
                iconUrl: this.iconUrl,
                shadowUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png',
                iconSize: [34, 55],
                iconAnchor: [16, 55],
                popupAnchor: [0, -46],
                shadowSize: [55, 55]
            });

            this.marker = L.marker([this.x, this.y], {draggable: true, icon: greenIcon});
            this.marker.bindPopup(this.information).openPopup()
            this.map.addLayer(this.marker);

            this.isActive = true;
        }

    }

    disable() {
        if (this.isActive) {
            this.map.removeLayer(this.marker);
            this.isActive = false;
        }
    }


}