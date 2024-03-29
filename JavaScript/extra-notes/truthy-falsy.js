/**
 * When casting any data type to a boolean, you need ot be able to cast
 * 
 * Truthy and Falsy are used to determine whether the casted value is true or false
 * 
 * Falsy:
 *  - false
 *  - 0
 *  - 0n
 *  - ""
 *  - null
 *  - undefined
 *  - NaN (Not a Number)
 * 
 * Truthy:
 *  - "0"
 *  - "false"
 *  - {}
 *  - []
 *  - Everything else that isn't on the falsy list
 *
 */

let someVal = [null];

if(someVal) {
    console.log('It is truthy!');
} else {
    console.log('It is falsy!');
}


// == Logical Equals (Equality) Operator
console.log(2 == 2); //true
console.log(2 == '2'); //true

// === Strict Equality Operator
console.log(2 === 2); //true
console.log(2 === '2'); //false

function myStrictEqualtiyOperator(left, right) {
    if(typeof left == typeof right) {
        return left == right;
    }
    return false;
}

console.log(myStrictEqualtiyOperator(2, '2')); //false

console.log(null == undefined); //true
console.log(null === undefined); //false

//checks that it is both not null AND not undefined
if(someVal != null) {
    //do something with the value
}

someVal = 0;
//this prevents null and undefined AND prevents ALL falsy values
if(someVal) {
    //do some logic
    console.log('Something')
}

console.log(2 <= '6'); //true