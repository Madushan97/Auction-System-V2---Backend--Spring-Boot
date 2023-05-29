import React, { useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import { TextField, Button } from '@material-ui/core';
import { Typography } from '@mui/material';
import axios from 'axios';
import { useNavigate } from 'react-router';

const useStyles = makeStyles((theme) => ({
  root: {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    marginTop: theme.spacing(4),
  },
  form: {
    display: 'flex',
    flexDirection: 'column',
    width: '100%',
    maxWidth: 400,
    padding: theme.spacing(2),
    border: `1px solid ${theme.palette.grey[300]}`,
    borderRadius: theme.shape.borderRadius,
    '& > *': {
      margin: theme.spacing(1, 0),
    },
  },
}));

const RegisterPage = () => {
  let navigate = useNavigate();

  const classes = useStyles();

  const [seller, setSeller] = useState({
    firstName: '',
    lastName: '',
    NIC: '',
    address: '',
    contactNumbers: [''],
    email: '',
  });

  const { firstName, lastName, NIC, email, address, contactNumbers } = seller;

  const onInputChange = (e) => {
    setSeller({ ...seller, [e.target.name]: e.target.value });
  };

  // POSt using axios
  const handleSubmit = async (event) => {
    event.preventDefault();
    await axios.post('http://localhost:8088/api/v1/seller/saveseller', seller);
    navigate('/');
  };

  return (
    <div className={classes.root}>
      <Typography
        variant="h5"
        sx={{ marginBottom: '8px', fontWeight: 'bold', color: '#004d40' }}
      >
        Seller Registration
      </Typography>
      <form className={classes.form} onSubmit={(e) => handleSubmit(e)}>
        <TextField
          label="First Name"
          name="firstName"
          variant="outlined"
          value={firstName}
          onChange={(e) => onInputChange(e)}
          required
        />
        <TextField
          label="Last Name"
          name="lastName"
          variant="outlined"
          value={lastName}
          onChange={(e) => onInputChange(e)}
          required
        />
        <TextField
          label="NIC"
          name="NIC"
          variant="outlined"
          value={NIC}
          onChange={(e) => onInputChange(e)}
          required
        />
        <TextField
          label="Address"
          name="address"
          variant="outlined"
          value={address}
          onChange={(e) => onInputChange(e)}
          required
        />
        <TextField
          label="Contact Number"
          name="contactNumbers"
          variant="outlined"
          value={contactNumbers}
          onChange={(e) => onInputChange(e)}
          required
        />
        <TextField
          label="Email"
          name="email"
          type="email"
          variant="outlined"
          value={email}
          onChange={(e) => onInputChange(e)}
          required
        />
        <Button
          type="submit"
          variant="contained"
          color="primary"
          style={{ backgroundColor: '#004d40' }}
        >
          Register
        </Button>
        <Button
          type="cancel"
          variant="contained"
          color="primary"
          style={{ backgroundColor: '#ff0000', opacity: '85%' }}
        >
          Cancel
        </Button>
      </form>
    </div>
  );
};

export default RegisterPage;
