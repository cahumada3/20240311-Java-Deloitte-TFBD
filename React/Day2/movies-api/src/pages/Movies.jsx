import { GridContainer, Grid, Button, Modal, ModalHeading, ModalToggleButton} from '@trussworks/react-uswds';
import MoviesTable from '../components/Movies/MoviesTable';
import { useEffect, useState, useRef } from 'react';
import MoviesForm from '../components/Movies/MoviesForm';

export default function Movies() {

    const url = 'http://localhost:8282/movies';

    //state for our list of movies
    const [movies, setMovies] = useState([]);

    //creating our modal reference that trussworks needs
    const modalRef = useRef(null);

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
                        <ModalToggleButton modalRef={modalRef} opener>New Movie</ModalToggleButton>
                    </Grid>

                </Grid>

                <Grid row>
                    
                    <Grid col={10}>
                        <MoviesTable tableData={movies} />
                    </Grid>
                </Grid>

            </GridContainer>
            <Modal id='movie-form-modal' ref={modalRef}>
                <ModalHeading id='movie-form-modal-heading'>Enter New Movie Details</ModalHeading>
                <MoviesForm handleNewMovie={handleNewMovie}></MoviesForm>
            </Modal>
        </>
    );
}