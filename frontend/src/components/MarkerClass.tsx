import L from 'leaflet';
import { Marker, Popup } from 'react-leaflet';


class MarkerData {

    public logId:number;
    public x: number;
    public y: number;
    public z: number;
    public date: Date;
    public iconUrl: string;
    public information: string;
    public steamId: number;
    public nickname: string;

    constructor (logId: number, x: number, y: number, z: number, iconUrl: string, information: string, date: Date, steamId: number, nickname: string) {
        this.logId = logId;
        this.x = x;
        this.y = y;
        this.z = z;
        this.iconUrl = iconUrl;
        this.information = information;
        this.date = date;
        this.steamId = steamId;
        this.nickname = nickname;
    }

    convertCoordinates (): [number, number] {
        const scaleX:number = 15360 / 256;
        const scaleY:number = 15360 / 256;
        
        let newX:number = this.x / scaleX;
        let newY:number = (this.z / scaleY - 256);


        return [newY, newX]
    }

    createMarker(key: string) {

        const customIcon = L.icon({
            iconUrl: "http://localhost:8080" + this.iconUrl,
            iconSize: [34, 55],
            iconAnchor: [16, 55],
            popupAnchor: [0, -46],
            shadowSize: [55, 55]
          })

          const coordinates = this.convertCoordinates();

          return (
              <Marker key={key} position={coordinates} draggable={true} icon={customIcon}>
                  <Popup>
                      <div dangerouslySetInnerHTML={{ __html: this.information }} />
                  </Popup>
              </Marker>
          );
    }
}

export default MarkerData;