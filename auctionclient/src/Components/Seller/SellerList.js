import { Typography } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import AdminNavBar from '../Admin/AdminNavBar';
import Navbar from '../Navbar';

const ROLE = 'user';

export default function SellerList() {
  const [sellers, setSellers] = useState([]);

  useEffect(() => {
    loadSellers();
  }, []);

  const loadSellers = async () => {
    const result = await axios.get(
      'http://localhost:8088/api/v1/seller/getallsellers'
    );
    setSellers(result.data);
  };

  return (
    <>
      {ROLE === 'user' ? <AdminNavBar /> : <Navbar />}
      <div className="container">
        <Typography
          variant="h5"
          sx={{
            marginBottom: '8px',
            marginTop: '8px',
            fontWeight: 'bold',
            color: '#004d40',
            textAlign: 'center',
          }}
        >
          Registered Seller List
        </Typography>
        <div className="py-4">
          <table className="table table-hover ">
            <thead>
              <tr className="table-dark">
                <th scope="col">#</th>
                <th scope="col">Seller Id</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">NIC</th>
                <th scope="col">Address</th>
                <th scope="col">Contact Numbers</th>
                <th scope="col">Email</th>
              </tr>
            </thead>
            <tbody>
              {sellers.map((seller, index) => (
                <tr key={index}>
                  <th scope="row">{index + 1}</th>
                  <td>{seller.sellerId}</td>
                  <td>{seller.firstName}</td>
                  <td>{seller.lastName}</td>
                  <td>{seller.nic}</td>
                  <td>{seller.address}</td>
                  <td>{seller.contactNumbers}</td>
                  <td>{seller.email}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </>
  );
}
