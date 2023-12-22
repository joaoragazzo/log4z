import React from "react";
import L from "leaflet";
import { Content } from "antd/es/layout/layout";
import { MapContainer, TileLayer } from "react-leaflet";
import MarkerData from "./MarkerClass";

interface LogsData {
  logId: number;
}

interface Prop {
  filteredMarkers: MarkerData[];
  logs: LogsData[];
}

const MapContent: React.FC<Prop> = ({ filteredMarkers }) => {
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

        {
          filteredMarkers.map((data, index) => {
            return data.createMarker(`${Date.now()}-{${index}}`);
          })
        }
      </MapContainer>
    </Content>
  );
};
export default MapContent;
