import { Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import Home from './pages/Home';
import RecordList from './pages/RecordList';

function RoutesApp() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="record" element={<RecordList />} />
      </Routes>
    </>
  );
}

export default RoutesApp;
