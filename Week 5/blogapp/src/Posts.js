import React from 'react';
import Post from './Post';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      loading: true,
      error: null
    };
  }

  // Lifecycle hook - runs after component mounts
  componentDidMount() {
    this.loadPosts();
  }

  // Load posts from API
  loadPosts = () => {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => response.json())
      .then(data => {
        // Convert to Post objects
        const postObjects = data.map(
          post => new Post(post.userId, post.id, post.title, post.body)
        );
        this.setState({
          posts: postObjects,
          loading: false
        });
      })
      .catch(error => {
        this.setState({
          error: error.message,
          loading: false
        });
      });
  }

  render() {
    const { posts, loading, error } = this.state;

    if (loading) {
      return <div><h2>Loading posts...</h2></div>;
    }

    if (error) {
      return <div><h2>Error: {error}</h2></div>;
    }

    return (
      <div>
        <h1>Blog Posts</h1>
        <p>Total Posts: {posts.length}</p>
        {posts.slice(0, 5).map(post => (
          <div key={post.id} style={{ border: '1px solid #ccc', padding: '10px', margin: '10px 0' }}>
            <h3>Post #{post.id}: {post.title}</h3>
            <p><strong>User ID:</strong> {post.userId}</p>
            <p><strong>Body:</strong> {post.body}</p>
          </div>
        ))}
        <p><em>Showing first 5 posts out of {posts.length}</em></p>
      </div>
    );
  }
}

export default Posts;