import { useState } from 'react';

export default function App() {

    const [accessToken, setAccessToken] = useState('');
    const [userInfo, setUserInfo] = useState('');


    function handleLogin() {

        /**
         * with OAuth2, you cannot send HTTP requests until you have JSESSIONID cookie established
         * 
         * instead, we can manually redirect the browser to the endpoint we want
         */

        window.location.replace("http://localhost:8080/signin");

        console.log("We signed in!");
    }

    // NEED to make sure to include credentials (cookies)
    function getUserInfo() {
        fetch('http://localhost:8080/userinfo', {credentials: 'include', method: 'GET'})
            .then(data => data.text())      //converting to text
            .then(userInfo => setUserInfo(userInfo))
            .catch(() => {window.location.replace('http://localhost:8080/signin'); } );     //if an an error happens, redirect user to sign in 
    }

    function getAccessToken() {
        fetch('http://localhost:8080/accessToken', {credentials: 'include', method: 'GET'})
            .then(data => data.text())      //converting to text
            .then(token => setAccessToken(token))
            .catch(() => {window.location.replace('http://localhost:8080/signin'); } ); 
    }




    return(
        <>
            <h1>Google OAuth2 Demo!!!</h1>

            <button onClick={handleLogin}>Sign In</button>
            <button onClick={getUserInfo}>Get User Info</button>
            <button onClick={getAccessToken}>Get Access Token</button>

            <h2>User Info</h2>
            <p>{userInfo}</p>

            <h2>Access Token</h2>
            <p>{accessToken}</p>
        
        </>
    );
}