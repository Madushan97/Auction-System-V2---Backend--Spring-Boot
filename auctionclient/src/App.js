import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import Navbar from './Components/Navbar';
import RegisterForm from './Components/Seller/RegisterPage';
import SellerList from './Components/Seller/SellerList';
import HomePage from './Components/HomePage/HomePage';
import Admin from './Components/Admin/Admin';

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/sellerregister" element={<RegisterForm />} />
          <Route path="/sellerlist" element={<SellerList />} />
          <Route path="/admin" element={<Admin />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
