import React, { useState } from "react";
import axios from 'axios';



const InputForm = ({ onPostCreate, onSubmit }) => {
    const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [content, setContent] = useState('');

    const countWords = (input) => {
        return input.trim().split(/\s+/).filter((word) => word).length;
      };

    const handleSubmit = async (e)=>{
      e.preventDefault();

      const postData = {
        title: title,
        description: description,
        content: content,
      };

      console.log(postData);
      try {
        // Make a POST request to the backend API
        const response = await axios.post('http://localhost:8080/api/posts', postData);
        onPostCreate(postData);
        onSubmit(postData);
        setTitle('');  // Clear input fields
        setDescription('');
        setContent('');

        console.log('Post created:', response.data);
      } catch (error) {
        console.error('There was an error creating the post:', error);
      }

    };
    const handleInput1Change = (e) => {
        if (countWords(e.target.value) <= 10) {
            setTitle(e.target.value);
        }
      };
    const handleInput2Change = (e) => {
        if (countWords(e.target.value) <= 500) {
            setDescription(e.target.value);
        }
      };
    const handleInput3Change = (e) => {
        if (countWords(e.target.value) <= 1000) {
            setContent(e.target.value);
        }
      };

  return (
    <div>
        <form onSubmit={handleSubmit} style={{padding:"10px", display:"flex", flexDirection:"column", gap:"10px", justifyContent: "center"}}>
            <div style={{display: "flex", flexDirection:"column"}}>
                <label>Title: </label>
                <input type="text"
                value={title}
                onChange={handleInput1Change}
                style={{
                  padding: '8px',
                  width: 'auto',
                  borderRadius: '4px',
                  border: '1px solid #ccc',
                }}
                >
                </input>
            </div>
            <div style={{display: "flex", flexDirection:"column"}}>
                <label>Description: </label>
                <input type="text"
                value={description}
                onChange={handleInput2Change}
                style={{
                    padding: '8px',
                    width: 'auto',
                    borderRadius: '4px',
                    border: '1px solid #ccc',
                  }}>
                </input>
            </div>
            <div style={{display: "flex", flexDirection:"column"}}>
                <label>Content: </label>
                <input type="text"
                value={content}
                onChange={handleInput3Change}
                style={{
                    padding: '8px',
                    width: 'auto',
                    borderRadius: '4px',
                    border: '1px solid #ccc',
                  }}>
                </input>
            </div>
            <button type="submit" style={{padding: '10px 15px',
              backgroundColor: '#28a745',
              color: '#fff',
              border: 'none',
              borderRadius: '4px',
              cursor: 'pointer',
              fontWeight: 'bold',}}>Submit</button>
        </form>
    </div>
  )
}

export default InputForm
