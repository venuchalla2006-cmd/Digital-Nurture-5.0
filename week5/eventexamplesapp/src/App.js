import React from 'react';
import Counter from './Components/Counter';
import CurrencyConvertor from './Components/CurrencyConvertor';

function App() {
  return (
    <div style={{ fontFamily: 'Arial, sans-serif', maxWidth: '600px', margin: '20px auto', padding: '20px' }}>
      <h1 style={{ textAlign: 'center', color: '#1e293b' }}>React Event Examples Portal</h1>
      <Counter />
      <CurrencyConvertor />
    </div>
  );
}

export default App;
