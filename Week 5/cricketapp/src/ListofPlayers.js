function ListofPlayers() {
  const players = [
    { id: 1, name: 'Virat Kohli', score: 95 },
    { id: 2, name: 'Rohit Sharma', score: 88 },
    { id: 3, name: 'MS Dhoni', score: 92 },
    { id: 4, name: 'Shikhar Dhawan', score: 85 },
    { id: 5, name: 'Hardik Pandya', score: 78 },
    { id: 6, name: 'KL Rahul', score: 82 },
    { id: 7, name: 'Rishabh Pant', score: 76 },
    { id: 8, name: 'Yuzvendra Chahal', score: 45 },
    { id: 9, name: 'Bumrah', score: 38 },
    { id: 10, name: 'Ravindra Jadeja', score: 55 },
    { id: 11, name: 'Siraj', score: 42 }
  ];

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>Cricket Team Players</h1>
      <table style={{ borderCollapse: 'collapse', width: '100%' }}>
        <thead>
          <tr style={{ backgroundColor: '#007bff', color: 'white' }}>
            <th style={{ border: '1px solid #ddd', padding: '10px' }}>ID</th>
            <th style={{ border: '1px solid #ddd', padding: '10px' }}>Player Name</th>
            <th style={{ border: '1px solid #ddd', padding: '10px' }}>Score</th>
          </tr>
        </thead>
        <tbody>
          {}
          {players.map(({ id, name, score }) => (
            <tr key={id}>
              <td style={{ border: '1px solid #ddd', padding: '10px' }}>{id}</td>
              <td style={{ border: '1px solid #ddd', padding: '10px' }}>{name}</td>
              <td style={{ border: '1px solid #ddd', padding: '10px' }}>{score}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <p style={{ marginTop: '20px', fontSize: '1.1rem' }}>
        <strong>Total Players: {players.length}</strong>
      </p>
    </div>
  );
}

export default ListofPlayers;