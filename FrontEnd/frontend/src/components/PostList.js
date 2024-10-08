import React, { useEffect, useState } from 'react';
import axios from 'axios';

const PostList = ({ refresh }) => {
  const [posts, setPosts] = useState([]);

  // Function to fetch posts from the backend
  const fetchPosts = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/posts');
      setPosts(response.data);  // Update the post list
    } catch (error) {
      console.error('Error fetching posts:', error);
    }
  };

  // Fetch posts when component mounts or when refresh is toggled
  useEffect(() => {
    fetchPosts();
  }, [refresh]);  // Trigger fetch whenever 'refresh' changes

  if (!posts || posts.length === 0) {
    return <p>No posts available</p>;
  }

  return (
    <ul>
      {posts.map((post) => (
        <li key={post.id}>
          <h3>{post.title}</h3>
          <p><strong>Description:</strong> {post.description}</p>
          <p><strong>Content:</strong> {post.content}</p>
        </li>
      ))}
    </ul>
  );
};

export default PostList;
