import React, { useEffect, useState } from "react";

export default function Root(props) {

  const [cartCount, setCartCount] = useState(0);

  useEffect(() => {
    // event handler
    const handleCartUpdate = (event) => {
      console.log(`Cart updated: `, event.detail);
      setCartCount(event.detail.count);
    }

    // Subscribe to the custom event
    window.addEventListener('cart:updated', handleCartUpdate);

    // Cleanup: unsubscribe when the component unmounts
    return () => {
      window.removeEventListener('cart:updated', handleCartUpdate);
    }
  }, [])

  const handleNavigation = (path) => {
    // single-spa navigation
    window.history.pushState(null, null, path);
    // dispatch a popstate event to trigger the single-spa routing
    window.dispatchEvent(new PopStateEvent("popstate"));
  }


  return (
    <nav>
      <h3>React Navbar</h3>
      <button
        onClick={(e) => {
          handleNavigation("/")
        }}
      >Home</button>

      <button
        onClick={(e) => {
          handleNavigation("/products")
        }}
      >Products</button>

      <p>Cart: {cartCount}</p>

    </nav>
  );
}
