import { configureStore } from "@reduxjs/toolkit";
import { movieApi } from "./api/movieApi";

const store = configureStore({

    reducer : {
        [movieApi.reducerPath] : movieApi.reducer
    },

    /**
     * middleware is a point in between your api call and your api endpoint 
     *      kinda similar to AOP in Spring
     *          middleware is often used for things like logging, crash reposrts, routing, etc.
     * 
     *      *we* aren't doing too much with it, but redux does
     */

    middleware : (defaultMiddleWare) => defaultMiddleWare().concat(movieApi.middleware)
});

export default store;