import { Route, Routes} from "react-router-dom";
import './App.css'
import Home from "./components/Home";
import MovieAdd from "./components/MovieAdd";
import MovieDelete from "./components/MovieDelete";
import MovieList from "./components/MovieList";
import MovieUpdate from "./components/MovieUpdate";
import Navigation from "./components/Navigation";


function App() {

  return (
    <div>
      <Navigation />
      <Routes>
        <Route path="/" element={<Home />}/>
        <Route path="/add" element={<MovieAdd />}/>
        <Route path="/delete" element={<MovieDelete />}/>
        <Route path="/list" element={<MovieList />}/>
        <Route path="/update" element={<MovieUpdate />}/>
      </Routes>
    </div>
  )
}

export default App;
