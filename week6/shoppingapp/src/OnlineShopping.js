import React from 'react';
import Cart from './Cart';

class OnlineShopping extends React.Component {
    render() {
        const cartItems = [
            { id: 1, Itemname: 'Laptop', Price: '$999' },
            { id: 2, Itemname: 'Smartphone', Price: '$699' },
            { id: 3, Itemname: 'Headphones', Price: '$150' },
            { id: 4, Itemname: 'Keyboard', Price: '$80' },
            { id: 5, Itemname: 'Mouse', Price: '$50' }
        ];

        return (
            <div style={{ padding: '20px' }}>
                <h2>Online Shopping Cart</h2>
                <table style={{ borderCollapse: 'collapse', width: '50%' }}>
                    <thead>
                        <tr style={{ backgroundColor: '#f2f2f2' }}>
                            <th style={{ border: '1px solid black', padding: '8px', textAlign: 'left' }}>Item Name</th>
                            <th style={{ border: '1px solid black', padding: '8px', textAlign: 'left' }}>Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        {cartItems.map(item => (
                            <Cart key={item.id} Itemname={item.Itemname} Price={item.Price} />
                        ))}
                    </tbody>
                </table>
            </div>
        );
    }
}

export default OnlineShopping;
