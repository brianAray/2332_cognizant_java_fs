import React, { useContext, useEffect, useState } from 'react'
import type { Pokemon } from './Pokemon';
import axios from 'axios';
import PokemonInput from './PokemonInput';
import PokemonDisplay from './PokemonDisplay';
import { DashboardContext } from '../useContext/context';

function PokemonManager() {

    let [pokemon, setPokemon] = useState<Pokemon | undefined>(undefined)

    const user = useContext(DashboardContext);

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
        <h1>{user?.name}</h1>
        <PokemonInput getPokemon={getPokemon}/>
        <PokemonDisplay pokemon={pokemon}/>
    
    </>
  )
}

export default PokemonManager