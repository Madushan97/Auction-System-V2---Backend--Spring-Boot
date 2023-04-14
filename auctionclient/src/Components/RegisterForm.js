import React, { useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import { TextField, Button } from '@material-ui/core';
import { Typography } from '@mui/material';

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
  const classes = useStyles();
  const [formData, setFormData] = useState({
    firstname: '',
    lastname: '',
    nic: '',
    email: '',
    address: '',
    contactnumber: '',
    password: '',
    confirmPassword: '',
  });

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setFormData((prevData) => ({ ...prevData, [name]: value }));
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    console.log(formData);
  };

  return (
    <div className={classes.root}>
      <Typography
        variant="h5"
        sx={{ marginBottom: '8px', fontWeight: 'bold', color: '#004d40' }}
      >
        Seller Registration
      </Typography>
      <form className={classes.form} onSubmit={handleSubmit}>
        <TextField
          label="First Name"
          name="firstname"
          variant="outlined"
          value={formData.firstname}
          onChange={handleInputChange}
          required
        />
        <TextField
          label="Last Name"
          name="lastname"
          variant="outlined"
          value={formData.lastname}
          onChange={handleInputChange}
          required
        />
        <TextField
          label="NIC"
          name="nic"
          variant="outlined"
          value={formData.nic}
          onChange={handleInputChange}
          required
        />
        <TextField
          label="Email"
          name="email"
          type="email"
          variant="outlined"
          value={formData.email}
          onChange={handleInputChange}
          required
        />
        <TextField
          label="Address"
          name="address"
          variant="outlined"
          value={formData.address}
          onChange={handleInputChange}
          required
        />
        <TextField
          label="Contact Number"
          name="contactnumber"
          variant="outlined"
          value={formData.contactnumber}
          onChange={handleInputChange}
          required
        />
        <TextField
          label="Password"
          name="password"
          type="password"
          variant="outlined"
          value={formData.password}
          onChange={handleInputChange}
          required
        />
        <TextField
          label="Confirm Password"
          name="confirmPassword"
          type="password"
          variant="outlined"
          value={formData.confirmPassword}
          onChange={handleInputChange}
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
      </form>
    </div>
  );
};

export default RegisterPage;
