import Counter from "./components/ItemCounter/Counter";

export default function App() {


    return (
        <>
            <Counter/>
        </>
    )

}

/**
 * Exporting is how we make the component available to the rest of the app
 * 
 *      default exports
 *          use the default keyword "export default ..."
 * 
 *          can only have one per file
 * 
 *      named exports
 *          simply use the export keyword "export ..."
 * 
 *          you can have as many as you want
 * 
 *          named exports need to be deconstructed when importing in other files
 *          ex: in main.jsx you'd have to import { num } from 'App.jsx'
 * 
 */

// doing a named export - needs to be destructured when imported
export const num = 0;

let count = 0;

// the function will handle access to the data it needs. other components won't need to import count to use increment
export const increment = () => {
    count++;
}
