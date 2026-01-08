import React from 'react'
import type { User } from './User'
import Sidebar from './Sidebar'
import Profile from './Profile'

interface DashboardProps {
    
}

function Dashboard() {
  return (
    <>
        <Sidebar/>
        <Profile/>
    </>
  )
}

export default Dashboard