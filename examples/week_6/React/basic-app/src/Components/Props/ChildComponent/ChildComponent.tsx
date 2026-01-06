function ChildComponent(props: any) {
    console.log(props.bgColor);
  return (
    <button style={{
        backgroundColor: props.bgColor,
        color: "white",
        border: "none",
        borderRadius: props.isRound ? "6px" : "0px",
        padding: "8px",
        fontSize: "20px"
    }}>
        Click Me
    </button>
  )
}

export default ChildComponent