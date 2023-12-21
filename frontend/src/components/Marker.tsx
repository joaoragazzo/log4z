import React from 'react';
import { Marker, Popup } from 'react-leaflet';
import L from 'leaflet';

interface CreateMarkersProps {
    x: number;
    y: number;
    date: Date;
    information: string;
    iconURL: string;
    logId: number;
  }

export const CreateMarkers:React.FC<CreateMarkersProps> = ({x, y, information, iconURL, date, logId}) => {

  
    const scaleX:number = 15360 / 256;
    const scaleY:number = 15360 / 256;
    
    let newX:number = x / scaleX;
    let newY:number = (y / scaleY - 256);

    const customIcon = L.icon({
      iconUrl: "http://localhost:8080" + iconURL,
      iconSize: [34, 55],
      iconAnchor: [16, 55],
      popupAnchor: [0, -46],
      shadowSize: [55, 55]

    })

    return (
    <Marker position={[newY, newX]} draggable={true} icon={customIcon}>
      <Popup>
        <div dangerouslySetInnerHTML={{ __html: information }}></div>
      </Popup>
    </Marker>
    );
};