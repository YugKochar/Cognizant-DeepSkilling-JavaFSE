import './App.css';
import CalculateScore from './CalculateScore';

function App() {
  return (
    <div className="App">
      <CalculateScore 
        name="John Doe" 
        school="ABC School" 
        total={450} 
        goal={500} 
      />
      <hr />
      <CalculateScore 
        name="Jane Smith" 
        school="XYZ Academy" 
        total={480} 
        goal={500} 
      />
      <hr />
      <CalculateScore 
        name="Mike Johnson" 
        school="DEF Institute" 
        total={400} 
        goal={500} 
      />
    </div>
  );
}

export default App;