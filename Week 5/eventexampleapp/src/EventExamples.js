import React from 'react';

class EventExamples extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      counter: 0
    };
  }

  // to increment counter
  handleIncrement = () => {
    this.setState({ counter: this.state.counter + 1 });
  }

  // to decrement counter
  handleDecrement = () => {
    this.setState({ counter: this.state.counter - 1 });
  }

  // show alert (multiple handler)
  sayHello = () => {
    alert('Hello! Counter is at: ' + this.state.counter);
  }

  // to reset counter
  handleReset = () => {
    this.setState({ counter: 0 });
  }

  render() {
    const { counter } = this.state;
    const buttonStyle = {
      padding: '10px 20px',
      margin: '5px',
      fontSize: '1rem',
      cursor: 'pointer',
      borderRadius: '4px',
      border: 'none',
      backgroundColor: '#007bff',
      color: 'white'
    };

    const resetButtonStyle = { ...buttonStyle, backgroundColor: '#6c757d' };
    const dangerButtonStyle = { ...buttonStyle, backgroundColor: '#dc3545' };

    return (
      <div style={{ padding: '40px', fontFamily: 'Arial', textAlign: 'center' }}>
        <h1>Event Examples App</h1>
        
        {/* Counter Display */}
        <div style={{
          fontSize: '3rem',
          fontWeight: 'bold',
          color: '#007bff',
          margin: '30px 0',
          padding: '20px',
          backgroundColor: '#f0f0f0',
          borderRadius: '8px'
        }}>
          Counter: {counter}
        </div>

        {/* Increment Button */}
        <button 
          onClick={this.handleIncrement}
          style={buttonStyle}
        >
          ➕ Increment
        </button>

        {/* Decrement Button */}
        <button 
          onClick={this.handleDecrement}
          style={dangerButtonStyle}
        >
          ➖ Decrement
        </button>

        {/* Reset Button */}
        <button 
          onClick={this.handleReset}
          style={resetButtonStyle}
        >
          🔄 Reset
        </button>

        {/* Hello Button - Multiple handlers */}
        <button 
          onClick={() => {
            this.handleIncrement();
            this.sayHello();
          }}
          style={{ ...buttonStyle, backgroundColor: '#28a745' }}
        >
          👋 Say Hello & Increment
        </button>

        {/* Counter Status */}
        <div style={{ marginTop: '30px', fontSize: '1.2rem', color: '#666' }}>
          {counter > 0 && <p>Counter is positive: {counter}</p>}
          {counter < 0 && <p>Counter is negative: {counter}</p>}
          {counter === 0 && <p>Counter is at zero</p>}
        </div>
      </div>
    );
  }
}

export default EventExamples;