import { Movie } from '../api/movieApi'

//create type for movie
type MovieProps = {
    movie : Movie,
    children? : React.ReactNode 
}

export default function Movies({movie} : MovieProps) {

    return(
        <>
            <h2>{movie.title}</h2>
            <h2>{movie.rating}</h2>
            <h2>{movie?.director?.firstName + ' ' + movie?.director?.lastName}</h2>
            <h3>--------------------------------------------------------------</h3>
        </>
    )
}