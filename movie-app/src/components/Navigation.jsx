import { Container, Nav, Navbar } from 'react-bootstrap';

const Navigation = () => {
  return (
    <>
      <Navbar bg="dark" data-bs-theme="dark">
        <Container>
          <Navbar.Brand to="/">Navbar</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link to="/list">Movie List</Nav.Link>
            <Nav.Link to="/add">Add Movie</Nav.Link>
            <Nav.Link to="/update">Update Movie</Nav.Link>
            <Nav.Link to="/delete">Delete Movie</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
    </>
  );
};

export default Navigation;
