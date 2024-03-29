/**
 * JS Event Loop
 *      this is the runtime model JS uses
 *          the event loop determines which subtasks to execute 
 *              runs more like a queue or a series of queues
 * 
 *              setTimeout and setInterval macrotaks
 *              while promises are microtasks
 *                  microtasks get priority over macrotasks
 * 
 *              execution task will have priority over macro and micro tasks
 */

console.log('1');                                           //add to execution stack
setTimeout(() => console.log('2'), 0);                      //add to macrotask queue
setTimeout(() => console.log('3'), 0);                      //add to macrotask queue
Promise.resolve('4').then(data => console.log(data));       //add to microtask queue
console.log('5');                                           //add to execution stack

//What order will the above execute in?
//answer: 1, 5, 4, 2, 3

//execution stack -> microstack queue -> macrostack queue