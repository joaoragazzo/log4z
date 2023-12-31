// App.tsx
import React, { useState } from "react";
import { Layout, notification } from "antd";
import Sider from "antd/es/layout/Sider";
import "./styles/main.css";
import { LogComponent } from "./components/home/logviewer/LogComponent";
import { HeaderContent } from "./components/HeaderContent";
import ControlPanel from "./components/home/logviewer/ControlPanel";
import MapContent from "./components/home/logviewer/MapContent";
import LogForm from "./components/home/logviewer/LogForm";
import { BreadCrumPath } from "./components/BreadcrumbPath";
import MarkerData from "./components/home/logviewer/MarkerClass";

type NotificationType = "success" | "info" | "warning" | "error";

interface LogsData {
  logId: number;
}

const LogViewer: React.FC = () => {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [textAreaValue, setTextAreaValue] = useState("");
  const [markers, setMarkers] = useState<MarkerData[]>([]); // Estado para armazenar os marcadores
  const [logs, setLogs] = useState<LogsData[]>([]);
  const [dateRange, setDateRange] = useState({
    minDate: new Date(),
    maxDate: new Date(),
  });
  const [api, contextHolder] = notification.useNotification();
  const [logId, setLogId] = useState(1);
  

  const openNotificationWithIcon = (type: NotificationType, title: string, description: string) => {
    api[type]({
      message: title,
      description: description,
    });
  };

  const addMarkers = (newMarkers: MarkerData[]) => {
    setMarkers((currentMarkers) => {
      const updatedMarkers = currentMarkers.slice(); // Cria uma cópia do array atual

      newMarkers.forEach((newMarker) => {
        const isDuplicate = currentMarkers.some(
          (currentMarker) =>
            currentMarker.x === newMarker.x &&
            currentMarker.y === newMarker.y &&
            currentMarker.z === newMarker.z &&
            currentMarker.iconUrl === newMarker.iconUrl &&
            new Date(currentMarker.date).getTime() ===
              new Date(newMarker.date).getTime() &&
            currentMarker.steamId === newMarker.steamId &&
            currentMarker.nickname === newMarker.nickname &&
            currentMarker.information === newMarker.information
        );

        if (!isDuplicate) {
          const newMarkerObject: MarkerData = new MarkerData(logId, newMarker.x, newMarker.y, newMarker.z, newMarker.iconUrl, newMarker.information, newMarker.date, newMarker.steamId, newMarker.nickname);
          updatedMarkers.push(newMarkerObject);
        }
      });

      return updatedMarkers.sort((a, b) => {
        const dateA = new Date(a.date);
        const dateB = new Date(b.date);
        return dateA.getTime() - dateB.getTime();
      });
    });
  };

  const resetMarkers = () => {
    setMarkers([]);
    setLogs([]);
  };

  const filteredMarkers = markers.filter(
    (marker) =>
      new Date(marker.date) >= dateRange.minDate &&
      new Date(marker.date) <= dateRange.maxDate
  );

  const maxSliderValue = markers.length > 0 ? markers.length - 1 : 0;
  const handleSliderChange = (value: [number, number]) => {

    if (markers.length === 0) return;

    // Assumindo que os marcadores estão ordenados por data
    const minDate = new Date(markers[value[0]].date);
    const maxDate = new Date(markers[value[1]].date);

    setDateRange({ minDate, maxDate });
  };

  const handleSubmit = async () => {
    try {
      setTextAreaValue("");

      const response = await fetch("http://localhost:8080/api/parser", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ log: textAreaValue }),
      });

      if (response.status === 404) {
        openNotificationWithIcon("warning", "Log not recognized", "This log format was not recognized by our system.")
        return;
      }

      if (!response.ok) {
        throw new Error("request failed");
      }

      const data = await response.json();

      
      setLogs((currentLogs) => [...currentLogs, { logId: logId}]);
      addMarkers(data);
      setIsModalOpen(false);
      openNotificationWithIcon("success", "Log recognized", "The log was recognized and successfully showed up into the map!");
      setLogId(logId + 1);
    } catch (error) {
      openNotificationWithIcon("error", "A error happened", "Our server seems to be offline. Try again later!");
    }
  };

  const handleTextAreaChange = (e: any) => {
    setTextAreaValue(e.target.value);
  };

  const showModal = () => {
    setIsModalOpen(true);
  };

  const handleOk = () => {
    handleSubmit();
    setIsModalOpen(false);
  };

  const handleCancel = () => {
    setIsModalOpen(false);
  };

  const removeMarkersByLogId = (logIdToRemove: number) => { 
    setMarkers((currentMarkers) =>
      currentMarkers.filter((marker) => marker.logId !== logIdToRemove)
    );

    setLogs((currentLogs) =>
      currentLogs.filter((log) => log.logId !== logIdToRemove)
    );
  };

  return (
    <Layout className="container">
      {contextHolder}

      <LogForm  textAreaValue={textAreaValue} handleTextAreaChange={handleTextAreaChange} handleCancel={handleCancel} handleOk={handleOk} isModalOpen={isModalOpen} />

      <HeaderContent />
      <BreadCrumPath items={[
      {
        title: <a href="/home">Home</a>,
      },
      {
        title: 'Log Viewer',
      },
    ]} />
      

      <Layout style={{ height: "100vh"}}>
        <Sider
          width={400}
          style={{ padding: "15px"}}
        >
          <ControlPanel
            showModal={showModal}
            resetMarkers={resetMarkers}
            handleSliderChange={handleSliderChange}
            maxSliderValue={maxSliderValue}
            markers={markers}
          />

          <Layout
            style={{
              padding: "15px",
              borderRadius: "10px",
              marginBottom: "15px",
              overflow: "hidden",
              height: "83%",
              overflowY: "scroll",
            }}
          >
            {logs.map((log) => (
              <LogComponent
                key={log.logId}
                logId={log.logId}
                removeMarkers={removeMarkersByLogId}
              />
            ))}
          </Layout>
        </Sider>
        <MapContent filteredMarkers={filteredMarkers} logs={logs}></MapContent>
      </Layout>
    </Layout>
  );
};

export default LogViewer;
