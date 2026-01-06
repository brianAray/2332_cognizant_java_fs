import type React from "react";
import { exampleFunction } from "../GlobalScripts";

function EventsDemo() {

    function clickEventTriggered(){
        console.log("Click Button Triggered");
    }

    function hoverEventTriggered(){
        console.log("Hover event triggered");
    }

    function inputChanged(event: React.ChangeEvent<HTMLInputElement>){
        console.log(event.target.value);
    }

  return (
    <>
        <button onClick={clickEventTriggered}>Click Event</button>
        <button onMouseOver={exampleFunction}>Hover Event</button>
        <input type="text" placeholder="Username" onChange={inputChanged}/>
    </>
  )
}

export default EventsDemo