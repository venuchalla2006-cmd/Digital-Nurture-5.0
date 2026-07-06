import React from 'react';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div style={{ padding: '20px' }}>
      <h1 style={{ textAlign: 'center', color: '#2c3e50' }}>Score Calculator Portal</h1>
      <CalculateScore 
        Name="John Doe" 
        School="St. Xavier High School" 
        Total={425} 
        Goal={450} 
      />
    </div>
  );
}

export default App;
