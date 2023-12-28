import React from 'react';
import { Button, Layout, Slider } from 'antd';

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

interface ControlPanelProps {
  showModal: () => void;
  resetMarkers: () => void;
  handleSliderChange: (value: [number, number]) => void;
  maxSliderValue: number;
  markers: MarkerData[]; // Ensure you import MarkerData type
}

const ControlPanel: React.FC<ControlPanelProps> = ({ 
  showModal, 
  resetMarkers, 
  handleSliderChange, 
  maxSliderValue, 
  markers 
}) => {
  return (
    <Layout
      style={{
        padding: "15px",
        borderRadius: "10px",
        marginBottom: "15px",
      }}
    >
      <div
        style={{
          display: "flex",
          justifyContent: "space-around",
          marginBottom: "35px",
        }}
      >
        <Button
          type="primary"
          style={{ width: "100%", marginRight: "5px", backgroundColor: "#1dab18" }}
          onClick={showModal}
        >
          <b>New</b>
        </Button>
        <Button
          type="primary"
          style={{ width: "100%", marginLeft: "5px", backgroundColor: "#ab1818" }}
          onClick={resetMarkers}
        >
          <b>Reset</b>
        </Button>
      </div>
      <Slider
        range={{ draggableTrack: true }}
        min={0}
        max={maxSliderValue}
        step={1}
        defaultValue={[0, maxSliderValue]}
        onChange={handleSliderChange}
        className="custom-slider"
        tooltip={{
          formatter: (value: any) => markers[value] ? new Date(markers[value].date).toString() : ""
        }}
      />
    </Layout>
  );
};

export default ControlPanel;
