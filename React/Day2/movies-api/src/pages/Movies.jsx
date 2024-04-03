import { GridContainer, Grid, Button} from '@trussworks/react-uswds';
import MoviesTable from '../components/MoviesTable';
import { useEffect, useState } from 'react';
import MoviesForm from '../components/MoviesForm';

export default function Movies() {

    const url = 'http://localhost:8282/movies';

    //state for our list of movies
    const [movies, setMovies] = useState([]);

    //makes this GET request when the component is mounted DOM
    useEffect(() => {
        //fetch will default to a GET request
        fetch(url)
        .then(data => data.json())
        .then(returnedData => {
            setMovies(returnedData);
        })
        .catch(error => console.error(error));
    }, []);  //need to add empty dependency list so it runs on mount only

    function handleNewMovie(newMovie) {
        setMovies((oldState) => {
            return [...oldState, newMovie];
        })

        /**
         * THIS IS BAD
         *      you should NEVER manually mutate your state
         */
        //let moviesList = movies;
        //moviesList.push(newMovie);
        //setMovies(moviesList);
    }


    return(
        <>
            <GridContainer>
                <Grid row>

                    <Grid col={10}>
                        <h1 className="text-centered">All Movies</h1>
                    </Grid>

                    <Grid col={2}>
                        <Button>New Movie</Button>
                    </Grid>

                </Grid>

                <Grid row>
                    
                    <Grid col={10}>
                        <MoviesTable tableData={movies} />
                    </Grid>
                </Grid>

            </GridContainer>

            <MoviesForm handleNewMovie={handleNewMovie}></MoviesForm>
        
        </>
    );
}