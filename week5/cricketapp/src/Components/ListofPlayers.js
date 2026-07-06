import React from 'react';

function ListofPlayers() {
  const players = [
    { name: 'Sachin Tendulkar', score: 95 },
    { name: 'Rahul Dravid', score: 85 },
    { name: 'Sourav Ganguly', score: 65 },
    { name: 'VVS Laxman', score: 72 },
    { name: 'Virender Sehwag', score: 110 },
    { name: 'MS Dhoni', score: 58 },
    { name: 'Yuvraj Singh', score: 45 },
    { name: 'Zaheer Khan', score: 25 },
    { name: 'Harbhajan Singh', score: 35 },
    { name: 'Anil Kumble', score: 30 },
    { name: 'Javagal Srinath', score: 15 }
  ];

  // Filter players with scores below 70 using ES6 arrow function
  const filteredPlayers = players.filter(player => player.score < 70);

  return (
    <div style={{ padding: '15px', backgroundColor: '#f0fdf4', borderRadius: '8px', border: '1px solid #bbf7d0' }}>
      <h2 style={{ color: '#166534' }}>List of Players</h2>
      
      <h3>All Players and Scores:</h3>
      <ul>
        {players.map((player, idx) => (
          <li key={idx} style={{ padding: '3px 0' }}>
            {player.name} : <strong style={{ color: '#15803d' }}>{player.score}</strong>
          </li>
        ))}
      </ul>

      <h3 style={{ color: '#991b1b', marginTop: '20px' }}>Players with Scores Below 70:</h3>
      <ul>
        {filteredPlayers.map((player, idx) => (
          <li key={idx} style={{ padding: '3px 0', color: '#991b1b' }}>
            {player.name} : <strong>{player.score}</strong>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ListofPlayers;
