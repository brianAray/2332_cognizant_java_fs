import React, { useContext } from 'react'
import type { User } from './User'
import { DashboardContext } from './context'

interface ProfileProps {
    
}

function Profile() {

    const user = useContext(DashboardContext);
  return (
    <>
        <h3>{user?.name}</h3>
    </>
  )
}

export default Profile