import { useDispatch, useSelector } from "react-redux";
import { increment, decrement, set } from "../slices/counterSlice";
import { useRef } from "react";

export default function StoreCounter() {

    /**
     * REACT-REDUX HOOk: useSelector()
     *      allow you to read a particular set of state from your store
     * 
     *      take in the store as a param
     *          this store object is going to be PROVIDED by main.tsx
     * 
     *      returns the entire store OR a specific piece of state
     */

    const {count} = useSelector((store : any) => store.counter) 

    /**
     * REACT-REDUX HOOK: useDispatch()
     *      just going to return the dispatch function of your reducer
     * 
     *      use this dispatcher to call your imported actions
     */
    const dispatch = useDispatch();

    // give types to functions using angle brackets 
    const inputRef = useRef<HTMLInputElement>(null);
    

    return(
        <>
            <h1>Store Counter</h1>
            <h2>Count: {count}</h2>

            {/**
             * dispatcher function will take in your action object (with type and payload) and call the reducer for you
             */}

            <button onClick={() => dispatch(increment())}>+</button>
            <button onClick={() => dispatch(decrement())}>-</button>

            <input type="number" ref={inputRef} />
            <button onClick={() => dispatch(set(Number(inputRef?.current?.value)))}>Set Count</button>
        </>
    );
}