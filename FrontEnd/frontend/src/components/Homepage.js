import React, { useEffect, useRef } from 'react';
import Typed from 'typed.js';
import './HomePage.css'; // Make sure to create this CSS file for background styles

const HomePage = () => {
  const el = useRef(null); // Create a ref to attach to the Typed.js element

  useEffect(() => {
    const options = {
      strings: ['Welcome to the Blog App'],
      typeSpeed: 50,
      backSpeed: 25,
      loop: true,
    };

    const typed = new Typed(el.current, options);

    return () => {
      typed.destroy(); // Clean up on unmount
    };
  }, []);

  return (
    <div className="homepage">
      <div className="content">
        <h1 ref={el}></h1>
      </div>
    </div>
  );
};

export default HomePage;
