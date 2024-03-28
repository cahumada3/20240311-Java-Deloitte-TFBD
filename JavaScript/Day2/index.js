/**
 * here is the javascript for index.html for the Movies API
 */

const URL = 'http://localhost:8282/movies';

let allMovies = [];

/**
 * document
 *      - gives access to html elements
 * 
 * event listeners are how we respod to events in the html
 */

document.addEventListener('DOMContentLoaded', () => {

    /**
     * DOM - Document Object Model 
     * 
     * DOMContentLoaded is an event that fires when the DOM is loaded
     */

    /**
     * AJAX - Asynchronous JavaScript and XML
     *      pirmary object of AJAX is XMLHttpRequest (XHR)
     */
    
    let xhr = new XMLHttpRequest(); //creates a new XHR object (puts it in to state 0 - unsent)

    /**
     * 
     *  5 stages (ready states):
     *      0 - unsent
     *      1 - opened 
     *      2 - headers recieved
     *      3 - loading
     *      4 - done    --> main state we care about
     * 
     */

    xhr.onreadystatechange = () => {

        /**
         * strict equality (===) and regular equality (==) in JS
         *      strict equality checks vaules and datatype
         *      regular qeuality only checks values
         * 
         *      ex: 4 === '4' returns false but 4 =='4' returns true
         */

        if(xhr.readyState === 4) {
            //at readyState 4, we hvae our response from the server

            //JSON.parse() parses the JSON into js objects
            let movies = JSON.parse(xhr.responseText);
            
            //adds movies to table
            movies.forEach(newMovie => {
                addMovieToTable(newMovie);
            });
        }
    }

    //sets the request method and the url to send the request to (state changed to 1 - opened)
    xhr.open('GET', URL);

    xhr.send();

});

document.getElementById('new-movie-form').addEventListener('submit', (event) => {

        // event object gives info about the event that we are listening for
        event.preventDefault();         //preventDefault() is going to prevent the form from refreshing the page 

        /**
         * one option to grab form data is to call document.getElementById().value for each input field
         * 
         * a better option is to use Form Data
         * 
         *      FormData provides all the data from a form in an easy to work with object
         */

        // FormData takes in the html tags for your form
        let inputData = new FormData(document.getElementById('new-movie-form'));

        // use .get() to retrieve a field from form data and pass in the NAME attribute from the <input> tag
        let newMovie = {
            title : inputData.get('new-movie-title'),
            rating : inputData.get('new-movie-rating'),
            director : {
                firstName : inputData.get('new-director-first'),
                lastName : inputData.get('new-director-last')
            }
        }

        /**
         * fetch() is a built-in function that can send http requests
         *         returns a promise
         * 
         *          PROMISES
         *              something that will return.... eventually
         *              happen asynchronously from the rest of your program
         * 
         *          ASYNC and AWAIT
         *              use async on a function to your program that the function returns a promise 
         *              use await to tell our program to wait for some asynchronous operation 
         *                      they can ONLY be used inside async functions
         * 
         */
        doPostRequest(newMovie);

});

function addMovieToTable(newMovie) {

    console.log(newMovie);

    //DOM Manipulation - we manually change the DOM

    //creating necessary DOM elements
    let tr = document.createElement('tr');          //will create a <tr> tag
    let id = document.createElement('td');          //will create a <td> tag for movie id
    let title = document.createElement('td');       //will create a <td> tag for movie title
    let rating = document.createElement('td');      //will create a <td> tag for movie rating
    let director = document.createElement('td');    //will create a <td> tag for movie director
    let editBtn = document.createElement('td');     //will create a <td> tag for movie edit button
    let deleteBtn = document.createElement('td');   //will create a <td> tag for movie delete button

    id.innerText = newMovie.id;
    title.innerText = newMovie.title;
    rating.innerText = newMovie.rating;
    director.innerText = newMovie.director.firstName + ' ' + newMovie.director.lastName;

    editBtn.innerHTML =
    `<button class="btn btn-primary" id="edit-button" onclick="activateEditForm(${newMovie.id})">Edit</button>`

    deleteBtn.innerHTML =
    `<button class="btn btn-primary" id="delete-button" onclick="activateDeleteForm(${newMovie.id})">Delete</button>`

    //adds the <td> tag as nested children to the <tr> tag in our html page
    tr.appendChild(id);
    tr.appendChild(title);
    tr.appendChild(rating);
    tr.appendChild(director);
    tr.appendChild(editBtn);
    tr.appendChild(deleteBtn);

    //sets the id attribute for the <tr> tag
    tr.setAttribute('id', 'TR' + newMovie.id)

    //adds the <tr> tag to the <tbody> tag
    document.getElementById('movie-table-body').appendChild(tr);

    //adds new movie to the list of movies
    allMovies.push(newMovie);

}

async function doPostRequest(newMovie) {

    console.log(newMovie);
    let returnedData = await fetch(URL + '/movie', {
        method : 'POST',
        headers : {
            'Content-Type' : 'application/json' //makes sure your server is expecting to recieve JSON in the body
        },
        body : JSON.stringify(newMovie)     //turns js object into json
    });

    //.json() to deserialize the JSON back into js object - this ALSO returns a promise
    let movieJson = await returnedData.json();

    console.log('MOVIE JSON' + movieJson);

    //add movie to table
    addMovieToTable(movieJson);

    //reset the form
    document.getElementById('new-movie-form').reset();
}

