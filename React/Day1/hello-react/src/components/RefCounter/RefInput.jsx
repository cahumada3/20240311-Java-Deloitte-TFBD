import { useRef, useState } from "react";

export default function RefInput() {

    const inputRef = useRef();

    const [inputValue, setInputValue] = useState('')


    function handleSubmit() {

        /**
         * since inputRef is bound to the <input>, .current will return that tag
         *         then use .value to get the value of the input text
         */
        if(inputRef.current.value.includes('@')) {
            alert('Input cannot contain at sign (@).');

            /**
             * in general, you should avoid using alert(). look into toast messaged instead
             *      in react, react-hot-toast
             */
        }
        else {
            alert('Input is valid!');
        }
    }

    function handleInputChange(event) {

        if(!event.target.value.includes('@')) {

            //if the value of <input> tag does NOT include '@' then the state can change
            setInputValue(event.target.value);
        }
    }


    /**
     * UNCONTROLLED COMPONENTS AND CONTROLLED COMPONENTS
     * 
     *      by default, native input tags in UNCONTROLLED 
     *          uncontrolled means that react does not own it/have control over it
     *          we use useRef to get *some* control back 
     * 
     *      Controlled components and elements are managed by react
     *          react decides what values they hold and when to hold them
     *          can use useState to turn an uncontrolled component into a controlled
     *  
     */

    return(
        <>
        <div>
            <label htmlFor="uncontrolled-input">Uncontrolled Input</label>

            <input id="uncontrolled-input" ref={inputRef}/> {/*ref is going to bind the inputRef to the valeu of this tag*/}


            <label htmlFor="controlled-input">Controlled Input</label>

            <input id="controlled-input" value={inputValue} onChange={handleInputChange}/>

            <button onClick={handleSubmit}>Submit</button>
        </div>
            
        </>
    )
}