import { useState, useEffect } from 'react'

function App() {
    const [items, setItems] = useState([])
    const [newItem, setNewItem] = useState('')

    // Replace with actual Backend URL from EC2
    const API_URL = import.meta.env.VITE_API_URL || 'http://localhost:80/api/items';

    useEffect(() => {
        fetchItems();
    }, [])

    const fetchItems = () => {
        fetch(API_URL)
            .then(res => res.json())
            .then(data => setItems(data))
            .catch(err => console.error('Error fetching items:', err));
    }

    const addItem = () => {
        if (!newItem) return;
        fetch(API_URL, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ name: newItem })
        })
            .then(res => res.json())
            .then(item => {
                setItems([...items, item]);
                setNewItem('');
            })
            .catch(err => console.error('Error adding item:', err));
    }

    return (
	    <>
		    <h1>Jenkins CI/CD Demo</h1>
			<h2>Items from Postgres DB</h2>

			    <input
				type="text"
				value={newItem}
				onChange={(e) => setNewItem(e.target.value)}
				placeholder="New Item Name"
			    />
			    <button onClick={addItem}>Add Item</button>

			<ul>
			    {items.map(item => (
				<li key={item.id}>
				    {item.id}: {item.name}
				</li>
			    ))}
			</ul>
	    </>

    )
}

export default App
