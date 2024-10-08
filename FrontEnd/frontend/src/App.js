
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import './App.css';
import FormContainer from './components/FormContainer';
import Navbar from './header/navBar';
import Preview from './components/Preview';
import PostList from './components/PostList';
import HomePage from './components/Homepage';
function App() {
  return (
    <div className="App">
      <Router>
      <div>
        {/* Navbar component */}
        <Navbar />

        {/* Routes to handle different pages */}
        <Routes>
          <Route path="/" element={<HomePage />} /> {/* Home Page */}
          <Route path="/form" element={<FormContainer />} /> {/* Form Page */}
          <Route path="/posts" element={<PostList />} /> {/* Posts List Page */}
          <Route path="/preview" element={<Preview />} /> {/* Preview Page */}
        </Routes>
      </div>
    </Router>
    </div>
  );
}

export default App;
