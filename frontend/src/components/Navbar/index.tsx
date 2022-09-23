import './styles.css';
import { NavLink } from 'react-router-dom';

function Navbar() {
  return (
    <>
      <nav className="nav-container">
        <div className="container-fluid nav-main">
          <h1 className="nav-title">Breakfast Group</h1>
          <ul className="menu-nav-items">
            <li>
              <NavLink to="/">Home</NavLink>
            </li>
            <li>
              <NavLink to="/participantes">Participantes</NavLink>
            </li>
          </ul>
        </div>
      </nav>
    </>
  );
}

export default Navbar;
