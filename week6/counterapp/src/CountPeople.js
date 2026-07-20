import React from 'react';

class CountPeople extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            entrycount: 0,
            exitcount: 0
        };
    }

    UpdateEntry = () => {
        this.setState(prevState => ({
            entrycount: prevState.entrycount + 1
        }));
    }

    UpdateExit = () => {
        this.setState(prevState => ({
            exitcount: prevState.exitcount + 1
        }));
    }

    render() {
        return (
            <div style={{ padding: '20px', fontFamily: 'Arial' }}>
                <h2>Mall Footprint Counter</h2>
                <div style={{ display: 'flex', gap: '50px', marginBottom: '20px' }}>
                    <div style={{ border: '1px solid #ccc', padding: '15px', borderRadius: '5px', minWidth: '150px' }}>
                        <h3>Entry Count</h3>
                        <p style={{ fontSize: '24px', fontWeight: 'bold' }}>{this.state.entrycount}</p>
                        <button onClick={this.UpdateEntry} style={{ padding: '8px 16px', cursor: 'pointer' }}>Login (Enter)</button>
                    </div>
                    <div style={{ border: '1px solid #ccc', padding: '15px', borderRadius: '5px', minWidth: '150px' }}>
                        <h3>Exit Count</h3>
                        <p style={{ fontSize: '24px', fontWeight: 'bold' }}>{this.state.exitcount}</p>
                        <button onClick={this.UpdateExit} style={{ padding: '8px 16px', cursor: 'pointer' }}>Exit</button>
                    </div>
                </div>
            </div>
        );
    }
}

export default CountPeople;
