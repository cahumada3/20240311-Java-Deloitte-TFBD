import { GridContainer, Grid, Button} from '@trussworks/react-uswds';
import MoviesTable from '../components/MoviesTable';

export default function Movies() {

    const url = 'http://localhost:8282/movies';

    fetch(url)

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
                        <MoviesTable tableData={[]} />
                    </Grid>
                </Grid>

            </GridContainer>
        
        </>
    );
}