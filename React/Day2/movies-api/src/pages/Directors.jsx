import { Grid } from "@trussworks/react-uswds";
import DirectorTable from "../components/DirectorTable/DirectorTable";
import { useState, useEffect } from "react";

export default function Directors() {

    //url for directors endpoint server
    const url = 'http://localhost:8282/directors';

    //our list of directors
    const [directors, setDirectors] = useState([])


    //makes this GET request when the component is mounted DOM
    useEffect(() => {
        //fetch will default to a GET request
        fetch(url)
        .then(data => data.json())
        .then(returnedData => {
            setDirectors(returnedData);
        })
        .catch(error => console.error(error));
    }, []);  //need to add empty dependency list so it runs on mount only

    return(
        <>
            <Grid row>
                <Grid col>
                    <h1 className="text-centered">All Directors</h1>
                </Grid>
            </Grid>

            <Grid row>
                <Grid col>
                    <DirectorTable tableData={directors} />
                </Grid>
            </Grid>
        
        </>
    );
}