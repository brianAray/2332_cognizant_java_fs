import ChildComponent from "../ChildComponent/ChildComponent"

function ParentComponent() {
  return (
    <>
        <ChildComponent bgColor="red" isRound={false}/>
        <ChildComponent bgColor="lightblue" isRound={true}/>
    </>
  )
}

export default ParentComponent