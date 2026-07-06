import React from 'react';
import '../Stylesheets/mystyle.css';

// Functional component using ES6 destructuring for props
const CalculateScore = ({ Name, School, Total, Goal }) => {
    // Assuming a max score of 500 (5 subjects of 100 marks each) to calculate average
    const average = (Total / 5).toFixed(2);
    
    return (
        <div className="score-container">
            <h2 className="score-title">Student Score Details</h2>
            <div className="student-info">
                <p>Name: <span>{Name}</span></p>
                <p>School: <span>{School}</span></p>
                <p>Total Marks: <span>{Total}</span></p>
                <p>Goal Marks: <span>{Goal}</span></p>
            </div>
            <div className="average-score">
                Average Score: {average} / 100
            </div>
        </div>
    );
};

export default CalculateScore;
