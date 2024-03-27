//JavaScript is not related to Java - JavaScript relates to Java the same way carpets relate to cars

/**
 * to run js files - cd into the proper folder, use the command node <file_name>
 */

console.log('Hello World!');    // double or single quotes for strings and semi-colons optional

/**
 * VARIABLES
 *      var - global or fucntion scoped depending on where you declare it 
 *      let - blocked scoped
 *      const - blocked scoped, but value cannot be changed (similar to final keyword in java)
 */

// GLOBAL Scoped - to the entire file
var x = 10;
console.log(x);

var x = 20;     //vars can be redeclared entirely
console.log(x);

function myFunction() {

    //FUNCTION Scoped
    console.log(x);
    var x = 50;         //undefined due to variable hoisting

    /**
     * VARIABLE HOISTING
     *      JS will move your varaible declarations to the top of their scope
     *          this is only the declaration, not the definition
     */

    if(true) {
        var myvar = 'var Caroline';     //SCOPED TO THE FUNCTION myFunction()

        let mylet = 'let Caroline';     //SCOPED TO THE BLOCK if-statment
        console.log(mylet);
    }
    //console.log(mylet); //mylet is not defined
}

myFunction();

const y = 12;
//y = 20;   // errors because const cannnot be changed

/**
 * JavaScript still has data types, we just dont declare them
 *      Primitives:
 *          - number
 *          - string
 *          - boolean
 *          - undefined
 *          - null
 *          - BigInt (huge numbers, you declare with an 'n'. ex. 5n)
 *          - Symbol (more of JS identifier)
 * 
 *      Non-primitives:
 *          - object
 *          - arrays
 *          - functions, etc.
 */

console.log(typeof y);

let bigInts = 12n;
console.log(bigInts);
console.log(typeof bigInts);

//JS has built in function for casting to a specific data type
let z = String(12);
console.log(typeof z);

let num = 12;
let myBool = Boolean(num);
console.log(myBool);

// fun ways that JS works
num = !!num;        // !!12 -> !false -> true
console.log(num);

/**
 * TYPE COERCION
 *      basically when JS tries to manually convert your data types
 */
let num1 = 5;
let num2 = '10';

let num3 = '5' == 5;

//JS hs to decide between making num1 and num2 both strings or both numbers
let sum1 = num1 + num2;     //string wins out and num1 is coerced into being a string
console.log('Sum1 = ' + sum1);

console.log('num3: ' + num3);

let sum2 = num1 + Number(num2);
console.log('Sum2 = ' + sum2);

/**
 * TEMPLATE LITERALS (aka Template Strings)
 *      - strings that are created with ticks(``) 
 *      - they print exactly as they appear in code
 */

let myName = 'Caroline';

// can reference varaibles in template literals with string interpolation ${var_name}
let newStr = 
`Here is a list of ${myName}'s favorite foods:
    1. Sushi
    2. Chicken and Rice
    3. Ice cream`;
console.log(newStr);