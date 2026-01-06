import React, { useEffect, useState } from 'react'
import type { Pokemon } from './Pokemon';
import axios from 'axios';
import PokemonInput from './PokemonInput';
import PokemonDisplay from './PokemonDisplay';

function PokemonManager() {

    let [pokemon, setPokemon] = useState<Pokemon | undefined>(undefined)

    useEffect(() => {
        getPokemon(1);
    }, [])

    async function getPokemon(id: number){

        let response = await axios.get(`https://pokeapi.co/api/v2/pokemon/${id}`);
        console.log(response.data);
        setPokemon(response.data);
    }
    
  return (
    <>

        <PokemonInput getPokemon={getPokemon}/>
        <PokemonDisplay pokemon={pokemon}/>
    
    </>
  )
}

export default PokemonManager