//UPDATE our movie table
document.getElementById('update-movie-form').addEventListener('submit', (event) => {
    event.preventDefault();  

    //retrieving data from the update form
    let inputData = new FormData(document.getElementById('update-movie-form'));

    //MAKE SURE TO INCLUDE IDS WHEN DOING A PUT REQUEST
    let movie = {
        id : document.getElementById('update-movie-id').value,  // FormData cannot access values from disabled fields
        title : inputData.get('update-movie-title'),
        rating : inputData.get('update-movie-rating'),
        director : {
            id : document.getElementById('update-director-id').value,
            firstName : inputData.get('update-director-first'),
            lastName : inputData.get('update-director-last')
        }
    }

    /**
     * alternative/perferred ways to handle promises:
     *      rather than using async/wait we can use .then() and pass some call back funtion
     * 
     *      .then - will run whenever the promise returns successfully
     *      .catch - will run whenever the promise returns unsuccessfully
     */

    fetch(URL + '/movie', {
        method : 'PUT',
        headers : {
            'Content-Type' : 'application/json',
        }, 
        body : JSON.stringify(movie)
    })
    .then((data) => {
        //this will handle all 100, 200, and 300 status response codes

        // still need to serialize the response into JSON
        return data.json();
    })
    .then((movieJson) => {      //handles the promise returned by data.json

        //add updated movie to our table
        updateMovieInTable(movieJson);
    })
    .catch((error) => {
        //this will handle all 400 and 500 status response codes

        console.error(error);
    })

});

document.getElementById('delete-movie-form').addEventListener('submit', (event) => {
    event.preventDefault(); 

    // get the data from the form since all the fields are disabled and FormData wont capture them
    let movieId = document.getElementById('delete-movie-id').value;
    let titleOnForm = document.getElementById('delete-movie-title').value;
    let ratingOnForm = document.getElementById('delete-movie-rating').value;
    let directorId = document.getElementById('delete-director-id').value;
    let directorFirstOnForm = document.getElementById('delete-director-first').value;
    let directorLastOnForm = document.getElementById('delete-director-last').value;

    let movie = {
        id : movieId,
        title : titleOnForm,
        rating : ratingOnForm, 
        director : {
            id : directorId,
            firstName : directorFirstOnForm,
            lastName : directorLastOnForm
        }
    }

    fetch(URL + '/movie', {
        method : 'DELETE',
        headers : {
            'Content-Type' : 'application/json',
        },
        body : JSON.stringify(movie)
    })
    .then((data) => {

        //delete request returns no-content so there's no need to deserialize the response and wait for a promise
        // just need to check that the response we get back is a 204 - No Content and then we can delete it
        if(data.status === 204) {

            //removes a movie from the table
            removeMovieFromTable(movie);

            // reseting all forms
            resetAllForms();
        }
    })
    .catch((error) => {
        console.error(error);
    })
});

function updateMovieInTable(movie) {
    document.getElementById('TR' + movie.id).innerHTML = `
    <td>${movie.id}</td>
    <td>${movie.title}</td>
    <td>${movie.rating}</td>
    <td>${movie.director.firstName + ' ' + movie.director.lastName}</td>
    <td><button class="btn btn-primary" id="editButton" onclick="activateEditForm(${movie.id})">Edit</button></td>
    <td><button class="btn btn-primary" id="deleteButton" onclick="activateDeleteForm(${movie.id})">Delete</button></td>
    `;
}

function activateEditForm(movieId) {
    // find the movie and its <tr> that needs to be edited
    for(let m of allMovies) {
        if(m.id === movieId) {
            document.getElementById('update-movie-id').value = m.id;
            document.getElementById('update-movie-title').value = m.title;
            document.getElementById('update-movie-rating').value = m.rating;
            document.getElementById('update-director-id').value = m.director.id;
            document.getElementById('update-director-first').value = m.director.firstName;
            document.getElementById('update-director-last').value = m.director.lastName;
        }
    }

    //SHOWING ONLY THE EDIT FORM
    document.getElementById('new-movie-form').style.display = 'none';
    document.getElementById('update-movie-form').style.display = 'block';   //block is the default for showing a tag
    document.getElementById('delete-movie-form').style.display = 'none'; 
}

function activateDeleteForm(movieId) {
    // find the movie and its <tr> that needs to be deleted
    for(let m of allMovies) {
        if(m.id === movieId) {
            document.getElementById('delete-movie-id').value = m.id;
            document.getElementById('delete-movie-title').value = m.title;
            document.getElementById('delete-movie-rating').value = m.rating;
            document.getElementById('delete-director-id').value = m.director.id;
            document.getElementById('delete-director-first').value = m.director.firstName;
            document.getElementById('delete-director-last').value = m.director.lastName;
        }
    }

    //SHOWING ONLY THE DELETE FORM
    document.getElementById('new-movie-form').style.display = 'none';
    document.getElementById('update-movie-form').style.display = 'none';   
    document.getElementById('delete-movie-form').style.display = 'block'; //block is the default for showing a tag
}

function removeMovieFromTable(movie) {
    //removing the <tr> tag from the table when a movie gets deleted
    const element = document.getElementById('TR' + movie.id);
    element.remove();
}

function resetAllForms() {

    // clears data from all forms
    document.getElementById('new-movie-form').reset();
    document.getElementById('update-movie-form').reset();
    document.getElementById('delete-movie-form').reset();

    //displays only the new-movie-form
    document.getElementById('new-movie-form').style.display = 'block';
    document.getElementById('update-movie-form').style.display = 'none';
    document.getElementById('delete-movie-form').style.display = 'none';
}
