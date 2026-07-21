function OfficeSpaces() {
  const officeSpaces = [
    {
      id: 1,
      name: 'Downtown Office',
      rent: '$2500/month',
      address: '123 Main St, NYC',
      image: 'https://via.placeholder.com/300x200?text=Downtown+Office'
    },
    {
      id: 2,
      name: 'Tech Park Office',
      rent: '$3000/month',
      address: '456 Tech Ave, Silicon Valley',
      image: 'https://via.placeholder.com/300x200?text=Tech+Park'
    },
    {
      id: 3,
      name: 'Startup Hub',
      rent: '$1800/month',
      address: '789 Innovation Blvd, Austin',
      image: 'https://via.placeholder.com/300x200?text=Startup+Hub'
    },
    {
      id: 4,
      name: 'Premium Suite',
      rent: '$4000/month',
      address: '101 Luxury Lane, Miami',
      image: 'https://via.placeholder.com/300x200?text=Premium+Suite'
    }
  ];

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial', backgroundColor: '#f5f5f5', minHeight: '100vh' }}>
      <h1 style={{ textAlign: 'center', color: '#333' }}>Office Space Rental</h1>
      <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(300px, 1fr))', gap: '20px' }}>
        {/* Loop through office spaces using map() */}
        {officeSpaces.map((office) => (
          <div key={office.id} style={{
            border: '1px solid #ddd',
            borderRadius: '8px',
            padding: '15px',
            backgroundColor: 'white',
            boxShadow: '0 2px 8px rgba(0,0,0,0.1)'
          }}>
            <img 
              src={office.image} 
              alt={office.name}
              style={{ width: '100%', borderRadius: '6px', marginBottom: '10px' }}
            />
            <h2 style={{ color: '#007bff', margin: '10px 0' }}>{office.name}</h2>
            <p><strong>Rent:</strong> {office.rent}</p>
            <p><strong>Address:</strong> {office.address}</p>
            <button style={{
              backgroundColor: '#007bff',
              color: 'white',
              border: 'none',
              padding: '10px 20px',
              borderRadius: '4px',
              cursor: 'pointer',
              width: '100%'
            }}>
              Book Now
            </button>
          </div>
        ))}
      </div>
    </div>
  );
}

export default OfficeSpaces;