import React from 'react';
import AdminNavBar from './AdminNavBar';
import Navbar from '../Navbar';

const ROLE = 'admin';

const Admin = () => {
  return <div>{ROLE === 'admin' ? <AdminNavBar /> : <Navbar />}</div>;
};

export default Admin;
