import { useState } from 'react';
import './App.css';
import { Configuration, OpenAIApi } from 'openai';

// Create a new instance of Configuration with the OpenAI API key
const configuration = new Configuration({
  apiKey: import.meta.env.VITE_MY_API_KEY,
});
// Create a new instance of OpenAIApi using the Configuration instance
const openai = new OpenAIApi(configuration);

function App() {
  // State to store the generated image URL
  const [image, setImage] = useState('');
  // State to manage loading state
  const [isLoading, setIsLoading] = useState(false);
  // State to store user input prompt
  const [prompt, setPrompt] = useState('');

  // Function to fetch data from OpenAI API
  async function fetchData() {
    try {
      // Set loading state to true
      setIsLoading(true);
      // Make a request to OpenAI API to create an image based on the user's prompt
      const response = await openai.createImage({
        prompt: prompt,
        n: 1,
        size: '512x512',
      });
      // Set the generated image URL in the state
      setImage(response.data.data[0].url);
      // Set loading state to false
      setIsLoading(false);
    } catch (e) {
      // Handle errors and set loading state to false
      setIsLoading(false);
      console.error(e);
    }
  }

  return (
    <div className='App'>
      <h1>Image Generator</h1>
      <div>
        {/* Input field to enter user prompt */}
        <input
          onChange={(e) => setPrompt(e.target.value)}
          placeholder='Enter your prompt'
        />
        {/* Button to trigger image generation */}
        <button onClick={fetchData}>Generate Image</button>
      </div>
      <div style={{ width: 512, height: 512 }}>
        {/* Conditional rendering based on loading state */}
        {isLoading ? (
          <>
            <p>Loading...</p>
            <p>Please wait until your image is ready.</p>
          </>
        ) : (
          // Display the generated image
          <img src={image} alt='Generated Image' />
        )}
      </div>
    </div>
  );
}

// Export the App component as the default export
export default App;
