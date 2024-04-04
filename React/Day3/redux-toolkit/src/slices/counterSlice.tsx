/**
 * SLICES
 *      contains the reducers and their actions
 *          in pure redux (is. no toolkit) actions and reducres are in seperate files 
 * 
 *      where you modify logic for manipulating the state
 * 
 *      createSlice takes in an object with 3 properties:
 *          - name: name of your reducer
 *          - initialState: your initial value of your state
 *          - reducers: the actions your reduces can perform
 * 
 *      createSlice returns an object with a couple of properties: actions and reducer
 */

import { createSlice } from "@reduxjs/toolkit";

const counterSlice  = createSlice({
    name : 'counter',
    initialState : {
        count : 0
    },
    reducers : {
        increment : (state) => {
            // in redux, you HAVE to mutate the state directly
            state.count++;
        },
        decrement : (state) => {
            state.count--;
        },
        set : (state, action) => {
            state.count = action.payload;
        }

    }
});

// exporting the reducer created by createSlice
export default counterSlice.reducer;


// exporting the actions so they can be used elsewhere
export const { increment, decrement, set } = counterSlice.actions;