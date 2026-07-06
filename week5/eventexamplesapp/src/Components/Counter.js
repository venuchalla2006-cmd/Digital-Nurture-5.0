import React, { useState } from 'react';

function Counter() {
  const [count, setCount] = useState(0);
  const [msg, setMsg] = useState('');

  // Increment invokes multiple methods (Hands-on step 20-22)
  const handleIncrement = () => {
    incrementCount();
    sayHelloMessage();
  };

  const incrementCount = () => {
    setCount(prev => prev + 1);
  };

  const sayHelloMessage = () => {
    setMsg("Hello! You just incremented the counter.");
  };

  const handleDecrement = () => {
    setCount(prev => prev - 1);
    setMsg("Counter decremented.");
  };

  // Takes welcome as parameter (Hands-on step 23)
  const handleSayWelcome = (welcomeText) => {
    alert("Welcome button says: " + welcomeText);
  };

  // Synthetic event handler (Hands-on step 24)
  const handleSyntheticPress = (e) => {
    alert("Synthetic Press: " + e.type + " event. Message: I was clicked!");
  };

  return (
    <div style={{ padding: '15px', border: '1px solid #e2e8f0', borderRadius: '8px', backgroundColor: '#fdf2f8', marginBottom: '20px' }}>
      <h2 style={{ color: '#be185d' }}>Event Counter Component</h2>
      
      <p style={{ fontSize: '18px' }}>Counter Value: <strong>{count}</strong></p>
      {msg && <p style={{ color: '#db2777', fontStyle: 'italic' }}>{msg}</p>}

      <div style={{ display: 'flex', gap: '10px', flexWrap: 'wrap', marginTop: '10px' }}>
        <button 
          onClick={handleIncrement} 
          style={{ padding: '8px 15px', backgroundColor: '#be185d', color: 'white', border: 'none', borderRadius: '4px', cursor: 'pointer' }}
        >
          Increment (Multi-method)
        </button>

        <button 
          onClick={handleDecrement} 
          style={{ padding: '8px 15px', backgroundColor: '#475569', color: 'white', border: 'none', borderRadius: '4px', cursor: 'pointer' }}
        >
          Decrement
        </button>

        <button 
          onClick={() => handleSayWelcome("Welcome to our portal")} 
          style={{ padding: '8px 15px', backgroundColor: '#2563eb', color: 'white', border: 'none', borderRadius: '4px', cursor: 'pointer' }}
        >
          Say Welcome
        </button>

        <button 
          onClick={handleSyntheticPress} 
          style={{ padding: '8px 15px', backgroundColor: '#059669', color: 'white', border: 'none', borderRadius: '4px', cursor: 'pointer' }}
        >
          Synthetic OnPress
        </button>
      </div>
    </div>
  );
}

export default Counter;
