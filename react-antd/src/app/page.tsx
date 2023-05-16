'use client';

import React from 'react';
import { Pagination } from 'antd';


export default function Home() {


  return (
    <Pagination showQuickJumper defaultCurrent={1} total={50} />
  )
}

