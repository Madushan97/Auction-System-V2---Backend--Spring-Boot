import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import Navbar from './Components/Navbar';
import RegisterForm from './Components/Seller/RegisterForm';
import SellerList from './Components/Seller/SellerList';

function App() {
  return (
    <>
      <Navbar />
      <BrowserRouter>
        <Routes>
          <Route path="/sellerregister" element={<RegisterForm />} />
          <Route path="/sellerlist" element={<SellerList />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
