// in JS, functions are treated like first-class

//you can pass fucntions into other functions as a parameter, return a function, from a a function
function greeterFunction(name) {

    /**
     * Closure - function in JS retain access to avraibles and values in their outside lexcial environment
     */
    return function() {
        console.log('Hello ' + name);
    }
}

// greetFawaz is a FUNCTION not a varaible
const greetFawaz = greeterFunction('Fawaz');
greetFawaz();

const greetKaiwen = greeterFunction('Kaiwen');
greetKaiwen();

greeterFunction('Caroline')();

/**
 * HIGH ORDER FUNCTIONS (HOFs)
 *      any function that takes a function as a param, OR returns a function
 * 
 *      arrays have a lot of built in HOFs
 * 
 */
const fruits = ['apple', 'orange', 'kiwi', 'mango', 'pineapple', 'peach', 'dragonfruit'];

// for each loops through the array and takes in a function with 3 params
fruits.forEach(function(fruitItrVar, index, copyOfFruitsArray) {
    fruitItrVar = fruitItrVar + index;
    console.log(`Fruit at index -- ${index}: ${fruitItrVar}`);

    copyOfFruitsArray.push(fruitItrVar);    //DOES modify fruits array
});
console.log(fruits);

// map returns a new list wiht each value changed by the function
const upperCasedFruits = fruits.map(function(fruit) {
    return fruit.toUpperCase();
});
console.log(fruits);    //original is unchanged
console.log(upperCasedFruits);

// filter returns a new list that meets the criteria specified in our function 
const apple = fruits.filter(function(fruit) {
    return fruit.includes('apple');
});
console.log(apple);

const numbers = [10, 20, 30, 40, 50];

//reduce returns the accumulated value 
const sum = numbers.reduce(function(preValue, currValue) {
    return preValue + currValue;
});
console.log(sum);

/**
 * CALLBACK FUNCTIONS
 *      functions that are invoked at a later point in time
 * 
 *      2 most common: setTimeout and setInterval
 */

// setTimeout() takes in a callback function and an amount of time - similar to .sleep() in java
setTimeout( () => {
    // this calback function execute once specified time has passed
    console.log('It has been 3 seconds!');
}, 3000);

let count = 10;

// setInteravl() runs the callback function each time the given time elapses
// need to make sure to use clearInterval() to stop it
const countdown = setInterval(() => {
    if(count <= 0) {
        console.log('LIFT OFFFF!!!!!');
        clearInterval(countdown); //only stops the interval from continuing after the current iteration
        return;
    }

    console.log('Current Count: ' + count);
    count--;
}, 1000);