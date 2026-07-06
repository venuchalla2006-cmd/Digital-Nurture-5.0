import React, { useState } from 'react';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [bookingStatus, setBookingStatus] = useState('');

  const flights = [
    { id: 1, flightNo: 'AI-101', source: 'Delhi (DEL)', destination: 'Mumbai (BOM)', time: '08:00 AM', fare: 5500 },
    { id: 2, flightNo: '6E-304', source: 'Bangalore (BLR)', destination: 'Chennai (MAA)', time: '11:30 AM', fare: 3200 },
    { id: 3, flightNo: 'UK-809', source: 'Kolkata (CCU)', destination: 'Delhi (DEL)', time: '04:15 PM', fare: 6700 }
  ];

  const handleBooking = (flightNo) => {
    setBookingStatus(`Ticket successfully booked for Flight ${flightNo}!`);
  };

  return (
    <div style={{ fontFamily: 'Arial, sans-serif', maxWidth: '700px', margin: '20px auto', padding: '20px', border: '1px solid #e2e8f0', borderRadius: '10px', boxShadow: '0 4px 6px rgba(0,0,0,0.05)' }}>
      {/* Header and Toggle Button */}
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', borderBottom: '2px solid #3b82f6', paddingBottom: '10px', marginBottom: '20px' }}>
        <h1 style={{ margin: 0, fontSize: '24px', color: '#1e3a8a' }}>AeroBook Ticket Portal</h1>
        
        {isLoggedIn ? (
          <button 
            onClick={() => { setIsLoggedIn(false); setBookingStatus(''); }} 
            style={{ padding: '8px 15px', backgroundColor: '#ef4444', color: 'white', border: 'none', borderRadius: '4px', cursor: 'pointer' }}
          >
            Logout
          </button>
        ) : (
          <button 
            onClick={() => setIsLoggedIn(true)} 
            style={{ padding: '8px 15px', backgroundColor: '#10b981', color: 'white', border: 'none', borderRadius: '4px', cursor: 'pointer' }}
          >
            Login
          </button>
        )}
      </div>

      {/* Conditional Messages */}
      {isLoggedIn ? (
        <div style={{ padding: '10px', backgroundColor: '#d1fae5', border: '1px solid #10b981', borderRadius: '5px', marginBottom: '20px', color: '#065f46' }}>
          <h4>Welcome back, User! You now have booking access enabled.</h4>
        </div>
      ) : (
        <div style={{ padding: '10px', backgroundColor: '#fee2e2', border: '1px solid #ef4444', borderRadius: '5px', marginBottom: '20px', color: '#991b1b' }}>
          <h4>Guest Mode: You can browse flights. Please login to book tickets.</h4>
        </div>
      )}

      {/* Flight Search / Browse (Available to all) */}
      <h3 style={{ color: '#2563eb' }}>Available Flights</h3>
      <table style={{ width: '100%', borderCollapse: 'collapse', marginTop: '10px', marginBottom: '25px' }}>
        <thead>
          <tr style={{ backgroundColor: '#f1f5f9', borderBottom: '2px solid #cbd5e1' }}>
            <th style={{ padding: '10px', textAlign: 'left' }}>Flight No</th>
            <th style={{ padding: '10px', textAlign: 'left' }}>Route</th>
            <th style={{ padding: '10px', textAlign: 'left' }}>Time</th>
            <th style={{ padding: '10px', textAlign: 'left' }}>Fare</th>
            <th style={{ padding: '10px', textAlign: 'center' }}>Action</th>
          </tr>
        </thead>
        <tbody>
          {flights.map(flight => (
            <tr key={flight.id} style={{ borderBottom: '1px solid #e2e8f0' }}>
              <td style={{ padding: '10px' }}>{flight.flightNo}</td>
              <td style={{ padding: '10px' }}>{flight.source} → {flight.destination}</td>
              <td style={{ padding: '10px' }}>{flight.time}</td>
              <td style={{ padding: '10px' }}>₹{flight.fare}</td>
              <td style={{ padding: '10px', textAlign: 'center' }}>
                {isLoggedIn ? (
                  <button 
                    onClick={() => handleBooking(flight.flightNo)}
                    style={{ padding: '5px 10px', backgroundColor: '#2563eb', color: 'white', border: 'none', borderRadius: '4px', cursor: 'pointer' }}
                  >
                    Book Now
                  </button>
                ) : (
                  <button 
                    disabled 
                    style={{ padding: '5px 10px', backgroundColor: '#94a3b8', color: '#cbd5e1', border: 'none', borderRadius: '4px', cursor: 'not-allowed' }}
                  >
                    Login to Book
                  </button>
                )}
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {/* Booking Alert / Confirmation */}
      {bookingStatus && (
        <div style={{ padding: '15px', backgroundColor: '#eff6ff', border: '1px dashed #2563eb', borderRadius: '6px', textAlign: 'center', color: '#1e40af', fontWeight: 'bold' }}>
          {bookingStatus}
        </div>
      )}
    </div>
  );
}

export default App;
