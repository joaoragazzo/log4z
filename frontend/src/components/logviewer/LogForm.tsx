import { Button, Form, Modal, Upload } from "antd";
import TextArea from "antd/es/input/TextArea";
import React from "react";
import { UploadOutlined } from '@ant-design/icons';

interface Prop {
  handleCancel: () => void;
  textAreaValue: string;
  handleOk: () => void;
  isModalOpen: boolean;
  handleTextAreaChange: (e: any) => void;
}

const LogForm: React.FC<Prop> = ({
  handleCancel,
  textAreaValue,
  handleOk,
  isModalOpen,
  handleTextAreaChange,
}) => {
  return (
    <Modal
      title="Log content"
      width={800}
      open={isModalOpen}
      onOk={handleOk}
      onCancel={handleCancel}
      okType="default"
    >
      <Form>
        <Form.Item>
          <TextArea
            value={textAreaValue}
            onChange={handleTextAreaChange}
            rows={25}
          />
        </Form.Item>
        <Upload
      action="https://run.mocky.io/v3/435e224c-44fb-4773-9faf-380c5e6a2188"
      listType="picture"
      maxCount={3}
      multiple
    >
      <Button icon={<UploadOutlined />}>Upload (Max: 3)</Button>
    </Upload>
        
      </Form>
    </Modal>
  );
};

export default LogForm;
