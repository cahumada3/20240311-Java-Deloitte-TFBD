import { useRef } from 'react';
import './App.css';
import {Movie as MovieType, movieApi } from './api/movieApi'
import Movies from './components/Movies';

export default function App() {

    const titleRef = useRef<HTMLInputElement>(null);
    const ratingRef = useRef<HTMLInputElement>(null);
    const directorFirstRef = useRef<HTMLInputElement>(null);
    const directorLastRef = useRef<HTMLInputElement>(null);


    /**
     * createApi created custom hooks based on our endpoints 
     *      use these hooks to do your api calls
     * 
     *      query hooks - return an object with 2 properties:
     *                      your data and function for that api call (refetch)
     * 
     *      mutation hooks - return an array with one index:
     *                      your function for the api call
     */

    const {data : movies, refetch} = movieApi.useFindAllMoviesQuery();

    const [createMovie] = movieApi.useCreateMovieMutation();

    function handleSubmit(event : any) {
        event.preventDefault();

        const newMovie : MovieType = {
            title : String(titleRef?.current?.value),
            rating : Number(ratingRef?.current?.value),
            director : {
                firstName : String(directorFirstRef?.current?.value),
                lastName :  String(directorLastRef?.current?.value)
            }
        }

        // create movie will make the call, but we need to get the data back
        createMovie(newMovie)
            .unwrap()
            .then(() => {

                //refetch the data from the database (calls findMoviesById)
                refetch();

                /**
                 * this is usually bad practice. you dont want to make unecesasry api calls
                 * 
                 * redux will cache your data in the store for you and ONLY send requests if the data has changed
                 */
            })
            .catch(error => console.error(error))

            

    }


    return(
        <>
            <form onSubmit={handleSubmit}>
                Title: <input ref={titleRef}/>
                Rating: <input ref={ratingRef}/>
                Director First Name: <input ref={directorFirstRef}/>
                Director Last Name: <input ref={directorLastRef}/>

                <button>Create Movie</button>
            </form> 

            {movies?.map((moviesToDisplay) => {
                return (
                    <Movies key={moviesToDisplay.id} movie={moviesToDisplay} />
                )
            })}
        </>
    );
}