import "./App.css";
import { Route, Routes } from "react-router-dom";
import Login from "./components_user/Login";
import Register from "./components_user/Register";
import Nav from "./components_user/Nav";
import Header from "./components_user/Header";
import Home from "./components_user/Home";
import Welcome from "./components_welcome/Welcome";

function App() {
  return (
    <div className="App">
      <Header />
      <Nav />
     
      {/* <Register /> */}
      <Routes>
   
        <Route path="/" element={<Home />} />
        <Route path="/registershop" element={<Register />} />
        <Route path="/welcome" element={<Welcome />} />
        <Route path="/login" element={<Login />} />
      </Routes>
    </div>
  );

}

export default App;
