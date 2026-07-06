import React from 'react';

function IndianPlayers() {
  // Destructuring Demonstration
  const indianTeam = ['Virat Kohli', 'Rohit Sharma', 'KL Rahul', 'Mohammed Shami', 'Jasprit Bumrah', 'Ravindra Jadeja'];
  const [p1, p2, p3, p4, p5, p6] = indianTeam;

  const oddTeam = [p1, p3, p5];  // Odd indexes (1-indexed: 1st, 3rd, 5th)
  const evenTeam = [p2, p4, p6]; // Even indexes (1-indexed: 2nd, 4th, 6th)

  // Spread Operator Demonstration (Merging)
  const T20players = ['Hardik Pandya', 'Suryakumar Yadav', 'Rishabh Pant'];
  const RanjiTrophyPlayers = ['Prithvi Shaw', 'Sarfaraz Khan', 'Yashasvi Jaiswal'];
  const mergedPlayers = [...T20players, ...RanjiTrophyPlayers];

  return (
    <div style={{ padding: '15px', backgroundColor: '#eff6ff', borderRadius: '8px', border: '1px solid #bfdbfe', marginTop: '15px' }}>
      <h2 style={{ color: '#1e40af' }}>Indian Players</h2>
      
      <div style={{ display: 'flex', gap: '20px', margin: '15px 0' }}>
        <div style={{ flex: 1, padding: '10px', backgroundColor: '#ffffff', borderRadius: '6px' }}>
          <h4 style={{ color: '#1e3a8a', margin: '0 0 10px 0' }}>Odd Team Players:</h4>
          <ul>
            {oddTeam.map((p, i) => <li key={i}>{p}</li>)}
          </ul>
        </div>
        
        <div style={{ flex: 1, padding: '10px', backgroundColor: '#ffffff', borderRadius: '6px' }}>
          <h4 style={{ color: '#1e3a8a', margin: '0 0 10px 0' }}>Even Team Players:</h4>
          <ul>
            {evenTeam.map((p, i) => <li key={i}>{p}</li>)}
          </ul>
        </div>
      </div>

      <div style={{ padding: '10px', backgroundColor: '#ffffff', borderRadius: '6px' }}>
        <h4 style={{ color: '#1e3a8a', margin: '0 0 10px 0' }}>Merged Squad (T20 + Ranji Players - using Spread):</h4>
        <ul>
          {mergedPlayers.map((p, i) => <li key={i}>{p}</li>)}
        </ul>
      </div>
    </div>
  );
}

export default IndianPlayers;
