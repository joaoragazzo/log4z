import 'antd/dist/reset.css';
import React from 'react';
import ReactDOM from 'react-dom/client';
import LogViewer from './LogViewer.tsx';
import './index.css';
import { ConfigProvider } from 'antd';

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <ConfigProvider theme={{
      token: {
        colorPrimary : "#0a2f4a",
        colorText: 'white',
        colorTextDescription: 'gray',
        colorBgBase: '#0a2f4a',
        colorBgContainer: '#0a2f4a',
        colorTextSecondary: '#000000',
        colorPrimaryHover: '#FF4C29',

       
        colorFillTertiary: '#FF4C29',
        colorPrimaryBorder: '#FF4C29',
        colorPrimaryBorderHover: '#FF4C29'

      },
    }}>
      <LogViewer />
    </ConfigProvider>
  </React.StrictMode>,
)
