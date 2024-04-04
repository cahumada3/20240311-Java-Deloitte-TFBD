
/**
 * redux uses the store for handling state across your ENTIRE application
 * 
 *      this store is going to be all of your reducers for your entire application
 */

import { configureStore } from "@reduxjs/toolkit";


const store = configureStore({
    reducer: {
        
    }
});

export default store;

