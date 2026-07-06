import React from 'react';

function App() {
  const offices = [
    { id: 1, name: 'DBS Office Space', rent: 75000, address: 'Tech Park, Block A, Bangalore', image: 'https://images.unsplash.com/photo-1497366216548-37526070297c?auto=format&fit=crop&w=400&q=80' },
    { id: 2, name: 'Regus Shared Space', rent: 45000, address: 'Nungambakkam High Rd, Chennai', image: 'https://images.unsplash.com/photo-1497215728101-856f4ea42174?auto=format&fit=crop&w=400&q=80' },
    { id: 3, name: 'WeWork Premium Cabin', rent: 90000, address: 'DLF CyberCity, Phase III, Gurgaon', image: 'https://images.unsplash.com/photo-1497366811353-6870744d04b2?auto=format&fit=crop&w=400&q=80' },
    { id: 4, name: 'Co-wrk Budget Space', rent: 55000, address: 'Salt Lake Sector V, Kolkata', image: 'https://images.unsplash.com/photo-1524758631624-e2822e304c36?auto=format&fit=crop&w=400&q=80' }
  ];

  return (
    <div style={{ fontFamily: 'Arial, sans-serif', maxWidth: '800px', margin: '20px auto', padding: '20px', backgroundColor: '#fdfdfd' }}>
      <h1 style={{ textAlign: 'center', color: '#2c3e50', borderBottom: '3px solid #34495e', paddingBottom: '15px' }}>
        Office Space Rental Portal
      </h1>
      
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(300px, 1fr))', gap: '20px', marginTop: '20px' }}>
        {offices.map(office => (
          <div key={office.id} style={{ border: '1px solid #e2e8f0', borderRadius: '8px', overflow: 'hidden', boxShadow: '0 4px 6px rgba(0,0,0,0.05)', backgroundColor: '#ffffff' }}>
            <img 
              src={office.image} 
              alt={office.name} 
              style={{ width: '100%', height: '200px', objectFit: 'cover' }} 
            />
            <div style={{ padding: '15px' }}>
              <h3 style={{ margin: '0 0 10px 0', color: '#1a202c' }}>{office.name}</h3>
              <p style={{ margin: '0 0 10px 0', color: '#718096', fontSize: '14px' }}>
                <strong>Address:</strong> {office.address}
              </p>
              <p style={{ margin: '0', fontSize: '18px', fontWeight: 'bold' }}>
                Rent: <span style={{ color: office.rent > 60000 ? 'green' : 'red' }}>
                  ₹{office.rent.toLocaleString()} / month
                </span>
              </p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
