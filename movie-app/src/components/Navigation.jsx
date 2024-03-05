import { Container, Nav, Navbar } from 'react-bootstrap';
import { Link } from 'react-router-dom'; 
const Navigation = () => {
  return (
    <>
      <Navbar bg="dark" variant="dark" fixed="top">
        <Container>
          <Navbar.Brand as={Link} to="/">Movie Box</Navbar.Brand>
          <Nav className="nav-fill">
            <Nav.Link as={Link} to="/list">Movie List</Nav.Link>
            <Nav.Link as={Link} to="/add">Add Movie</Nav.Link>
            <Nav.Link as={Link} to="/update">Update Movie</Nav.Link>
            <Nav.Link as={Link} to="/delete">Delete Movie</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
    </>
  );
};

export default Navigation;
