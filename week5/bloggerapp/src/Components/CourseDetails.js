import React from 'react';

function CourseDetails() {
  const courses = [
    { id: 1, name: 'Full-Stack Java Enterprise Developer', duration: '12 Weeks', price: '₹49,999' },
    { id: 2, name: 'React Development & Application Debugging', duration: '6 Weeks', price: '₹24,999' },
    { id: 3, name: 'Spring Boot REST & Cloud Microservices', duration: '8 Weeks', price: '₹34,999' }
  ];

  return (
    <div style={{ padding: '15px', backgroundColor: '#f0fdf4', borderRadius: '8px', border: '1px solid #bbf7d0' }}>
      <h3 style={{ color: '#16a34a', margin: '0 0 10px 0' }}>Offered Courses</h3>
      <ul style={{ paddingLeft: '20px' }}>
        {courses.map(course => (
          <li key={course.id} style={{ margin: '8px 0' }}>
            <strong>{course.name}</strong> - {course.duration} ({course.price})
          </li>
        ))}
      </ul>
    </div>
  );
}

export default CourseDetails;
