import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faHouse,
  faAddressCard,
  faSignIn,
} from "@fortawesome/free-solid-svg-icons";
const Nav = () => {
  return (
    <nav className="Nav">
      <Link to="/" className="Nav">
        <FontAwesomeIcon icon={faHouse} />
        <span> </span>
        Home
      </Link>
      <Link to="/registershop" className="Nav">
        <FontAwesomeIcon icon={faAddressCard} />
        <span> </span>Register
      </Link>
      <Link to="/login" className="Nav">
        <FontAwesomeIcon icon={faSignIn} />
        <span> </span>Login
      </Link>
    </nav>
  );
};

export default Nav;
