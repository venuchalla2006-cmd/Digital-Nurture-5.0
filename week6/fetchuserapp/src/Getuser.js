import React from 'react';

class Getuser extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            loading: true,
            user: null
        };
    }

    async componentDidMount() {
        try {
            const response = await fetch('https://api.randomuser.me/');
            const data = await response.json();
            if (data.results && data.results.length > 0) {
                const fetchedUser = data.results[0];
                this.setState({
                    user: {
                        title: fetchedUser.name.title,
                        firstname: fetchedUser.name.first,
                        lastname: fetchedUser.name.last,
                        image: fetchedUser.picture.large
                    },
                    loading: false
                });
            }
        } catch (error) {
            console.error('Error fetching user:', error);
            this.setState({ loading: false });
        }
    }

    render() {
        if (this.state.loading) {
            return <div style={{ padding: '20px' }}>Loading...</div>;
        }

        if (!this.state.user) {
            return <div style={{ padding: '20px' }}>Failed to fetch user.</div>;
        }

        const { title, firstname, lastname, image } = this.state.user;

        return (
            <div style={{ padding: '20px', fontFamily: 'Arial', textAlign: 'center', border: '1px solid #ccc', borderRadius: '8px', maxWidth: '300px', margin: '20px' }}>
                <h2>User Profile</h2>
                <img src={image} alt={`${firstname}`} style={{ borderRadius: '50%', marginBottom: '15px' }} />
                <h3>{title}. {firstname} {lastname}</h3>
            </div>
        );
    }
}

export default Getuser;
