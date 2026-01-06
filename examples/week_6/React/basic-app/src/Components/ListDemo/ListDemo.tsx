import React from 'react'

interface User {
    username: string;
    password: string;
}

const Users: User[] = [
    {
        username: "user1",
        password: "pass1"
    },
    {
        username: "user2",
        password: "pass2"
    },
    {
        username: "user3",
        password: "pass3"
    },
]

function ListDemo() {
  return (
    <>
        <h1>Users</h1>
        <ul>
        {
            // Display each item in an array
            // THe map function to transform each item in the array

            Users.map((obj: User, index) => {
                return (
                    <li key={index}>
                        {obj.username}
                    </li>
                );
            })
        }

        </ul>
        {/* <ul>
            <li>{Users[0].username}</li>
            <li>{Users[1].username}</li>
            <li>{Users[2].username}</li>
        </ul> */}
    </>
  )
}

export default ListDemo