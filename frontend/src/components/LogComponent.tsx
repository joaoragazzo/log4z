import { Button } from "antd";
import React from "react";
import { MdDelete } from "react-icons/md";

interface Props {
  logId: number;
}

export const LogComponent: React.FC<
  Props & { removeMarkers: (logId: number) => void }
> = ({ logId, removeMarkers }) => {
  return (
    <div
      style={{
        backgroundColor: "#2C394B",
        padding: "23px",
        borderRadius: "13px",
        color: "white",
        fontSize: "20px",
        display: "flex",
        justifyContent: "space-between",
        marginBottom: "5px",
      }}
    >
      <div>Log #{logId.toString()}</div>
      <div>
        <Button onClick={() => removeMarkers(logId)}>
          <MdDelete />
        </Button>
      </div>
    </div>
  );
};
