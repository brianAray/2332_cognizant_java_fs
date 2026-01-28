import { useEffect, useState } from 'react'
import './App.css'

function App() {

  const [message, setMessage] = useState('Loading...');

  useEffect(() => {
    fetch('http://localhost:8081/')
      .then(response => response.text())
      .then(data => setMessage(data))
      .catch(error => setMessage('Error calling backend'))
  }, [])

  return (
    <>
      <h1>React app is working</h1>

      <p>
        Backend says: {message}
      </p>
    </>
  )
}

export default App
