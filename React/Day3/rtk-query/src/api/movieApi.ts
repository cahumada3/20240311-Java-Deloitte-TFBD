import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';

// creating a custom type in typescript
export type Movie = {
    id? : number,
    title : String,
    rating : number,
    director? : {               // ? means the property is optional
        firstName? : String,
        lastName? : String
    }
}

/**
 * createApi is going to provide all the functionality you need for making server calls
 *      it will also add the returned data to our store for us
 *          its a combo of createSlice, and createAsyncThunk (used with async reducers)
 * 
 *      it takes in an object 3 properties:
 *          - reducerPath - a path to be used by your reduc store as a reducer
 *          - baseQuery - the default url for your server 
 *          - endpoints - a function that takes an object as param where each property in that object is an endpoint
 *                  - takes in a builder object with 2 properties:
 *                          - query: is used for requests that DO NOT change data (GET)
 *                          - mutation: is used for requests that WILL change data (POST, PUT, DELETE)
 */

export const movieApi = createApi({
    reducerPath : 'movieApi',
    baseQuery : fetchBaseQuery({baseUrl : 'http://localhost:8282/movies'}),
    endpoints : (builder) => ({
        /**
         * .query and .mutation need two data types
         *      the first type is the type of the data returned
         *      the second is the type of what data you're passing into the function
         * 
         *      both are going to take in an object with a query property
         *          this query property is going to be a function that does the call
         */
        
        findAllMovies : builder.query<Movie[], void>({query : () => ''}),  //the query function will take in the path for this endpoint

        findMovieById : builder.query<Movie, number>({query : (id) => `/movie/${id}`}), //adding a path variable to the url

        createMovie : builder.mutation<Movie, Movie>({
            query : (newMovie) => {
                return {
                    method : 'POST',
                    url : '/movie',
                    body : newMovie 
                }
            }
        }),
        updateMovie : builder.mutation<Movie, Movie>({
            query : (updatedMovie) => {
                return {
                    method : 'PUT',
                    url : '/movie',
                    body : updatedMovie 
                }
            }
        }),
        deleteMovie : builder.mutation<Movie, Movie>({
            query : (movieToDelete) => {
                return {
                    method : 'DELETE',
                    url : '/movie',
                    body : movieToDelete 
                }
            }
        })
    })
})
