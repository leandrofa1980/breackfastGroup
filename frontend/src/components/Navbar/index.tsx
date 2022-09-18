import './styles.css';

function Navbar() {
  return (
    <>
      <header className="nav-container">
        <nav className="nav-main">
          <h1 className="nav-title">Breakfast Group</h1>
          <ul className="menu-nav-items">
            <li>
              <a className="esconder" href="/">
                Home
              </a>
            </li>
            <li>
              <a href="/record">Participantes</a>
            </li>
          </ul>
        </nav>
      </header>
    </>
  );
}

export default Navbar;
