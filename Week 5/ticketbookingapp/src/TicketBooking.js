import React from 'react';

class TicketBooking extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isLoggedIn: false
    };
  }

  handleLogin = () => {
    this.setState({ isLoggedIn: true });
  }

  handleLogout = () => {
    this.setState({ isLoggedIn: false });
  }

  render() {
    const { isLoggedIn } = this.state;

    const containerStyle = {
      padding: '40px',
      fontFamily: 'Arial',
      textAlign: 'center',
      minHeight: '100vh',
      backgroundColor: isLoggedIn ? '#e8f5e9' : '#f5f5f5'
    };

    const buttonStyle = {
      padding: '12px 24px',
      margin: '10px',
      fontSize: '1rem',
      cursor: 'pointer',
      borderRadius: '4px',
      border: 'none',
      color: 'white'
    };

    const loginButtonStyle = { ...buttonStyle, backgroundColor: '#4CAF50' };
    const logoutButtonStyle = { ...buttonStyle, backgroundColor: '#f44336' };

    return (
      <div style={containerStyle}>
        {/* Navigation */}
        <div style={{ marginBottom: '30px' }}>
          {!isLoggedIn && (
            <button onClick={this.handleLogin} style={loginButtonStyle}>
              🔓 Login
            </button>
          )}
          {isLoggedIn && (
            <button onClick={this.handleLogout} style={logoutButtonStyle}>
              🔒 Logout
            </button>
          )}
        </div>

        {/* Conditional Content - Guest User */}
        {!isLoggedIn && (
          <div style={{
            backgroundColor: 'white',
            padding: '40px',
            borderRadius: '8px',
            maxWidth: '600px',
            margin: '0 auto',
            boxShadow: '0 2px 8px rgba(0,0,0,0.1)'
          }}>
            <h1>🎫 Welcome to Ticket Booking</h1>
            <p style={{ fontSize: '1.2rem', color: '#666' }}>Guest User</p>
            <div style={{
              backgroundColor: '#fff3cd',
              padding: '20px',
              borderRadius: '4px',
              marginTop: '20px',
              border: '1px solid #ffc107'
            }}>
              <h2>Available Flights</h2>
              <p><strong>Flight 101:</strong> NYC → LA - $299</p>
              <p><strong>Flight 202:</strong> NYC → Miami - $199</p>
              <p style={{ color: '#d32f2f', marginTop: '20px' }}>
                👉 Please login to book tickets
              </p>
            </div>
          </div>
        )}

        {/* Conditional Content - Logged-in User */}
        {isLoggedIn && (
          <div style={{
            backgroundColor: 'white',
            padding: '40px',
            borderRadius: '8px',
            maxWidth: '600px',
            margin: '0 auto',
            boxShadow: '0 2px 8px rgba(0,0,0,0.1)'
          }}>
            <h1>🎫 Ticket Booking Portal</h1>
            <p style={{ fontSize: '1.2rem', color: '#2e7d32' }}>✅ Logged In User</p>
            <div style={{
              backgroundColor: '#c8e6c9',
              padding: '20px',
              borderRadius: '4px',
              marginTop: '20px',
              border: '1px solid #4CAF50'
            }}>
              <h2>Book Your Flight</h2>
              <div style={{ margin: '15px 0' }}>
                <div style={{
                  backgroundColor: '#fff',
                  padding: '15px',
                  marginBottom: '10px',
                  borderRadius: '4px'
                }}>
                  <p><strong>✈️ Flight 101:</strong> NYC → LA - $299</p>
                  <button style={{
                    backgroundColor: '#2196F3',
                    color: 'white',
                    border: 'none',
                    padding: '8px 16px',
                    borderRadius: '4px',
                    cursor: 'pointer'
                  }}>
                    Book Now
                  </button>
                </div>
                <div style={{
                  backgroundColor: '#fff',
                  padding: '15px',
                  marginBottom: '10px',
                  borderRadius: '4px'
                }}>
                  <p><strong>✈️ Flight 202:</strong> NYC → Miami - $199</p>
                  <button style={{
                    backgroundColor: '#2196F3',
                    color: 'white',
                    border: 'none',
                    padding: '8px 16px',
                    borderRadius: '4px',
                    cursor: 'pointer'
                  }}>
                    Book Now
                  </button>
                </div>
              </div>
              <p style={{ color: '#2e7d32', marginTop: '20px' }}>
                🎉 You can now book tickets!
              </p>
            </div>
          </div>
        )}
      </div>
    );
  }
}

export default TicketBooking;