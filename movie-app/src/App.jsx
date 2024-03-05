import { Route, Routes} from "react-router-dom";
import './App.css'
import Home from "./components/Home";
import MovieAdd from "./components/MovieAdd";
import MovieDelete from "./components/MovieDelete";
import MovieList from "./components/MovieList";
import MovieUpdate from "./components/MovieUpdate";
import Navigation from "./components/Navigation";


const App = () => {
  return (
    <div style={{ display: 'flex', flexDirection: 'column', minHeight: '100vh' }}>
      <Navigation />

      <div style={{ flex: 1, padding: '20px' }}>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/add" element={<MovieAdd />} />
          <Route path="/delete" element={<MovieDelete />} />
          <Route path="/list" element={<MovieList />} />
          <Route path="/update" element={<MovieUpdate />} />
        </Routes>
      </div>
    </div>
  );
};

export default App;
