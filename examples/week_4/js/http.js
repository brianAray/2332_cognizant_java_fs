
// JSON
// JavaScript Object Notation

const jsObject = {
    name: "Pikachu",
    id: 25,
    types: ["electric"]
}

// JSON string
// const jsonString = `{
//     "name": "Pikachu",
//     "id": 25,
//     "types": ["electric"]
// }`

// JSON methods
const jsonString = JSON.stringify(jsObject);
console.log(jsonString);

// Convert JSOn string to js object
const parsedObject = JSON.parse(jsonString);
console.log(parsedObject.name);

// Different to handle asynchronous activities
// Promises
// An object representing an eventual completion or failure of an asynchronous operation
// States: pending, fulfilled, rejected

// Creating a promise

const myPromise = new Promise((resolve, reject) => {
    // Asynchronous operation
    const success = false; // simulate a successful operation

    setTimeout(() => {
        if(success){
            resolve("Operation Completed")
        }else{
            reject("Operation failed");
        }
    }, 1000);
})

// Using the promise
myPromise.then(result => {
    console.log(result);
}).catch(error => {
    console.error(error);
})


// Fetch API
// The fetch api is a modern interface for making HTTP requests
// It returns promises and is more powerful and flexible than the older method of XMLHttpRequest

// fetch("https://pokeapi.co/api/v2/pokemon/ditto", {
//     method: 'POST',
//     headers: {
//         'Content-Type': 'application/json'
//     },
//     body: JSON.stringify({
//         name: 'Pikachu',
//         type: ["Electric"]
//     })
// })
//     .then(response => {
//         if(!response.ok){
//             throw new Error('Network responding with error');
//         }
//         return response.json();
//     })
//     .then(data => {
//         console.log(data);
//     })
//     .catch(error => {
//         console.error(error);
//     })


// Async / Await keyword
// Syntactic sugar built on top of promises that make asynchronous code easier to read and write

// async function fetchPokemon(){
//     try{
//         const response = await fetch('https://pokeapi.co/api/v2/pokemon/ditto');
//         const data = await response.json();
//         console.log(data);
//     }catch(error){
//         console.error(error);
//     }
// }

// fetchPokemon();


{/* <h1>Pokemon Searcher</h1>

<div id="poke-input-container">
    <h3>Pokemon Input</h3>
    <input id="poke-input" type="number">
    <br>
    <button id="poke-input-button">Search</button>
</div>

<div id="poke-display-container">
</div> */}

const pokeInputContainer = document.querySelector("#poke-input-container");
const pokeDisplayContainer = document.querySelector("#poke-display-container");

const pokeInput = pokeInputContainer.children[1];
const pokeInputSearchButton = pokeInput.nextElementSibling.nextElementSibling;

console.log(pokeInput);
console.log(pokeInputSearchButton);

pokeInputSearchButton.addEventListener('click', async () => {
    const pokeId = pokeInput.value;
    const pokeData = await fetchPokemon(pokeId);

    displayPokemon(pokeData);
})

pokeInput.addEventListener('change', async (event) => {
    const pokeId = event.target.value;
    const pokeData = await fetchPokemon(pokeId);

    displayPokemon(pokeData);
})

async function fetchPokemon(id){
    try{
        const response = await fetch(`https://pokeapi.co/api/v2/pokemon/${id}`);
        const data = await response.json();
        console.log(data);
        return data;
    }catch(error){
        console.error(error);
    }
}

function displayPokemon(pokeData){
    pokeDisplayContainer.innerHTML = "";

    const pokeName = document.createElement("h3");
    pokeName.textContent = pokeData.name;
    pokeDisplayContainer.appendChild(pokeName);

    const pokeSprite = document.createElement("img");
    pokeSprite.src = pokeData.sprites.front_shiny;
    pokeDisplayContainer.appendChild(pokeSprite);
}