import React from 'react';
import { Route } from 'react-router-dom';
import { Home, Login, Register, Profile, Logout } from '../pages';
import ProtectedRoute from './ProtectedRoute';

// Define route elememts that can be imported into app.js
export const publicRoutes =(
    <>
    <Route path="/" element={<Home />} />
    <Route path="/login" element={<Login />} />
    <Route path="/register" element={<Register />} />
    </>
);

export const protectedRoutes =(
    <Route element={<ProtectedRoute />}>
        <Route path="/profile" element={<Profile />}/>
        <Route path="/logout" element={<Logout />}/>
        
    </Route>

);





// import { RouterProvider, createBrowserRouter } from "react-router-dom";
// import { useAuth } from "../provider/authProvider";
// import ProtectedRoute from "./ProtectedRoute";
// import Logout from "../pages/Logout";
// import Login from "../pages/Login";
// import Profile from "../pages/Profile";
// import Home from "../pages/Home";
// import Register from "../pages/Register";

// const Routes = () => {
//     const { token } = useAuth();
//     // Route configurations

//     const routesForPublic = [
//         {
//             path: "/",
//             element: <Home />
//         },
//         {
//             path: "/register",
//             element: <Register />
//         },
//     ];

//     const routesForAuthenticatedOnly = [
//         {
//             path: "/",
//             element: <ProtectedRoute />,
//             children: [
//                 {
//                     path: "/",
//                     element: <Home />,
//                   },
//                 {
//                     path:"/profile",
//                     element: <Profile />
//                 },
//                 {
//                     path: "/logout",
//                     element: <Logout />
//                 },
//             ],
//         },
//     ];

//     const routesForNotAuthenticatedOnly = [
//         {
//             path: "/",
//             element: <Home />,
//         },
//         {
//             path: "/login",
//             element: <Login />,
//         },

//     ];

//     // Combine and conditionally include routes based on authentication status
//     const router = createBrowserRouter([
//         ...routesForPublic,
//         ...(!token ? routesForNotAuthenticatedOnly : []),
//         ...routesForAuthenticatedOnly,
//     ]);

//     // Provide the router configuration using RouterProvider
//     return <RouterProvider router={router} />;

// };

// export default Routes;