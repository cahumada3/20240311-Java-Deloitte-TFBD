// Spread Operator
// ...
// Takes an iterable and fans it out

const charArray = [..."Johnny"]; // ["J", "o", "h", "n", "n", "y"]
console.log(charArray);

// Combine arrays with spread
const newArray = [...charArray, '!']; // Creates a new array with the old array and a ! at the end

console.log(newArray);


// Spread with objects
// Objects are NOT iterable, but they are special exception

const obj = {
    firstName: 'Dan',
    lastName: 'Pickles'
}

// Copying the contents of the old object into a new one
const newObj = {
    firstName: 'Shawn', // This is a default value if obj doesn't contain a firstName
    ...obj,
    favColor: 'Blue'
}

console.log(newObj);



// Rest Operator
// ...
// Rest takes many items and consolidates into one

// Array destructuring with rest

const daysOfTheWeek = ['Monday', 'Tuesday', 'Wednesday'];
const [monday, ...otherDays] = daysOfTheWeek;

console.log(monday);
console.log(otherDays); // ['Tuesday', 'Wednesday']


// Everything from 4th param on is stored in an array
const printTop3Movies = (firstPlace, secondPlace, thirdPlace, ...runnerUps) => {
    console.log('The top movie is: ' + firstPlace);             // 1
    console.log(`The second place movie is: ${secondPlace}`);   // 2
    console.log(`The third place movie is: ${thirdPlace}`);     // 3
    console.log(`The runner ups are: ${runnerUps}`);            // All the others
}

const movies = ['Fast and Furious', 'The Dark Knight', 'Harry Potter', 'The Whale', 'John Wick 4', 'The Way of the Water', 'Avatar', 'The Godfather', 'Goodfellas'];

// printTop3Movies('Fast and Furious', 'The Dark Knight', 'Harry Potter', 'The Whale', ...);
printTop3Movies(...movies);

//  rest is all the other properties stored in an object
const spreadWithObject =  ({firstName, lastName, ...rest}) => {

}