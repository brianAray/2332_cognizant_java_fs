import React, { useContext } from 'react'
import type { User } from './User'
import { DashboardContext } from './context'

interface SidebarProps {
    
}

function Sidebar() {

    const user = useContext(DashboardContext);

  return (
    <>
        <h1>{user?.name}</h1>
        <div>Status: {user?.isActive ? "True" : "False"}</div>
    </>
  )
}

export default Sidebar