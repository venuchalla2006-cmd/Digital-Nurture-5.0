import React from 'react';

function BlogDetails() {
  const blogs = [
    { id: 1, title: 'Understanding React Virtual DOM', reads: '1.2k', date: 'June 10, 2026' },
    { id: 2, title: 'Spring Boot 3 Security with JWT', reads: '3.5k', date: 'July 2, 2026' },
    { id: 3, title: 'Getting Started with Spring Cloud', reads: '950', date: 'July 5, 2026' }
  ];

  return (
    <div style={{ padding: '15px', backgroundColor: '#e0f2fe', borderRadius: '8px', border: '1px solid #bae6fd' }}>
      <h3 style={{ color: '#0284c7', margin: '0 0 10px 0' }}>Latest Blog Articles</h3>
      <ul style={{ paddingLeft: '20px' }}>
        {blogs.map(blog => (
          <li key={blog.id} style={{ margin: '8px 0' }}>
            <strong>{blog.title}</strong> - {blog.reads} reads ({blog.date})
          </li>
        ))}
      </ul>
    </div>
  );
}

export default BlogDetails;
