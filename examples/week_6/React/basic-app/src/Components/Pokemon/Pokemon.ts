interface Ability {
    name: string;
    url: string;
}
interface Abilities {
    is_hidden: boolean;
    slot: number;
    ability: Ability
}

export interface Pokemon{
    abilities: Abilities[];
    
}