import { useState, useEffect } from "react";

export default function Counter() {

    //react doesnt see count at STATE
    let count = 0;

    /**
     * REACT HOOK - useState()
     *      creates some piece of state
     * 
     *      it will take in a default value
     *      it will return an array 
     *          this array always has 2 indexes
     *              index 0 contains your variable
     *              index 1 contains your setter function for the variable
     *          usually we will destructure this array into its 2 returned pieces
     */
    const [counter, setCounter] = useState(0);

    function increment() {

        //count++;  // does change the value of count, BUT does not reflect changes on view
        //console.log(counter);

        //setCounter(counter + 1)

        // NEVER mutate your state directly 
        //counter++;  // this wont work, partly why we use const as a reminder that it can not be mutated

        //if you need to access the old state for any reason, you can pass in an arrow function to the setter
        setCounter((oldState) => {
            return oldState + 1;
        })
    }

    /**
     * REACT HOOK - useEffect()
     *      taps into the COMPONENTS lifecycle
     *          - Component Initialization (on mount) - component to the DOM
     *          - State Update  (did update) - anytime state updates
     *          - Component Destruction (will unmount) - component is unrendered from the DOM
     * 
     *      where in the lifecycle you tap into, depends on how you use useEffect()
     *          has 2 params:
     *                  - callback function (this is what wil be invoked when useEffect is ran)
     *                  - an optional array (dependency list - refers to pieces of state that we care about)
     *                          - no array - care about ALL state updates
     *                          - empty array - care about NO state updates
     *                          - array with elements - care about state updates for THESE elements only
     * 
     * 
     *      useEffect always runs on mount
     *      useEffect runs on state updates based on the dependency list
     *      useEffect runs on unmount if you return a function
     *                  this returned function is invoked during component destruction
     */

    //not commonly used - call back function gets ran everytime our useEffect gets called
    useEffect(() => {
        console.log('Runs on mount and ALL state updates');
    });

    //commonly used for fetching data from a server
    useEffect(() => {
        console.log('Runs on mount ONLY')
    }, []);

    //commonly used with forms and data validation
    useEffect(() => {
        console.log('Runs on mount and ONLY when counter is updated')
    }, [counter]);


    useEffect(() => {
        console.log('Runs on mount');

        const intervalKey = setInterval(() => {
            console.log(counter);
        }, 1000)


        return () => {
            console.log('Runs when unmounted');
            clearInterval(intervalKey);
        }

    }, []);

    /**
     * in jsx, we return our html 
     *      usually we wrap this html in a fragment (<></>)
     * 
     *      your function can only return one parent html element, so we make the fragment the parent
     * 
     *      fragments will never be rendered on the DOM
     */
    return (
        <>
            {/**
             * curly braces are used for expression
             *          expressions contain js code
             */}

             {/* this is a jsx comment */}
            <h1>Count:</h1>
            <h2>{counter}</h2>

            <button onClick={increment}>+</button>
        </>       
       
    );
}