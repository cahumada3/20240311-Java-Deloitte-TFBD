/**
 * ES stands EcmaScript (added in 2015)
 *     add a bunch of new stuff
 */

// arrow functions
[1,2,3].map((data1, data2) => {'Hello'});   //takes in 2 params, and returns 'Hello'

/**
 * if you only have 1 parameter, () are optional
 * but if you have more than 1 parameter, you need ()
 * 
 * if you have one line in your function, {} are optional
 * but if you have more than 1 line, you need {}
 * 
 * 
 * Valid arrow functions:
 *      a => a*2
 *      a => a
 *      (a, b) => a*b
 *      () => 'hello'
 *      () => {}
 */

function myFunction() {

}

const myFunc = () => {

}

/**
 * JAVASCRIPT OBJECTS
 *      basically like maps with key-value pairs
 *      very similar to dictionaries in python
 */

// object literal syntax
const person = {
    age: 67,
    name: {
        firstname: 'Dan',
        lastname: 'Pickles'
    },
    favColor: 'orange'
}

console.log(person.age);

//const is just on the Object, not its properties, those can be modified
person.age = 21;
console.log(person.age);

// you can add properties to objects after they've been created
person.favDayOfTheWeek = 'Sunday';
console.log(person);

// this will make your object read only 
Object.freeze(person);

person.location = 'Atlanta';       // won't be added
console.log(person);

/**
 * OBJECTS are NOT iterable. They are ENUMERABLE
 * 
 *      enumerables use for..in loops
 *      iterables use for..of loops
 */

for(let property in person) {
    console.log(`Key: ${property}. Value: ${person[property]}`);
}

/**
 * DESTRUCTURING
 *      object destrcuturing and array destructuring
 * 
 *      basically breaking down the properties of something into its own varaibles
 */

const animal = {
    species: 'cat',
    name: 'Rey'
}

// taking the properties of our animal object and converting them into their own variables
const {species, name} = animal;

//species = 'cat';    //in general you want to avoid
console.log(species);

const nums = [1, 2, 3, 4, 5];

// here we're taking in elements inside nums and putting them to their own varaibles
const [num1, num2, num3] = nums;

console.log(num2);

//skipping elements in the array
const [,,,num4] = nums;
console.log(num4);      //will print 4

/**
 * OPTIONAL CHAINING
 *      ? - null check, but used to access properties in an object
 *      if it is in the front of the quetsion mark it is null, it will ignore everything behind it
 * 
 */

animal.home = {
    street: '123 Monroe Dr',
    city: {
        city1: 'Atlanta',
        city2: 'Atlanta2'
    }, 
    state: 'GA'
}

//standard null checking
if(animal.home != null) {
    console.log(animal.home);
}

console.log(animal?.home?.city);

animal.home.city = null;
console.log(animal?.home?.city)

