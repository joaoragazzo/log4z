import { Header } from "antd/es/layout/layout";
import React from 'react';
import '../styles/main.css';

export const HeaderContent:React.FC = () => {
  return (
    <Header className="header"
      style={{
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