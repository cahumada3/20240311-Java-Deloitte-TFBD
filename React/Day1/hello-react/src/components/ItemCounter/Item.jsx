/**
 * PASSING DATA FROM A PARENT TO CHILD COMPONENT
 *      use props to pass data to child
 *          props are the attributes given when the component is called from the parent
 * 
 *          props will always have one specific property: children
 *              children is everything nested inside of the compenent tag when it is called in the parent
 * 
 */

// export default function Item(props) {
//     return (
//         <>
//             <h2>{props.name}</h2>
//             <h3>{props.desc}</h3>
//             {props.children}   
//         </>
//     );
// }

//since props is an object, we can destrcuture it 
export default function Item({name, desc, children}) {

    return(
        <>
            <h2>{name}</h2>
            <h3>{desc}</h3>
            {children}
        </>
    );
}