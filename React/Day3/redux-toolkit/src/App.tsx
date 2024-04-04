import AnotherStoreCounter from "./components/AnotherStoreCounter";
import StoreCounter from "./components/StoreCounter";
import UseReducerCounter from "./components/UseReducerCounter";

export default function App() {

    return(
        <>
            <UseReducerCounter />
            <StoreCounter />
            <AnotherStoreCounter />
        </>
    );
}