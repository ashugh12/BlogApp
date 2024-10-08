import React, { useState } from 'react';
import InputForm from './InputForm';
import Preview from './Preview';
import PostsList from './PostList';

const FormContainer = () => {

  const [refresh, setRefresh] = useState(false); // This will trigger re-fetch

  // Function to trigger refresh in PostList after a new post is created
  const triggerRefresh = () => {
    setRefresh(!refresh);  // Toggle the refresh state to re-fetch posts
  };

  const [submittedData, setSubmittedData] = useState({
    title: '',
    description: '',
    content: ''
  });

  // Handle form submission and update the state
  const handleFormSubmit = (formData) => {
    setSubmittedData(formData);
  };

  return (
    <div style={{ display: 'flex', flexDirection: 'row', padding: '20px' }}>
      {/* Left Section: Input Form */}
      <div style={{ flex: 1, padding: '10px', borderRight: '1px solid #ccc' }}>
        <h3>Fill the Form</h3>
        <InputForm onPostCreate={triggerRefresh} onSubmit={handleFormSubmit}/>
      </div>

      {/* Right Section: Rendered Content and PostsList */}
      <div style={{ flex: 1, padding: '10px' }}>
        <Preview data={submittedData} />

        {/* Posts List */}
        {/* <div style={{ marginTop: '20px' }}>
          <h3>All Posts</h3>
          <PostsList refresh={refresh}/>
        </div> */}
      </div>
    </div>
  );
};

export default FormContainer;
