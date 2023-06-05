import AdminNavBar from '../Admin/AdminNavBar';
import Navbar from '../Navbar';
// import RegisterPage from '../Seller/RegisterPage';
// import SellerList from '../Seller/SellerList';

const ROLE = 'user';

const HomePage = () => {
  return (
    <div>
      {ROLE === 'user' ? <Navbar /> : <AdminNavBar />}
      {/* <RegisterPage /> */}
      {/* <SellerList /> */}
    </div>
  );
};

export default HomePage;
