import React from 'react';
import { useParams, Link } from 'react-router-dom';
import { TrainersMockData } from './TrainersMock';

function TrainerDetail() {
    const { id } = useParams();
    const trainer = TrainersMockData.find(t => t.TrainerId === parseInt(id));

    if (!trainer) {
        return (
            <div>
                <h3>Trainer Not Found</h3>
                <Link to="/trainers">Back to List</Link>
            </div>
        );
    }

    return (
        <div>
            <h3>Trainer Details</h3>
            <p><strong>ID:</strong> {trainer.TrainerId}</p>
            <p><strong>Name:</strong> {trainer.Name}</p>
            <p><strong>Email:</strong> {trainer.Email}</p>
            <p><strong>Phone:</strong> {trainer.Phone}</p>
            <p><strong>Technology:</strong> {trainer.Technology}</p>
            <p><strong>Skills:</strong> {trainer.Skills}</p>
            <Link to="/trainers">Back to List</Link>
        </div>
    );
}

export default TrainerDetail;
