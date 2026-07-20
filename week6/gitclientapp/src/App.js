import React, { useState } from 'react';
import GitClient from './GitClient';

function App() {
  const [username, setUsername] = useState('techiesyed');
  const [repos, setRepos] = useState([]);
  const [loading, setLoading] = useState(false);

  const gitClient = new GitClient();

  const handleFetch = async () => {
    setLoading(true);
    const repoNames = await gitClient.getRepositories(username);
    setRepos(repoNames);
    setLoading(false);
  };

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h2>GitHub Repositories Fetcher</h2>
      <div style={{ marginBottom: '15px' }}>
        <input 
          type="text" 
          value={username} 
          onChange={(e) => setUsername(e.target.value)} 
          style={{ padding: '8px', marginRight: '10px' }}
        />
        <button onClick={handleFetch} style={{ padding: '8px 16px', cursor: 'pointer' }}>Fetch Repositories</button>
      </div>
      {loading ? <p>Loading...</p> : (
        <ul>
          {repos.map((repo, idx) => <li key={idx}>{repo}</li>)}
        </ul>
      )}
    </div>
  );
}

export default App;
