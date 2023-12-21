import React from "react";
import L from "leaflet";
import { Content } from "antd/es/layout/layout";
import { MapContainer, TileLayer } from "react-leaflet";
import { CreateMarkers } from "./Marker";

interface LogsData {
  logId: number;
}

interface MarkerData {
  logId: number;
  x: number;
  y: number;
  z: number;
  iconUrl: string;
  date: Date;
  steamId: number;
  nickname: string;
  information: string;
}

interface Prop {
  filteredMarkers: MarkerData[];
  logs: LogsData[];
}

const MapContent: React.FC<Prop> = ({ filteredMarkers, logs }) => {
  return (
    <Content>
      <MapContainer
        center={[-128, 128]}
        zoom={1.5}
        style={{ height: "100%", width: "100%" }}
        crs={L.CRS.Simple}
        maxBounds={[
          [-256, 0],
          [0, 256],
        ]}
      >
        <TileLayer
          url="http://localhost:8080/images/chernarus/{z}/{x}/{y}.jpeg"
          maxZoom={7}
          minZoom={1}
          noWrap={true}
          bounds={[
            [-256, 0],
            [0, 256],
          ]}
        />

        {filteredMarkers.map((data, index) => (
          <CreateMarkers
            key={`marker-${data.date}-${index}`}
            x={data.x}
            y={data.z}
            information={data.information}
            iconURL={data.iconUrl}
            date={data.date}
            logId={logs.length}
          />
        ))}
      </MapContainer>
    </Content>
  );
};
export default MapContent;
