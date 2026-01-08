import React, { useEffect, useState } from 'react'

function Async() {
    const [post, setPost] = useState<any>(undefined);

    useEffect(() => {
        fetch("https://jsonplaceholder.typicode.com/posts")
            .then(response => response.json())
            .then(data => setPost(data))
    }, [])

  return (
    <>
        {/* <ul> */}
            {/* {
                posts.map((post: any) => {
                    return <li key={post.id}>{post.title}</li>
                })
            } */}
        {/* </ul> */}

            <h1>{post?.title}</h1>

    </>
  )
}

export default Async