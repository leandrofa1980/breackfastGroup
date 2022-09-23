import { Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Navbar from './components/Navbar';
import RecordList from './pages/RecordList';

function RoutesApp() {
  return (
    <>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/participantes" element={<RecordList />} />
      </Routes>
    </>
  );
}

export default RoutesApp;
