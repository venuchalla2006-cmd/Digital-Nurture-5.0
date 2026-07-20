import React from 'react';

class Cart extends React.Component {
    render() {
        return (
            <tr>
                <td style={{ border: '1px solid black', padding: '8px' }}>{this.props.Itemname}</td>
                <td style={{ border: '1px solid black', padding: '8px' }}>{this.props.Price}</td>
            </tr>
        );
    }
}

export default Cart;
