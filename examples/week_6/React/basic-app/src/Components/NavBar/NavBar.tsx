import { Link } from "react-router-dom"

function NavBar() {
  return (
    <nav className="navbar navbar-expand-lg bg-body-tertiary">
  <div className="container-fluid">
    <Link className="navbar-brand" to="/">Home</Link>
    <div className="navbar-nav">
        <Link className="nav-link" to="/events">Events</Link>
        <Link className="nav-link" to="/lists">Lists</Link>
        <Link className="nav-link" to="/parent">Parent</Link>
        <Link className="nav-link" to="/hooks">Hooks</Link>
        <Link className="nav-link" to="/poke">Pokemon</Link>
    </div>
  </div>
</nav>
  )
}

export default NavBar