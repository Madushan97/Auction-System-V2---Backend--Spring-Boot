import React from 'react';
import {
  AppBar,
  Button,
  IconButton,
  Stack,
  Toolbar,
  Typography,
} from '@mui/material';
import GavelIcon from '@mui/icons-material/Gavel';

const Navbar = () => {
  return (
    <AppBar position="static" sx={{ backgroundColor: '#004d40' }}>
      <Toolbar>
        <IconButton size="large" edge="start" aria-label="logo" color="inherit">
          <GavelIcon />
        </IconButton>
        <Typography variant="h6" component="div" sx={{ flex: 1 }}>
          Gem Auction
        </Typography>
        <Stack direction="row" spacing={1}>
          <Button color="inherit">Features</Button>
          <Button color="inherit">Bids</Button>
          <Button color="inherit">Sell</Button>
          <Button color="inherit">Help</Button>
          <Button color="inherit">Contact Us</Button>
          <Button color="inherit">Login</Button>
        </Stack>
      </Toolbar>
    </AppBar>
  );
};

export default Navbar;
