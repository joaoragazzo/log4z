interface MarkerObject {
    x:number,
    y:number,
    iconUrl:string;
    information:string;
    date:Date;
    map:any;
    isActive:boolean;
    id:number;
    marker:any;

    disable: () => void;
    enable: () => void;
}

export class MarkerManager {

    public map: any;
    public lastId: number;
    public markers: MarkerObject[]; 
    public slider:any;

    constructor(map: any, slider: any) {
        this.map = map;
        this.markers = [];
        this.lastId = 1;
        this.slider = slider;
    }
    
    markerSorter(markerA: MarkerObject, markerB: MarkerObject) {
        const dateA: Date = markerA.date;
        const dateB: Date = markerB.date;

        if (dateA >= dateB) {
            return -1
        }
        
        return 1
    }
    addMarker(x: number, y: number, description: string, date: string, iconUrl: string) {
        const dateFormat = new Date(date);
        [x, y] = this.convertCoordinates(x, y);

        this.markers.push(new MarkerObject(this.map, [x, y], description, dateFormat, iconUrl, this.lastId));
        this.markers.sort(this.markerSorter);

        this.slider.max = parseInt(this.slider.max, 10) + 1;
    }

    convertCoordinates(x: number, y: number){
        const scaleX:number = 15360 / 256;
        const scaleY:number = 15360 / 256;

        let newX:number = x / scaleX;
        let newY:number = (y / scaleY - 256);

        return [newY, newX];
    }

    viewToIndex(max:number) {
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
            this.markers[i].disable();
        }

        this.markers = []
    }

    deleteMarkerById(id:number) {

        let deletedElements = 0;

        this.markers = this.markers.filter(function customFilter(marker) {
            if (marker.id !== id) {
                marker.disable();
                deletedElements += 1;
                return true;
            }
            return false;
        });

        this.slider.max = parseInt(this.slider.max, 10) - deletedElements;
    }

}
