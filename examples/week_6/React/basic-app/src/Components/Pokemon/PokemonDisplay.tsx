import { useEffect, useState } from "react"
import type { Pokemon } from "./Pokemon"
import axios from "axios"
import PokemonInput from "./PokemonInput"


function PokemonDisplay(props: {pokemon: Pokemon | undefined}) {

  return (
    <>
    {
        props.pokemon ? 

        <>
        <h1>
            Pokemon Loaded in
        </h1>
        <ul>
            {
                props.pokemon.abilities.map((obj: any, index) => {
                    // console.log(obj.name);
                    return (
                        <li key={index}>{obj.ability.name}</li>
                    )
                })
            }
        </ul>

        </>
        :

        <h1>Loading Pokemon!</h1>
    }



    </>
    
  )
}


export default PokemonDisplay