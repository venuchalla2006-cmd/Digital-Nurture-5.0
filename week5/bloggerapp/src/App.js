import React, { useState } from 'react';
import BookDetails from './Components/BookDetails';
import BlogDetails from './Components/BlogDetails';
import CourseDetails from './Components/CourseDetails';

function App() {
  const [selectedTab, setSelectedTab] = useState('books'); // 'books', 'blogs', 'courses'
  const [showPromo, setShowPromo] = useState(true);
  const [premiumUser, setPremiumUser] = useState(false);

  // 1. Conditional Rendering using Switch-Case Method
  const renderTabContent = () => {
    switch (selectedTab) {
      case 'books':
        return <BookDetails />;
      case 'blogs':
        return <BlogDetails />;
      case 'courses':
        return <CourseDetails />;
      default:
        return <div>Select a valid category</div>;
    }
  };

  return (
    <div style={{ fontFamily: 'Arial, sans-serif', maxWidth: '600px', margin: '20px auto', padding: '20px', border: '1px solid #ddd', borderRadius: '8px' }}>
      <h1 style={{ textAlign: 'center', color: '#1e293b' }}>Blogger Application</h1>
      
      {/* 2. Conditional Rendering using Logical && Operator */}
      {showPromo && (
        <div style={{ padding: '10px', backgroundColor: '#fee2e2', border: '1px solid #fca5a5', color: '#b91c1c', borderRadius: '5px', marginBottom: '15px', position: 'relative' }}>
          <strong>Special Offer!</strong> Sign up for any course today and get 20% off.
          <button 
            onClick={() => setShowPromo(false)} 
            style={{ float: 'right', background: 'none', border: 'none', color: '#b91c1c', fontWeight: 'bold', cursor: 'pointer' }}
          >
            ✖
          </button>
          <div style={{ clear: 'both' }}></div>
        </div>
      )}

      {/* 3. Conditional Rendering using Ternary Operator */}
      <div style={{ marginBottom: '20px', padding: '10px', border: '1px solid #cbd5e1', borderRadius: '6px', backgroundColor: '#f8fafc', display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
        <span>User Status: {premiumUser ? <strong>⭐ Premium Member</strong> : <strong>Standard Guest</strong>}</span>
        <button 
          onClick={() => setPremiumUser(!premiumUser)}
          style={{ padding: '5px 10px', fontSize: '12px', cursor: 'pointer' }}
        >
          {premiumUser ? 'Switch to Standard' : 'Upgrade to Premium'}
        </button>
      </div>

      {/* Navigation tabs */}
      <div style={{ display: 'flex', gap: '5px', marginBottom: '15px' }}>
        <button 
          onClick={() => setSelectedTab('books')}
          style={{ flex: 1, padding: '10px', backgroundColor: selectedTab === 'books' ? '#d97706' : '#cbd5e1', color: selectedTab === 'books' ? 'white' : 'black', border: 'none', borderRadius: '4px', cursor: 'pointer' }}
        >
          Books Catalog
        </button>
        <button 
          onClick={() => setSelectedTab('blogs')}
          style={{ flex: 1, padding: '10px', backgroundColor: selectedTab === 'blogs' ? '#0284c7' : '#cbd5e1', color: selectedTab === 'blogs' ? 'white' : 'black', border: 'none', borderRadius: '4px', cursor: 'pointer' }}
        >
          Blog Posts
        </button>
        <button 
          onClick={() => setSelectedTab('courses')}
          style={{ flex: 1, padding: '10px', backgroundColor: selectedTab === 'courses' ? '#16a34a' : '#cbd5e1', color: selectedTab === 'courses' ? 'white' : 'black', border: 'none', borderRadius: '4px', cursor: 'pointer' }}
        >
          Courses Offered
        </button>
      </div>

      {/* Renders Tab Content */}
      <div style={{ minHeight: '150px' }}>
        {renderTabContent()}
      </div>
    </div>
  );
}

export default App;
