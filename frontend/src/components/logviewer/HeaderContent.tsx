
import { Header } from "antd/es/layout/layout";
import React from 'react';




export const HeaderContent:React.FC = () => {
  return (
    <Header
      style={{
        backgroundColor: "#082032",
        color: "white",
        textAlign: "center",
      }}
    >
      <div className="brand" style={{ fontFamily: "'Sunflower', sans-serif", height: '100%' }}>
        LOG4Z
      </div>
      
    </Header>
    
  );
};

export default HeaderContent;