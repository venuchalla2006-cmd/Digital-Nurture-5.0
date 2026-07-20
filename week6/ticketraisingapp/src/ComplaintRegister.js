import React, { useState } from 'react';

function ComplaintRegister() {
    const [employeeName, setEmployeeName] = useState('');
    const [complaint, setComplaint] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        if (!employeeName.trim() || !complaint.trim()) {
            alert('Please fill in all fields');
            return;
        }
        const refNumber = Math.floor(Math.random() * 900000) + 100000;
        alert(`Thanks ${employeeName}!\nYour complaint has been registered.\nReference Number: ${refNumber}`);
        setEmployeeName('');
        setComplaint('');
    };

    return (
        <div style={{ padding: '20px', fontFamily: 'Arial', maxWidth: '400px' }}>
            <h2>Complaint Register</h2>
            <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', gap: '15px' }}>
                <div>
                    <label style={{ display: 'block', marginBottom: '5px' }}>Employee Name:</label>
                    <input 
                        type="text" 
                        value={employeeName} 
                        onChange={(e) => setEmployeeName(e.target.value)} 
                        style={{ width: '100%', padding: '8px', boxSizing: 'border-box' }}
                        required
                    />
                </div>
                <div>
                    <label style={{ display: 'block', marginBottom: '5px' }}>Complaint:</label>
                    <textarea 
                        value={complaint} 
                        onChange={(e) => setComplaint(e.target.value)} 
                        style={{ width: '100%', padding: '8px', boxSizing: 'border-box', height: '100px' }}
                        required
                    />
                </div>
                <button type="submit" style={{ padding: '10px', cursor: 'pointer', backgroundColor: '#007bff', color: '#fff', border: 'none', borderRadius: '4px' }}>
                    Submit Complaint
                </button>
            </form>
        </div>
    );
}

export default ComplaintRegister;
