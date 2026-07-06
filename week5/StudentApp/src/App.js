import React, { Component } from 'react';
import Home from './Components/Home';
import About from './Components/About';
import Contact from './Components/Contact';

class App extends Component {
  render() {
    return (
      <div style={{ fontFamily: 'Arial, sans-serif', maxWidth: '600px', margin: '20px auto', padding: '20px', border: '1px solid #ccc', borderRadius: '10px' }}>
        <h1 style={{ textAlign: 'center', color: '#1a73e8' }}>Student Management Portal</h1>
        <Home />
        <About />
        <Contact />
      </div>
    );
  }
}

export default App;
