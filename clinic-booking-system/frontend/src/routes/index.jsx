import { RouterProvider, createBrowserRouter } from "react-router-dom";
import { useAuth } from "../provider/authProvider";
import ProtectedRoute from "./ProtectedRoute";
import Logout from "../pages/Logout";
import Login from "../pages/Login";
import Profile from "../pages/Profile";

const Routes = () => {
    const { token } = useAuth();
    // Route configurations

    const routesForPublic = [
        {
            path: "/",
            element: <div>Home Page</div>
        },
        {
            path: "/register",
            element: <div>Register</div>
        },
    ];

    const routesForAuthenticatedOnly = [
        {
            path: "/",
            element: <ProtectedRoute />,
            children: [
                {
                    path: "/",
                    element: <div>User Home Page</div>,
                  },
                {
                    path:"/profile",
                    element: <Profile />
                },
                {
                    path: "/logout",
                    element: <Logout />
                },
            ],
        },
    ];

    const routesForNotAuthenticatedOnly = [
        {
            path: "/",
            element: <div>Home Page</div>,
        },
        {
            path: "/login",
            element: <Login />,
        },

    ];

    // Combine and conditionally include routes based on authentication status
    const router = createBrowserRouter([
        ...routesForPublic,
        ...ProtectedRoute(!token ? routesForNotAuthenticatedOnly : []),
        ...routesForAuthenticatedOnly,
    ]);

    // Provide the router configuration using RouterProvider
    return <RouterProvider router={router} />;

};

export default Routes;