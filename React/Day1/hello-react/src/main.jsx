import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    {/**
     * StrictMode mounts and immediately unmounts components
     *    useful for memory leaks 
     *    if something persists after unmount - then memory leak
     *  
     *    only used in dev server - NOT IN PRODUCTION BUILD
     */}


    {/**
     * everything returned App.jsx will be displayed here
     */}
    <App />
  </React.StrictMode>,
)
