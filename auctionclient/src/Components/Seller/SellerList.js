import { Typography } from '@mui/material';
import axios from 'axios';
import { makeStyles } from '@mui/styles';
import React, { useEffect, useState } from 'react';
import AdminNavBar from '../Admin/AdminNavBar';
import Navbar from '../Navbar';
import { Button } from '@material-ui/core';

const ROLE = 'user';

const useStyle = makeStyles({
  customeButton: {
    backgroundColor: 'blue',
    color: 'white',
  },
});

export default function SellerList() {
  const [sellers, setSellers] = useState([]);

  useEffect(() => {
    loadSellers();
  }, []);

  const classes = useStyle();

  const loadSellers = async () => {
    const result = await axios.get(
      'http://localhost:8088/api/v1/seller/getallusers'
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
          Registered User List
        </Typography>
        <Button className={classes.customeButton}>Register User</Button>
        <div className="py-4">
          <table className="table table-hover ">
            <thead>
              <tr className="table-dark">
                <th scope="col">#</th>
                <th scope="col">User Id</th>
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
