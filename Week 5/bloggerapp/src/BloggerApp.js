import React from 'react';

class BloggerApp extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      activeTab: 'books'
    };
  }

  handleTabChange = (tab) => {
    this.setState({ activeTab: tab });
  }

  render() {
    const { activeTab } = this.state;

    const books = [
      { id: 1, title: 'React Basics', author: 'John Doe', price: '$29.99' },
      { id: 2, title: 'Advanced JavaScript', author: 'Jane Smith', price: '$39.99' },
      { id: 3, title: 'Web Development', author: 'Mike Johnson', price: '$34.99' }
    ];

    const blogs = [
      { id: 1, title: 'Getting Started with React', author: 'Sarah Lee', date: '2024-07-10' },
      { id: 2, title: 'State Management Best Practices', author: 'Alex Brown', date: '2024-07-09' },
      { id: 3, title: 'React Hooks Deep Dive', author: 'Emma White', date: '2024-07-08' }
    ];

    const courses = [
      { id: 1, title: 'React Masterclass', instructor: 'David Chen', students: 1250, rating: '4.8' },
      { id: 2, title: 'JavaScript Advanced', instructor: 'Lisa Park', students: 980, rating: '4.6' },
      { id: 3, title: 'Full Stack Development', instructor: 'Tom Wilson', students: 2150, rating: '4.9' }
    ];

    const containerStyle = {
      padding: '40px',
      fontFamily: 'Arial',
      maxWidth: '900px',
      margin: '0 auto'
    };

    const tabButtonStyle = {
      padding: '12px 24px',
      margin: '5px',
      fontSize: '1rem',
      cursor: 'pointer',
      borderRadius: '4px',
      border: 'none',
      backgroundColor: '#ddd',
      color: '#333'
    };

    const activeTabButtonStyle = {
      ...tabButtonStyle,
      backgroundColor: '#007bff',
      color: 'white'
    };

    const itemStyle = {
      backgroundColor: '#f9f9f9',
      padding: '20px',
      margin: '10px 0',
      borderLeft: '4px solid #007bff',
      borderRadius: '4px'
    };

    return (
      <div style={containerStyle}>
        <h1>📚 Blogger App - Content Hub</h1>

        {/* Tab Navigation */}
        <div style={{ marginBottom: '30px', textAlign: 'center' }}>
          <button 
            onClick={() => this.handleTabChange('books')}
            style={activeTab === 'books' ? activeTabButtonStyle : tabButtonStyle}
          >
            📖 Books
          </button>
          <button 
            onClick={() => this.handleTabChange('blogs')}
            style={activeTab === 'blogs' ? activeTabButtonStyle : tabButtonStyle}
          >
            ✍️ Blogs
          </button>
          <button 
            onClick={() => this.handleTabChange('courses')}
            style={activeTab === 'courses' ? activeTabButtonStyle : tabButtonStyle}
          >
            🎓 Courses
          </button>
        </div>

        {/* simple if/else conditional rendering */}
        {activeTab === 'books' && (
          <div>
            <h2>📖 Books</h2>
            {books.map(book => (
              <div key={book.id} style={itemStyle}>
                <h3>{book.title}</h3>
                <p><strong>Author:</strong> {book.author}</p>
                <p><strong>Price:</strong> {book.price}</p>
              </div>
            ))}
          </div>
        )}

        {/* ternary operator conditional rendering */}
        {activeTab === 'blogs' ? (
          <div>
            <h2>✍️ Blogs</h2>
            {blogs.length > 0 ? (
              blogs.map(blog => (
                <div key={blog.id} style={itemStyle}>
                  <h3>{blog.title}</h3>
                  <p><strong>Author:</strong> {blog.author}</p>
                  <p><strong>Published:</strong> {blog.date}</p>
                </div>
              ))
            ) : (
              <p>No blogs available</p>
            )}
          </div>
        ) : null}

        {/* switch statement conditional rendering */}
        {(() => {
          switch(activeTab) {
            case 'courses':
              return (
                <div>
                  <h2>🎓 Courses</h2>
                  {courses.map(course => (
                    <div key={course.id} style={itemStyle}>
                      <h3>{course.title}</h3>
                      <p><strong>Instructor:</strong> {course.instructor}</p>
                      <p><strong>Students:</strong> {course.students.toLocaleString()}</p>
                      <p><strong>Rating:</strong> ⭐ {course.rating}</p>
                    </div>
                  ))}
                </div>
              );
            default:
              return null;
          }
        })()}

        {/* summary */}
        <div style={{
          backgroundColor: '#e3f2fd',
          padding: '20px',
          borderRadius: '4px',
          marginTop: '30px',
          textAlign: 'center'
        }}>
          <p>
            {activeTab === 'books' && `Showing ${books.length} books`}
            {activeTab === 'blogs' && `Showing ${blogs.length} blogs`}
            {activeTab === 'courses' && `Showing ${courses.length} courses`}
          </p>
        </div>
      </div>
    );
  }
}

export default BloggerApp;