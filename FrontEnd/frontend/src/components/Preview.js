import React from 'react';

const Preview = ({ data = {} }) => {
  // Destructure the properties from data, provide fallback values if data is undefined
  const { title = 'No title', description = 'No description', content = 'No content' } = data;

  return (
    <div>
      <h3>Post Preview</h3>
      <p><strong>Title:</strong> {title}</p>
      <p><strong>Description:</strong> {description}</p>
      <p><strong>Content:</strong> {content}</p>
    </div>
  );
};

export default Preview;
