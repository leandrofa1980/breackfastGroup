import './styles.css';

function Navbar() {
  return (
    <>
      <nav className="nav-container">
        <div className="container-fluid nav-main">
          <h1 className="nav-title">Breakfast Group</h1>
          <ul className="menu-nav-items">
            <li>
              <a className="esconder" href="/">
                Home
              </a>
            </li>
            <li>
              <a href="/participantes">Participantes</a>
            </li>
          </ul>
        </div>
      </nav>
    </>
  );
}

export default Navbar;
