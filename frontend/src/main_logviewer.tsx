import 'antd/dist/reset.css';
import React from 'react';
import ReactDOM from 'react-dom/client';
import LogViewer from './LogViewer.tsx';
import './index.css';
import { ConfigProvider, theme } from 'antd';

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <ConfigProvider theme={{
      algorithm: theme.darkAlgorithm,
      token: {
        colorBgBase: '#121212',

        colorPrimary : "#0a2f4a",
        colorText: 'white',
        colorTextDescription: 'gray',
        
        colorBgContainer: '#0a2f4a',
        colorTextSecondary: '#000000',
        colorPrimaryHover: '#FF4C29',
        colorBgElevated: '#0b324f',
       
        colorPrimaryBorder: '#FF4C29',
        colorPrimaryBorderHover: '#FF4C29'

      },
      
    }}>
      <LogViewer />
    </ConfigProvider>
  </React.StrictMode>,
)
