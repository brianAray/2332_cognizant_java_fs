import { useEffect, useState } from "react";

function Hook() {

    // let visible: boolean = false;
    let [visible, setVisibility] = useState(true);

    function toggleDiv(){
        setVisibility(!visible);
        // visible = !visible
    }

    useEffect(() => {

        console.log("useEffect Triggered");

    }, [])

  return (
    <>
        <button onClick={toggleDiv}>Toggle</button>

        {
            visible ?  
                <h2>
                    Am I visible?
                </h2>
            :
                <>
                </>

        }
    
    </>
  )
}

export default Hook