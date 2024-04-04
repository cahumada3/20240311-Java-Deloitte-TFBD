import '@trussworks/react-uswds/lib/index.css';
import '@trussworks/react-uswds/lib/uswds.css';

import Movies from './pages/Movies';
import Directors from './pages/Directors';
import Home from './pages/Home'
import { Title, Header, PrimaryNav, Grid } from '@trussworks/react-uswds';
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';

export default function App() {

    //creates a list of react-router-dom Links to pass to our navbar
    const navItems = [
        <Link to='/'>Home</Link>,
        <Link to='/movies'>All Movies</Link>,
        <Link to='/directors'>All Directors</Link>
    ];

    return (
        <>
            <Header basic={true}>
                <Title className='text-center'>Movies API</Title>
            </Header>

            {/**
             * REACT ROUTER DOM
             *      client-side routing - means no page refreshes!
             *      
             *      BrowserRouter is going to to work with the History API
             *          gives it access to url and history of your browser so it can navigate between pages
             * 
             *      Links and Routes to handle the navigation
             *          need to be nested inside of the browser router
             *      
             */}

            <BrowserRouter basename='/'>
                <Grid>
                    <PrimaryNav items={navItems}></PrimaryNav>
                </Grid>

                <Routes>
                    <Route path='/' element={<Home />} />
                    <Route path='/movies' element={<Movies />} />
                    <Route path='/directors' element={<Directors />} />
                </Routes>
            </BrowserRouter>
        </>
    );
}