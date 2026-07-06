import React from 'react';
import Posts from './Posts';

function App() {
  return (
    <div style={{ fontFamily: 'Arial, sans-serif', maxWidth: '800px', margin: '20px auto', padding: '20px' }}>
      <h1 style={{ textAlign: 'center', color: '#2c3e50' }}>Cohort Blog Dashboard</h1>
      <Posts />
    </div>
  );
}

export default App;
