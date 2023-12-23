import React from 'react';
import { Breadcrumb } from 'antd';
import { ItemType } from 'antd/es/breadcrumb/Breadcrumb';

interface Prop {
    items: ItemType[]
}

export const BreadCrumPath: React.FC<Prop> = ({items}) => {
    return (
        <div style={{padding: '7px', paddingLeft: '15px'}}>
            <Breadcrumb 
                items={items}
            />
        </div>
    );
}

