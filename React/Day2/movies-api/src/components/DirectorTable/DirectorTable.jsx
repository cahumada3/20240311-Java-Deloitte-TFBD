import { Table } from "@trussworks/react-uswds";

export default function DirectorTable({tableData}) {

    return(
        <>
             <Table striped fullWidth className="bg-primary-lighter">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                    </tr>
                </thead>
                <tbody>
                    {tableData.map((dir) => {
                        return (
                            <tr key={dir.id}> {/*need to set the key so react knows which elements in the DOM to modify */}
                                <td>{dir.id}</td>
                                <td>{dir.firstName}</td>
                                <td>{dir.lastName}</td>
                            </tr>
                        );
                    })}
                </tbody>

            </Table>
        </>
    );
}