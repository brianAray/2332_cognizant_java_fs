import axios from 'axios';
import React from 'react'

function PokemonInput(props: {getPokemon: any}) {

  return (
    <>
        <h1>Get a new pokemon</h1>
        <input type="number" onChange={(event: any) => {
            if(event.target.value){
                props.getPokemon(event.target.value);
            }
        }}></input>
    </>
  )
}

export default PokemonInput