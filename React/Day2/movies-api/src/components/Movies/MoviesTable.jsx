import { Table } from "@trussworks/react-uswds";

export default function MoviesTable({tableData}) {

    return(
        <>
            <Table striped fullWidth className="bg-primary-lighter">

                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Rating</th>
                        <th>Director</th>
                    </tr>
                </thead>
                <tbody>
                    {tableData.map((movie) => {
                        return (
                            <tr key={movie.id}> {/*need to set the key so react knows which elements in the DOM to modify */}
                                <td>{movie.id}</td>
                                <td>{movie.title}</td>
                                <td>{movie.rating}</td>
                                <td>{movie.director.firstName + ' ' + movie.director.lastName}</td>
                            </tr>
                        );
                    })}
                </tbody>
                
            </Table>
        
        </>
    );
}