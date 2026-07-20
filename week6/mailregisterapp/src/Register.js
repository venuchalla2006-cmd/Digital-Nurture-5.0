import React, { useState } from 'react';

function Register() {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [errors, setErrors] = useState({});

    const validate = () => {
        let tempErrors = {};
        if (name.length < 5) {
            tempErrors.name = 'Name should have atleast 5 characters';
        }
        if (!email.includes('@') || !email.includes('.')) {
            tempErrors.email = 'Email should have @ and .';
        }
        if (password.length < 8) {
            tempErrors.password = 'Password should have atleast 8 characters';
        }
        setErrors(tempErrors);
        return Object.keys(tempErrors).length === 0;
    };

    const handleFormSubmit = (e) => {
        e.preventDefault();
        if (validate()) {
            alert('Registration Successful!');
            setName('');
            setEmail('');
            setPassword('');
            setErrors({});
        }
    };

    return (
        <div style={{ padding: '20px', fontFamily: 'Arial', maxWidth: '400px' }}>
            <h2>Mail Registration</h2>
            <form onSubmit={handleFormSubmit} style={{ display: 'flex', flexDirection: 'column', gap: '15px' }}>
                <div>
                    <label style={{ display: 'block', marginBottom: '5px' }}>Name:</label>
                    <input 
                        type="text" 
                        value={name} 
                        onChange={(e) => setName(e.target.value)} 
                        style={{ width: '100%', padding: '8px', boxSizing: 'border-box' }}
                    />
                    {errors.name && <p style={{ color: 'red', margin: '5px 0 0 0', fontSize: '14px' }}>{errors.name}</p>}
                </div>
                <div>
                    <label style={{ display: 'block', marginBottom: '5px' }}>Email:</label>
                    <input 
                        type="text" 
                        value={email} 
                        onChange={(e) => setEmail(e.target.value)} 
                        style={{ width: '100%', padding: '8px', boxSizing: 'border-box' }}
                    />
                    {errors.email && <p style={{ color: 'red', margin: '5px 0 0 0', fontSize: '14px' }}>{errors.email}</p>}
                </div>
                <div>
                    <label style={{ display: 'block', marginBottom: '5px' }}>Password:</label>
                    <input 
                        type="password" 
                        value={password} 
                        onChange={(e) => setPassword(e.target.value)} 
                        style={{ width: '100%', padding: '8px', boxSizing: 'border-box' }}
                    />
                    {errors.password && <p style={{ color: 'red', margin: '5px 0 0 0', fontSize: '14px' }}>{errors.password}</p>}
                </div>
                <button type="submit" style={{ padding: '10px', cursor: 'pointer', backgroundColor: '#28a745', color: '#fff', border: 'none', borderRadius: '4px' }}>
                    Register
                </button>
            </form>
        </div>
    );
}

export default Register;
