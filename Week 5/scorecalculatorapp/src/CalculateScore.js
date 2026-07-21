function CalculateScore(props) {
    const averageScore = (props.total / props.goal) * 100;
    return (
        <div>
            <h1>Score Calculator</h1>
            <p><strong>Name:</strong> {props.name}</p>
            <p><strong>School:</strong> {props.school}</p>
            <p><strong>Total Marks:</strong> {props.total}</p>
            <p><strong>Goal Marks:</strong> {props.goal}</p>
            <p><strong>Average Score (%):</strong> {averageScore.toFixed(2)}%</p>
        </div>
    );
}
export default CalculateScore;