import React from 'react';
import {
  AppBar,
  Button,
  // IconButton,
  Stack,
  Toolbar,
  // Typography,
} from '@mui/material';
import { Link } from 'react-router-dom';

const AdminNavBar = () => {
  return (
    <AppBar position="static" sx={{ backgroundColor: '#004d40' }}>
      <Toolbar>
        <Stack direction="row" spacing={1}>
          <Link to="/" style={{ textDecoration: 'none', color: 'inherit' }}>
            <Button color="inherit">Home</Button>
          </Link>
          <Link
            to="/sellerlist"
            style={{ textDecoration: 'none', color: 'inherit' }}
          >
            <Button color="inherit">Users</Button>
          </Link>

          <Button color="inherit">Gems</Button>
          <Button color="inherit">Auctions</Button>
          <Button color="inherit">Contact Us</Button>
          <Button color="inherit">Login</Button>
        </Stack>
      </Toolbar>
    </AppBar>
  );
};

export default AdminNavBar;
