import React, { useState } from 'react';
import ListofPlayers from './Components/ListofPlayers';
import IndianPlayers from './Components/IndianPlayers';

function App() {
  // Use state to manage the flag variable dynamically
  const [flag, setFlag] = useState(true);

  return (
    <div style={{ fontFamily: 'Arial, sans-serif', maxWidth: '600px', margin: '20px auto', padding: '20px', border: '1px solid #ddd', borderRadius: '10px', boxShadow: '0 4px 8px rgba(0,0,0,0.05)' }}>
      <h1 style={{ textAlign: 'center', color: '#333' }}>Cricket App Dashboard</h1>
      
      <div style={{ textAlign: 'center', marginBottom: '20px' }}>
        <button 
          onClick={() => setFlag(!flag)} 
          style={{ padding: '10px 20px', fontSize: '16px', backgroundColor: '#3b82f6', color: 'white', border: 'none', borderRadius: '5px', cursor: 'pointer', transition: 'background-color 0.2s' }}
          onMouseOver={(e) => e.target.style.backgroundColor = '#2563eb'}
          onMouseOut={(e) => e.target.style.backgroundColor = '#3b82f6'}
        >
          Toggle Component View (Current Flag: {flag.toString()})
        </button>
      </div>

      {flag ? <ListofPlayers /> : <IndianPlayers />}
    </div>
  );
}

export default App;
