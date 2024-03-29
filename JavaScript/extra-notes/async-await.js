/**
 * ASYNC and AWAIT 
 * 
 *      altenative way to handle promises
 * 
 *      async functions are automatically going to retun a promise
 *          whatever data is returned by the funtion is the "resolved" state
 *          if the function throws an exception, that will be the "rejected" state
 * 
 *      await will act as our .then() function
 *          it will pause the execution of the code block around it, 
 *          making it asynchronous from the rest of the program.
 *                  MUST be inside of an async function 
 * 
 */

async function myAsyncFunc() {
    return 'This is an async function';
}

const awaitFunc = async () => {

    //if it returns a rejected Promise it WILL fail
    const msg = await myAsyncFunc();
    console.log(msg + ' inside awaitFunc');
}
awaitFunc();


/**
 * Grocery Shopping Example
 */
const inStockItems = ['Apple', 'Orange', 'Eggs', 'Milk', 'Bread', 'Ice Cream'];

//time it takes to travel to the grocery store
const travel = async location => {
    await new Promise(resolve => setTimeout(() => {
        console.log(`Travel to ${location}`);
        resolve();
    }, 5000));
}

//time it takes to find the items in the store
const findItems = async itemsOnList => {
    await new Promise((resolve, reject) => setTimeout(() => {

        //looping through the given grocery list
        for(let item of itemsOnList) {

            //find() loop through an array and check some condition on each element
            //returns the first elements where the condition is true or undefined if all are false
            if(inStockItems.find(inStockItems => inStockItems === item) == undefined) {

                //this means the item on the grocery list could not be found
                return reject(`${item} could not be found`);
            }
        }
        console.log(`Purchasing ${itemsOnList}`);
        resolve();
    }, 3000));
}

//time it takes to check out at the store
const checkout = async () => {
    await new Promise(resolve => setTimeout(() => {
        console.log('Checking out!');
        resolve();
    }, 2000));
}

const buyItemsFromStore = async(startLocation, endLocation, items) => {
    /**
     * 1. Drive to the store
     * 2. Find items
     * 3. Purchse
     * 4. Head home
     */
    try {
        await travel(endLocation);
        await findItems(items);
        await checkout();
        await travel(startLocation);
        console.log('Shopping Success!!')
    } catch (err) {
        console.error(err);
        console.log('Shopping was a failure :(')
    } finally {
        console.log('Shopping journey has come to an end!')
    }
}

buyItemsFromStore('Home', 'Trader Joes', ['Apple', 'Milk', 'Honey']);

