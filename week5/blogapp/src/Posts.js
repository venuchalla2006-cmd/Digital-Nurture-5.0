import React, { Component } from 'react';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false,
      errorMessage: ''
    };
  }

  loadPosts = () => {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then(data => {
        // Only load the first 10 posts for clean rendering
        this.setState({ posts: data.slice(0, 10) });
      })
      .catch(error => {
        this.setState({ hasError: true, errorMessage: error.message });
        alert("Error loading posts: " + error.message);
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    this.setState({ hasError: true, errorMessage: error.toString() });
    LOGGER_ERROR_LOG(error, info);
  }

  render() {
    if (this.state.hasError) {
      return (
        <div style={{ padding: '20px', color: 'red', textAlign: 'center' }}>
          <h2>Something went wrong loading the posts.</h2>
          <p>{this.state.errorMessage}</p>
        </div>
      );
    }

    return (
      <div style={{ padding: '15px' }}>
        <h2 style={{ color: '#2c3e50', borderBottom: '2px solid #3498db', paddingBottom: '10px' }}>Latest Blog Posts</h2>
        {this.state.posts.map(post => (
          <div key={post.id} style={{ margin: '20px 0', padding: '15px', border: '1px solid #e2e8f0', borderRadius: '5px', backgroundColor: '#f8fafc' }}>
            <h3 style={{ textTransform: 'capitalize', color: '#2980b9' }}>{post.title}</h3>
            <p style={{ color: '#555', lineHeight: '1.6' }}>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

// Helper mock error logger
function LOGGER_ERROR_LOG(error, info) {
    console.error("Component Caught Error: ", error, info);
    alert("Alert: Caught an exception inside Posts component. Message: " + error.toString());
}

export default Posts;
