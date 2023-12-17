class MarkerManager {

    constructor(map) {
        this.map = map;
        this.markers = [];
    }

    markerSorter(markerA, markerB) {
        const dateA = markerA.date;
        const dateB = markerB.date;

        return dateA - dateB;
    }
    addMarker(x, y, description, date, iconUrl) {
        const dateFormat = new Date(date);
        [x, y] = this.convertCoordinates(x, y);

        this.markers.push(new Marker(this.map, [x, y], description, dateFormat, iconUrl));
        this.markers.sort(this.markerSorter);
    }

    convertCoordinates(x, y) {
        const scaleX = 15360 / 256;
        const scaleY = 15360 / 256;

        let newX = x / scaleX;
        let newY = (y / scaleY - 256);

        return [newY, newX];
    }

    viewToIndex(max) {
        if (max === -1) {
            this.markers[0].disable();
            return;
        }

        let i;
        for(i = 0; i <= max; i++) {
            this.markers[i].enable();
        }

        for(; i < this.markers.length; i++) {
            this.markers[i].disable();
        }
    }

    deleteAllMarkers() {
        for(let i = 0; i < this.markers.length; i++) {
            console.log("my first i is...", i);
            this.markers[i].disable();
        }

        this.markers = []
    }
}