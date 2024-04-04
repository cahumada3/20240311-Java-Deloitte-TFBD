import { useRef } from "react";
import { useDispatch, useSelector } from "react-redux"
import { decrement, increment, set } from "../slices/counterSlice";

export default function AnotherStoreCounter() {

    /**
     * this does the exact same thing as StoreCounter.tsx
     * 
     *      when state from a store is changed in one component, it is changed everywhere!
     */

    const {count} = useSelector((store : any) => store.counter);
    const dispatch = useDispatch();

    const inputRef = useRef<HTMLInputElement>(null);

    return(
        <>
            <h1>Another Store Counter</h1>
            <h2>Count: {count}</h2>

            <button onClick={() => dispatch(increment())}>+</button>
            <button onClick={() => dispatch(decrement())}>-</button>

            <input type="number" ref={inputRef} />
            <button onClick={() => dispatch(set(Number(inputRef?.current?.value)))}>Set Count</button>
        </>
    )
}