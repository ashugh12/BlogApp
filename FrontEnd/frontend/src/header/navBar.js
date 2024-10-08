import React from 'react';
import './Navbar.css';  // Import the CSS file for styling

const NavBar = () => {
  return (
      <div className='navbar'>
        <ul className="nav-list">
        <li className="nav-item"><a href="/">Home</a></li>
        <li className="nav-item"><a href="/form">Create Post</a></li>
        <li className="nav-item"><a href="/posts">All Posts</a></li>
        <li className="nav-item username">Ashutosh Mishra</li> {/* Example username */}
      </ul>
      </div>
  );
}

export default NavBar;

{/* <nav style={{ width:"50%", padding: '10px', backgroundColor: '#eee', display: 'flex', justifyContent:'space-around'}}>
      <Link to="/">Home</Link>
      <Link to="/form">Create Post</Link>
      <Link to="/posts">Posts List</Link>
      <Link to="/preview">Preview</Link>
    </nav> */}
