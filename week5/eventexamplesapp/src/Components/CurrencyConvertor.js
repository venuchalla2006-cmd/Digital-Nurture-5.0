import React, { useState } from 'react';

function CurrencyConvertor() {
  const [rupees, setRupees] = useState('');
  const [euros, setEuros] = useState(null);

  const handleSubmit = (e) => {
    e.preventDefault();
    const parsedRupees = parseFloat(rupees);
    if (!isNaN(parsedRupees) && parsedRupees >= 0) {
      // Conversion rate: 1 Euro = 90 INR (approx)
      const converted = (parsedRupees / 90).toFixed(2);
      setEuros(converted);
    } else {
      alert("Please enter a valid numeric amount for Rupees.");
      setEuros(null);
    }
  };

  return (
    <div style={{ padding: '15px', border: '1px solid #e2e8f0', borderRadius: '8px', backgroundColor: '#ecfdf5' }}>
      <h2 style={{ color: '#047857' }}>Currency Converter (INR to EUR)</h2>
      
      <form onSubmit={handleSubmit} style={{ marginTop: '10px' }}>
        <div style={{ marginBottom: '10px' }}>
          <label style={{ display: 'block', marginBottom: '5px', fontWeight: 'bold' }}>
            Amount in Indian Rupees (₹):
          </label>
          <input 
            type="number" 
            value={rupees} 
            onChange={(e) => setRupees(e.target.value)} 
            placeholder="Enter INR amount" 
            style={{ width: '100%', padding: '8px', boxSizing: 'border-box', border: '1px solid #ccc', borderRadius: '4px' }}
          />
        </div>

        <button 
          type="submit" 
          style={{ padding: '8px 15px', backgroundColor: '#047857', color: 'white', border: 'none', borderRadius: '4px', cursor: 'pointer' }}
        >
          Convert
        </button>
      </form>

      {euros !== null && (
        <div style={{ marginTop: '15px', padding: '10px', backgroundColor: '#ffffff', border: '1px dashed #047857', borderRadius: '4px', textAlign: 'center' }}>
          <h4 style={{ margin: '0 0 5px 0', color: '#065f46' }}>Conversion Result:</h4>
          <p style={{ margin: '0', fontSize: '18px', fontWeight: 'bold' }}>
            ₹{parseFloat(rupees).toLocaleString()} INR = €{euros} EUR
          </p>
        </div>
      )}
    </div>
  );
}

export default CurrencyConvertor;
