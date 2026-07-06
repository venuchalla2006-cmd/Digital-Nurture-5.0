import React from 'react';

function BookDetails() {
  const books = [
    { id: 1, title: 'Clean Code', author: 'Robert C. Martin', year: 2008 },
    { id: 2, title: 'The Pragmatic Programmer', author: 'Andy Hunt & Dave Thomas', year: 1999 },
    { id: 3, title: 'Design Patterns', author: 'Erich Gamma et al.', year: 1994 }
  ];

  return (
    <div style={{ padding: '15px', backgroundColor: '#fef3c7', borderRadius: '8px', border: '1px solid #fde68a' }}>
      <h3 style={{ color: '#d97706', margin: '0 0 10px 0' }}>Book Catalog</h3>
      <ul style={{ paddingLeft: '20px' }}>
        {books.map(book => (
          <li key={book.id} style={{ margin: '8px 0' }}>
            <strong>{book.title}</strong> by {book.author} ({book.year})
          </li>
        ))}
      </ul>
    </div>
  );
}

export default BookDetails;
