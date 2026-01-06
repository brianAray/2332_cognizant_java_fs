import { Route, Routes } from 'react-router-dom'
import EventsDemo from './Components/EventsDemo/EventsDemo'
import GreetingComponent from './Components/GreetingComponent/GreetingComponent'
import ListDemo from './Components/ListDemo/ListDemo'
import ParentComponent from './Components/Props/ParentComponent/ParentComponent'
import NavBar from './Components/NavBar/NavBar'
import Hook from './Components/Hooks/Hook'
import PokemonDisplay from './Components/Pokemon/PokemonDisplay'
import PokemonManager from './Components/Pokemon/PokemonManager'

function App() {

  return (
    <>
      {/* <GreetingComponent/>
      <EventsDemo/>
      <ListDemo/>
      <ParentComponent/> */}
      <NavBar/>
      <Routes>
        <Route path="/" element={<GreetingComponent/>}></Route>
        <Route path="/events" element={<EventsDemo/>}></Route>
        <Route path="/lists" element={<ListDemo/>}></Route>
        <Route path="/parent" element={<ParentComponent/>}></Route>
        <Route path="/hooks" element={<Hook/>}></Route>
        <Route path="/poke" element={<PokemonManager/>}></Route>
      </Routes>
    </>
  )
}

// class App extends React.Component{
//   render(): React.ReactNode {
//     return(
//       <>
//         <GreetingComponent/>
//       </>
//     )
//   }
// }

export default App
