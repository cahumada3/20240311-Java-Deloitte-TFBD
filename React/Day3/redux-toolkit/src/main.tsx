import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import './index.css'
import { Provider } from 'react-redux'
import store from './store.ts'

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    {/**react-redux is going to PROVIDE the store to the rest of the app - kinda like a global variable */}
    <Provider store={store}>
      <App />
    </Provider>
    
  </React.StrictMode>,
)
